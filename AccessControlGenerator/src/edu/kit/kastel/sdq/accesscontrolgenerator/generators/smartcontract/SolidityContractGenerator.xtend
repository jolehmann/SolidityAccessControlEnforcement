package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AnnotationGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.ModifierGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityContractGenerationTemplate
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ContractType
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Event
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Modifier
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Struct
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Type
import org.eclipse.xtend.lib.annotations.Accessors

import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants.*
import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityConstants.*

import static extension edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityNaming.*

/**
 * Generator to create a Solidity smart contract from a smart contract model using the contract template
 */
class SolidityContractGenerator extends SolidityContractGenerationTemplate {

	@Accessors(PRIVATE_GETTER) boolean currentTargetNeedsAc
	@Accessors(PRIVATE_GETTER) AccessControlContract currentTarget
	@Accessors(PRIVATE_GETTER) AccessControlSystem acSystem
	@Accessors(PRIVATE_GETTER) AnnotationGenerator annotationGenerator
	@Accessors(PRIVATE_GETTER) ModifierGenerator modifierGenerator
	@Accessors(PRIVATE_GETTER) SolidityFunctionGenerator functionGenerator

	/**
	 * Constructor creating the necessary sub-generators
	 */
	new(AccessControlSystem acSystem) {
		this.modifierGenerator = new ModifierGenerator(acSystem)
		this.annotationGenerator = new AnnotationGenerator(acSystem)
		this.functionGenerator = new SolidityFunctionGenerator(annotationGenerator, modifierGenerator)
		this.acSystem = acSystem
	}

	/**
	 * Generating the import statements by iterating over all referenced contracts.
	 * Additionally, the import for the AccessControl contract is added if necessary.
	 */
	override protected generateImports() {
		val contractTypes = currentTarget.localTypes.filter(ContractType).toSet
		
		return '''«FOR type : contractTypes SEPARATOR System.lineSeparator»import "./«type.contract.getTargetFileNameForContract»«targetFileExt»";«ENDFOR»
«FOR contract : currentTarget.parents SEPARATOR System.lineSeparator»import "./«contract.getTargetFileNameForContract»«targetFileExt»";«ENDFOR»
«IF currentTargetNeedsAc»import "./«accessControlContactName»«targetFileExt»";«ENDIF»'''
	}
	
	/**
	 * Generating the declaration of the contract with its name and references to its parents
	 */
	override protected generateDeclaration() {
		return '''contract «currentTarget.entityName»«FOR parent : currentTarget.parents BEFORE " is " SEPARATOR ", "»«parent.entityName»«ENDFOR»'''
	}
	
	/**
	 * Generates all enums defined in the contract model.
	 * Implementation taken from SolidityCodeGenerator.
	 */
	override protected generateEnums() {
		return '''«FOR en : getUsedEnumsForCurrentTarget SEPARATOR System.lineSeparator»«generateEnumDefinition(en)»«ENDFOR»'''
	}

	/**
	 * Generates all structs defined in the contract model.
	 * Implementation taken from SolidityCodeGenerator.
	 */
	override protected generateStructs() {
		return '''«FOR struct : getUsedStructsForCurrentTarget SEPARATOR System.lineSeparator»«generateStructDefinition(struct)»«ENDFOR»'''
	}
	
	/**
	 * Generates the state variables of the contract by combining the state variables from the model
	 * with the ones needed for the access control.
	 */
	override protected generateFields() {
		val fields = #[generateFieldForAccessControl, generateFieldsForStateVariables]
		return String.join(System.lineSeparator, fields)
	}
	
	/**
	 * Generates all events defined in the contract model.
	 * Implementation taken from SolidityCodeGenerator.
	 */
	override protected generateEvents() {
		return '''«FOR event : currentTarget.events SEPARATOR System.lineSeparator»«generateEventDefinition(event)»«ENDFOR»'''
	}
	
	/**
	 * Generates the contracts constructor.
	 * Implementation taken from SolidityCodeGenerator.
	 */
	override protected generateConstructor() {
		val constructor = currentTarget.constructor
		if(constructor !== null) {			
			return '''constructor(«FOR param : constructor.parameters SEPARATOR ", "»«getTargetNameForType(param.type, true)» «param.name.replace(" ", "").toFirstLower»«ENDFOR») {
	«IF constructor.content === null || constructor.content.empty»//TODO: Auto-generated Constructor«ELSE»«constructor.content»«ENDIF»
}''' 
	} else {
		return ""
	}
}
	
	/**
	 * Generating the methods based on the functions from the model by using the FunctionGenerator
	 */
	override protected generateMethods() {
		val functions = currentTarget.functions
		val methodDefinitions = generateMethodDefinitions(functions).toString
		return methodDefinitions
	}
	
	/**
	 * Generating the modifiers used for access control by using the ModifierGenerator as well as the ones
	 * described in the model. Generating the ones from the model is taken from the SolidityCodeGenerator.
	 */
	override protected generateModifiers() {
		val acModifiers = modifierGenerator.generateAccessControlModifiers()
		val modifiers = '''«FOR modifier : currentTarget.modifiers SEPARATOR System.lineSeparator»«generateModifierDefinition(modifier)»«ENDFOR»''' 
		return '''«acModifiers»«System.lineSeparator»«modifiers»'''
	}
	
