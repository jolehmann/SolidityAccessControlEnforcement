package edu.kit.kastel.sdq.accesscontrolgenerator.validation

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable
import java.util.ArrayList
import java.util.Collection

class RbacViolationGenerator implements ViolationGenerator {
	
	AccessControlSystem system
	Collection<StateVariable> allVariables = new ArrayList<StateVariable>()
	Collection<Function> allFunctions = new ArrayList<Function>()
		
	/**
	 * Implementation of the interface describing the concrete Strategy for generating violations.
	 * This includes the collection of violations to the four different systemwide RBAC equations.
	 */
	override generateViolations() {
		val violations = new ArrayList<String>()
		violations.addAll(findViolationsWhereRoleCanIllegallyAccessCalledFunctions())
		violations.addAll(checkIfRoleCanModifyAllItsVariables())
		violations.addAll(checkIfRoleCanInfluenceVariablesThroughVariables())
		violations.addAll(checkIfRoleCanInfluenceVariablesThroughFunctions())
		return violations
	}
	
	/**
	 * Add the state variables and functions from the given contract to the corresponding lists
	 */
	override addNewSmartContract(AccessControlContract contract) {
		allVariables.addAll(contract.variables)
		allFunctions.addAll(contract.functions)
	}
	
	/**
	 * Changes the current AccessControlSystem to the given one
	 */
	override changeAccessControlSystem(AccessControlSystem system) {
		this.system = system
	}

	/**
	 * Validates the first RBAC equation which looks like this:
	 * Forall role r, function f and function f_c: (r can access f) and (f calls f_c) implies (r can access f_c)
	 * It handles the transitive access through function calls and shows possible illegal access to functions for certain roles.
	 * This only concerns functions that are not publicly available. All violations to this equation are collected
	 * in a concise error messages and returned.
	 */
	private def Collection<String> findViolationsWhereRoleCanIllegallyAccessCalledFunctions() {
		val violations = new ArrayList<String>()		
		for(role : system.roles) {
			for(func : allFunctions) {
				for (calledFunc : allFunctions) {
					val roleCanAccessFunc = checkIfRoleCanAccessFunction(role, func)
					val funcCallsCalledFunc = checkIfFunctionCanCallFunction(func, calledFunc)
					val roleCanAccessCalledFunc = checkIfRoleCanAccessFunction(role, calledFunc)
					val calleeFuncIsPublic = checkIfFunctionPubliclyAvailable(calledFunc)
					
					if(roleCanAccessFunc && funcCallsCalledFunc && !roleCanAccessCalledFunc && !calleeFuncIsPublic) {
						violations.add('''Role '«role.entityName»' can access function '«calledFunc.entityName»' indirectly through function '«func.entityName»' ''')
					}
				}
			}
		}		
		return violations
	}
	
	/**
	 * Validates the second RBAC equation which looks like this:
	 * Forall role r, variable v: (r can modify s) implies existence of a function f with: (r can access f) and (f can access v)
	 * Violations to this equation show possible shortcomings in the model since it is modelled that a role may modify a variable but
	 * it cannot access any function through which this modification could be done.
	 * All violations to this equation are collected in a concise error messages and returned.
	 */
	private def Collection<String> checkIfRoleCanModifyAllItsVariables() {
		val violations = new ArrayList<String>()
		for(role : system.roles) {
			for(stateVar : allVariables) {
				if(checkIfRoleCanModifyOrInfluenceVariable(role, stateVar, true)) {
					if(!getFunctionsThatCanAccessVariable(stateVar).exists[func | checkIfRoleCanAccessFunction(role, func) || checkIfFunctionPubliclyAvailable(func)]) {
						violations.add('''Role '«role.entityName»' cannot modify variable '«stateVar.entityName»' through any function''')
					}
				}
			}
		}		
		return violations
	}
	
