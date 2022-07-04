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
	    accCtrl.changeOperatorRoleForEntity(msg.sender, true);
	    state = IDLE;
	    pot = 0;
	    bet = 0;
	}

	/// @notice modifies pot 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance <= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function addToPot() public payable onlyOperator {
		pot = pot + msg.value;
	}

	/// @notice modifies pot 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance >= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance <= __verifier_old_uint(address(this).balance)
	function removeFromPot(uint amount) public onlyOperator {
		// no active bet ongoing:
	    require (state != BET_PLACED);
	    //operator.transfer(amount);
	    pot = pot - amount;
	}

	/// @notice modifies hashedNumber 
	/// @notice modifies state 
	function createGame(bytes32 _hashedNumber) public onlyOperator {
		require (state == IDLE);
	    hashedNumber = _hashedNumber;
	    state = GAME_AVAILABLE;
	}

	/// @notice modifies state 
	/// @notice modifies bet 
	/// @notice modifies guess 
	/// @notice modifies msg.sender.balance
	/// @notice postcondition msg.sender.balance <= __verifier_old_uint(msg.sender.balance)
	/// @notice modifies address(this).balance
	/// @notice postcondition address(this).balance >= __verifier_old_uint(address(this).balance)
	function placeBet(Coin _guess) public payable onlyPlayer {
		require (state == GAME_AVAILABLE);
	    require (msg.value <= pot);
	    
	    state = BET_PLACED;	
	    bet = msg.value;
	    guess = _guess;
	}

	/// @notice modifies pot 
	/// @notice modifies bet 
	/// @notice modifies state 
	function decideBet(uint secretNumber) public onlyOperator {
		require (state == BET_PLACED);
	    require (hashedNumber == cryptohash(secretNumber));
	    
	    Coin secret = (secretNumber % 2 == 0)? HEADS : TAILS;
	    
	    if (secret == guess) {
	      // player wins, gets back twice her bet
	      pot = pot - bet;
	      //player.transfer(2*bet);
	      bet = 0;
	    } else {
	      // operator wins, bet transfered to pot
	      pot = pot + bet;
	      bet = 0;
	    }
	    
	    state = IDLE;
	}

	function claimPlayerRole() public {
		accCtrl.changePlayerRoleForEntity(msg.sender, true);
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