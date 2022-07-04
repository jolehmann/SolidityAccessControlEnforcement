// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract SingleAuctionAccessControl {
    enum Roles { SELLER, BIDDER, HIGHEST_BIDDER, MANAGER, ADMIN }
		
	mapping(address => bool) private sellers;
	mapping(address => bool) private bidders;
	mapping(address => bool) private highestBidders;
	mapping(address => bool) private managers;
	mapping(address => bool) private admins;
	
	uint private highestBidderCounter = 0;
	uint private sellerCounter = 0;
	
	constructor(address admin){
		admins[admin] = true;
	}
	
	function checkAccess(address entity, Roles role) public view returns(bool result) {
		if(role == Roles.SELLER) {
			return sellers[entity];
		}	
		if(role == Roles.BIDDER){
			return bidders[entity];
		}
		if(role == Roles.HIGHEST_BIDDER){
			return highestBidders[entity];
		}
		if(role == Roles.MANAGER){
			return managers[entity];
		}
		if(role == Roles.ADMIN){
			return admins[entity];
		}
	}
	
	/// @notice modifies sellers[entity]
	/// @notice modifies sellerCounter
	function changeSellerRoleForEntity(address entity, bool giveRole) external onlyAdmin bidderMutualExclusion(giveRole) managerMutualExclusion(giveRole) {
		require(sellerCounter > 0 && !giveRole, "There needs to be at least one seller before the role can be removed.");
		require(sellerCounter < 1 && giveRole, "There is already 1 seller.");
	
		if(giveRole) {
			sellerCounter++;
		} else {
			sellerCounter--;
		}
	
		sellers[entity] = giveRole;
	}
	
	/// @notice modifies bidders[entity]
	function changeBidderRoleForEntity(address entity, bool giveRole) external onlyAdmin sellerMutualExclusion(giveRole) managerMutualExclusion(giveRole) {	
		bidders[entity] = giveRole;
	}
	
	/// @notice modifies highestBidders[entity]
	/// @notice modifies highestBidderCounter
	function changeHighestBidderRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		require(highestBidderCounter > 0 && !giveRole, "There needs to be at least one highest bidder before the role can be removed.");
		require(highestBidderCounter < 1 && giveRole, "There is already 1 highest bidder.");
		
		if(giveRole) {
			highestBidderCounter++;
		} else {
			highestBidderCounter--;
		}
		
		highestBidders[entity] = giveRole;
	}
	
	/// @notice modifies managers[entity]
	function changeManagerRoleForEntity(address entity, bool giveRole) external onlyAdmin sellerMutualExclusion(giveRole) bidderMutualExclusion(giveRole) {
		managers[entity] = giveRole;
	}
	
	/// @notice modifies admins[entity]
	function changeAdminRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		admins[entity] = giveRole;
	}
	
	modifier onlyAdmin {
		require(checkAccess(msg.sender, Roles.ADMIN), "Access denied.");
		_;
	}
	
	modifier sellerMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.SELLER), "The address cannot be the seller as well.");
		}
		_;
	}
	
	modifier managerMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.MANAGER), "The address cannot be the manager as well.");
		}
		_;
	}
	
	modifier bidderMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.BIDDER), "The address cannot be a bidder as well.");
		}
		_;
	}	
}
