// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract AccessControlContract {
	enum Roles { PLAYER, OPERATOR, ADMIN }

	mapping(address => mapping(Roles => bool)) private roleAssignment;
	uint private playerCounter = 0;
	uint private operatorCounter = 0;

	constructor(address admin) {
		roleAssignment[admin][Roles.ADMIN] = true;
	}

	function checkAccess(address entity, Roles role) public view returns(bool result) {
		return roleAssignment[entity][role];
	}

	/// @notice modifies roleAssignment[entity][Roles.PLAYER]
	/// @notice modifies playerCounter
	function changePlayerRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.OPERATOR), "The address cannot be a Operator as well.");
			require(playerCounter < 1, "There are already 1 Player(s).");
			playerCounter++;
		} else {
			require(playerCounter > 0, "There needs to be at least one Player before any role can be removed.");
			playerCounter--;
		}
		
		roleAssignment[entity][Roles.PLAYER] = giveRole;
	}

	/// @notice modifies roleAssignment[entity][Roles.OPERATOR]
	/// @notice modifies operatorCounter
	function changeOperatorRoleForEntity(address entity, bool giveRole) external onlyAdmin {
		if(giveRole) {
			require(!checkAccess(msg.sender, Roles.PLAYER), "The address cannot be a Player as well.");
			require(operatorCounter < 1, "There are already 1 Operator(s).");
			operatorCounter++;
		} else {
			require(operatorCounter > 0, "There needs to be at least one Operator before any role can be removed.");
			operatorCounter--;
		}
		
		roleAssignment[entity][Roles.OPERATOR] = giveRole;
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