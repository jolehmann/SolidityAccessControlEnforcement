package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role

/**
 * Utility class to collect all constant strings needed throughout the Solidity code generation
 * for everything related to access control
 */
class AccessControlConstants {
	private new() {}
	
	static def String getAccessControlContactName() '''AccessControlContract'''
	
	static def String getAccessControlVariableName() '''accCtrl'''
	
	static def String getSolcVerifyModificationSpecifier() '''/// @notice modifies'''
	
	static def String getMsgSenderKeyword() '''msg.sender'''
	
	static def String getThisAddressKeyword() '''address(this)'''
	
	/**
	 * Returning the enum Value for the given role object by replacing empty spaces with _
	 * and converting it all to upper case.
	 * @param role - Role with name to convert
	 * @returns enum value for the given role
	 */
	static def String getRoleEnumValueForRole(Role role) {
		var name = role.entityName.replaceAll(" ", "_")
		return name.toUpperCase
	}
	
	static def String getRolesEnumName() '''Roles'''
	
	static def String getAccessCheckingFunctionName() '''checkAccess'''
	
	static def String getTimingCheckFunctionName() '''checkTiming'''
	
	static def String getAccessControlRequiresMessage() '''Access denied due to missing role!'''
	
	static def String getCounterMimimumRequiresMessage(String role) 
		'''There needs to be at least one «role» before any role can be removed.'''
	
	static def String getCounterMaximumRequiresMessage(int amount, String role) 
		'''There are already «amount.toString» «role»(s).'''
	
	static def String getPrerequisiteRequiresMessage(String role) '''The address needs to be a «role» as well.'''
	
	static def String getMutualExclusionRequiresMessage(String role) '''The address cannot be a «role» as well.'''
}