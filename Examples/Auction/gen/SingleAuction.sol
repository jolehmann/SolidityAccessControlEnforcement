// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract SingleAuction {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// no Role can modify or influence
	address payable private managingContract; // Auto-generated Field

	// no Role can modify or influence
	address payable private sellerAddress; // Auto-generated Field

	// no Role can modify or influence
	address private highestBidder; // Auto-generated Field

	// Modification by: SELLER, MANAGER
	// Influence by: None
	bool public auctionClosed; // Auto-generated Field

	// Modification by: SELLER
	// Influence by: None
	bool public moneyCollected; // Auto-generated Field

	// no Role can modify or influence
	uint public highestBid; // Auto-generated Field

	// no Role can modify or influence
	uint public bidderCounter; // Auto-generated Field

	// no Role can modify or influence
	mapping(uint => address payable) private bidders; // Auto-generated Field

	// Modification by: BIDDER, MANAGER
	// Influence by: None
	mapping(address => uint) private currentBids; // Auto-generated Field

	constructor(address seller) {
		//TODO: Auto-generated Constructor
	}

	function collectItem() external onlyHighestBidder {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies bidders if !auctionClosed
	/// @notice modifies bidderCounter if !auctionClosed
	/// @notice modifies highestBid if !auctionClosed
	/// @notice modifies highestBidder if !auctionClosed
	/// @notice modifies currentBids[msg.sender] if !auctionClosed
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance <= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function bid() external payable {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies auctionClosed if !auctionClosed
	function close() public onlySeller_TimeGreater7days {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies moneyCollected if auctionClosed && !moneyCollected
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function collectMoney() external onlySeller {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies currentBids[msg.sender] 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function withdrawMoney() external onlyBidder {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies auctionClosed 
	/// @notice modifies currentBids 
	function emergencyShutdown() public onlyManager {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyHighestBidder {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.HIGHEST_BIDDER), "Access denied due to missing role!");
		_;
	}

	modifier onlySeller_TimeGreater7days {
		require((accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.SELLER)
		 && accCtrl.checkTiming( false, 7 days)), "Access denied!");
		_;
	}

	modifier onlySeller {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.SELLER), "Access denied due to missing role!");
		_;
	}

	modifier onlyBidder {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.BIDDER), "Access denied due to missing role!");
		_;
	}

	modifier onlyManager {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.MANAGER), "Access denied due to missing role!");
		_;
	}
}