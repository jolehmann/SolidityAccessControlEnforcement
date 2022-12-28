package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants.*

/**
 * Class to generate the Solc-Verify annotations in the contract
 */
class AnnotationGenerator {

	@Accessors(PUBLIC_SETTER) AccessControlContract currentTarget
	@Accessors(PUBLIC_SETTER) AccessControlSystem acSystem
	
	val SOLC_VERIFY_POSTCONDITION = "/// @notice postcondition"
	val SOLC_VERIFY_OLD = "__verifier_old_uint"
	
	/**
	 * Constructor setting the AccessControlSystem as a basis for the annotations
	 */
	new(AccessControlSystem acSystem) {
		this.acSystem = acSystem
	}

	/**
	 * Generates the modification annotations for the given function by looking at the variables
	 * that are allowed to be changed by the function. It also looks at the balance modifications
	 * connected to the function and generates annotations accordingly.
	 * If a variable is a Caller-Specific Mapping (CSM), the function can differentiate between
	 * address-specific access or general access.
	 */
	def String generateModificationAnnotations(Function func) {
		if(acSystem === null) {
			return ""
		}
		
		val relevantFuncToVars = acSystem.functionToVariableTuples.filter[fs | fs.function.equals(func)]
		val funcToStateVars = relevantFuncToVars.filter(FunctionToStateVariableRelation)
		val funcToCsms = relevantFuncToVars.filter(FunctionToCsmRelation)
		val balanceAnnot = addFunctionBalanceModifications(func)
		
		return '''«IF !funcToStateVars.isEmpty»«iterateOverStateVariables(funcToStateVars.toSet)»«ENDIF»
«IF !funcToCsms.isEmpty»«iterateOverCallerSpecificMappings(funcToCsms.toSet)»«ENDIF»
«IF !balanceAnnot.isBlank»«balanceAnnot»«ENDIF»'''
	}
	
	/**
	 * Generates comments explaining which roles are allowed to access the given function.
	 * If no role is allowed to access, a fitting comment is generated & returned.
	 */
	def String generateRoleComments(Function function) {
		if(acSystem === null) {
			return ""
		}
		val roleWithDirectAccess = acSystem.roleToFunctionTuples.filter[rf | rf.function.equals(function)].map[rf | rf.role]
		
		if(roleWithDirectAccess.isEmpty) {
			// All Roles can directly access
			val allRoles = acSystem.roles
			return '''// Roles: All Roles can directly access {«generateAccessCommentContentForRoles(allRoles.toSet)»}'''
		}
		return '''// Roles: Direct Access by {«generateAccessCommentContentForRoles(roleWithDirectAccess.toSet)»}'''
	}
	
	/**
	 * Generates comments explaining which roles are allowed to access the given function.
	 * If no role is allowed to access, a fitting comment is generated & returned.
	 */
	def String generateRoleBrackets(Function function) {
		if(acSystem === null) {
			return ""
		}
		val roleWithDirectAccess = acSystem.roleToFunctionTuples.filter[rf | rf.function.equals(function)].map[rf | rf.role]
		if(roleWithDirectAccess.isEmpty) {
			// All Roles can directly access
			val allRoles = acSystem.roles
			return '''{«generateAccessCommentContentForRoles(allRoles.toSet)»}'''
		}
		return '''{«generateAccessCommentContentForRoles(roleWithDirectAccess.toSet)»}'''
	}
	
	/**
	 * Generates comments explaining which roles are allowed to access the given state variable.
	 * There are two comments generated: One for roles that are allowed to modify the variable and
	 * one for roles that are only allowed to influence it. If no role is allowed to access,
	 * a fitting comment is generated & returned.
	 */
	def String generateRoleComments(StateVariable variable) {
		if(acSystem === null) {
			return ""
		}
		
		val rolesWithModAccess = acSystem.roleToVariableTuples.filter[rv | rv.variable.equals(variable) 
			&& rv.modifies].map[rv | rv.role]
		val rolesWithInfAccess = acSystem.roleToVariableTuples.filter[rv | rv.variable.equals(variable) 
			&& !rv.modifies].map[rv | rv.role]
		
		if(rolesWithModAccess.isEmpty && rolesWithInfAccess.isEmpty) {
			return "// Roles: No Role can modify or influence"
		}
		return '''// Roles: Modification by {«generateAccessCommentContentForRoles(rolesWithModAccess.toSet)»}, Influence by {«generateAccessCommentContentForRoles(rolesWithInfAccess.toSet)»}'''
	}
	
