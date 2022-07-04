package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityContractGenerationTemplate
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors

import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants.*
import java.util.Collection

/**
 * Generator to create the access control smart contract from an access control system model using the contract template
 */
class AccessControlContractGenerator extends SolidityContractGenerationTemplate {
	
	@Accessors(PUBLIC_SETTER, PRIVATE_GETTER) AccessControlSystem target
	@Accessors(PRIVATE_GETTER) boolean timingNeeded;
	
	val DEFAULT_CARD = -1
	val ADMIN_ROLE = '''admin'''
	val ONLY_ADMIN_MOD = '''onlyAdmin'''
	val ASSIGNMENT_VAR = '''roleAssignment'''
	val TIME_VAR = '''timeAtStart'''
	val TIMESTAMP_KEYWORD = '''block.timestamp'''
	val COUNTER_SUFFIX = '''Counter'''
	val ENTITY_PARAM = '''entity'''
	val GIVE_ROLE_PARAM = '''giveRole'''	

	/**
	 * Constructor setting the AccessControlSystem to generate the contracts content for and
	 * checking, if the handling of time-based constraints is needed.
	 */
	new(AccessControlSystem acsystem) {
		this.target = acsystem
		this.timingNeeded = checkIfTimingIsNeeded()
	}
	
	/**
	 * Generates the contracts import statement, which is not necessary for the AccessControl contract
	 */
	override protected generateImports() {
		return ""
	}
	
	/**
	 * Generating the declaration of the access control contract
	 */
	override protected generateDeclaration() {
		return '''contract «getAccessControlContactName»'''
	}	
	
	/**
	 * Generates the enum for the roles from the AccessControlSystem
	 */
	override protected generateEnums() {
		return '''enum Roles { «FOR role : target.roles SEPARATOR ", "»«getRoleEnumValueForRole(role)»«ENDFOR», «ADMIN_ROLE.toUpperCase» }'''
	}
	
	/**
	 * Generates the structs for the access control contract, which is not necessary
	 */
	override protected generateStructs() {
		return ""
	}	
	
	/**
	 * Generates the state variables for the access control contract.
	 * This includes:
	 * - nested mapping from addresses to possible roles
	 * - time variable if time-based constraints are handled
	 * - counter for roles with no default cardinality
	 * «FOR role : target.roles SEPARATOR ", "»«getRoleEnumValueForRole(role)»«ENDFOR»
	 */
	override protected generateFields() {
		return '''mapping(address => mapping(«getRolesEnumName» => bool)) private «ASSIGNMENT_VAR»;
«IF timingNeeded»uint256 private «TIME_VAR» = 0;«ENDIF»
«FOR role : target.roles.filter[r | r.cardinality != DEFAULT_CARD] SEPARATOR System.lineSeparator»
uint private «role.entityName.replaceAll(" ", "").toFirstLower»«COUNTER_SUFFIX» = 0;«ENDFOR»'''
	}
	
	/**
	 * Generates the contracts events, which is not necessary for the AccessControl contract
	 */
	override protected generateEvents() {
		return ""
	}
	
	/**
	 * Generates the access control contracts constructor containing:
	 * - the header with its parameter
	 * - assignment of the admin role to the sender as well as this contract
	 * - setting of the timing variable (if necessary)
	 */
	override protected generateConstructor() {
		return '''constructor(address «ADMIN_ROLE») {
	«ASSIGNMENT_VAR»[«ADMIN_ROLE»][«getRolesEnumName».«ADMIN_ROLE.toUpperCase»] = true;
	«IF timingNeeded»«TIME_VAR» = «TIMESTAMP_KEYWORD»;«ENDIF»
}'''
	}
	
	/**
	 * Generates the methods for the access control contract, which includes:
	 * - the function to check access
	 * - the function to check the timing (if necessary)
	 * - either use basic role assignment in a single function or...
	 * - create one assignment function per role
	 */
	override protected generateMethods() {
		return '''«generateCheckAccessFunction()»

«IF timingNeeded»«generateCheckTimingFunction()»«ENDIF»

«IF checkForBasicRoleAssignment()»
«generateBasicRoleAssignment()»
«ELSE»
«FOR role : target.roles SEPARATOR System.lineSeparator + System.lineSeparator»«generateRoleAssignmentForRole(role)»«ENDFOR»
«generateRoleAssignmentForAdmin()»
«ENDIF»'''
	}
	
