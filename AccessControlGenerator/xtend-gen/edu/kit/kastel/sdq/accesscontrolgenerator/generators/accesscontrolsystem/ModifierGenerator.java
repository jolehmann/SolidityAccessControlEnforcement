package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Class to generate the modifiers needed to handle access control in the current contract
 */
@SuppressWarnings("all")
public class ModifierGenerator {
  @Accessors(AccessorType.PRIVATE_SETTER)
  private Set<String> alreadyCoveredModifiers;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private AccessControlContract currentTarget;
  
  @Accessors(AccessorType.PRIVATE_SETTER)
  private ModifierRoleAndConditionsHelper conditionsHelper;
  
  private final String ROLE_MOD_SUFFIX = "only";
  
  private final String REQUIRE_MSG_ACCESS_DENIED = "Access denied!";
  
  /**
   * Constructor setting the AccessControlSystem as a basis for the modifiers
   */
  public ModifierGenerator(final AccessControlSystem acSystem) {
    this.currentTarget = this.currentTarget;
    HashSet<String> _hashSet = new HashSet<String>();
    this.alreadyCoveredModifiers = _hashSet;
    ModifierRoleAndConditionsHelper _modifierRoleAndConditionsHelper = new ModifierRoleAndConditionsHelper(acSystem);
    this.conditionsHelper = _modifierRoleAndConditionsHelper;
  }
  
  /**
   * Generating and returning the modifier using definition for the given function to add
   * to the functions header
   */
  public String generateModifierUsageDefinition(final Function func) {
    if ((this.conditionsHelper == null)) {
      return "";
    }
    this.conditionsHelper.extractConditionsForFunction(func);
    if ((this.conditionsHelper.getRoles().isEmpty() && (!this.conditionsHelper.isHasConditions()))) {
      return "";
    }
    return this.generateModifierDefinitionUsingConditions();
  }
  