	/**
	 * Sets the current contract to generate a solidity file for to the given one.
	 * Also checks if it needs a reference to the AccessControl contract.
	 */
	def void setCurrentTarget(AccessControlContract contract) {
		this.currentTarget = contract
		this.currentTargetNeedsAc = AccessControlUtility.checkIfAccessControlContractNeeded(acSystem, contract)
		this.annotationGenerator.currentTarget = contract
		modifierGenerator.currentTarget = contract
	}

	/**
	 * Executes the generation of a method for the given function using the FunctionGenerator
	 */
	protected def String executeMethodGeneration(Function function) {
		functionGenerator.currentTarget = function
		return functionGenerator.generate
	}
	
	/**
	 * Generates a state variable referencing the AccessControl contract if necessary
	 */
	private def String generateFieldForAccessControl() {
		if (currentTargetNeedsAc) {
			return '''«getAccessControlContactName» private «getAccessControlVariableName» = new «getAccessControlContactName»(«getThisAddressKeyword»); // Auto-generated Field'''
		} else {
			return ""
		}
	}
	
	/**
	 * Generates the variables based on all state variables defined in the model.
	 * For each variable, a comment summarizing the roles that can access it is generated before its declaration.
	 */
	private def String generateFieldsForStateVariables() {
		var variables = '''«FOR variable : currentTarget.variables SEPARATOR System.lineSeparator»
«annotationGenerator.generateRoleComments(variable)»
«getTargetNameForType(variable.type, false)» «getTargetNameForVariableVisibility(variable.visibility)» «getTargetNameForVariableMutability(variable.mutability)» «variable.entityName.toFirstLower.replaceAll(" ", "")»; // Auto-generated Field
«ENDFOR»'''
		return variables.normalizeSpaces
	}
	
	/**
	 * Describes the general structure of methods that need to be generated for the given list of functions.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateMethodDefinitions(Iterable<Function> functions) '''
		«FOR function : functions»
			«executeMethodGeneration(function)»

		«ENDFOR»
	'''
	
	/**
	 * Creates a single enum in solidity code from the given enum object.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateEnumDefinition(Enum en) {
		return '''enum «en.entityName.replaceAll(" ", "")» {«FOR member : en.members BEFORE " " SEPARATOR ", " AFTER " "»«member.value»«ENDFOR»}'''
	}
	
	/**
	 * Collects the enums used in the contract before generating a solidity enum for each.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def Iterable<Enum> getUsedEnumsForCurrentTarget() {
		val localEnums = currentTarget.localTypes.filter(Enum)
		val usedGlobalEnums = getAllUsedTypesForCurrentTarget().filter(Enum)
		return (localEnums + usedGlobalEnums).toSet
	}
	
	/**
	 * Creates the given event from the metamodel.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateEventDefinition(Event event) {
		val anonymous = event.anonymous ? " anonymous" : ""
		return '''event «event.entityName.replace(" ", "")»(«FOR param : event.parameters SEPARATOR ", "»«getTargetNameForType(param.type, false)» «param.indexed ? "indexed " : ""»«param.name.replaceAll(" ", "").toFirstLower»«ENDFOR»)«anonymous»;'''
	}
	
	/**
	 * Creates a single struct in solidity code from the given struct object.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateStructDefinition(Struct struct) {
		return '''
			struct «struct.entityName.replaceAll(" ", "")» {
				«FOR member : struct.members SEPARATOR System.lineSeparator»«getTargetNameForType(member.type, false)» «member.entityName.replaceAll(" ", "").toFirstLower»;«ENDFOR»
			}
		'''
	}
	
	/**
	 * Collects the structs used in the contract before generating a solidity struct for each.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def Iterable<Struct> getUsedStructsForCurrentTarget() {
		val localStructs = currentTarget.localTypes.filter(Struct)
		val usedGlobalStructs = getAllUsedTypesForCurrentTarget().filter(Struct)
		return (localStructs + usedGlobalStructs).toSet
	}

	/**
	 * Gets all ata types that are used somewhere in the contract (for variables, parameters and function returns).
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def Iterable<Type> getAllUsedTypesForCurrentTarget() {
		val stateVariableTypes = currentTarget.variables?.map[it.type] ?: #[]
		val functionParameterTypes = currentTarget.functions?.map[it.parameters].flatten.map[it.type] ?: #[]
		val functionReturnTypes = currentTarget.functions?.map[it.returnVariables].flatten.map[it.type] ?: #[]

		return #[stateVariableTypes, functionParameterTypes, functionReturnTypes].flatten
	}
	
	/**
	 * Generates the definition for the given modeled modifier.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateModifierDefinition(Modifier modifier) {
		val virtual = modifier.virtual ? "virtual " : ""
		val modifierHead = '''modifier «modifier.getModifierName»(«generateModifierParametersDefinition(modifier)») «virtual»'''
		return '''«modifierHead.normalizeSpaces»{
	«generateModifierBody(modifier)»
}'''
	}
	
	/**
	 * Creates the parameters for the given modeled modifier.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateModifierParametersDefinition(Modifier modifier) {
		return '''«FOR param : modifier.parameters SEPARATOR ", "»«getTargetNameForType(param.type, true)» «param.name»«ENDFOR»'''
	}
	
	/**
	 * Generates the body for the given modeled modifier.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateModifierBody(Modifier modifier) {		
		if(modifier.content === null || modifier.content.empty) {
			return "_; //TODO: Auto-generated Modifier"
		} else {
			return modifier.content
		}
	}
}