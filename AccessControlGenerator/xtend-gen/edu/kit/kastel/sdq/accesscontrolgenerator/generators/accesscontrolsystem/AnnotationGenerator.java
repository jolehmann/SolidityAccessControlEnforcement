package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Class to generate the Solc-Verify annotations in the contract
 */
@SuppressWarnings("all")
public class AnnotationGenerator {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private AccessControlContract currentTarget;

  @Accessors(AccessorType.PUBLIC_SETTER)
  private AccessControlSystem acSystem;

  private final String SOLC_VERIFY_POSTCONDITION = "/// @notice postcondition";

  private final String SOLC_VERIFY_OLD = "__verifier_old_uint";

  /**
   * Constructor setting the AccessControlSystem as a basis for the annotations
   */
  public AnnotationGenerator(final AccessControlSystem acSystem) {
    this.acSystem = acSystem;
  }

  /**
   * Generates the modification annotations for the given function by looking at the variables
   * that are allowed to be changed by the function. It also looks at the balance modifications
   * connected to the function and generates annotations accordingly.
   * If a variable is a Caller-Specific Mapping (CSM), the function can differentiate between
   * address-specific access or general access.
   */
  public String generateModificationAnnotations(final Function func) {
    if ((this.acSystem == null)) {
      return "";
    }
    final Function1<FunctionToVariableRelation, Boolean> _function = new Function1<FunctionToVariableRelation, Boolean>() {
      public Boolean apply(final FunctionToVariableRelation fs) {
        return Boolean.valueOf(fs.getFunction().equals(func));
      }
    };
    final Iterable<FunctionToVariableRelation> relevantFuncToVars = IterableExtensions.<FunctionToVariableRelation>filter(this.acSystem.getFunctionToVariableTuples(), _function);
    final Iterable<FunctionToStateVariableRelation> funcToStateVars = Iterables.<FunctionToStateVariableRelation>filter(relevantFuncToVars, FunctionToStateVariableRelation.class);
    final Iterable<FunctionToCsmRelation> funcToCsms = Iterables.<FunctionToCsmRelation>filter(relevantFuncToVars, FunctionToCsmRelation.class);
    final String balanceAnnot = this.addFunctionBalanceModifications(func);
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(funcToStateVars);
      boolean _not = (!_isEmpty);
      if (_not) {
        String _iterateOverStateVariables = this.iterateOverStateVariables(IterableExtensions.<FunctionToStateVariableRelation>toSet(funcToStateVars));
        _builder.append(_iterateOverStateVariables);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty_1 = IterableExtensions.isEmpty(funcToCsms);
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        String _iterateOverCallerSpecificMappings = this.iterateOverCallerSpecificMappings(IterableExtensions.<FunctionToCsmRelation>toSet(funcToCsms));
        _builder.append(_iterateOverCallerSpecificMappings);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      boolean _isBlank = balanceAnnot.isBlank();
      boolean _not_2 = (!_isBlank);
      if (_not_2) {
        _builder.append(balanceAnnot);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates comments explaining which roles are allowed to access the given function.
   * If no role is allowed to access, a fitting comment is generated & returned.
   */
  public String generateRoleComments(final Function function) {
    if ((this.acSystem == null)) {
      return "";
    }
    final Function1<RoleToFunctionRelation, Boolean> _function = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation rf) {
        return Boolean.valueOf(rf.getFunction().equals(function));
      }
    };
    final Function1<RoleToFunctionRelation, Role> _function_1 = new Function1<RoleToFunctionRelation, Role>() {
      public Role apply(final RoleToFunctionRelation rf) {
        return rf.getRole();
      }
    };
    final Iterable<Role> roleWithDirectAccess = IterableExtensions.<RoleToFunctionRelation, Role>map(IterableExtensions.<RoleToFunctionRelation>filter(this.acSystem.getRoleToFunctionTuples(), _function), _function_1);
    boolean _isEmpty = IterableExtensions.isEmpty(roleWithDirectAccess);
    if (_isEmpty) {
      final EList<Role> allRoles = this.acSystem.getRoles();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// Roles: All Roles can directly access {");
      String _generateAccessCommentContentForRoles = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(allRoles));
      _builder.append(_generateAccessCommentContentForRoles);
      _builder.append("}");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("// Roles: Direct Access by {");
    String _generateAccessCommentContentForRoles_1 = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(roleWithDirectAccess));
    _builder_1.append(_generateAccessCommentContentForRoles_1);
    _builder_1.append("}");
    return _builder_1.toString();
  }

