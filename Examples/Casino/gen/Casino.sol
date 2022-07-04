// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract Casino {
	enum Coin { HEADS, TAILS }
	enum State { IDLE, GAME_AVAILABLE, BET_PLACED }

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: OPERATOR
	// Influence by: None
	uint public pot; // Auto-generated Field

	// Modification by: OPERATOR
	// Influence by: None
	bytes32 public hashedNumber; // Auto-generated Field

	// Modification by: PLAYER
	// Influence by: None
	Coin internal guess; // Auto-generated Field

	// Modification by: PLAYER, OPERATOR
	// Influence by: None
	uint internal bet; // Auto-generated Field

	// Modification by: OPERATOR, PLAYER
	// Influence by: None
	State private state; // Auto-generated Field

	constructor() {
		//TODO: Auto-generated Constructor
	}

	/// @notice modifies pot 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance <= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function addToPot() public payable onlyOperator {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies pot 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function removeFromPot(uint amount) public onlyOperator {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies hashedNumber 
	/// @notice modifies state 
	function createGame(bytes32 hashedNumber) public onlyOperator {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies state 
	/// @notice modifies bet 
	/// @notice modifies guess 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance <= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function placeBet(Coin guess) public payable onlyPlayer {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies pot 
	/// @notice modifies bet 
	/// @notice modifies state 
	function decideBet(uint secretNumber) public onlyOperator {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function claimPlayerRole() public {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyOperator {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.OPERATOR), "Access denied due to missing role!");
		_;
	}

	modifier onlyPlayer {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.PLAYER), "Access denied due to missing role!");
		_;
	}

}