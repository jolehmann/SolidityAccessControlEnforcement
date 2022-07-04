// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract Banking {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: BANK_MANAGER
	// Influence by: None
	mapping(address => uint) private balances; // Auto-generated Field

	// Modification by: BANK_MANAGER
	// Influence by: None
	bool private isOpen; // Auto-generated Field

	// no Role can modify or influence
	uint private accountCounter; // Auto-generated Field

	// no Role can modify or influence
	mapping(uint => address payable) private accounts; // Auto-generated Field

	/// @notice modifies accounts if isOpen
	/// @notice modifies accountCounter if isOpen
	/// @notice modifies balances[msg.sender] if isOpen
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function deposit() external payable {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies balances[msg.sender] if isOpen
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function withdraw(uint amount) external {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies isOpen 
	/// @notice modifies balances 
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function payoutAll() external onlyBankManager {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyBankManager {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.BANK_MANAGER), "Access denied due to missing role!");
		_;
	}
}