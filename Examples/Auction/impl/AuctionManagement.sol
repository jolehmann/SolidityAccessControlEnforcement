// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./SingleAuction.sol";

contract AuctionManagement {

	SingleAuction[] private auctions;
	uint private auctionCounter = 0;
	
	/// @notice modifies auctions
	/// @notice modifies auctionCounter
	function createNewAuction() public {
	    auctions[auctionCounter] = new SingleAuction(msg.sender);
	    auctionCounter++;
	}
}