	/**
	 * Generating the onlyAdmin modifier at the end of the contract.
	 */
	override protected generateModifiers() {
		return '''modifier «ONLY_ADMIN_MOD» {
	require(«getAccessCheckingFunctionName»(«getMsgSenderKeyword», «getRolesEnumName».«ADMIN_ROLE.toUpperCase»), "«getAccessControlRequiresMessage»");
	_;
}'''
	}
	
	/**
	 * Checks if handling time-based constraints is necessary in the AccessControlSystem.
	 * This is the case if a single time-based condition exists inside the system.
	 */
	private def boolean checkIfTimingIsNeeded() {
		for(roleToFunc : target.roleToFunctionTuples) {
			for(cond : roleToFunc.conditions) {
				if(cond instanceof TimeContext) {
					return true
				}
			}
		}
		return false
	}
	
	/**
	 * Generates the checkAccess function, accessing the RoleAssignment nested mapping for the given role and address
	 */
	private def String generateCheckAccessFunction() {
		return '''function «getAccessCheckingFunctionName»(address «ENTITY_PARAM», «getRolesEnumName» role) public view returns(bool result) {
	return «ASSIGNMENT_VAR»[«ENTITY_PARAM»][role];
}'''
	}
	
	/**
	 * Generates the checkTiming function, allowing for checking time-based constraints during execution
	 */
	private def String generateCheckTimingFunction() {
		return '''function «getTimingCheckFunctionName»(bool upper, uint256 addition) public view returns(bool result) {
	if(upper) {
		return «TIMESTAMP_KEYWORD» >= timeAtStart + addition;
	} else {
		return «TIMESTAMP_KEYWORD» <= timeAtStart + addition;
	}
}'''
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
	private def boolean checkForBasicRoleAssignment() {
		if(!target.roleExclusions.isEmpty) {
			return false
		}
		
		for(role : target.roles) {
			if(role.cardinality != DEFAULT_CARD) {
				return false
			}
			if(!role.prerequisite.isEmpty) {
				return false
			}
			if(!role.superior.isEmpty) {
				return false
			}
		}
		
		return true
	}
	
	/**
	 * Generates the basic role assignment function assessing the nested mapping for the given role and address
	 */
	private def String generateBasicRoleAssignment() {
		return '''«getSolcVerifyModificationSpecifier» «ASSIGNMENT_VAR»[«ENTITY_PARAM»][role]
function changeRoleAssignment(address «ENTITY_PARAM», «getRolesEnumName» role, bool give) external «ONLY_ADMIN_MOD» {
	«ASSIGNMENT_VAR»[«ENTITY_PARAM»][role] = give;
}'''
	}
	
	/**
	 * Generating a role assignment function for the given role when the basic role assignment is NOT used.
	 * This also handles the special role conditions like cardinality, mutual exclusion, role hierarchy and prerequisite.
	 */
	private def String generateRoleAssignmentForRole(Role role) {		
		return '''«generateAnnotationsForSingleRoleAssignment(role)»
function change«role.entityName.replaceAll(" ", "")»RoleForEntity(address «ENTITY_PARAM», bool «GIVE_ROLE_PARAM») «getVisibilityForRoleAssignmentFunction(role)» «ONLY_ADMIN_MOD» {
	«generateConditionsForSingleRoleAssignment(role)»
	
	«IF !role.superior.isEmpty»
	«FOR superRole : role.superior SEPARATOR ""»
	change«superRole.entityName.replaceAll(" ", "")»RoleForEntity(«ENTITY_PARAM», «GIVE_ROLE_PARAM»);
	«ENDFOR»
	«ENDIF»
	«ASSIGNMENT_VAR»[«ENTITY_PARAM»][«getRolesEnumName».«getRoleEnumValueForRole(role)»] = «GIVE_ROLE_PARAM»;
}'''
	}
	
	/**
	 * Creates the keyword for the role assignment functions visibility. This is "public" if the role is a superior
	 * to any other role. Otherwise it is "external"
	 */
	private def String getVisibilityForRoleAssignmentFunction(Role role) {
		if(target.roles.exists[r | r.superior.exists[sup | sup.equals(role)]]) {
			return "public"
		} else {
			return "external"
		}
	}
	
	/**
	 * Generates the annotations for the method to assign the given role.
	 */
	private def String generateAnnotationsForSingleRoleAssignment(Role role) {
		return '''«getSolcVerifyModificationSpecifier» «ASSIGNMENT_VAR»[«ENTITY_PARAM»][«getRolesEnumName».«getRoleEnumValueForRole(role)»]
«IF !role.superior.isEmpty»
«FOR superRole : role.superior SEPARATOR ""»
«getSolcVerifyModificationSpecifier» «ASSIGNMENT_VAR»[«ENTITY_PARAM»][«getRolesEnumName».«getRoleEnumValueForRole(superRole)»]
«ENDFOR»
«ENDIF»
«IF role.cardinality != DEFAULT_CARD»
«getSolcVerifyModificationSpecifier» «role.entityName.replaceAll(" ", "").toFirstLower»«COUNTER_SUFFIX»
«ENDIF»'''
	}
	
	/**
	 * Generate all possible conditions that can occur in relation to the given role.
	 */
	private def String generateConditionsForSingleRoleAssignment(Role role) {
		val mutualExclusiveRoles = getMutuallyExclusiveRolesForRole(role)
		val specialCard = role.cardinality != DEFAULT_CARD
		var counterVarName = ""
		if(specialCard) {
			counterVarName = '''«role.entityName.replaceAll(" ", "").toFirstLower»«COUNTER_SUFFIX»'''
		}
		
		return '''«IF role.cardinality != DEFAULT_CARD || !role.prerequisite.isEmpty || !mutualExclusiveRoles.isEmpty»
	if(«GIVE_ROLE_PARAM») {
		«FOR pre : role.prerequisite SEPARATOR ""»
		require(«getAccessCheckingFunctionName»(«getMsgSenderKeyword», «getRolesEnumName».«getRoleEnumValueForRole(pre)»), "«getPrerequisiteRequiresMessage(pre.entityName)»");
		«ENDFOR»
		«FOR exclusive : mutualExclusiveRoles SEPARATOR ""»
		require(!«getAccessCheckingFunctionName»(«getMsgSenderKeyword», «getRolesEnumName».«getRoleEnumValueForRole(exclusive)»), "«getMutualExclusionRequiresMessage(exclusive.entityName)»");
		«ENDFOR»
		«IF specialCard»
		require(«counterVarName» < «role.cardinality», "«getCounterMaximumRequiresMessage(role.cardinality, role.entityName)»");
		«counterVarName»++;
		«ENDIF»
	} «IF specialCard»else {
		require(«counterVarName» > 0, "«getCounterMimimumRequiresMessage(role.entityName)»");
		«counterVarName»--;
	}
	«ENDIF»
	«ENDIF»'''
	}
	
	/**
	 * This function returns a list with all roles the given role is mutually exclusive to.
	 * If no mutual exclusions are modeled, an empty list is returned.
	 */
	private def Collection<Role> getMutuallyExclusiveRolesForRole(Role role) {
		val fittingExclusions = target.roleExclusions.filter[re | re.roles.contains(role)]
		val roles = new ArrayList<Role>()
		for(exc : fittingExclusions) {
			for(exclusiveRole : exc.roles) {
				if(!exclusiveRole.equals(role)) {
					roles.add(exclusiveRole)
				}
			}
		}
		return roles
	}
	
	/**
	 * Generating a role assignment function for the ADMIN role when the basic role assignment is NOT used.
	 * There is no need to handle the special role conditions.
	 */
	private def String generateRoleAssignmentForAdmin() {
		return '''«getSolcVerifyModificationSpecifier» «ASSIGNMENT_VAR»[«ENTITY_PARAM»][«getRolesEnumName».«ADMIN_ROLE.toUpperCase»]
function change«ADMIN_ROLE.toFirstUpper»RoleForEntity(address «ENTITY_PARAM», bool «GIVE_ROLE_PARAM») external «ONLY_ADMIN_MOD» {
	«ASSIGNMENT_VAR»[«ENTITY_PARAM»][«getRolesEnumName».«ADMIN_ROLE.toUpperCase»] = «GIVE_ROLE_PARAM»;
}'''
	}	
}