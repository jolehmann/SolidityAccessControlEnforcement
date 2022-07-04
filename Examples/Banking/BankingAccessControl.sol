// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract BankingAccessControl {
    enum Roles { BANK_MANAGER, ADMIN }
		
	mapping(address => bool) private bankManagers;
	mapping(address => bool) private admins;
	
	uint private bankManagerCounter = 0;
	
	constructor(address admin){
		admins[admin] = true;
	}
	
	function checkAccess(address entity, Roles role) public view returns(bool result) {
		if(role == Roles.BANK_MANAGER){
			return bankManagers[entity];
		}
	}
	
	/// @notice modifies bankManagers[entity]
	/// @notice modifies bankManagerCounter
	function changeBankManagerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		require(bankManagerCounter > 0 && !giveRole, "There needs to be at least one bank manager before the role can be removed.");
		require(bankManagerCounter < 3 && giveRole, "There are already 3 bank managers.");
		
		if(giveRole) {
			bankManagerCounter++;
		} else {
			bankManagerCounter--;
		}
		
		bankManagers[entity] = giveRole;
	}
	
	/// @notice modifies admins[entity]
	function changeAdminRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		admins[entity] = giveRole;
	}
	
	modifier onlyAdmin {
		require(checkAccess(msg.sender, Roles.ADMIN), "Access denied.");
		_;
	}
}