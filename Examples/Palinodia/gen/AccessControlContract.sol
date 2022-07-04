// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { ROOT_OWNER, REGISTERED_IDENTITY, DEVELOPER, MAINTAINER, PLATFORM, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint private rootOwnerCounter = 0;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	/// @notice modifies roleAssignment[entity][Roles.ROOT_OWNER]
	/// @notice modifies rootOwnerCounter
	function changeRootOwnerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.DEVELOPER), "The address cannot be a Developer as well.");
			require(!checkAccess(msg.sender, Roles.MAINTAINER), "The address cannot be a Maintainer as well.");
			require(rootOwnerCounter < 1, "There are already 1 Root Owner(s).");
			rootOwnerCounter++;
		} else {
			require(rootOwnerCounter > 0, "There needs to be at least one Root Owner before any role can be removed.");
			rootOwnerCounter--;
		}
		
		roleAssignment[entity][Roles.ROOT_OWNER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.REGISTERED_IDENTITY]
	function changeRegisteredIdentityRoleForEntity(address entity, bool giveRole) public onlyAdmin {
		
		roleAssignment[entity][Roles.REGISTERED_IDENTITY] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.DEVELOPER]
	/// @notice modifies roleAssignment[entity][Roles.REGISTERED_IDENTITY]
	function changeDeveloperRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.MAINTAINER), "The address cannot be a Maintainer as well.");
			require(!checkAccess(msg.sender, Roles.ROOT_OWNER), "The address cannot be a Root Owner as well.");
		} 
		
		changeRegisteredIdentityRoleForEntity(entity, giveRole);
		roleAssignment[entity][Roles.DEVELOPER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.MAINTAINER]
	/// @notice modifies roleAssignment[entity][Roles.REGISTERED_IDENTITY]
	function changeMaintainerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.DEVELOPER), "The address cannot be a Developer as well.");
			require(!checkAccess(msg.sender, Roles.ROOT_OWNER), "The address cannot be a Root Owner as well.");
		} 
		
		changeRegisteredIdentityRoleForEntity(entity, giveRole);
		roleAssignment[entity][Roles.MAINTAINER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.PLATFORM]
	function changePlatformRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		
		roleAssignment[entity][Roles.PLATFORM] = giveRole;
	}
	/// @notice modifies roleAssignment[entity][Roles.ADMIN]
	function changeAdminRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		roleAssignment[entity][Roles.ADMIN] = giveRole;
	}

	modifier onlyAdmin {
		require(checkAccess(msg.sender, Roles.ADMIN), "Access denied due to missing role!");
		_;
	}
}