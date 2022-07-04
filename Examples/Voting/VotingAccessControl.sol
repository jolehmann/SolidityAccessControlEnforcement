// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract VotingAccessControl {
    enum Roles { ELIGIBLE_VOTER, VOTER, ELECTION_WORKER, ADMIN }
		
	mapping(address => bool) private eligibleVoters;
	mapping(address => bool) private voters;
	mapping(address => bool) private electionWorkers;
	mapping(address => bool) private admins;
	
	uint private electionWorkerCounter = 0;
	uint256 private timeAtStart = 0;
	
	constructor(address admin){
		admins[admin] = true;
		timeAtStart = block.timestamp;
	}
	
	function checkAccess(address entity, Roles role) public view returns(bool result) {
		if(role == Roles.ELIGIBLE_VOTER){
			return eligibleVoters[entity];
		}
		if(role == Roles.VOTER){
			return voters[entity];
		}
		if(role == Roles.ELECTION_WORKER){
			return electionWorkers[entity];
		}
		if(role == Roles.ADMIN){
			return admins[entity];
		}
	}
	
	function checkTiming(bool lower, uint256 addition) public view returns(bool result) {
		if(lower) {
			return block.timestamp <= timeAtStart + addition;
		} else {
			return block.timestamp >= timeAtStart + addition;
		}
	}
	
	/// @notice modifies eligibleVoters[entity]
	function changeEligibleVoterRoleForEntity(address entity, bool giveRole) external onlyAdmin electionWorkerMutualExclusion(giveRole) {
		eligibleVoters[entity] = giveRole;
	}
	
	/// @notice modifies voters[entity]	
	function changeVoterRoleForEntity(address entity, bool giveRole) external onlyAdmin eligibleVoterPrerequisite(giveRole) electionWorkerMutualExclusion(giveRole) {	
		voters[entity] = giveRole;
	}
	
	/// @notice modifies electionWorkers[entity]
	/// @notice modifies electionWorkerCounter
	function changeElectionWorkerRoleForEntity(address entity, bool giveRole) external onlyAdmin eligibleVoterMutualExclusion(giveRole) voterMutualExclusion(giveRole) {
		require(electionWorkerCounter > 0 && !giveRole, "There needs to be at least one election worker before the role can be removed.");
		require(electionWorkerCounter < 5 && giveRole, "There are already 5 election workers.");
		
		if(giveRole) {
			electionWorkerCounter++;
		} else {
			electionWorkerCounter--;
		}
		
		electionWorkers[entity] = giveRole;
	}
	
	/// @notice modifies admins[entity]
	function changeAdminRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		admins[entity] = giveRole;
	}
	
	modifier onlyAdmin {
		require(checkAccess(msg.sender, Roles.ADMIN), "Access denied.");
		_;
	}
	
	modifier eligibleVoterPrerequisite(bool giveRole) {
		if(giveRole) {
			require(checkAccess(msg.sender, Roles.ELIGIBLE_VOTER), "The address needs to be an eligible voter as well.");
		}
		_;
	}
	
	modifier eligibleVoterMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.ELIGIBLE_VOTER), "The address cannot be an eligible voter as well.");
		}
		_;
	}
	
	modifier voterMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.VOTER), "The address cannot be a voter as well.");
		}
		_;
	}
	
	modifier electionWorkerMutualExclusion(bool giveRole) {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.ELECTION_WORKER), "The address cannot be an election worker as well.");
		}
		_;
	}	
}