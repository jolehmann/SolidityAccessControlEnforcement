// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./SingleAuctionAccessControl.sol";

contract SingleAuction {
	address payable private managingContract;
	address payable private sellerAddress;
	address private highestBidder;
	
	SingleAuctionAccessControl private accessControl = new SingleAuctionAccessControl(address(this));
	
	bool private auctionClosed;
	bool private moneyCollected;
	uint private highestBid;
	uint private bidderCounter;
	
	mapping(uint => address payable) private bidders;
	mapping(address => uint) private currentBids;
	
	constructor(address seller) {
		managingContract = payable(msg.sender);
		sellerAddress = payable(seller);
		
		accessControl.changeManagerRoleForEntity(msg.sender, true);
		accessControl.changeSellerRoleForEntity(seller, true);
		
		auctionClosed = false;	
		moneyCollected = false;
		highestBid = 0;
		bidderCounter = 0;
	}
	
	/// @notice modifies address(this).balance
	/// @notice modifies highestBidder
	/// @notice modifies highestBid 
	/// @notice modifies bidderCounter
	/// @notice modifies bidders
	/// @notice modifies currentBids[msg.sender]
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function bid() external payable {
		require(auctionClosed == false, "Auction already closed.");
		require(currentBids[msg.sender] > 0, "Please withdraw your bid before staking a new one.");
		
		bidders[bidderCounter] = payable(msg.sender);
		currentBids[msg.sender] = msg.value;
		bidderCounter++;
		accessControl.changeBidderRoleForEntity(msg.sender, true);
		
		if(msg.value > highestBid) {
			highestBid = msg.value;
			highestBidder = msg.sender;
			accessControl.changeHighestBidderRoleForEntity(highestBidder, false);
			accessControl.changeHighestBidderRoleForEntity(msg.sender, true);
		}
	}

	/// @notice modifies auctionClosed
	function close() public onlySeller {
		require(auctionClosed == false, "Auction already closed.");
		
		auctionClosed = true;
	}
	
	/// @notice modifies address(this).balance
	/// @notice modifies sellerAddress.balance
	/// @notice modifies moneyCollected
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	/// @notice postcondition sellerAddress.balance >= __verifier_old_uint(sellerAddress.balance)
	function collectMoney() external onlySeller {
		require(auctionClosed == true, "Auction is still active.");
		require(moneyCollected == false, "The money has already been collected.");
		
		moneyCollected = true;
		if(!sellerAddress.send(highestBid)) {
			moneyCollected = false;
		}		
	}

	function collectItem() external onlyHighestBidder {
		require(auctionClosed == true, "Auction is still active.");
		
		// sent the item, whatever form it may have
	}

	/// @notice modifies address(this).balance
	/// @notice modifies msg.sender.balance
	/// @notice modifies currentBids[msg.sender]
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	function withdrawMoney() external onlyBidder {
		require(msg.sender != highestBidder, "The highest bidder cannot withdraw their money.");
		require(currentBids[msg.sender] > 0, "No money to withdraw.");
		
		uint amount = currentBids[msg.sender];
		currentBids[msg.sender] = 0;
		if(!msg.sender.send(amount)) {
			currentBids[msg.sender] = amount;
			assert(currentBids[msg.sender] == amount);
		} else {
			accessControl.changeBidderRoleForEntity(msg.sender, false);
			assert(currentBids[msg.sender] == 0);
		}		
	}

	/// @notice modifies address(this).balance
	/// @notice modifies auctionClosed
	/// @notice modifies currentBids
	function emergencyShutdown() public onlyManager {
		auctionClosed = true;
		
		for(uint i = 0; i < bidderCounter; i++) {
			uint amount = currentBids[bidders[i]];
			if(amount > 0) {
				currentBids[bidders[i]] = 0;
				if(!bidders[i].send(amount)) {
					currentBids[bidders[i]] = amount;
					assert(currentBids[bidders[i]] == amount);
				} else {
					accessControl.changeBidderRoleForEntity(bidders[i], false);
					assert(currentBids[bidders[i]] == 0);
				}
			}
		}
		
		// the selfdestruct function semms to not work with solc-verify 0.5.17
		// selfdestruct(managingContract);
	}
	
	modifier onlySeller {
		require(accessControl.checkAccess(msg.sender, SingleAuctionAccessControl.Roles.SELLER), "Access denied.");
		_;	
	}	
	
	modifier onlyBidder {
		require(accessControl.checkAccess(msg.sender, SingleAuctionAccessControl.Roles.BIDDER), "Access denied.");
		_;	
	}
	
	modifier onlyHighestBidder {
		require(accessControl.checkAccess(msg.sender, SingleAuctionAccessControl.Roles.HIGHEST_BIDDER), "Access denied.");
		_;	
	}
	
	modifier onlyManager {
		require(accessControl.checkAccess(msg.sender, SingleAuctionAccessControl.Roles.MANAGER), "Access denied.");
		_;	
	}
}
