package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract

import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AnnotationGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.ModifierGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityFunctionGenerationTemplate
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.GlobalFunction
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.LocalFunction
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ReturnVariable
import java.util.Collection
import org.eclipse.xtend.lib.annotations.Accessors

import static extension edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityNaming.*

/**
 * Generator to create a Solidity function based on a function from the smart contract model using the method template
 */
class SolidityFunctionGenerator extends SolidityFunctionGenerationTemplate {

	@Accessors(PRIVATE_GETTER) Function currentFunction
	@Accessors(PRIVATE_GETTER) AnnotationGenerator annotationGenerator
	@Accessors(PRIVATE_GETTER) ModifierGenerator modifierGenerator

	/**
	 * Constructor setting the necessary sub-generators
	 */
	new(AnnotationGenerator annotationGenerator, ModifierGenerator modifierGenerator) {
		this.annotationGenerator = annotationGenerator
		this.modifierGenerator = modifierGenerator
	}
	
	/**
	 * Generating the annotations for this function using the AnnotationGenerator
	 */
	override protected generateComments() {
		return annotationGenerator.generateModificationAnnotations(currentFunction)
	}

	/**
	 * Generating and returning the function header containing:
	 * - method name
	 * - parameter list
	 * - access control modifiers
	 * - visibility & mutability
	 * - return value
	 */
	override protected generateHeader() {
		val returnType = generateReturn()
		val methodName = getFunctionName(currentFunction)		
		val parameterDeclarations = '''«FOR parameter : currentFunction.parameters SEPARATOR ', '»«getTargetNameForType(parameter.type, true)» «parameter.name.replaceAll(" ", "").toFirstLower»«ENDFOR»'''
		val accessControlModifiers = modifierGenerator.generateModifierUsageDefinition(currentFunction)
		val visibility = generateVisibility(currentFunction)
		val mutability = getTargetNameForFunctionMutability(currentFunction.getMutability)
		val virtual = currentFunction.virtual ? "virtual " : ""
		val result = '''function «methodName»(«parameterDeclarations») «virtual» «visibility» «mutability» «accessControlModifiers» «returnType»'''
		return result.normalizeSpaces
	}
	
	/**
	 * Generating the function body as empty or with the content defined in the model.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	override protected generateBody() {
		if(currentFunction.content === null || currentFunction.content.empty) {
			return '''
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
		'''
			
		} else {
			return currentFunction.content
		}
	}
	
	/**
	 * Sets the current function to generate a solidity function for to the given one
	 */
	def protected void setCurrentTarget(Function function) {
		this.currentFunction = function
	}
	
	/**
	 * Generates the return statement for the given function.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateReturn() {
		val returnVariables = currentFunction.returnVariables

		if (returnVariables === null || returnVariables.empty) {
			return ""
		}

		val returnedVariables = handleReturnVariables(returnVariables)
		
		return '''returns («returnedVariables») '''
	}

	/**
	 * Handles the different possible return variables for the current function.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String handleReturnVariables(Collection<ReturnVariable> vars) {
		return '''«FOR variable : vars SEPARATOR ", "»«getTargetNameForType(variable.type, true)» «getReturnVariableName(variable)»«ENDFOR»'''
	}
	
	/**
	 * Returns the name for the return variable or an emtpy string if no name is set.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String getReturnVariableName(ReturnVariable variable) {
		if(variable.name === null) {
			return ""
		}
		return variable.name.replaceAll(" ", "").toFirstLower
	}
	
	/**
	 * Generates the functions visibility, differentiating between the possibilites for local and global functions.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateVisibility(Function function) {		
		if(function instanceof LocalFunction) {			
			return getTargetNameForFunctionVisibility(function.visibility)
		} else if (function instanceof GlobalFunction) {
			return getTargetNameForFunctionVisibility(function.visibility)
		}
		return ""
	}
}