	/**
	 * Validates the last RBAC equation which looks like this:
	 * Forall role r, variable v_1 & v_2: (r can modify v_1) and (r cannot influence v_2) implies (v_1 does not influence v_2)
	 * This equation covers illegal influence by a certain role through a variable it is allowed to access.
	 */
	private def Collection<String> checkIfRoleCanInfluenceVariablesThroughVariables() {
		val violations = new ArrayList<String>()
		for(role : system.roles) {
			for(influencer : allVariables) {
				for(influenced : allVariables) {
					val roleCanModifyInfluencer = checkIfRoleCanModifyOrInfluenceVariable(role, influencer, true)
					val roleCanInfluenceInfluenced = checkIfRoleCanModifyOrInfluenceVariable(role, influenced, false)
					val influencerInfluencesInfluenced = checkIfVariableCanInfluenceVariable(influencer, influenced)
					
					if(roleCanModifyInfluencer && !roleCanInfluenceInfluenced && influencerInfluencesInfluenced) {
						violations.add('''Role '«role.entityName»' can illegally influence variable '«influenced.entityName»' by modifying variable '«influencer.entityName»' ''')
					}
				}
			}
		}		
		return violations
	}
	
	/**
	 * Validates the last RBAC equation which looks like this:
	 * Forall function f, role r, variable v: (r can access f) and (r cannot influence v) implies (f does not influence v)
	 * To verify the (f does not influence v) relation, we use the "checkFunctionForVariableInfluence"-function.
	 * This equation covers illegal access by a role to a variable through a function without
	 * differentiating between modification and influence access. So both kinds are found if they are done illegally.
	 */
	private def Collection<String> checkIfRoleCanInfluenceVariablesThroughFunctions() {
		val violations = new ArrayList<String>()
		for(role : system.roles) {
			for(variable : allVariables) {
				for(func : allFunctions) {
					val roleCanAccessFunc = checkIfRoleCanAccessFunction(role, func)
					val roleCanInfluenceVar = checkIfRoleCanModifyOrInfluenceVariable(role, variable, false)
					val funcCanAccessVar = checkIfFunctionInfluencesVariable(func, variable)
					
					if(roleCanAccessFunc && !roleCanInfluenceVar && funcCanAccessVar != IllegalInfluenceResult.NO_ILLEGAL_ACCESS) {
						violations.add('''Role '«role.entityName»' can illegally «IF funcCanAccessVar == IllegalInfluenceResult.ILLEGAL_MODIFICATION»modify«ELSE»influence«ENDIF» variable '«variable.entityName»' through function '«func.entityName»' ''')
					}
				}
			}
		}		
		return violations
	}
	
	/**
	 * This function checks the influence relation between the given function f and variable v.
	 * To do so, it follows the following predicate equation:
	 * (f influences v) iff (f modifies v) or (Forall variable v_i: (f modifies v_i) and (v_i influences v)) or (Forall function f_c: (f calls f_c) and (f_c influences v))
	 * 
	 * The recursive definition of the predicate can be omitted here since we use the transitive closure, 
	 * so the first two checks need to be copied for every f_c, resulting in this simplification:
	 * (f influences v) iff (f modifies v) or (Forall variable v_i: (f modifies v_i) and (v_i influences v)) or 
	 * (Forall function f_c called by f: (f_c modifies v) or (Forall variable v_i: (f_c modifies v_i) and (v_i influences v)))
	 */
	private def IllegalInfluenceResult checkIfFunctionInfluencesVariable(Function func, StateVariable variable) {
		val directInfluence = checkDirectInfluenceThroughFunction(func, variable)
		if (directInfluence != IllegalInfluenceResult.NO_ILLEGAL_ACCESS) {
			return directInfluence
		}
		
		// Since we previously calculate the transitive closure, we do not need to call this function recursively
		for(calledFunc : system.functionToFunctionTuples.filter[ff | ff.caller.equals(func)].map[ff | ff.callee]) {
			val indirectInfluence = checkDirectInfluenceThroughFunction(func, variable)
			if (indirectInfluence != IllegalInfluenceResult.NO_ILLEGAL_ACCESS) {
				return indirectInfluence
			}
		}
		
		return IllegalInfluenceResult.NO_ILLEGAL_ACCESS
	}
	
	/**
	 * Checks for direct influence through the given function to the state variable.
	 * This can come either through direct access or by directly accessing a variable that influences the
	 * given variable.
	 */
	private def IllegalInfluenceResult checkDirectInfluenceThroughFunction(Function func, StateVariable variable) {
		if(checkIfFunctionCanAccessVariable(func, variable)) {
			return IllegalInfluenceResult.ILLEGAL_MODIFICATION
		}
		
		for(influencer : allVariables) {
			val funcCanAccessInfluencer = checkIfFunctionCanAccessVariable(func, influencer)
			val influencerInfluencesVar = checkIfVariableCanInfluenceVariable(influencer, variable)
			
			if(funcCanAccessInfluencer && influencerInfluencesVar) {
				return IllegalInfluenceResult.ILLEGAL_INFLUENCE
			}
		}
		
		return IllegalInfluenceResult.NO_ILLEGAL_ACCESS
	}
	