  /**
   * Generates comments explaining which roles are allowed to access the given function.
   * If no role is allowed to access, a fitting comment is generated & returned.
   */
  public String generateRoleBrackets(final Function function) {
    if ((this.acSystem == null)) {
      return "";
    }
    final Function1<RoleToFunctionRelation, Boolean> _function = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation rf) {
        return Boolean.valueOf(rf.getFunction().equals(function));
      }
    };
    final Function1<RoleToFunctionRelation, Role> _function_1 = new Function1<RoleToFunctionRelation, Role>() {
      public Role apply(final RoleToFunctionRelation rf) {
        return rf.getRole();
      }
    };
    final Iterable<Role> roleWithDirectAccess = IterableExtensions.<RoleToFunctionRelation, Role>map(IterableExtensions.<RoleToFunctionRelation>filter(this.acSystem.getRoleToFunctionTuples(), _function), _function_1);
    boolean _isEmpty = IterableExtensions.isEmpty(roleWithDirectAccess);
    if (_isEmpty) {
      final EList<Role> allRoles = this.acSystem.getRoles();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      String _generateAccessCommentContentForRoles = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(allRoles));
      _builder.append(_generateAccessCommentContentForRoles);
      _builder.append("}");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("{");
    String _generateAccessCommentContentForRoles_1 = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(roleWithDirectAccess));
    _builder_1.append(_generateAccessCommentContentForRoles_1);
    _builder_1.append("}");
    return _builder_1.toString();
  }

  /**
   * Generates comments explaining which roles are allowed to access the given state variable.
   * There are two comments generated: One for roles that are allowed to modify the variable and
   * one for roles that are only allowed to influence it. If no role is allowed to access,
   * a fitting comment is generated & returned.
   */
  public String generateRoleComments(final StateVariable variable) {
    if ((this.acSystem == null)) {
      return "";
    }
    final Function1<RoleToVariableRelation, Boolean> _function = new Function1<RoleToVariableRelation, Boolean>() {
      public Boolean apply(final RoleToVariableRelation rv) {
        return Boolean.valueOf((rv.getVariable().equals(variable) && rv.isModifies()));
      }
    };
    final Function1<RoleToVariableRelation, Role> _function_1 = new Function1<RoleToVariableRelation, Role>() {
      public Role apply(final RoleToVariableRelation rv) {
        return rv.getRole();
      }
    };
    final Iterable<Role> rolesWithModAccess = IterableExtensions.<RoleToVariableRelation, Role>map(IterableExtensions.<RoleToVariableRelation>filter(this.acSystem.getRoleToVariableTuples(), _function), _function_1);
    final Function1<RoleToVariableRelation, Boolean> _function_2 = new Function1<RoleToVariableRelation, Boolean>() {
      public Boolean apply(final RoleToVariableRelation rv) {
        return Boolean.valueOf((rv.getVariable().equals(variable) && (!rv.isModifies())));
      }
    };
    final Function1<RoleToVariableRelation, Role> _function_3 = new Function1<RoleToVariableRelation, Role>() {
      public Role apply(final RoleToVariableRelation rv) {
        return rv.getRole();
      }
    };
    final Iterable<Role> rolesWithInfAccess = IterableExtensions.<RoleToVariableRelation, Role>map(IterableExtensions.<RoleToVariableRelation>filter(this.acSystem.getRoleToVariableTuples(), _function_2), _function_3);
    if ((IterableExtensions.isEmpty(rolesWithModAccess) && IterableExtensions.isEmpty(rolesWithInfAccess))) {
      return "// Roles: No Role can modify or influence";
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Roles: Modification by {");
    String _generateAccessCommentContentForRoles = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(rolesWithModAccess));
    _builder.append(_generateAccessCommentContentForRoles);
    _builder.append("}, Influence by {");
    String _generateAccessCommentContentForRoles_1 = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(rolesWithInfAccess));
    _builder.append(_generateAccessCommentContentForRoles_1);
    _builder.append("}");
    return _builder.toString();
  }

  /**
   * Generates comments explaining which roles are allowed to access the given function.
   * If no role is allowed to access, a fitting comment is generated & returned.
   */
  public String generateRoleBrackets(final StateVariable variable) {
    if ((this.acSystem == null)) {
      return "";
    }
    final Function1<RoleToVariableRelation, Boolean> _function = new Function1<RoleToVariableRelation, Boolean>() {
      public Boolean apply(final RoleToVariableRelation rv) {
        return Boolean.valueOf((rv.getVariable().equals(variable) && rv.isModifies()));
      }
    };
    final Function1<RoleToVariableRelation, Role> _function_1 = new Function1<RoleToVariableRelation, Role>() {
      public Role apply(final RoleToVariableRelation rv) {
        return rv.getRole();
      }
    };
    final Iterable<Role> rolesWithModAccess = IterableExtensions.<RoleToVariableRelation, Role>map(IterableExtensions.<RoleToVariableRelation>filter(this.acSystem.getRoleToVariableTuples(), _function), _function_1);
    final Function1<RoleToVariableRelation, Boolean> _function_2 = new Function1<RoleToVariableRelation, Boolean>() {
      public Boolean apply(final RoleToVariableRelation rv) {
        return Boolean.valueOf((rv.getVariable().equals(variable) && (!rv.isModifies())));
      }
    };
    final Function1<RoleToVariableRelation, Role> _function_3 = new Function1<RoleToVariableRelation, Role>() {
      public Role apply(final RoleToVariableRelation rv) {
        return rv.getRole();
      }
    };
    final Iterable<Role> rolesWithInfAccess = IterableExtensions.<RoleToVariableRelation, Role>map(IterableExtensions.<RoleToVariableRelation>filter(this.acSystem.getRoleToVariableTuples(), _function_2), _function_3);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    String _generateAccessCommentContentForRoles = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(rolesWithModAccess));
    _builder.append(_generateAccessCommentContentForRoles);
    _builder.append("}, {");
    String _generateAccessCommentContentForRoles_1 = this.generateAccessCommentContentForRoles(IterableExtensions.<Role>toSet(rolesWithInfAccess));
    _builder.append(_generateAccessCommentContentForRoles_1);
    _builder.append("}");
    return _builder.toString();
  }

  /**
   * Generates the content of a single comment visualizing role access to variables or functions.
   * This function iterates over the list of roles and adds the enum value name to the comment.
   * If the list is empty, "None" is returned.
   */
  private String generateAccessCommentContentForRoles(final Set<Role> roles) {
    boolean _isEmpty = roles.isEmpty();
    if (_isEmpty) {
      return "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasElements = false;
        for(final Role role : roles) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(role);
          _builder.append(_roleEnumValueForRole);
        }
      }
      return _builder.toString();
    }
  }

  /**
   * Iterate over all relations accessing state variables, generating one annotation per relation.
   */
  private String iterateOverStateVariables(final Set<FunctionToStateVariableRelation> relations) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final FunctionToStateVariableRelation funcToVar : relations) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("", "");
        }
        _builder.newLineIfNotEmpty();
        String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
        _builder.append(_solcVerifyModificationSpecifier);
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(funcToVar.getVariable().getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
        _builder.append(" ");
        String _addConditionToModifiesFromBooleanContext = this.addConditionToModifiesFromBooleanContext(funcToVar);
        _builder.append(_addConditionToModifiesFromBooleanContext);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  /**
   * Iterate over all relations accessing csm variables, generating one annotation per relation.
   */
  private String iterateOverCallerSpecificMappings(final Set<FunctionToCsmRelation> relations) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final FunctionToCsmRelation funcToVar : relations) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("", "");
        }
        _builder.newLineIfNotEmpty();
        String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
        _builder.append(_solcVerifyModificationSpecifier);
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(funcToVar.getCsm().getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
        {
          boolean _isAccessWholeMapping = funcToVar.isAccessWholeMapping();
          boolean _not = (!_isAccessWholeMapping);
          if (_not) {
            _builder.append("[");
            String _msgSenderKeyword = AccessControlConstants.getMsgSenderKeyword();
            _builder.append(_msgSenderKeyword);
            _builder.append("]");
          }
        }
        _builder.append(" ");
        String _addConditionToModifiesFromBooleanContext = this.addConditionToModifiesFromBooleanContext(funcToVar);
        _builder.append(_addConditionToModifiesFromBooleanContext);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  /**
   * Add a boolean condition to a modification specifier, if the given relation contains any
   */
  private String addConditionToModifiesFromBooleanContext(final FunctionToVariableRelation relation) {
    boolean _isEmpty = relation.getConditions().isEmpty();
    if (_isEmpty) {
      return "";
    }
    final Iterable<BooleanVariableContext> booleanConds = Iterables.<BooleanVariableContext>filter(relation.getConditions(), BooleanVariableContext.class);
    boolean _isEmpty_1 = IterableExtensions.isEmpty(booleanConds);
    if (_isEmpty_1) {
      return "";
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if ");
    {
      boolean _hasElements = false;
      for(final BooleanVariableContext cond : booleanConds) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" && ", "");
        }
        {
          boolean _isValueToCheck = cond.isValueToCheck();
          boolean _not = (!_isValueToCheck);
          if (_not) {
            _builder.append("!");
          }
        }
        String _firstLower = StringExtensions.toFirstLower(cond.getVariable().getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
      }
    }
    return _builder.toString();
  }

  /**
   * Returns the annotations based on the balance modifications for the given function.
   */
  private String addFunctionBalanceModifications(final Function func) {
    final Function1<FunctionBalanceModification, Boolean> _function = new Function1<FunctionBalanceModification, Boolean>() {
      public Boolean apply(final FunctionBalanceModification bm) {
        return Boolean.valueOf(bm.getFunction().equals(func));
      }
    };
    final Iterable<FunctionBalanceModification> balanceMods = IterableExtensions.<FunctionBalanceModification>filter(this.currentTarget.getBalanceModifications(), _function);
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final FunctionBalanceModification balance : balanceMods) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("", "");
        }
        _builder.newLineIfNotEmpty();
        String _checkBalanceModificationEnum = this.checkBalanceModificationEnum(balance.getModifiesMsgSenderBalance(), true);
        _builder.append(_checkBalanceModificationEnum);
        _builder.newLineIfNotEmpty();
        String _checkBalanceModificationEnum_1 = this.checkBalanceModificationEnum(balance.getModifiesThisContractsBalance(), false);
        _builder.append(_checkBalanceModificationEnum_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  /**
   * This function checks the given BalanceModificationType and creates the fitting annotations.
   * Differentiating between the two possible keywords is done through the boolean parameter.
   * Possibilities:
   * - DOES_NOT_MODIFY: Nothing
   * - ONLY_DECREASE: Modification specifier & postcondition checking for decrease
   * - ONLY_INCREASE: Modification specifier & postcondition checking for increase
   * - MODIFIES_BOTH_WAYS: Modification specifier only
   */
  private String checkBalanceModificationEnum(final BalanceModificationType modType, final boolean isMsgSender) {
    String _xifexpression = null;
    if (isMsgSender) {
      _xifexpression = AccessControlConstants.getMsgSenderKeyword();
    } else {
      _xifexpression = AccessControlConstants.getThisAddressKeyword();
    }
    final String keyword = (_xifexpression + ".balance");
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(modType, BalanceModificationType.DOES_NOT_MODIFY));
      if (_notEquals) {
        String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
        _builder.append(_solcVerifyModificationSpecifier);
        _builder.append(" ");
        _builder.append(keyword);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if ((modType == BalanceModificationType.ONLY_DECREASE)) {
        _builder.append(this.SOLC_VERIFY_POSTCONDITION);
        _builder.append(" ");
        _builder.append(keyword);
        _builder.append(" <= ");
        _builder.append(this.SOLC_VERIFY_OLD);
        _builder.append("(");
        _builder.append(keyword);
        _builder.append(")");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if ((modType == BalanceModificationType.ONLY_INCREASE)) {
        _builder.append(this.SOLC_VERIFY_POSTCONDITION);
        _builder.append(" ");
        _builder.append(keyword);
        _builder.append(" >= ");
        _builder.append(this.SOLC_VERIFY_OLD);
        _builder.append("(");
        _builder.append(keyword);
        _builder.append(")");
      }
    }
    return _builder.toString();
  }

  public void setCurrentTarget(final AccessControlContract currentTarget) {
    this.currentTarget = currentTarget;
  }

  public void setAcSystem(final AccessControlSystem acSystem) {
    this.acSystem = acSystem;
  }
}
