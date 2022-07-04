// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { FIRST_ROLE, SECOND_ROLE, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	/// @notice modifies roleAssignment[entity][role]
	function changeRoleAssignment(address entity, Roles role, bool give) external onlyAdmin {
		roleAssignment[entity][role] = give;
	}

	modifier onlyAdmin {
		require(checkAccess(msg.sender, Roles.ADMIN), "Access denied due to missing role!");
		_;
	}
}