package edu.kit.kastel.sdq.accesscontrolgenerator.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RbacViolationGenerator implements ViolationGenerator {
  private AccessControlSystem system;

  private Collection<StateVariable> allVariables = new ArrayList<StateVariable>();

  private Collection<Function> allFunctions = new ArrayList<Function>();

  /**
   * Implementation of the interface describing the concrete Strategy for generating violations.
   * This includes the collection of violations to the four different systemwide RBAC equations.
   */
  public Collection<String> generateViolations() {
    final ArrayList<String> violations = new ArrayList<String>();
    violations.addAll(this.findViolationsWhereRoleCanIllegallyAccessCalledFunctions());
    violations.addAll(this.checkIfRoleCanModifyAllItsVariables());
    violations.addAll(this.checkIfRoleCanInfluenceVariablesThroughVariables());
    violations.addAll(this.checkIfRoleCanInfluenceVariablesThroughFunctions());
    return violations;
  }

  /**
   * Add the state variables and functions from the given contract to the corresponding lists
   */
  public void addNewSmartContract(final AccessControlContract contract) {
    this.allVariables.addAll(contract.getVariables());
    this.allFunctions.addAll(contract.getFunctions());
  }

  /**
   * Changes the current AccessControlSystem to the given one
   */
  public void changeAccessControlSystem(final AccessControlSystem system) {
    this.system = system;
  }

  /**
   * Validates the first RBAC equation which looks like this:
   * Forall role r, function f and function f_c: (r can access f) and (f calls f_c) implies (r can access f_c)
   * It handles the transitive access through function calls and shows possible illegal access to functions for certain roles.
   * This only concerns functions that are not publicly available. All violations to this equation are collected
   * in a concise error messages and returned.
   */
  private Collection<String> findViolationsWhereRoleCanIllegallyAccessCalledFunctions() {
    final ArrayList<String> violations = new ArrayList<String>();
    EList<Role> _roles = this.system.getRoles();
    for (final Role role : _roles) {
      for (final Function func : this.allFunctions) {
        for (final Function calledFunc : this.allFunctions) {
          {
            final boolean roleCanAccessFunc = this.checkIfRoleCanAccessFunction(role, func);
            final boolean funcCallsCalledFunc = this.checkIfFunctionCanCallFunction(func, calledFunc);
            final boolean roleCanAccessCalledFunc = this.checkIfRoleCanAccessFunction(role, calledFunc);
            final boolean calleeFuncIsPublic = this.checkIfFunctionPubliclyAvailable(calledFunc);
            if ((((roleCanAccessFunc && funcCallsCalledFunc) && (!roleCanAccessCalledFunc)) && (!calleeFuncIsPublic))) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Role \'");
              String _entityName = role.getEntityName();
              _builder.append(_entityName);
              _builder.append("\' can access function \'");
              String _entityName_1 = calledFunc.getEntityName();
              _builder.append(_entityName_1);
              _builder.append("\' indirectly through function \'");
              String _entityName_2 = func.getEntityName();
              _builder.append(_entityName_2);
              _builder.append("\' ");
              violations.add(_builder.toString());
            }
          }
        }
      }
    }
    return violations;
  }

  /**
   * Validates the second RBAC equation which looks like this:
   * Forall role r, variable v: (r can modify s) implies existence of a function f with: (r can access f) and (f can access v)
   * Violations to this equation show possible shortcomings in the model since it is modelled that a role may modify a variable but
   * it cannot access any function through which this modification could be done.
   * All violations to this equation are collected in a concise error messages and returned.
   */
  private Collection<String> checkIfRoleCanModifyAllItsVariables() {
    final ArrayList<String> violations = new ArrayList<String>();
    EList<Role> _roles = this.system.getRoles();
    for (final Role role : _roles) {
      for (final StateVariable stateVar : this.allVariables) {
        boolean _checkIfRoleCanModifyOrInfluenceVariable = this.checkIfRoleCanModifyOrInfluenceVariable(role, stateVar, true);
        if (_checkIfRoleCanModifyOrInfluenceVariable) {
          final Function1<Function, Boolean> _function = new Function1<Function, Boolean>() {
            public Boolean apply(final Function func) {
              return Boolean.valueOf((RbacViolationGenerator.this.checkIfRoleCanAccessFunction(role, func) || RbacViolationGenerator.this.checkIfFunctionPubliclyAvailable(func)));
            }
          };
          boolean _exists = IterableExtensions.<Function>exists(this.getFunctionsThatCanAccessVariable(stateVar), _function);
          boolean _not = (!_exists);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Role \'");
            String _entityName = role.getEntityName();
            _builder.append(_entityName);
            _builder.append("\' cannot modify variable \'");
            String _entityName_1 = stateVar.getEntityName();
            _builder.append(_entityName_1);
            _builder.append("\' through any function");
            violations.add(_builder.toString());
          }
        }
      }
    }
    return violations;
  }

  /**
   * Validates the last RBAC equation which looks like this:
   * Forall role r, variable v_1 & v_2: (r can modify v_1) and (r cannot influence v_2) implies (v_1 does not influence v_2)
   * This equation covers illegal influence by a certain role through a variable it is allowed to access.
   */
  private Collection<String> checkIfRoleCanInfluenceVariablesThroughVariables() {
    final ArrayList<String> violations = new ArrayList<String>();
    EList<Role> _roles = this.system.getRoles();
    for (final Role role : _roles) {
      for (final StateVariable influencer : this.allVariables) {
        for (final StateVariable influenced : this.allVariables) {
          {
            final boolean roleCanModifyInfluencer = this.checkIfRoleCanModifyOrInfluenceVariable(role, influencer, true);
            final boolean roleCanInfluenceInfluenced = this.checkIfRoleCanModifyOrInfluenceVariable(role, influenced, false);
            final boolean influencerInfluencesInfluenced = this.checkIfVariableCanInfluenceVariable(influencer, influenced);
            if (((roleCanModifyInfluencer && (!roleCanInfluenceInfluenced)) && influencerInfluencesInfluenced)) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Role \'");
              String _entityName = role.getEntityName();
              _builder.append(_entityName);
              _builder.append("\' can illegally influence variable \'");
              String _entityName_1 = influenced.getEntityName();
              _builder.append(_entityName_1);
              _builder.append("\' by modifying variable \'");
              String _entityName_2 = influencer.getEntityName();
              _builder.append(_entityName_2);
              _builder.append("\' ");
              violations.add(_builder.toString());
            }
          }
        }
      }
    }
    return violations;
  }

  /**
   * Validates the last RBAC equation which looks like this:
   * Forall function f, role r, variable v: (r can access f) and (r cannot influence v) implies (f does not influence v)
   * To verify the (f does not influence v) relation, we use the "checkFunctionForVariableInfluence"-function.
   * This equation covers illegal access by a role to a variable through a function without
   * differentiating between modification and influence access. So both kinds are found if they are done illegally.
   */
  private Collection<String> checkIfRoleCanInfluenceVariablesThroughFunctions() {
    final ArrayList<String> violations = new ArrayList<String>();
    EList<Role> _roles = this.system.getRoles();
    for (final Role role : _roles) {
      for (final StateVariable variable : this.allVariables) {
        for (final Function func : this.allFunctions) {
          {
            final boolean roleCanAccessFunc = this.checkIfRoleCanAccessFunction(role, func);
            final boolean roleCanInfluenceVar = this.checkIfRoleCanModifyOrInfluenceVariable(role, variable, false);
            final IllegalInfluenceResult funcCanAccessVar = this.checkIfFunctionInfluencesVariable(func, variable);
            if (((roleCanAccessFunc && (!roleCanInfluenceVar)) && (!Objects.equal(funcCanAccessVar, IllegalInfluenceResult.NO_ILLEGAL_ACCESS)))) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Role \'");
              String _entityName = role.getEntityName();
              _builder.append(_entityName);
              _builder.append("\' can illegally ");
              {
                boolean _equals = Objects.equal(funcCanAccessVar, IllegalInfluenceResult.ILLEGAL_MODIFICATION);
                if (_equals) {
                  _builder.append("modify");
                } else {
                  _builder.append("influence");
                }
              }
              _builder.append(" variable \'");
              String _entityName_1 = variable.getEntityName();
              _builder.append(_entityName_1);
              _builder.append("\' through function \'");
              String _entityName_2 = func.getEntityName();
              _builder.append(_entityName_2);
              _builder.append("\' ");
              violations.add(_builder.toString());
            }
          }
        }
      }
    }
    return violations;
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
  private IllegalInfluenceResult checkIfFunctionInfluencesVariable(final Function func, final StateVariable variable) {
    final IllegalInfluenceResult directInfluence = this.checkDirectInfluenceThroughFunction(func, variable);
    boolean _notEquals = (!Objects.equal(directInfluence, IllegalInfluenceResult.NO_ILLEGAL_ACCESS));
    if (_notEquals) {
      return directInfluence;
    }
    final Function1<FunctionToFunctionRelation, Boolean> _function = new Function1<FunctionToFunctionRelation, Boolean>() {
      public Boolean apply(final FunctionToFunctionRelation ff) {
        return Boolean.valueOf(ff.getCaller().equals(func));
      }
    };
    final Function1<FunctionToFunctionRelation, Function> _function_1 = new Function1<FunctionToFunctionRelation, Function>() {
      public Function apply(final FunctionToFunctionRelation ff) {
        return ff.getCallee();
      }
    };
    Iterable<Function> _map = IterableExtensions.<FunctionToFunctionRelation, Function>map(IterableExtensions.<FunctionToFunctionRelation>filter(this.system.getFunctionToFunctionTuples(), _function), _function_1);
    for (final Function calledFunc : _map) {
      {
        final IllegalInfluenceResult indirectInfluence = this.checkDirectInfluenceThroughFunction(func, variable);
        boolean _notEquals_1 = (!Objects.equal(indirectInfluence, IllegalInfluenceResult.NO_ILLEGAL_ACCESS));
        if (_notEquals_1) {
          return indirectInfluence;
        }
      }
    }
    return IllegalInfluenceResult.NO_ILLEGAL_ACCESS;
  }

  /**
   * Checks for direct influence through the given function to the state variable.
   * This can come either through direct access or by directly accessing a variable that influences the
   * given variable.
   */
  private IllegalInfluenceResult checkDirectInfluenceThroughFunction(final Function func, final StateVariable variable) {
    boolean _checkIfFunctionCanAccessVariable = this.checkIfFunctionCanAccessVariable(func, variable);
    if (_checkIfFunctionCanAccessVariable) {
      return IllegalInfluenceResult.ILLEGAL_MODIFICATION;
    }
    for (final StateVariable influencer : this.allVariables) {
      {
        final boolean funcCanAccessInfluencer = this.checkIfFunctionCanAccessVariable(func, influencer);
        final boolean influencerInfluencesVar = this.checkIfVariableCanInfluenceVariable(influencer, variable);
        if ((funcCanAccessInfluencer && influencerInfluencesVar)) {
          return IllegalInfluenceResult.ILLEGAL_INFLUENCE;
        }
      }
    }
    return IllegalInfluenceResult.NO_ILLEGAL_ACCESS;
  }

  /**
   * Checks if the given role is allowed to access the given function
   */
  private boolean checkIfRoleCanAccessFunction(final Role role, final Function func) {
    final Function1<RoleToFunctionRelation, Boolean> _function = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation roleToFunc) {
        return Boolean.valueOf((roleToFunc.getRole().equals(role) && roleToFunc.getFunction().equals(func)));
      }
    };
    final boolean directAccess = IterableExtensions.<RoleToFunctionRelation>exists(this.system.getRoleToFunctionTuples(), _function);
    if (directAccess) {
      return true;
    } else {
      EList<Role> _superior = role.getSuperior();
      for (final Role superior : _superior) {
        {
          final Function1<RoleToFunctionRelation, Boolean> _function_1 = new Function1<RoleToFunctionRelation, Boolean>() {
            public Boolean apply(final RoleToFunctionRelation roleToFunc) {
              return Boolean.valueOf((roleToFunc.getRole().equals(superior) && roleToFunc.getFunction().equals(func)));
            }
          };
          final boolean indirectAccess = IterableExtensions.<RoleToFunctionRelation>exists(this.system.getRoleToFunctionTuples(), _function_1);
          if (indirectAccess) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Checks if the given function caller is allowed to call the given function callee
   */
  private boolean checkIfFunctionCanCallFunction(final Function caller, final Function callee) {
    final Function1<FunctionToFunctionRelation, Boolean> _function = new Function1<FunctionToFunctionRelation, Boolean>() {
      public Boolean apply(final FunctionToFunctionRelation funcToFunc) {
        return Boolean.valueOf((funcToFunc.getCaller().equals(caller) && funcToFunc.getCallee().equals(callee)));
      }
    };
    return IterableExtensions.<FunctionToFunctionRelation>exists(this.system.getFunctionToFunctionTuples(), _function);
  }

  /**
   * Checks if the given variable (influencer) can influence the given variable (influenced)
   */
  private boolean checkIfVariableCanInfluenceVariable(final StateVariable influencer, final StateVariable influenced) {
    final Function1<VariableToVariableRelation, Boolean> _function = new Function1<VariableToVariableRelation, Boolean>() {
      public Boolean apply(final VariableToVariableRelation varToVar) {
        return Boolean.valueOf((varToVar.getInfluencer().equals(influencer) && varToVar.getInfluenced().equals(influenced)));
      }
    };
    return IterableExtensions.<VariableToVariableRelation>exists(this.system.getVariableToVariableTuples(), _function);
  }

  /**
   * Checks if the given role is allowed either modify or influence the given state variable. This can happen either directly
   * or indirectly through a superior role. Which kind of access should be checked is determined by the modifies parameter.
   */
  private boolean checkIfRoleCanModifyOrInfluenceVariable(final Role role, final StateVariable stateVar, final boolean modifies) {
    final boolean direct = this.checkIfRoleCanAccessDirectly(role, stateVar, modifies);
    if (direct) {
      return true;
    }
    final boolean indirect = this.checkIfRoleCanAccessIndirectlyThroughSuperior(role, stateVar, modifies);
    if (indirect) {
      return true;
    }
    return false;
  }

  /**
   * Checks if the role can either modify or influence the state variable directly
   */
  private boolean checkIfRoleCanAccessDirectly(final Role role, final StateVariable stateVar, final boolean modifies) {
    final Function1<RoleToVariableRelation, Boolean> _function = new Function1<RoleToVariableRelation, Boolean>() {
      public Boolean apply(final RoleToVariableRelation roleToVar) {
        return Boolean.valueOf((roleToVar.getRole().equals(role) && roleToVar.getVariable().equals(stateVar)));
      }
    };
    final Iterable<RoleToVariableRelation> filtered = IterableExtensions.<RoleToVariableRelation>filter(this.system.getRoleToVariableTuples(), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(filtered);
    if (_isEmpty) {
      return false;
    } else {
      if (modifies) {
        final Function1<RoleToVariableRelation, Boolean> _function_1 = new Function1<RoleToVariableRelation, Boolean>() {
          public Boolean apply(final RoleToVariableRelation roleToVar) {
            return Boolean.valueOf(roleToVar.isModifies());
          }
        };
        return IterableExtensions.<RoleToVariableRelation>exists(filtered, _function_1);
      } else {
        return true;
      }
    }
  }

  /**
   * Checks if the role can either modify or influence the state variable indirectly through a superior role.
   * This is checked recursively
   */
  private boolean checkIfRoleCanAccessIndirectlyThroughSuperior(final Role junior, final StateVariable stateVar, final boolean modifies) {
    EList<Role> _superior = junior.getSuperior();
    for (final Role superior : _superior) {
      {
        final boolean indirectAccess = this.checkIfRoleCanAccessDirectly(superior, stateVar, modifies);
        if (indirectAccess) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks if the given function can access the given variable.
   */
  private boolean checkIfFunctionCanAccessVariable(final Function func, final StateVariable stateVar) {
    final Iterable<FunctionToStateVariableRelation> funcToStateVars = Iterables.<FunctionToStateVariableRelation>filter(this.system.getFunctionToVariableTuples(), FunctionToStateVariableRelation.class);
    final Iterable<FunctionToCsmRelation> funcToCsm = Iterables.<FunctionToCsmRelation>filter(this.system.getFunctionToVariableTuples(), FunctionToCsmRelation.class);
    return (IterableExtensions.<FunctionToStateVariableRelation>exists(funcToStateVars, new Function1<FunctionToStateVariableRelation, Boolean>() {
      public Boolean apply(final FunctionToStateVariableRelation funcToVar) {
        return Boolean.valueOf((funcToVar.getFunction().equals(func) && funcToVar.getVariable().equals(stateVar)));
      }
    }) || 
      IterableExtensions.<FunctionToCsmRelation>exists(funcToCsm, new Function1<FunctionToCsmRelation, Boolean>() {
        public Boolean apply(final FunctionToCsmRelation funcToVar) {
          return Boolean.valueOf((funcToVar.getFunction().equals(func) && funcToVar.getCsm().equals(stateVar)));
        }
      }));
  }

  /**
   * Returns all functions that can access the given variable.
   */
  private Iterable<Function> getFunctionsThatCanAccessVariable(final StateVariable stateVar) {
    final Function1<Function, Boolean> _function = new Function1<Function, Boolean>() {
      public Boolean apply(final Function func) {
        return Boolean.valueOf(RbacViolationGenerator.this.checkIfFunctionCanAccessVariable(func, stateVar));
      }
    };
    return IterableExtensions.<Function>filter(this.allFunctions, _function);
  }

  /**
   * Checks if the given function is publicly available. This is the case if no roles are modeled to access it.
   */
  private boolean checkIfFunctionPubliclyAvailable(final Function func) {
    final Function1<RoleToFunctionRelation, Boolean> _function = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation roleToVar) {
        return Boolean.valueOf(roleToVar.getFunction().equals(func));
      }
    };
    boolean _exists = IterableExtensions.<RoleToFunctionRelation>exists(this.system.getRoleToFunctionTuples(), _function);
    return (!_exists);
  }
}
