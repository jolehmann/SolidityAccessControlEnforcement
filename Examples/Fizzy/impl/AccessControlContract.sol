// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { INSURANCE_COMPANY, INSURANT, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint private insuranceCompanyCounter = 0;
	uint private insurantCounter = 0;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	/// @notice modifies roleAssignment[entity][Roles.INSURANCE_COMPANY]
	/// @notice modifies insuranceCompanyCounter
	function changeInsuranceCompanyRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(insuranceCompanyCounter < 1, "There are already 1 Insurance Company(s).");
			insuranceCompanyCounter++;
		} else {
			require(insuranceCompanyCounter > 0, "There needs to be at least one Insurance Company before any role can be removed.");
			insuranceCompanyCounter--;
		}
		
		roleAssignment[entity][Roles.INSURANCE_COMPANY] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.INSURANT]
	/// @notice modifies insurantCounter
	function changeInsurantRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(insurantCounter < 1, "There are already 1 Insurant(s).");
			insurantCounter++;
		} else {
			require(insurantCounter > 0, "There needs to be at least one Insurant before any role can be removed.");
			insurantCounter--;
		}
		
		roleAssignment[entity][Roles.INSURANT] = giveRole;
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