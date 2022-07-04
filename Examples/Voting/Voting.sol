// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./VotingAccessControl.sol";

contract Voting {

    enum Choices{ ONE, TWO, THREE }
    
    bool private votingClosed;
    
    VotingAccessControl private accessControl = new VotingAccessControl(address(this));
    
    mapping(Choices => uint) public votes;
    
	/// @notice modifies votingClosed
    function closeVoting() public onlyElectionWorker closeVotingTiming {
        votingClosed = true;
    }
    
	/// @notice modifies votes if !votingClosed
    function castVote(Choices choice) public onlyEligible {
        require(votingClosed == false, "Voting already closed.");
        
        votes[choice]++;
        
        accessControl.changeEligibleVoterRoleForEntity(msg.sender, false);
        accessControl.changeVoterRoleForEntity(msg.sender, true);
    }
    
    modifier onlyEligible {
		require(accessControl.checkAccess(msg.sender, VotingAccessControl.Roles.ELIGIBLE_VOTER), "Access denied.");
		_;
	}
	
	modifier onlyElectionWorker {
		require(accessControl.checkAccess(msg.sender, VotingAccessControl.Roles.ELECTION_WORKER), "Access denied.");
		_;
	}
	
	modifier onlyAdmin {
	    require(accessControl.checkAccess(msg.sender, VotingAccessControl.Roles.ADMIN), "Access denied.");
        _;
	}
	
	modifier closeVotingTiming {
	    require(accessControl.checkTiming(false, 7 days), "Voting is not yet open long enough");
        _;
	}
}