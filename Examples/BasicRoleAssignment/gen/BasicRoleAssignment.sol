// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract BasicRoleAssignment {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: FIRST_ROLE
	// Influence by: None
	int public variableOne; // Auto-generated Field

	// Modification by: SECOND_ROLE
	// Influence by: None
	int public variableTwo; // Auto-generated Field

	/// @notice modifies variableOne 
	function functionA() external onlyFirstRole {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies variableTwo 
	function functionB() private onlySecondRole {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyFirstRole {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.FIRST_ROLE), "Access denied due to missing role!");
		_;
	}

	modifier onlySecondRole {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.SECOND_ROLE), "Access denied due to missing role!");
		_;
	}
}