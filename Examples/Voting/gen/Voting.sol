// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract Voting {
	enum VotingChoices { Choice1, Choice2, ChoiceN }

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: ELECTION_WORKER
	// Influence by: None
	bool private votingClosed; // Auto-generated Field

	// Modification by: ELIGIBLE_VOTER
	// Influence by: None
	mapping(VotingChoices => uint) private votingResults; // Auto-generated Field

	/// @notice modifies votingResults if !votingClosed
	function castVote(VotingChoices choice) public onlyEligibleVoter {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies votingClosed 
	function closeVoting() public onlyElectionWorker_TimeLess7days {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyEligibleVoter {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.ELIGIBLE_VOTER), "Access denied due to missing role!");
		_;
	}

	modifier onlyElectionWorker_TimeLess7days {
		require((accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.ELECTION_WORKER)
		 && accCtrl.checkTiming( true, 7 days)), "Access denied!");
		_;
	}
}