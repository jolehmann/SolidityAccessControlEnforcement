package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract;

import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AnnotationGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.ModifierGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityFunctionGenerationTemplate;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.FunctionParameter;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.GlobalFunction;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.LocalFunction;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ReturnVariable;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generator to create a Solidity function based on a function from the smart contract model using the method template
 */
@SuppressWarnings("all")
public class SolidityFunctionGenerator extends SolidityFunctionGenerationTemplate {
  @Accessors(AccessorType.PRIVATE_GETTER)
  private Function currentFunction;
  
  @Accessors(AccessorType.PRIVATE_GETTER)
  private AnnotationGenerator annotationGenerator;
  
  @Accessors(AccessorType.PRIVATE_GETTER)
  private ModifierGenerator modifierGenerator;
  
  /**
   * Constructor setting the necessary sub-generators
   */
  public SolidityFunctionGenerator(final AnnotationGenerator annotationGenerator, final ModifierGenerator modifierGenerator) {
    this.annotationGenerator = annotationGenerator;
    this.modifierGenerator = modifierGenerator;
  }
  
  /**
   * Generating the annotations for this function using the AnnotationGenerator
   */
  protected String generateComments() {
    return this.annotationGenerator.generateModificationAnnotations(this.currentFunction);
  }
  
  /**
   * Generating and returning the function header containing:
   * - method name
   * - parameter list
   * - access control modifiers
   * - visibility & mutability
   * - return value
   */
  protected String generateHeader() {
    final String returnType = this.generateReturn();
    final String methodName = SolidityNaming.getFunctionName(this.currentFunction);
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<FunctionParameter> _parameters = this.currentFunction.getParameters();
      boolean _hasElements = false;
      for(final FunctionParameter parameter : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _targetNameForType = SolidityNaming.getTargetNameForType(parameter.getType(), true);
        _builder.append(_targetNameForType);
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(parameter.getName().replaceAll(" ", ""));
        _builder.append(_firstLower);
      }
    }
    final String parameterDeclarations = _builder.toString();
    final String accessControlModifiers = this.modifierGenerator.generateModifierUsageDefinition(this.currentFunction);
    final String visibility = this.generateVisibility(this.currentFunction);
    final String mutability = SolidityNaming.getTargetNameForFunctionMutability(this.currentFunction.getMutability());
    String _xifexpression = null;
    boolean _isVirtual = this.currentFunction.isVirtual();
    if (_isVirtual) {
      _xifexpression = "virtual ";
    } else {
      _xifexpression = "";
    }
    final String virtual = _xifexpression;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("function ");
    _builder_1.append(methodName);
    _builder_1.append("(");
    _builder_1.append(parameterDeclarations);
    _builder_1.append(") ");
    _builder_1.append(virtual);
    _builder_1.append(" ");
    _builder_1.append(visibility);
    _builder_1.append(" ");
    _builder_1.append(mutability);
    _builder_1.append(" ");
    _builder_1.append(accessControlModifiers);
    _builder_1.append(" ");
    _builder_1.append(returnType);
    final String result = _builder_1.toString();
    return SolidityNaming.normalizeSpaces(result);
  }
  
  /**
   * Generating the function body as empty or with the content defined in the model.
   * This function is taken from the SolidityCodeGenerator.
   */
  protected String generateBody() {
    if (((this.currentFunction.getContent() == null) || this.currentFunction.getContent().isEmpty())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// TODO: implement and verify auto-generated method stub");
      _builder.newLine();
      _builder.append("revert(\"TODO: auto-generated method stub\");");
      _builder.newLine();
      return _builder.toString();
    } else {
      return this.currentFunction.getContent();
    }
  }
  
  /**
   * Sets the current function to generate a solidity function for to the given one
   */
  protected void setCurrentTarget(final Function function) {
    this.currentFunction = function;
  }
  
  /**
   * Generates the return statement for the given function.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateReturn() {
    final EList<ReturnVariable> returnVariables = this.currentFunction.getReturnVariables();
    if (((returnVariables == null) || returnVariables.isEmpty())) {
      return "";
    }
    final String returnedVariables = this.handleReturnVariables(returnVariables);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("returns (");
    _builder.append(returnedVariables);
    _builder.append(") ");
    return _builder.toString();
  }
  
  /**
   * Handles the different possible return variables for the current function.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String handleReturnVariables(final Collection<ReturnVariable> vars) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final ReturnVariable variable : vars) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _targetNameForType = SolidityNaming.getTargetNameForType(variable.getType(), true);
        _builder.append(_targetNameForType);
        _builder.append(" ");
        String _returnVariableName = this.getReturnVariableName(variable);
        _builder.append(_returnVariableName);
      }
    }
    return _builder.toString();
  }
  
  /**
   * Returns the name for the return variable or an emtpy string if no name is set.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String getReturnVariableName(final ReturnVariable variable) {
    String _name = variable.getName();
    boolean _tripleEquals = (_name == null);
    if (_tripleEquals) {
      return "";
    }
    return StringExtensions.toFirstLower(variable.getName().replaceAll(" ", ""));
  }
  
  /**
   * Generates the functions visibility, differentiating between the possibilites for local and global functions.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateVisibility(final Function function) {
    if ((function instanceof LocalFunction)) {
      return SolidityNaming.getTargetNameForFunctionVisibility(((LocalFunction)function).getVisibility());
    } else {
      if ((function instanceof GlobalFunction)) {
        return SolidityNaming.getTargetNameForFunctionVisibility(((GlobalFunction)function).getVisibility());
      }
    }
    return "";
  }
  
  @Pure
  private Function getCurrentFunction() {
    return this.currentFunction;
  }
  
  @Pure
  private AnnotationGenerator getAnnotationGenerator() {
    return this.annotationGenerator;
  }
  
  @Pure
  private ModifierGenerator getModifierGenerator() {
    return this.modifierGenerator;
  }
}
