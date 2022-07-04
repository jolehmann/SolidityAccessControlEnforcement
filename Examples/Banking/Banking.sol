// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./BankingAccessControl.sol";

contract Banking {
    BankingAccessControl private accessControl = new BankingAccessControl(address(this));
    uint private accountCounter = 0;
    bool private isOpen = true;
    mapping(uint => address payable) private accounts;
	mapping(address => uint) private balances;
	
	/// @notice modifies balances[msg.sender] if isOpen
	/// @notice modifies accounts if isOpen
	/// @notice modifies accountCounter if isOpen
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function deposit() external payable {
	    require(isOpen, "The bank is currently closed.");
	    accounts[accountCounter] = payable(msg.sender);
		balances[msg.sender] += msg.value;
		accountCounter++;
	}
	
	/// @notice modifies balances[msg.sender] if isOpen
	/// @notice modifies address(this).balance
	/// @notice modifies msg.sender.balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	function withdraw(uint amount) external {
	    require(isOpen, "The bank is currently closed.");
		require(amount <= balances[msg.sender], "Not enough money to withdraw!");
		
		uint balanceBefore = balances[msg.sender];
		balances[msg.sender] -= amount;
		if(!msg.sender.send(amount)) {
			balances[msg.sender] = balanceBefore;
			assert(balances[msg.sender] == balanceBefore);
		} else {
			assert(balances[msg.sender] == balanceBefore - amount);
		}
	}
	
	/// @notice modifies isOpen
	/// @notice modifies balances
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function payoutAll() external onlyBankManager {
		isOpen = false;
		
		for(uint i = 0; i < accountCounter; i++) {
			uint balanceBefore = balances[accounts[i]];
			if(balanceBefore > 0) {
				balances[accounts[i]] = 0;
				if(!accounts[i].send(balanceBefore)) {
					balances[accounts[i]] = balanceBefore;
					assert(balances[accounts[i]] == balanceBefore);
				} else {
					assert(balances[accounts[i]] == 0);
				}
			}
		}
	}
	
	modifier onlyBankManager {
		require(accessControl.checkAccess(msg.sender, BankingAccessControl.Roles.BANK_MANAGER), "Access denied.");
		_;
	}
}
