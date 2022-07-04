package edu.kit.kastel.sdq.accesscontrolgenerator.validation;

import com.google.common.base.Objects;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OclViolationGenerator implements ViolationGenerator {
  private AccessControlSystem system;
  
  private Collection<AccessControlContract> smartContracts = new ArrayList<AccessControlContract>();
  
  /**
   * Implementation of the interface describing the concrete Strategy for generating violations.
   * This contains the control of all OCL constraints in the model
   */
  public Collection<String> generateViolations() {
    final ArrayList<String> violations = new ArrayList<String>();
    violations.addAll(this.validateElementSpecificOclConstraints(this.system));
    for (final AccessControlContract contract : this.smartContracts) {
      {
        violations.addAll(this.validateContractSpecificOclConstraints(contract));
        violations.addAll(this.validateElementSpecificOclConstraints(contract));
      }
    }
    return violations;
  }
  
  /**
   * Set the system to the given one
   */
  public void changeAccessControlSystem(final AccessControlSystem system) {
    this.system = system;
  }
  
  /**
   * Adds the given SmartContract to the contract list
   */
  public void addNewSmartContract(final AccessControlContract smaCo) {
    this.smartContracts.add(smaCo);
  }
  
  /**
   * Validates the OCL constraints only for the given smart contract system container from the resource files by returning all error messages.
   * To do so, only the relevant constraints are handled. To get the name of a constraint, they are extracted from the following error message:
   * "The 'CardinalityIsValid' constraint is violated on 'edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl@53a470b5{platform:/resource/Examples/EdgeCase/EdgeCase.accesscontrolsystem#_KwQ8ISs9EeyOxbte1tTmVQ}'"
   */
  private Collection<String> validateContractSpecificOclConstraints(final EObject system) {
    final ArrayList<String> violations = new ArrayList<String>();
    final Diagnostic dia = Diagnostician.INSTANCE.validate(system);
    int _severity = dia.getSeverity();
    boolean _equals = (_severity == Diagnostic.ERROR);
    if (_equals) {
      final Function1<Diagnostic, Boolean> _function = new Function1<Diagnostic, Boolean>() {
        public Boolean apply(final Diagnostic d) {
          return Boolean.valueOf((d != null));
        }
      };
      Iterable<Diagnostic> _filter = IterableExtensions.<Diagnostic>filter(dia.getChildren(), _function);
      for (final Diagnostic d : _filter) {
        {
          int _indexOf = d.getMessage().indexOf("\'");
          final int first = (_indexOf + 1);
          final String constraint = d.getMessage().substring(first, d.getMessage().indexOf("\'", (first + 1)));
          boolean _isViolatedTopLevelContainerConstraint = this.isViolatedTopLevelContainerConstraint(constraint);
          if (_isViolatedTopLevelContainerConstraint) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Violation for OCL constraint \'");
            _builder.append(constraint);
            _builder.append("\':");
            _builder.newLineIfNotEmpty();
            String _errorMessageForOclConstraint = this.getErrorMessageForOclConstraint(constraint);
            _builder.append(_errorMessageForOclConstraint);
            violations.add(_builder.toString());
          }
        }
      }
    }
    return violations;
  }
  
  /**
   * Validates the OCL constraints for all elements of the given system by returning all error messages.
   * To do so, the names of the constraints are extracted from the following error message to look for more extensive error messages:
   * "The 'CardinalityIsValid' constraint is violated on 'edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl@53a470b5{platform:/resource/Examples/EdgeCase/EdgeCase.accesscontrolsystem#_KwQ8ISs9EeyOxbte1tTmVQ}'"
   */
  private Collection<String> validateElementSpecificOclConstraints(final EObject system) {
    final ArrayList<String> violations = new ArrayList<String>();
    EList<EObject> _eContents = system.eContents();
    for (final EObject obj : _eContents) {
      {
        final Diagnostic dia = Diagnostician.INSTANCE.validate(obj);
        int _severity = dia.getSeverity();
        boolean _equals = (_severity == Diagnostic.ERROR);
        if (_equals) {
          final Function1<Diagnostic, Boolean> _function = new Function1<Diagnostic, Boolean>() {
            public Boolean apply(final Diagnostic d) {
              return Boolean.valueOf((d != null));
            }
          };
          Iterable<Diagnostic> _filter = IterableExtensions.<Diagnostic>filter(dia.getChildren(), _function);
          for (final Diagnostic d : _filter) {
            {
              int _indexOf = d.getMessage().indexOf("\'");
              final int first = (_indexOf + 1);
              final String constraint = d.getMessage().substring(first, d.getMessage().indexOf("\'", (first + 1)));
              StringConcatenation _builder = new StringConcatenation();
              String _removeImplClassEnding = AccessControlUtility.removeImplClassEnding(obj.getClass());
              _builder.append(_removeImplClassEnding);
              _builder.append(" \'");
              String _entityNameForEObject = AccessControlUtility.getEntityNameForEObject(obj);
              _builder.append(_entityNameForEObject);
              _builder.append("\' - Violation for OCL constraint \'");
              _builder.append(constraint);
              _builder.append("\':");
              _builder.newLineIfNotEmpty();
              String _errorMessageForOclConstraint = this.getErrorMessageForOclConstraint(constraint);
              _builder.append(_errorMessageForOclConstraint);
              violations.add(_builder.toString());
            }
          }
        }
      }
    }
    return violations;
  }
  
  /**
   * Returns a more extensive error message for the given OCL constraint from the AccessControlMetamodel.
   */
  private String getErrorMessageForOclConstraint(final String constraint) {
    boolean _matched = false;
    if (Objects.equal(constraint, "CardinalityIsValid")) {
      _matched=true;
      return "The role cardinality needs to be -1 or bigger than 0";
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoRoleCanBePrerequisiteForItself")) {
        _matched=true;
        return "The prerequisites need to be different from the role itself";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoRoleCanBeSuperiorToItself")) {
        _matched=true;
        return "The superior roles need to be different from the role itself";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoRoleInPrerequisiteAndSuperiorSet")) {
        _matched=true;
        return "One role cannot be a prerequisite and a superior role";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "ForbidTimeContextConditions")) {
        _matched=true;
        return "FunctionToVariable relations are not allowed to have time-based constraints";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "RolesCannotBeInHierarchyOrPrerequisite")) {
        _matched=true;
        return "The two mutually exclusive roles cannot be superiors or prerequisites to each other";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "VariableTypeNeedsToBeBoolean")) {
        _matched=true;
        return "The referenced variable needs to be a boolean variable";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "VariableTypeNeedsToBeMapping")) {
        _matched=true;
        return "The referenced variable needs to be a mapping";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "MappingKeyTypeNeedsToBeAddressOrAddressPayable")) {
        _matched=true;
        return "The referenced mappings key needs to have the data type \'address\' or \'address payable\'";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "VariableTypeIsNoMappingWithAddressAsKeytype")) {
        _matched=true;
        return "The referenced variable is not allowed to be mapping with \'address\' as its key data type";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoMoreBalanceModificationsThanFunctions")) {
        _matched=true;
        return "There are more function balance modifications than functions";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "BalanceModificationsReferenceDifferentFunctions")) {
        _matched=true;
        return "All balance modifications need to reference different functions";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "BalanceModificationsRegardingThisContractNeedPayableFunction")) {
        _matched=true;
        return "A function that is allowed to increase the balance of this contract needs to be marked as \'payable\'";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoAdditionalLocalFunctions")) {
        _matched=true;
        return "Local functions defined not as \'Function\' are not covered by the generator";
      }
    }
    if (!_matched) {
      if (Objects.equal(constraint, "NoFunctionOverrides")) {
        _matched=true;
        return "The generator does not support the usage of function overrides";
      }
    }
    return "No Message found.";
  }
  
  /**
   * Checks if a given OCL constraint from the AccessControlMetamodel is linked to a top-level container (f.e. a SmartContract element).
   * If that is the case, true is returned. Currently, there are three constraints defined for the SmartContract element:
   * NotMoreBalanceModificationsThenFunctions, BalanceModificationsReferenceDifferentFunctions & BalanceModificationsRegardingThisContractNeedPayableFunction
   */
  private boolean isViolatedTopLevelContainerConstraint(final String constraint) {
    if (((((constraint.equals("NoMoreBalanceModificationsThanFunctions") || 
      constraint.equals("BalanceModificationsReferenceDifferentFunctions")) || 
      constraint.equals("BalanceModificationsRegardingThisContractNeedPayableFunction")) || 
      constraint.equals("NoAdditionalLocalFunctions")) || 
      constraint.equals("NoFunctionOverrides"))) {
      return true;
    } else {
      return false;
    }
  }
}