  /**
   * Generate the modifier using definition by combining the name of all roles that can access
   * as well as all conditions that restrict the access. For the conditions, not the names but
   * a more comprehensive name is generated.
   */
  private String generateModifierDefinitionUsingConditions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.ROLE_MOD_SUFFIX);
    {
      Set<Role> _roles = this.conditionsHelper.getRoles();
      boolean _hasElements = false;
      for(final Role role : _roles) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("", "");
        }
        String _replaceAll = role.getEntityName().replaceAll(" ", "");
        _builder.append(_replaceAll);
      }
      if (_hasElements) {
        _builder.append("");
      }
    }
    {
      boolean _isEmpty = this.conditionsHelper.getBoolConditions().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("_Bool");
      }
    }
    {
      Set<BooleanVariableContext> _boolConditions = this.conditionsHelper.getBoolConditions();
      boolean _hasElements_1 = false;
      for(final BooleanVariableContext cond : _boolConditions) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("", "");
        }
        {
          boolean _isValueToCheck = cond.isValueToCheck();
          boolean _not_1 = (!_isValueToCheck);
          if (_not_1) {
            _builder.append("Not");
          }
        }
        String _replaceAll_1 = cond.getVariable().getEntityName().replaceAll(" ", "");
        _builder.append(_replaceAll_1);
      }
      if (_hasElements_1) {
        _builder.append("");
      }
    }
    {
      boolean _isEmpty_1 = this.conditionsHelper.getTimeConditions().isEmpty();
      boolean _not_2 = (!_isEmpty_1);
      if (_not_2) {
        _builder.append("_Time");
      }
    }
    {
      Set<TimeContext> _timeConditions = this.conditionsHelper.getTimeConditions();
      boolean _hasElements_2 = false;
      for(final TimeContext cond_1 : _timeConditions) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate("", "");
        }
        {
          boolean _isIsUpperBound = cond_1.isIsUpperBound();
          if (_isIsUpperBound) {
            _builder.append("Less");
          } else {
            _builder.append("Greater");
          }
        }
        int _timeValue = cond_1.getTimeValue();
        _builder.append(_timeValue);
        String _convertTimeUnitToString = this.convertTimeUnitToString(cond_1.getTimeUnit());
        _builder.append(_convertTimeUnitToString);
      }
      if (_hasElements_2) {
        _builder.append("");
      }
    }
    return _builder.toString();
  }
  
  /**
   * Generate all modifiers for the currently targeted contract by iterating over all functions
   */
  public String generateAccessControlModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Function> _functions = this.currentTarget.getFunctions();
      boolean _hasElements = false;
      for(final Function func : _functions) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          String _lineSeparator_1 = System.lineSeparator();
          String _plus = (_lineSeparator + _lineSeparator_1);
          _builder.appendImmediate(_plus, "");
        }
        String _generateSingleModifier = this.generateSingleModifier(func);
        _builder.append(_generateSingleModifier);
      }
    }
    return _builder.toString();
  }
  
  /**
   * Generate a single modifier for the given function by first checking if it already exists (through its definition).
   * Afterwards, the checks for roles and conditions are generated if necessary.
   */
  private String generateSingleModifier(final Function func) {
    if ((this.conditionsHelper == null)) {
      return "";
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.REQUIRE_MSG_ACCESS_DENIED);
    String msg = _builder.toString();
    this.conditionsHelper.extractConditionsForFunction(func);
    boolean _isHasConditions = this.conditionsHelper.isHasConditions();
    boolean _not = (!_isHasConditions);
    if (_not) {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _accessControlRequiresMessage = AccessControlConstants.getAccessControlRequiresMessage();
      _builder_1.append(_accessControlRequiresMessage);
      msg = _builder_1.toString();
      boolean _isEmpty = this.conditionsHelper.getRoles().isEmpty();
      if (_isEmpty) {
        return "";
      }
    }
    final String modUsage = this.generateModifierDefinitionUsingConditions();
    boolean _checkAlreadyCoveredModifier = this.checkAlreadyCoveredModifier(modUsage);
    if (_checkAlreadyCoveredModifier) {
      return "";
    }
    this.alreadyCoveredModifiers.add(modUsage);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("modifier ");
    _builder_2.append(modUsage);
    _builder_2.append(" {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("\t");
    _builder_2.append("require(");
    String _generateModifierChecks = this.generateModifierChecks();
    _builder_2.append(_generateModifierChecks, "\t");
    _builder_2.append(", \"");
    _builder_2.append(msg, "\t");
    _builder_2.append("\");");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("\t");
    _builder_2.append("_;");
    _builder_2.newLine();
    _builder_2.append("}");
    return _builder_2.toString();
  }
  
  /**
   * Generates the checks inside the requires statement in the modifier, combining role-specific checks with the
   * conditions referencing the role as well as the function.
   */
  private String generateModifierChecks() {
    String condition = "";
    StringConcatenation _builder = new StringConcatenation();
    String _accessControlVariableName = AccessControlConstants.getAccessControlVariableName();
    _builder.append(_accessControlVariableName);
    _builder.append(".");
    String _accessCheckingFunctionName = AccessControlConstants.getAccessCheckingFunctionName();
    _builder.append(_accessCheckingFunctionName);
    _builder.append("(");
    String _msgSenderKeyword = AccessControlConstants.getMsgSenderKeyword();
    _builder.append(_msgSenderKeyword);
    _builder.append(", ");
    String _accessControlContactName = AccessControlConstants.getAccessControlContactName();
    _builder.append(_accessControlContactName);
    _builder.append(".");
    String _rolesEnumName = AccessControlConstants.getRolesEnumName();
    _builder.append(_rolesEnumName);
    _builder.append(".");
    final String checkAccessTemplate = _builder.toString();
    Set<Role> _roles = this.conditionsHelper.getRoles();
    for (final Role role : _roles) {
      {
        boolean _isEmpty = IterableExtensions.isEmpty(this.conditionsHelper.getBoolCondsForRole().get(role));
        final boolean hasBoolConds = (!_isEmpty);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(this.conditionsHelper.getTimeCondsForRole().get(role));
        final boolean hasTimeConds = (!_isEmpty_1);
        StringConcatenation _builder_1 = new StringConcatenation();
        String _roleEnumValueForRole = AccessControlConstants.getRoleEnumValueForRole(role);
        _builder_1.append(_roleEnumValueForRole);
        _builder_1.append(")");
        final String roleCheck = (checkAccessTemplate + _builder_1);
        if (((!hasBoolConds) && (!hasTimeConds))) {
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            boolean _isBlank = condition.isBlank();
            boolean _not = (!_isBlank);
            if (_not) {
              _builder_2.append(condition);
              _builder_2.append(" ||");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t\t");
            }
          }
          _builder_2.append(roleCheck);
          condition = _builder_2.toString();
        } else {
          StringConcatenation _builder_3 = new StringConcatenation();
          {
            boolean _isBlank_1 = condition.isBlank();
            boolean _not_1 = (!_isBlank_1);
            if (_not_1) {
              _builder_3.append("(");
              _builder_3.append(condition);
              _builder_3.append(" &&");
            }
          }
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("(");
          _builder_3.append(roleCheck);
          {
            if (hasBoolConds) {
              _builder_3.append(" && ");
              String _createBooleanCheckFromConditions = this.createBooleanCheckFromConditions(this.conditionsHelper.getBoolCondsForRole().get(role));
              _builder_3.append(_createBooleanCheckFromConditions);
            }
          }
          _builder_3.newLineIfNotEmpty();
          {
            if (hasTimeConds) {
              _builder_3.append(" && ");
              String _createTimeCheckFromConditions = this.createTimeCheckFromConditions(this.conditionsHelper.getTimeCondsForRole().get(role));
              _builder_3.append(_createTimeCheckFromConditions);
            }
          }
          _builder_3.append(")");
          condition = _builder_3.toString();
        }
      }
    }
    return condition;
  }
  
  /**
   * Creates the in-line boolean variable checks from the given list of conditions
   */
  private String createBooleanCheckFromConditions(final Iterable<BooleanVariableContext> boolConds) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final BooleanVariableContext cond : boolConds) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          String _plus = ("&&" + _lineSeparator);
          _builder.appendImmediate(_plus, "");
        }
        _builder.newLineIfNotEmpty();
        {
          boolean _isValueToCheck = cond.isValueToCheck();
          boolean _not = (!_isValueToCheck);
          if (_not) {
            _builder.append("!");
          }
        }
        String _firstLower = StringExtensions.toFirstLower(cond.getVariable().getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Creates the in-line time-based checks from the given list of time conditions
   */
  private String createTimeCheckFromConditions(final Iterable<TimeContext> timeConds) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final TimeContext cond : timeConds) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          String _plus = ("&&" + _lineSeparator);
          _builder.appendImmediate(_plus, "");
        }
        String _accessControlVariableName = AccessControlConstants.getAccessControlVariableName();
        _builder.append(_accessControlVariableName);
        _builder.append(".");
        String _timingCheckFunctionName = AccessControlConstants.getTimingCheckFunctionName();
        _builder.append(_timingCheckFunctionName);
        _builder.append("( ");
        {
          boolean _isIsUpperBound = cond.isIsUpperBound();
          if (_isIsUpperBound) {
            _builder.append("true");
          } else {
            _builder.append("false");
          }
        }
        _builder.append(", ");
        int _timeValue = cond.getTimeValue();
        _builder.append(_timeValue);
        _builder.append(" ");
        String _convertTimeUnitToString = this.convertTimeUnitToString(cond.getTimeUnit());
        _builder.append(_convertTimeUnitToString);
        _builder.append(")");
      }
    }
    return _builder.toString();
  }
  
  /**
   * Converting the TimeUnits enum to its resulting Solidity keyword
   */
  private String convertTimeUnitToString(final TimeUnits unit) {
    if (unit != null) {
      switch (unit) {
        case DAY:
          return "days";
        case HOUR:
          return "hours";
        case MINUTE:
          return "minutes";
        case SECOND:
          return "seconds";
        case WEEK:
          return "weeks";
        case YEAR:
          return "years";
        default:
          break;
      }
    }
    return null;
  }
  
  /**
   * Check if a modifier for the given modifier definition was already created
   * to prevent two identical modifiers from being created.
   */
  private boolean checkAlreadyCoveredModifier(final String toCheck) {
    boolean _isEmpty = this.alreadyCoveredModifiers.isEmpty();
    if (_isEmpty) {
      return false;
    }
    for (final String modifier : this.alreadyCoveredModifiers) {
      boolean _equals = modifier.equals(toCheck);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
  
  private void setAlreadyCoveredModifiers(final Set<String> alreadyCoveredModifiers) {
    this.alreadyCoveredModifiers = alreadyCoveredModifiers;
  }
  
  public void setCurrentTarget(final AccessControlContract currentTarget) {
    this.currentTarget = currentTarget;
  }
  
  private void setConditionsHelper(final ModifierRoleAndConditionsHelper conditionsHelper) {
    this.conditionsHelper = conditionsHelper;
  }
}
