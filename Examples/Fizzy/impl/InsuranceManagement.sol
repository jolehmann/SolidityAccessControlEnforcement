// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./Insurance.sol";
import "./AccessControlContract.sol";

contract InsuranceManagement {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// no Role can modify or influence
	uint private insuranceCounter; // Auto-generated Field

	// no Role can modify or influence
	Insurance[] private insurances; // Auto-generated Field

	// Modification by: INSURANCE_COMPANY
	// Influence by: None
	address public airTrafficDatabase; // Auto-generated Field

	constructor() {
		accCtrl.changeInsuranceCompanyRoleForEntity(msg.sender, true);
	}

	/// @notice modifies airTrafficDatabase 
	function changeAirTrafficDatabase(address newDatabase) external onlyInsuranceCompany {
		airTrafficDatabase = newDatabase;
	}

	/// @notice modifies insuranceCounter 
	/// @notice modifies insurances 
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function takeOutInsurance(string memory flight, uint amount) public {
		insurances[insuranceCounter] = new Insurance(msg.sender, flight, amount);
		payable(address(insurances[insuranceCounter])).send(amount);
	    insuranceCounter++;
	}

	modifier onlyInsuranceCompany {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.INSURANCE_COMPANY), "Access denied due to missing role!");
		_;
	}

}