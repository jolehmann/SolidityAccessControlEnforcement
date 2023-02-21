"""
Module enhancing the data-dependency printer.
Detecting and Printing indirect influence as well as direct and transitive influence.
Additionally, it also calculates the transitive closure for function calls.

Indirect Influence Example:
    if(influencer > 5) {
        x = 20;
    }
=> Here, "influencer" indirectly influences "x"
"""

from typing import Union, Set, List
from slither.core.variables.variable import Variable
from slither.core.variables.state_variable import StateVariable
from slither.core.declarations import Contract, Function, Modifier
from slither.core.declarations.function_contract import FunctionContract
from slither.core.cfg.node import Node, NodeType
from slither.printers.abstract_printer import AbstractPrinter
from slither.analyses.data_dependency.data_dependency import get_dependencies
from slither.slithir.variables import TemporaryVariable, ReferenceVariable
from slither.utils.myprettytable import MyPrettyTable

# Dictionary mapping each variable name to the list of variables it is influenced by.
# It is used to keept track of the influence overview created at the beginning (over all functions).
influence_dict = dict()

"""
This function maps each variable to its influencers once at the beginning of the printing process. 
It is given the list of contracts to analyte and iterates over it to look at each contract independently.
For all variables in each contract that has not yet been considered, it finds all direct
(using the normal data-dependency printer through get_dependencies) and indirect dependencies. 
They are returned, the transitive closure is calculated and saved in a local dictionary for later use.
"""
def return_all_dependencies(cons): 
    temp_influence_dict = dict()
     
    for c in cons:
        for v in c.state_variables:
            if v in temp_influence_dict:
                continue

            #print('Var: ', v.name, 'Context: ', c.name, 'Type: ', type(c))
            temp_influence_dict[v] = set()
            for inf in get_dependencies(v, c):
                if isinstance(inf, StateVariable):
                    if inf not in temp_influence_dict[v] and inf.name != v.name:
                        temp_influence_dict[v].add(inf)
                            
            for inf in get_indirect_dependencies(v, c):
                if isinstance(inf, StateVariable):
                    if inf not in temp_influence_dict[v] and inf.name != v.name:
                        temp_influence_dict[v].add(inf)
                        
    return temp_influence_dict
  
"""
This function takes all found dependencies, calculates the transitive closure and then saves 
the results in the influence_dict dictionary to map each variable to its influencers.
To do so, it iterates over all state variables and calculates the transitive closure recursively.
"""        
def fill_dictionary(d):
    for var in d:
        already_considered = set()
        already_considered.add(var)
        influence_dict[var] = calculate_transitive_closure_recursively(d, var, already_considered)

"""
To calculate the transitive closure for the given variable, this function looks at all influencers
and their influencers recursively. While doing so, it keeps track of the already considered influencers
to prevent unnecessary recursive steps.
"""        
def calculate_transitive_closure_recursively(d, var, already_considered):
    temp = set()
    for inf in d[var]:
        if inf not in already_considered:
            temp.add(inf)
            already_considered.add(inf)
            temp.update(calculate_transitive_closure_recursively(d, inf, already_considered))
        
    return temp

"""
This function calculates the transitive closure for the function calls, beginning with the given function.
In each recursive call, it looks at the internal and external (= high_level) calls made by that function and
adds all functions that have not yet been considered to the result set. When no more functions can be traversed,
the function returns the set of functions.
""" 
def calculate_transitive_closure_for_function_recursively(func, already_considered):
    temp = set()
    
    if not isinstance(func, FunctionContract):
        return temp

    for called in func.internal_calls:
        if called not in already_considered and isinstance(called, FunctionContract):
            temp.add(called)
            already_considered.add(called)
            temp.update(calculate_transitive_closure_for_function_recursively(called, already_considered))
    
    for called in func.high_level_calls:
        if called not in already_considered and isinstance(called, FunctionContract):
            temp.add(called)
            already_considered.add(called)
            temp.update(calculate_transitive_closure_for_function_recursively(called, already_considered))
    
    return temp   
        
