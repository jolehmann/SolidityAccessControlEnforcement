// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { ELIGIBLE_VOTER, VOTER, ELECTION_WORKER, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint256 private timeAtStart = 0;
	uint private electionWorkerCounter = 0;

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

	/// @notice modifies roleAssignment[entity][Roles.ELIGIBLE_VOTER]
	function changeEligibleVoterRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.ELECTION_WORKER), "The address cannot be a Election Worker as well.");
		} 
		
		roleAssignment[entity][Roles.ELIGIBLE_VOTER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.VOTER]
	function changeVoterRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(checkAccess(msg.sender, Roles.ELIGIBLE_VOTER), "The address needs to be a Eligible Voter as well.");
		} 
		
		roleAssignment[entity][Roles.VOTER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.ELECTION_WORKER]
	/// @notice modifies electionWorkerCounter
	function changeElectionWorkerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.ELIGIBLE_VOTER), "The address cannot be a Eligible Voter as well.");
			require(electionWorkerCounter < 5, "There are already 5 Election Worker(s).");
			electionWorkerCounter++;
		} else {
			require(electionWorkerCounter > 0, "There needs to be at least one Election Worker before any role can be removed.");
			electionWorkerCounter--;
		}
		
		roleAssignment[entity][Roles.ELECTION_WORKER] = giveRole;
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