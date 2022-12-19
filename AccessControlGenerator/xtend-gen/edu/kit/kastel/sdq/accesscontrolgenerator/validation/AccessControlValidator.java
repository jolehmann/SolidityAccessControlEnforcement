package edu.kit.kastel.sdq.accesscontrolgenerator.validation;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Class to start the validation process by using all available violation generators.
 */
@SuppressWarnings("all")
public class AccessControlValidator {
  private int errorCounter;

  private AccessControlSystem system;

  private TransitiveClosureCalculator closureCalc = new TransitiveClosureCalculator();

  private Collection<ViolationGenerator> violationGens = new ArrayList<ViolationGenerator>();

  private Collection<AccessControlContract> smartContracts = new ArrayList<AccessControlContract>();

  public AccessControlValidator() {
    RbacViolationGenerator _rbacViolationGenerator = new RbacViolationGenerator();
    this.violationGens.add(_rbacViolationGenerator);
    OclViolationGenerator _oclViolationGenerator = new OclViolationGenerator();
    this.violationGens.add(_oclViolationGenerator);
  }

  /**
   * Registers the given resource at the validator either as the current AccessControlSystem or by
   * adding it to the list of SmartContracts
   */
  public void registerResource(final Resource inputResource) {
    EList<EObject> _contents = inputResource.getContents();
    for (final EObject system : _contents) {
      {
        if ((system instanceof AccessControlSystem)) {
          this.system = ((AccessControlSystem)system);
          this.closureCalc.calculateTransitiveClosures(((AccessControlSystem)system));
          for (final ViolationGenerator generator : this.violationGens) {
            generator.changeAccessControlSystem(((AccessControlSystem)system));
          }
        }
        if ((system instanceof AccessControlContract)) {
          this.smartContracts.add(((AccessControlContract)system));
          for (final ViolationGenerator generator_1 : this.violationGens) {
            generator_1.addNewSmartContract(((AccessControlContract)system));
          }
        }
      }
    }
  }

  /**
   * Checks the soundness of the system by validating the OCL constraints as well as the systemwide RBAC
   * equations using the available violation generator. Throughout all of it, the violation messages are collected
   * and combined at the end.
   */
  public String checkSoundnessOfSystem() {
    this.errorCounter = 1;
    final ArrayList<String> violations = new ArrayList<String>();
    for (final ViolationGenerator generator : this.violationGens) {
      violations.addAll(generator.generateViolations());
    }
    boolean _isEmpty = violations.isEmpty();
    if (_isEmpty) {
      return "";
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("There are violations in the selected AccessControlSystem \'");
    String _entityNameForEObject = AccessControlUtility.getEntityNameForEObject(this.system);
    _builder.append(_entityNameForEObject);
    _builder.append("\' and SmartContracts ");
    {
      boolean _hasElements = false;
      for(final AccessControlContract smaCo : this.smartContracts) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" ", "");
        }
        _builder.append("\'");
        String _entityNameForEObject_1 = AccessControlUtility.getEntityNameForEObject(smaCo);
        _builder.append(_entityNameForEObject_1);
        _builder.append("\'");
      }
    }
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements_1 = false;
      for(final String violation : violations) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        int _plusPlus = this.errorCounter++;
        _builder.append(_plusPlus);
        _builder.append(") ");
        _builder.append(violation);
      }
    }
    return _builder.toString();
  }
}
