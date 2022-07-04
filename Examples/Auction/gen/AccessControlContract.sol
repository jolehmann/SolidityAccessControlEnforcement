// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { SELLER, BIDDER, HIGHEST_BIDDER, MANAGER, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint256 private timeAtStart = 0;
	uint private sellerCounter = 0;
	uint private highestBidderCounter = 0;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
		timeAtStart = block.timestamp;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	function checkTiming(bool upper, uint256 addition) public view returns(bool result) {
		if(upper) {
			return block.timestamp >= timeAtStart + addition;
		} else {
			return block.timestamp <= timeAtStart + addition;
		}
	}

	/// @notice modifies roleAssignment[entity][Roles.SELLER]
	/// @notice modifies sellerCounter
	function changeSellerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.BIDDER), "The address cannot be a Bidder as well.");
			require(!checkAccess(msg.sender, Roles.MANAGER), "The address cannot be a Manager as well.");
			require(sellerCounter < 1, "There are already 1 Seller(s).");
			sellerCounter++;
		} else {
			require(sellerCounter > 0, "There needs to be at least one Seller before any role can be removed.");
			sellerCounter--;
		}
		
		roleAssignment[entity][Roles.SELLER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.BIDDER]
	function changeBidderRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.SELLER), "The address cannot be a Seller as well.");
		} 
		
		roleAssignment[entity][Roles.BIDDER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.HIGHEST_BIDDER]
	/// @notice modifies highestBidderCounter
	function changeHighestBidderRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(checkAccess(msg.sender, Roles.BIDDER), "The address needs to be a Bidder as well.");
			require(highestBidderCounter < 1, "There are already 1 Highest Bidder(s).");
			highestBidderCounter++;
		} else {
			require(highestBidderCounter > 0, "There needs to be at least one Highest Bidder before any role can be removed.");
			highestBidderCounter--;
		}
		
		roleAssignment[entity][Roles.HIGHEST_BIDDER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.MANAGER]
	function changeManagerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.SELLER), "The address cannot be a Seller as well.");
		} 
		
		roleAssignment[entity][Roles.MANAGER] = giveRole;
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