// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./Market.sol";

contract MarketManagement {

	// Roles: No Role can modify or influence
	uint private marketCounter; // Auto-generated Field

	// Roles: No Role can modify or influence
	Market[] private markets; // Auto-generated Field

	// Roles: No Role can directly access
	/// @notice modifies marketCounter 
	/// @notice modifies markets 
	function createNewMarket() public {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

}