// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { BANK_MANAGER, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint private bankManagerCounter = 0;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	/// @notice modifies roleAssignment[entity][Roles.BANK_MANAGER]
	/// @notice modifies bankManagerCounter
	function changeBankManagerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(bankManagerCounter < 3, "There are already 3 Bank Manager(s).");
			bankManagerCounter++;
		} else {
			require(bankManagerCounter > 0, "There needs to be at least one Bank Manager before any role can be removed.");
			bankManagerCounter--;
		}
		
		roleAssignment[entity][Roles.BANK_MANAGER] = giveRole;
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