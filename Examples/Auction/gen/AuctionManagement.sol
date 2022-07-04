// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./SingleAuction.sol";

contract AuctionManagement {

	// no Role can modify or influence
	SingleAuction[] private auctions; // Auto-generated Field

	// no Role can modify or influence
	uint private auctionCounter; // Auto-generated Field

	/// @notice modifies auctionCounter 
	/// @notice modifies auctions 
	function createNewAuction() public {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

}