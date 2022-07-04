// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./IdentityManagement.sol";
import "./Software.sol";
import "./AccessControlContract.sol";

contract BinaryHashStorage {

	struct BinaryStatement {
		uint256 publishNumber;
		uint256 binaryHash;
	}

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: ROOT_OWNER
	// Influence by: None
	address public rootOwnerAddress; // Auto-generated Field

	// Modification by: MAINTAINER
	// Influence by: None
	string public platformId; // Auto-generated Field

	// Modification by: REGISTERED_IDENTITY, ROOT_OWNER
	// Influence by: None
	uint8 public initializeStatus; // Auto-generated Field

	// Modification by: MAINTAINER
	// Influence by: None
	uint256 public publishCounter; // Auto-generated Field

	// Modification by: MAINTAINER
	// Influence by: None
	mapping(string => BinaryStatement) internal hashStore; // Auto-generated Field

	// Modification by: ROOT_OWNER
	// Influence by: None
	IdentityManagement public maintainerControl; // Auto-generated Field

	// Modification by: REGISTERED_IDENTITY, ROOT_OWNER
	// Influence by: None
	Software public softwareContract; // Auto-generated Field

	event MaintainerChangeEvent(IdentityManagement oldAddress, IdentityManagement newAddress);
	event OwnerAddressChange(address oldOwnerAddress, address newOwnerAddress);
	event PublishingEvent(uint256 indexed pubCounter, string hashId, uint256 hash);
	event RevocationEvent(uint256 indexed pubCounter, string hashId);

	constructor(address mainControl) {
		//TODO: Auto-generated Constructor
	}

	/// @notice modifies rootOwnerAddress 
	function changeRootOwner(address newAddress) public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies maintainerControl 
	function setMaintainer(IdentityManagement newMaintainer) public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies initializeStatus 
	/// @notice modifies softwareContract 
	function setSoftwareContract() public returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies platformId 
	/// @notice modifies initializeStatus 
	function setSDPId(string memory newSDPId) public onlyMaintainer returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies hashStore 
	/// @notice modifies publishCounter 
	function publishHash(string memory hashId, uint256 hash) public onlyMaintainer returns (bool success) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies hashStore 
	function revokeHash(string memory hashId) public onlyMaintainer returns (bool success) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function getBinaryStatement(string memory hashId) public view returns (uint256 hash, uint256 publishNumber) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function checkHashRevoked(string memory hashId) public view returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyRootOwner {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.ROOT_OWNER), "Access denied due to missing role!");
		_;
	}

	modifier onlyMaintainer {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.MAINTAINER), "Access denied due to missing role!");
		_;
	}

}