"""
Function taken from the original data-dependency printer but adjusted to better incorporate 
the additional functionality for indirect influence. The function is given a variable v and
either a contract or a function (represented by c). If a contract is given, the variables 
that influence v are returned from the influence_dict dictionary. If a function is given, 
the variables are directly collected and returned. To do so, for both cases, the results of
the normal data-dependency printer (get_dependencies) and our extension are combined.
"""
def _get(v, c):
    if isinstance(c, Contract):
        return [inf.name for inf in influence_dict[v]]
       
    elif isinstance(c, Function):    
        res = set()
        for inf in get_dependencies(v, c):
            if not isinstance(inf, (TemporaryVariable, ReferenceVariable)):
                if inf not in res and inf.name != v.name:
                    res.add(inf.name)
        
        for inf in get_indirect_dependencies(v, c):
            if not isinstance(inf, (TemporaryVariable, ReferenceVariable)):
                if inf not in res and inf.name != v.name:
                    res.add(inf.name)
             
        return list(res)      
        
"""
This function returns the variables that indirectly influence the given variable var.
To do so, it differentiates between contracts and functions and either iterates over
all available functions to collect the variables or directly analyzes the given
function.
"""
def get_indirect_dependencies(
    var: Variable,
    cont: Union[Contract, Function]
) -> Set[Variable]:

    assert isinstance(cont, (Contract, Function))
    #print('Var: ', var.name, 'Context: ', cont.name, 'Type: ', type(cont))
    res = set()

    if isinstance(cont, Contract):
        for func in cont.functions:
            res.update(get_influencers_for_var_in_func(var, func))  
        return res
    elif isinstance(cont, Function):
        return get_influencers_for_var_in_func(var, cont)
    
"""
This function takes a variable var and a function func and returns all variables that 
influence var inside of the function. To do so, it uses the CFG by looking at all
conditional nodes in the function and checking if var is written inside its children
nodes.
"""  
def get_influencers_for_var_in_func(
    var: Variable,
    func: Function
) -> Set[Variable]:

    res = set()
    # print('Func: ', func.name)
    # print('Written: ', *func.variables_written)
    # print('Read: ', *func.variables_read)
    if var in func.variables_written:
        condNodes = [n for n in func.nodes if n.is_conditional()]    
        for node in condNodes:
            if check_children_for_write(var, node):
                res.update(node.variables_read)
                  
    return res
  
"""
This function is used to check if the given variable is written by any children 
of the given node. To do so, it checks all child nodes recursively. If any check is positive,
these results will be returned. If an END_IF node is found during the traversal of the CFG,
a further look at those children nodes is not necessary. 
"""   
def check_children_for_write(
    check_for: Variable,
    node: Node
) -> bool:

    for son in node.sons:
        if check_for in son.variables_written:
            return True
        if son.type != NodeType.ENDIF:
            if check_children_for_write(check_for, son):
                return True
    return False
    
"""
This class is mainly the same as the printer class for the standard data-dependency printer.
The only changes are how the data is collected beforehand and the addition of a table summarizing
the transitive closure for function calls before the results for each function are displayed.
"""    		
class InfluenceAndCallsPrinter(AbstractPrinter):
    """
    Documentation
    """

    ARGUMENT = "influence-and-calls"
    HELP = "Prints all influencing relations between variables and the transitive closure for function calls."

    WIKI = "ToDo"

    def output(self, _filename):
        """
        _filename is not used
        Args:
            _filename(string)
        """
        
        fill_dictionary(return_all_dependencies(self.contracts))

        all_tables = []
        all_txt = ""

        txt = ""
        for c in self.contracts:
            if c.is_top_level:
                continue
            txt += "\nContract %s\n" % c.name
            table = MyPrettyTable(["Variable", "Influencers"])
            for v in c.state_variables:
                table.add_row([v.name, _get(v, c)])

            txt += str(table)

            txt += "\n"
            table = MyPrettyTable(["Function", "Internal & External Calls"])
            for f in c.functions_and_modifiers_declared:
                already_considered = set()
                already_considered.add(f)
                called_funcs = calculate_transitive_closure_for_function_recursively(f, already_considered)
                temp = set()                
                for f2 in called_funcs:
                    if not isinstance(f2, tuple):
                        temp.add(f2.full_name)
                table.add_row([f.full_name, [cf for cf in temp]])
                
            txt += str(table)
            
            
            for f in c.functions_and_modifiers_declared:
                txt += "\nFunction %s\n" % f.full_name
                table = MyPrettyTable(["Variable", "Influencers"])
                for v in c.state_variables:
                    table.add_row([v.canonical_name, _get(v, f)])
                txt += str(table)
            
            self.info(txt)

            all_txt += txt
            all_tables.append((c.name, table))

        res = self.generate_output(all_txt)
        for name, table in all_tables:
            res.add_pretty_table(table, name)

        return res
