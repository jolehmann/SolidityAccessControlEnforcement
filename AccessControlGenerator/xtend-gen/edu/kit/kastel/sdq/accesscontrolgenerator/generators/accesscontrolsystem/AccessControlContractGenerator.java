package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Context;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityContractGenerationTemplate;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generator to create the access control smart contract from an access control system model using the contract template
 */
@SuppressWarnings("all")
public class AccessControlContractGenerator extends SolidityContractGenerationTemplate {
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PRIVATE_GETTER })
  private AccessControlSystem target;
  
  @Accessors(AccessorType.PRIVATE_GETTER)
  private boolean timingNeeded;
  
  private final int DEFAULT_CARD = (-1);
  
  private final String ADMIN_ROLE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("admin");
      return _builder.toString();
    }
  }.apply();
  
  private final String ONLY_ADMIN_MOD = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("onlyAdmin");
      return _builder.toString();
    }
  }.apply();
  
  private final String ASSIGNMENT_VAR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("roleAssignment");
      return _builder.toString();
    }
  }.apply();
  
  private final String TIME_VAR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("timeAtStart");
      return _builder.toString();
    }
  }.apply();
  
  private final String TIMESTAMP_KEYWORD = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("block.timestamp");
      return _builder.toString();
    }
  }.apply();
  
  private final String COUNTER_SUFFIX = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Counter");
      return _builder.toString();
    }
  }.apply();
  
  private final String ENTITY_PARAM = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity");
      return _builder.toString();
    }
  }.apply();
  
  private final String GIVE_ROLE_PARAM = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("giveRole");
      return _builder.toString();
    }
  }.apply();
  
  /**
   * Constructor setting the AccessControlSystem to generate the contracts content for and
   * checking, if the handling of time-based constraints is needed.
   */
  public AccessControlContractGenerator(final AccessControlSystem acsystem) {
    this.target = acsystem;
    this.timingNeeded = this.checkIfTimingIsNeeded();
  }
  
  /**
   * Generates the contracts import statement, which is not necessary for the AccessControl contract
   */
  protected String generateImports() {
    return "";
  }
  
  /**
   * Generating the declaration of the access control contract
   */
  protected String generateDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("contract ");
    String _accessControlContactName = AccessControlConstants.getAccessControlContactName();
    _builder.append(_accessControlContactName);
    return _builder.toString();
  }
  
  /**
   * Generates the enum for the roles from the AccessControlSystem
   */
  protected String generateEnums() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Roles { ");
    {
      EList<Role> _roles = this.target.getRoles();
      boolean _hasElements = false;
      for(final Role role : _roles) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(role);
        _builder.append(_roleEnumValueForRole);
      }
    }
    _builder.append(", ");
    String _upperCase = this.ADMIN_ROLE.toUpperCase();
    _builder.append(_upperCase);
    _builder.append(" }");
    return _builder.toString();
  }
  
  /**
   * Generates the structs for the access control contract, which is not necessary
   */
  protected String generateStructs() {
    return "";
  }
  
  /**
   * Generates the state variables for the access control contract.
   * This includes:
   * - nested mapping from addresses to possible roles
   * - time variable if time-based constraints are handled
   * - counter for roles with no default cardinality
   * «FOR role : target.roles SEPARATOR ", "»«getRoleEnumValueForRole(role)»«ENDFOR»
   */
  protected String generateFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mapping(address => mapping(");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(" => bool)) private ");
    _builder.append(this.ASSIGNMENT_VAR);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      if (this.timingNeeded) {
        _builder.append("uint256 private ");
        _builder.append(this.TIME_VAR);
        _builder.append(" = 0;");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      final Function1<Role, Boolean> _function = new Function1<Role, Boolean>() {
        public Boolean apply(final Role r) {
          int _cardinality = r.getCardinality();
          return Boolean.valueOf((_cardinality != AccessControlContractGenerator.this.DEFAULT_CARD));
        }
      };
      Iterable<Role> _filter = IterableExtensions.<Role>filter(this.target.getRoles(), _function);
      boolean _hasElements = false;
      for(final Role role : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        _builder.append("uint private ");
        String _firstLower = StringExtensions.toFirstLower(role.getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
        _builder.append(this.COUNTER_SUFFIX);
        _builder.append(" = 0;");
      }
    }
    return _builder.toString();
  }
  
  /**
   * Generates the contracts events, which is not necessary for the AccessControl contract
   */
  protected String generateEvents() {
    return "";
  }
  
  /**
   * Generates the access control contracts constructor containing:
   * - the header with its parameter
   * - assignment of the admin role to the sender as well as this contract
   * - setting of the timing variable (if necessary)
   */
  protected String generateConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("constructor(address ");
    _builder.append(this.ADMIN_ROLE);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.ASSIGNMENT_VAR, "\t");
    _builder.append("[");
    _builder.append(this.ADMIN_ROLE, "\t");
    _builder.append("][");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName, "\t");
    _builder.append(".");
    String _upperCase = this.ADMIN_ROLE.toUpperCase();
    _builder.append(_upperCase, "\t");
    _builder.append("] = true;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      if (this.timingNeeded) {
        _builder.append(this.TIME_VAR, "\t");
        _builder.append(" = ");
        _builder.append(this.TIMESTAMP_KEYWORD, "\t");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Generates the methods for the access control contract, which includes:
   * - the function to check access
   * - the function to check the timing (if necessary)
   * - either use basic role assignment in a single function or...
   * - create one assignment function per role
   */
  protected String generateMethods() {
    StringConcatenation _builder = new StringConcatenation();
    String _generateCheckAccessFunction = this.generateCheckAccessFunction();
    _builder.append(_generateCheckAccessFunction);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      if (this.timingNeeded) {
        String _generateCheckTimingFunction = this.generateCheckTimingFunction();
        _builder.append(_generateCheckTimingFunction);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _checkForBasicRoleAssignment = this.checkForBasicRoleAssignment();
      if (_checkForBasicRoleAssignment) {
        String _generateBasicRoleAssignment = this.generateBasicRoleAssignment();
        _builder.append(_generateBasicRoleAssignment);
        _builder.newLineIfNotEmpty();
      } else {
        {
          EList<Role> _roles = this.target.getRoles();
          boolean _hasElements = false;
          for(final Role role : _roles) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              String _lineSeparator = System.lineSeparator();
              String _lineSeparator_1 = System.lineSeparator();
              String _plus = (_lineSeparator + _lineSeparator_1);
              _builder.appendImmediate(_plus, "");
            }
            String _generateRoleAssignmentForRole = this.generateRoleAssignmentForRole(role);
            _builder.append(_generateRoleAssignmentForRole);
          }
        }
        _builder.newLineIfNotEmpty();
        String _generateRoleAssignmentForAdmin = this.generateRoleAssignmentForAdmin();
        _builder.append(_generateRoleAssignmentForAdmin);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Generating the onlyAdmin modifier at the end of the contract.
   */
  protected String generateModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("modifier ");
    _builder.append(this.ONLY_ADMIN_MOD);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("require(");
    String _accessCheckingFunctionName = AccessControlConstants.getAccessCheckingFunctionName();
    _builder.append(_accessCheckingFunctionName, "\t");
    _builder.append("(");
    String _msgSenderKeyword = AccessControlConstants.getMsgSenderKeyword();
    _builder.append(_msgSenderKeyword, "\t");
    _builder.append(", ");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName, "\t");
    _builder.append(".");
    String _upperCase = this.ADMIN_ROLE.toUpperCase();
    _builder.append(_upperCase, "\t");
    _builder.append("), \"");
    String _accessControlRequiresMessage = AccessControlConstants.getAccessControlRequiresMessage();
    _builder.append(_accessControlRequiresMessage, "\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("_;");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Checks if handling time-based constraints is necessary in the AccessControlSystem.
   * This is the case if a single time-based condition exists inside the system.
   */
  private boolean checkIfTimingIsNeeded() {
    EList<RoleToFunctionRelation> _roleToFunctionTuples = this.target.getRoleToFunctionTuples();
    for (final RoleToFunctionRelation roleToFunc : _roleToFunctionTuples) {
      EList<Context> _conditions = roleToFunc.getConditions();
      for (final Context cond : _conditions) {
        if ((cond instanceof TimeContext)) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Generates the checkAccess function, accessing the RoleAssignment nested mapping for the given role and address
   */
  private String generateCheckAccessFunction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("function ");
    String _accessCheckingFunctionName = AccessControlConstants.getAccessCheckingFunctionName();
    _builder.append(_accessCheckingFunctionName);
    _builder.append("(address ");
    _builder.append(this.ENTITY_PARAM);
    _builder.append(", ");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(" role) public view returns(bool result) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    _builder.append(this.ASSIGNMENT_VAR, "\t");
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM, "\t");
    _builder.append("][role];");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Generates the checkTiming function, allowing for checking time-based constraints during execution
   */
  private String generateCheckTimingFunction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("function ");
    String _timingCheckFunctionName = AccessControlConstants.getTimingCheckFunctionName();
    _builder.append(_timingCheckFunctionName);
    _builder.append("(bool upper, uint256 addition) public view returns(bool result) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if(upper) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    _builder.append(this.TIMESTAMP_KEYWORD, "\t\t");
    _builder.append(" >= timeAtStart + addition;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    _builder.append(this.TIMESTAMP_KEYWORD, "\t\t");
    _builder.append(" <= timeAtStart + addition;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Checks if basic role assignment in a single function should be used.
   * That is the case, when no special role conditions are modelled.
   * These include:
   * - role cardinality
   * - mutual exclusion
   * - role hierarchy
   * - role prerequisites
   */
  private boolean checkForBasicRoleAssignment() {
    boolean _isEmpty = this.target.getRoleExclusions().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return false;
    }
    EList<Role> _roles = this.target.getRoles();
    for (final Role role : _roles) {
      {
        int _cardinality = role.getCardinality();
        boolean _notEquals = (_cardinality != this.DEFAULT_CARD);
        if (_notEquals) {
          return false;
        }
        boolean _isEmpty_1 = role.getPrerequisite().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          return false;
        }
        boolean _isEmpty_2 = role.getSuperior().isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Generates the basic role assignment function assessing the nested mapping for the given role and address
   */
  private String generateBasicRoleAssignment() {
    StringConcatenation _builder = new StringConcatenation();
    String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
    _builder.append(_solcVerifyModificationSpecifier);
    _builder.append(" ");
    _builder.append(this.ASSIGNMENT_VAR);
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM);
    _builder.append("][role]");
    _builder.newLineIfNotEmpty();
    _builder.append("function changeRoleAssignment(address ");
    _builder.append(this.ENTITY_PARAM);
    _builder.append(", ");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(" role, bool give) external ");
    _builder.append(this.ONLY_ADMIN_MOD);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.ASSIGNMENT_VAR, "\t");
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM, "\t");
    _builder.append("][role] = give;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Generating a role assignment function for the given role when the basic role assignment is NOT used.
   * This also handles the special role conditions like cardinality, mutual exclusion, role hierarchy and prerequisite.
   */
  private String generateRoleAssignmentForRole(final Role role) {
    StringConcatenation _builder = new StringConcatenation();
    String _generateAnnotationsForSingleRoleAssignment = this.generateAnnotationsForSingleRoleAssignment(role);
    _builder.append(_generateAnnotationsForSingleRoleAssignment);
    _builder.newLineIfNotEmpty();
    _builder.append("function change");
    String _replaceAll = role.getEntityName().replaceAll(" ", "");
    _builder.append(_replaceAll);
    _builder.append("RoleForEntity(address ");
    _builder.append(this.ENTITY_PARAM);
    _builder.append(", bool ");
    _builder.append(this.GIVE_ROLE_PARAM);
    _builder.append(") ");
    String _visibilityForRoleAssignmentFunction = this.getVisibilityForRoleAssignmentFunction(role);
    _builder.append(_visibilityForRoleAssignmentFunction);
    _builder.append(" ");
    _builder.append(this.ONLY_ADMIN_MOD);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateConditionsForSingleRoleAssignment = this.generateConditionsForSingleRoleAssignment(role);
    _builder.append(_generateConditionsForSingleRoleAssignment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isEmpty = role.getSuperior().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        {
          EList<Role> _superior = role.getSuperior();
          boolean _hasElements = false;
          for(final Role superRole : _superior) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("", "\t");
            }
            _builder.append("\t");
            _builder.append("change");
            String _replaceAll_1 = superRole.getEntityName().replaceAll(" ", "");
            _builder.append(_replaceAll_1, "\t");
            _builder.append("RoleForEntity(");
            _builder.append(this.ENTITY_PARAM, "\t");
            _builder.append(", ");
            _builder.append(this.GIVE_ROLE_PARAM, "\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append(this.ASSIGNMENT_VAR, "\t");
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM, "\t");
    _builder.append("][");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName, "\t");
    _builder.append(".");
    String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(role);
    _builder.append(_roleEnumValueForRole, "\t");
    _builder.append("] = ");
    _builder.append(this.GIVE_ROLE_PARAM, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  /**
   * Creates the keyword for the role assignment functions visibility. This is "public" if the role is a superior
   * to any other role. Otherwise it is "external"
   */
  private String getVisibilityForRoleAssignmentFunction(final Role role) {
    final Function1<Role, Boolean> _function = new Function1<Role, Boolean>() {
      public Boolean apply(final Role r) {
        final Function1<Role, Boolean> _function = new Function1<Role, Boolean>() {
          public Boolean apply(final Role sup) {
            return Boolean.valueOf(sup.equals(role));
          }
        };
        return Boolean.valueOf(IterableExtensions.<Role>exists(r.getSuperior(), _function));
      }
    };
    boolean _exists = IterableExtensions.<Role>exists(this.target.getRoles(), _function);
    if (_exists) {
      return "public";
    } else {
      return "external";
    }
  }
  
  /**
   * Generates the annotations for the method to assign the given role.
   */
  private String generateAnnotationsForSingleRoleAssignment(final Role role) {
    StringConcatenation _builder = new StringConcatenation();
    String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
    _builder.append(_solcVerifyModificationSpecifier);
    _builder.append(" ");
    _builder.append(this.ASSIGNMENT_VAR);
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM);
    _builder.append("][");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(".");
    String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(role);
    _builder.append(_roleEnumValueForRole);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = role.getSuperior().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        {
          EList<Role> _superior = role.getSuperior();
          boolean _hasElements = false;
          for(final Role superRole : _superior) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("", "");
            }
            String _solcVerifyModificationSpecifier_1 = AccessControlConstants.getSolcVerifyModificationSpecifier();
            _builder.append(_solcVerifyModificationSpecifier_1);
            _builder.append(" ");
            _builder.append(this.ASSIGNMENT_VAR);
            _builder.append("[");
            _builder.append(this.ENTITY_PARAM);
            _builder.append("][");
            String _rolesEnumName_1 = AccessControlConstants.getRolesEnumName();
            _builder.append(_rolesEnumName_1);
            _builder.append(".");
            String _roleEnumValueForRole_1 = AccessControlConstants.getRoleEnumValueForRole(superRole);
            _builder.append(_roleEnumValueForRole_1);
            _builder.append("]");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      int _cardinality = role.getCardinality();
      boolean _notEquals = (_cardinality != this.DEFAULT_CARD);
      if (_notEquals) {
        String _solcVerifyModificationSpecifier_2 = AccessControlConstants.getSolcVerifyModificationSpecifier();
        _builder.append(_solcVerifyModificationSpecifier_2);
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(role.getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
        _builder.append(this.COUNTER_SUFFIX);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Generate all possible conditions that can occur in relation to the given role.
   */
  private String generateConditionsForSingleRoleAssignment(final Role role) {
    final Collection<Role> mutualExclusiveRoles = this.getMutuallyExclusiveRolesForRole(role);
    int _cardinality = role.getCardinality();
    final boolean specialCard = (_cardinality != this.DEFAULT_CARD);
    String counterVarName = "";
    if (specialCard) {
      StringConcatenation _builder = new StringConcatenation();
      String _firstLower = StringExtensions.toFirstLower(role.getEntityName().replaceAll(" ", ""));
      _builder.append(_firstLower);
      _builder.append(this.COUNTER_SUFFIX);
      counterVarName = _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      if ((((role.getCardinality() != this.DEFAULT_CARD) || (!role.getPrerequisite().isEmpty())) || (!mutualExclusiveRoles.isEmpty()))) {
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("if(");
        _builder_1.append(this.GIVE_ROLE_PARAM);
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Role> _prerequisite = role.getPrerequisite();
          boolean _hasElements = false;
          for(final Role pre : _prerequisite) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder_1.appendImmediate("", "\t");
            }
            _builder_1.append("\t");
            _builder_1.append("require(");
            String _accessCheckingFunctionName = AccessControlConstants.getAccessCheckingFunctionName();
            _builder_1.append(_accessCheckingFunctionName, "\t");
            _builder_1.append("(");
            String _msgSenderKeyword = AccessControlConstants.getMsgSenderKeyword();
            _builder_1.append(_msgSenderKeyword, "\t");
            _builder_1.append(", ");
            String _rolesEnumName = AccessControlConstants.getRolesEnumName();
            _builder_1.append(_rolesEnumName, "\t");
            _builder_1.append(".");
            String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(pre);
            _builder_1.append(_roleEnumValueForRole, "\t");
            _builder_1.append("), \"");
            String _prerequisiteRequiresMessage = AccessControlConstants.getPrerequisiteRequiresMessage(pre.getEntityName());
            _builder_1.append(_prerequisiteRequiresMessage, "\t");
            _builder_1.append("\");");
            _builder_1.newLineIfNotEmpty();
          }
        }
        {
          boolean _hasElements_1 = false;
          for(final Role exclusive : mutualExclusiveRoles) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder_1.appendImmediate("", "\t");
            }
            _builder_1.append("\t");
            _builder_1.append("require(!");
            String _accessCheckingFunctionName_1 = AccessControlConstants.getAccessCheckingFunctionName();
            _builder_1.append(_accessCheckingFunctionName_1, "\t");
            _builder_1.append("(");
            String _msgSenderKeyword_1 = AccessControlConstants.getMsgSenderKeyword();
            _builder_1.append(_msgSenderKeyword_1, "\t");
            _builder_1.append(", ");
            String _rolesEnumName_1 = AccessControlConstants.getRolesEnumName();
            _builder_1.append(_rolesEnumName_1, "\t");
            _builder_1.append(".");
            String _roleEnumValueForRole_1 = AccessControlConstants.getRoleEnumValueForRole(exclusive);
            _builder_1.append(_roleEnumValueForRole_1, "\t");
            _builder_1.append("), \"");
            String _mutualExclusionRequiresMessage = AccessControlConstants.getMutualExclusionRequiresMessage(exclusive.getEntityName());
            _builder_1.append(_mutualExclusionRequiresMessage, "\t");
            _builder_1.append("\");");
            _builder_1.newLineIfNotEmpty();
          }
        }
        {
          if (specialCard) {
            _builder_1.append("\t");
            _builder_1.append("require(");
            _builder_1.append(counterVarName, "\t");
            _builder_1.append(" < ");
            int _cardinality_1 = role.getCardinality();
            _builder_1.append(_cardinality_1, "\t");
            _builder_1.append(", \"");
            String _counterMaximumRequiresMessage = AccessControlConstants.getCounterMaximumRequiresMessage(role.getCardinality(), role.getEntityName());
            _builder_1.append(_counterMaximumRequiresMessage, "\t");
            _builder_1.append("\");");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append(counterVarName, "\t");
            _builder_1.append("++;");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("} ");
        {
          if (specialCard) {
            _builder_1.append("else {");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("require(");
            _builder_1.append(counterVarName, "\t");
            _builder_1.append(" > 0, \"");
            String _counterMimimumRequiresMessage = AccessControlConstants.getCounterMimimumRequiresMessage(role.getEntityName());
            _builder_1.append(_counterMimimumRequiresMessage, "\t");
            _builder_1.append("\");");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append(counterVarName, "\t");
            _builder_1.append("--;");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("}");
            _builder_1.newLine();
          }
        }
      }
    }
    return _builder_1.toString();
  }
  
  /**
   * This function returns a list with all roles the given role is mutually exclusive to.
   * If no mutual exclusions are modeled, an empty list is returned.
   */
  private Collection<Role> getMutuallyExclusiveRolesForRole(final Role role) {
    final Function1<MutualRoleExclusion, Boolean> _function = new Function1<MutualRoleExclusion, Boolean>() {
      public Boolean apply(final MutualRoleExclusion re) {
        return Boolean.valueOf(re.getRoles().contains(role));
      }
    };
    final Iterable<MutualRoleExclusion> fittingExclusions = IterableExtensions.<MutualRoleExclusion>filter(this.target.getRoleExclusions(), _function);
    final ArrayList<Role> roles = new ArrayList<Role>();
    for (final MutualRoleExclusion exc : fittingExclusions) {
      EList<Role> _roles = exc.getRoles();
      for (final Role exclusiveRole : _roles) {
        boolean _equals = exclusiveRole.equals(role);
        boolean _not = (!_equals);
        if (_not) {
          roles.add(exclusiveRole);
        }
      }
    }
    return roles;
  }
  
  /**
   * Generating a role assignment function for the ADMIN role when the basic role assignment is NOT used.
   * There is no need to handle the special role conditions.
   */
  private String generateRoleAssignmentForAdmin() {
    StringConcatenation _builder = new StringConcatenation();
    String _solcVerifyModificationSpecifier = AccessControlConstants.getSolcVerifyModificationSpecifier();
    _builder.append(_solcVerifyModificationSpecifier);
    _builder.append(" ");
    _builder.append(this.ASSIGNMENT_VAR);
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM);
    _builder.append("][");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(".");
    String _upperCase = this.ADMIN_ROLE.toUpperCase();
    _builder.append(_upperCase);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("function change");
    String _firstUpper = StringExtensions.toFirstUpper(this.ADMIN_ROLE);
    _builder.append(_firstUpper);
    _builder.append("RoleForEntity(address ");
    _builder.append(this.ENTITY_PARAM);
    _builder.append(", bool ");
    _builder.append(this.GIVE_ROLE_PARAM);
    _builder.append(") external ");
    _builder.append(this.ONLY_ADMIN_MOD);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.ASSIGNMENT_VAR, "\t");
    _builder.append("[");
    _builder.append(this.ENTITY_PARAM, "\t");
    _builder.append("][");
    String _rolesEnumName_1 = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName_1, "\t");
    _builder.append(".");
    String _upperCase_1 = this.ADMIN_ROLE.toUpperCase();
    _builder.append(_upperCase_1, "\t");
    _builder.append("] = ");
    _builder.append(this.GIVE_ROLE_PARAM, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  @Pure
  private AccessControlSystem getTarget() {
    return this.target;
  }
  
  public void setTarget(final AccessControlSystem target) {
    this.target = target;
  }
  
  @Pure
  private boolean isTimingNeeded() {
    return this.timingNeeded;
  }
}