	/**
	 * Generates comments explaining which roles are allowed to access the given function.
	 * If no role is allowed to access, a fitting comment is generated & returned.
	 */
	def String generateRoleBrackets(StateVariable variable) {
		if(acSystem === null) {
			return ""
		}
		val rolesWithModAccess = acSystem.roleToVariableTuples.filter[rv | rv.variable.equals(variable) 
			&& rv.modifies].map[rv | rv.role]
		val rolesWithInfAccess = acSystem.roleToVariableTuples.filter[rv | rv.variable.equals(variable) 
			&& !rv.modifies].map[rv | rv.role]
		
		return '''{«generateAccessCommentContentForRoles(rolesWithModAccess.toSet)»}, {«generateAccessCommentContentForRoles(rolesWithInfAccess.toSet)»}'''
	}
	
	/**
	 * Generates the content of a single comment visualizing role access to variables or functions.
	 * This function iterates over the list of roles and adds the enum value name to the comment.
	 * If the list is empty, "None" is returned.
	 */
	private def String generateAccessCommentContentForRoles(Set<Role> roles) {		
		if(roles.isEmpty) {
			return ""
		} else {
			return '''«FOR role : roles SEPARATOR ", "»«getRoleEnumValueForRole(role)»«ENDFOR»'''
		}
	}
	
	/**
	 * Iterate over all relations accessing state variables, generating one annotation per relation.
	 */
	private def String iterateOverStateVariables(Set<FunctionToStateVariableRelation> relations) {
		return '''«FOR funcToVar : relations SEPARATOR ""»
«getSolcVerifyModificationSpecifier» «funcToVar.variable.entityName.replaceAll(" ", "").toFirstLower» «addConditionToModifiesFromBooleanContext(funcToVar)»
«ENDFOR»'''
	}
	
	/**
	 * Iterate over all relations accessing csm variables, generating one annotation per relation.
	 */
	private def String iterateOverCallerSpecificMappings(Set<FunctionToCsmRelation> relations) {
		return '''«FOR funcToVar : relations SEPARATOR ""»
«getSolcVerifyModificationSpecifier» «funcToVar.csm.entityName.replaceAll(" ", "").toFirstLower»«IF !funcToVar.accessWholeMapping»[«getMsgSenderKeyword»]«ENDIF» «addConditionToModifiesFromBooleanContext(funcToVar)»
«ENDFOR»'''
	}
	
	/**
	 * Add a boolean condition to a modification specifier, if the given relation contains any
	 */
	private def String addConditionToModifiesFromBooleanContext(FunctionToVariableRelation relation) {
		if(relation.conditions.isEmpty) {
			return ""
		}
		
		val booleanConds = relation.conditions.filter(BooleanVariableContext)
		if(booleanConds.isEmpty) {
			return ""
		}
		
		return '''if «FOR cond : booleanConds SEPARATOR " && "»«IF !cond.valueToCheck»!«ENDIF»«cond.variable.entityName.replaceAll(" ", "").toFirstLower»«ENDFOR»'''
	}
	
	/**
	 * Returns the annotations based on the balance modifications for the given function.
	 */
	private def String addFunctionBalanceModifications(Function func) {
		val balanceMods = currentTarget.balanceModifications.filter[bm | bm.function.equals(func)]
		
		return '''«FOR balance : balanceMods SEPARATOR ""»
«checkBalanceModificationEnum(balance.modifiesMsgSenderBalance, true)»
«checkBalanceModificationEnum(balance.modifiesThisContractsBalance, false)»
«ENDFOR»'''
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
	private def String checkBalanceModificationEnum(BalanceModificationType modType, boolean isMsgSender) {
		val keyword = (isMsgSender ? getMsgSenderKeyword : getThisAddressKeyword) + ".balance"
		
		return '''«IF modType != BalanceModificationType.DOES_NOT_MODIFY»«getSolcVerifyModificationSpecifier» «keyword»«ENDIF»
«IF modType === BalanceModificationType.ONLY_DECREASE»«SOLC_VERIFY_POSTCONDITION» «keyword» <= «SOLC_VERIFY_OLD»(«keyword»)«ENDIF»
«IF modType === BalanceModificationType.ONLY_INCREASE»«SOLC_VERIFY_POSTCONDITION» «keyword» >= «SOLC_VERIFY_OLD»(«keyword»)«ENDIF»'''
	}
}