// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract Insurance {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// no Role can modify or influence
	address private databaseLocation; // Auto-generated Field

	// Modification by: INSURANT
	// Influence by: None
	address private insurant; // Auto-generated Field

	// no Role can modify or influence
	string private insuredFlight; // Auto-generated Field

	// no Role can modify or influence
	uint private insuranceAmount; // Auto-generated Field

	// Modification by: INSURANT, INSURANCE_COMPANY
	// Influence by: None
	bool public insuranceClosed; // Auto-generated Field

	constructor(address toInsure, string memory flight, uint amount) {
		databaseLocation = msg.sender;
	    insurant = toInsure;
	    insuranceAmount = amount;
	    insuredFlight = flight;
	    
	    accCtrl.changeInsuranceCompanyRoleForEntity(msg.sender, true);
	    accCtrl.changeInsurantRoleForEntity(insurant, true);
	}

	/// @notice modifies insuranceClosed if !insuranceClosed
	function cancelInsurance() external onlyInsurant {
		require(!insuranceClosed, "Insurance is already closed");
		payout();
		insurant = address(0);
		insuranceClosed = true;
	}

	/// @notice modifies insurant if !insuranceClosed
	function changeAccount(address newInsurant) external onlyInsurant {
		require(!insuranceClosed, "Insurance is already closed");
		accCtrl.changeInsurantRoleForEntity(insurant, false);
		accCtrl.changeInsurantRoleForEntity(newInsurant, true);
		insurant = newInsurant;
	}

	/// @notice modifies insuranceClosed 
	function checkForDelay() public onlyInsuranceCompany {
		// use databaseLocation.airTrafficDatabase to get a boolean decision if
	    // the payout needs to happen for the given flight
		payout();
	}

	/// @notice modifies insuranceClosed if !insuranceClosed
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function payout() internal onlyInsuranceCompany {
		require(!insuranceClosed, "Insurance is already closed");
		insuranceClosed = true;
		if(!payable(insurant).send(insuranceAmount)) {
			insuranceClosed = false;
		}
	}

	modifier onlyInsurant {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.INSURANT), "Access denied due to missing role!");
		_;
	}

	modifier onlyInsuranceCompany {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.INSURANCE_COMPANY), "Access denied due to missing role!");
		_;
	}

}