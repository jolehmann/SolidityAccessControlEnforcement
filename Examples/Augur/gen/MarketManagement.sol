// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./Market.sol";

contract MarketManagement {

	// no Role can modify or influence
	uint private marketCounter; // Auto-generated Field

	// no Role can modify or influence
	Market[] private markets; // Auto-generated Field

	/// @notice modifies marketCounter 
	/// @notice modifies markets 
	function createNewMarket() public {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

}