	/**
	 * Checks if the given role is allowed to access the given function
	 */
	private def boolean checkIfRoleCanAccessFunction(Role role, Function func) {
		val directAccess = system.roleToFunctionTuples.exists[roleToFunc | roleToFunc.role.equals(role) && roleToFunc.function.equals(func)]
		if(directAccess) {
			return true
		} else {
			for(superior : role.superior) {
				val indirectAccess = system.roleToFunctionTuples.exists[roleToFunc | roleToFunc.role.equals(superior) && roleToFunc.function.equals(func)]
				if(indirectAccess) {
					return true
				}
			}
		}
		return false
	}
	
	/**
	 * Checks if the given function caller is allowed to call the given function callee
	 */
	private def boolean checkIfFunctionCanCallFunction(Function caller, Function callee) {
		return system.functionToFunctionTuples.exists[funcToFunc | funcToFunc.caller.equals(caller) && funcToFunc.callee.equals(callee)]
	}
	
	/**
	 * Checks if the given variable (influencer) can influence the given variable (influenced)
	 */
	private def boolean checkIfVariableCanInfluenceVariable(StateVariable influencer, StateVariable influenced) {
		return system.variableToVariableTuples.exists[varToVar | varToVar.influencer.equals(influencer) && varToVar.influenced.equals(influenced)]
	}
	
	/**
	 * Checks if the given role is allowed either modify or influence the given state variable. This can happen either directly
	 * or indirectly through a superior role. Which kind of access should be checked is determined by the modifies parameter.
	 */
	private def boolean checkIfRoleCanModifyOrInfluenceVariable(Role role, StateVariable stateVar, boolean modifies) {
		val direct = checkIfRoleCanAccessDirectly(role, stateVar, modifies)
		if(direct) {
			return true
		}
		
		val indirect = checkIfRoleCanAccessIndirectlyThroughSuperior(role, stateVar, modifies)
		if(indirect) {
			return true
		}
		
		return false
	}
	
	/**
	 * Checks if the role can either modify or influence the state variable directly
	 */
	private def boolean checkIfRoleCanAccessDirectly(Role role, StateVariable stateVar, boolean modifies) {
		val filtered = system.roleToVariableTuples.filter[roleToVar | roleToVar.role.equals(role) && roleToVar.variable.equals(stateVar)]
		if(filtered.empty) {
			return false
		} else {
			if(modifies) {
				return filtered.exists[roleToVar | roleToVar.modifies]
			} else {
				return true
			}
		}
	}
	
	/**
	 * Checks if the role can either modify or influence the state variable indirectly through a superior role.
	 * This is checked recursively
	 */
	private def boolean checkIfRoleCanAccessIndirectlyThroughSuperior(Role junior, StateVariable stateVar, boolean modifies) {
		for(superior : junior.superior) {
			val indirectAccess =  checkIfRoleCanAccessDirectly(superior, stateVar, modifies)
			if(indirectAccess) {
				return true
			}
		}
		return false
	}
	
	/**
	 * Checks if the given function can access the given variable.
	 */
	private def boolean checkIfFunctionCanAccessVariable(Function func, StateVariable stateVar) {
		val funcToStateVars = system.functionToVariableTuples.filter(FunctionToStateVariableRelation)
		val funcToCsm = system.functionToVariableTuples.filter(FunctionToCsmRelation)
		return funcToStateVars.exists[funcToVar | funcToVar.function.equals(func) && funcToVar.variable.equals(stateVar)] ||
			funcToCsm.exists[funcToVar | funcToVar.function.equals(func) && funcToVar.csm.equals(stateVar)]
	}
	
	/**
	 * Returns all functions that can access the given variable.
	 */
	private def Iterable<Function> getFunctionsThatCanAccessVariable(StateVariable stateVar) {
		return allFunctions.filter[func | checkIfFunctionCanAccessVariable(func, stateVar)]
	}
	
	/**
	 * Checks if the given function is publicly available. This is the case if no roles are modeled to access it.
	 */
	private def boolean checkIfFunctionPubliclyAvailable(Function func) {
		return !system.roleToFunctionTuples.exists[roleToVar | roleToVar.function.equals(func)]
	}
}