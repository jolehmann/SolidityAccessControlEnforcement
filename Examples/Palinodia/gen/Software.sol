// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./BinaryHashStorage.sol";
import "./IdentityManagement.sol";
import "./AccessControlContract.sol";

contract Software {

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: ROOT_OWNER
	// Influence by: None
	address public rootOwnerAddress; // Auto-generated Field

	// Modification by: DEVELOPER
	// Influence by: None
	string public softwareName; // Auto-generated Field

	// Modification by: PLATFORM, MAINTAINER, DEVELOPER
	// Influence by: None
	mapping(string => uint) internal platformsStore; // Auto-generated Field

	// Modification by: ROOT_OWNER
	// Influence by: None
	IdentityManagement public developerControl; // Auto-generated Field

	// Modification by: DEVELOPER
	// Influence by: None
	BinaryHashStorage[] public storageContracts; // Auto-generated Field

	event DeveloperChangeEvent(IdentityManagement oldAddress, IdentityManagement newAddress);
	event OwnerAddressChange(address oldOwnerAddress, address newOwnerAddress);

	constructor(address devControl) {
		//TODO: Auto-generated Constructor
	}

	/// @notice modifies rootOwnerAddress 
	function changeRootOwner(address newAddress) public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies developerControl 
	function setDeveloper(IdentityManagement newDev) public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies softwareName 
	function setSoftwareName(string memory newName) public onlyDeveloper returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies platformsStore 
	/// @notice modifies storageContracts 
	function registerBinaryHashStorageContract(address binaryHashStore) public onlyDeveloper returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies platformsStore 
	/// @notice modifies storageContracts 
	function deregisterBinaryHashStorageContract(string memory platformId) public onlyDeveloper returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies platformsStore 
	function updateIdofSDP(string memory currentPlatformId, string memory newPlatformId) public onlyPlatformMaintainer returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function isVerifiedSDP(string memory platformId) public view returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function getBinaryHashStorageContract(string memory platformId) public view returns (address ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function getPlatforms() public view returns (BinaryHashStorage[] memory ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	modifier onlyRootOwner {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.ROOT_OWNER), "Access denied due to missing role!");
		_;
	}

	modifier onlyDeveloper {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.DEVELOPER), "Access denied due to missing role!");
		_;
	}

	modifier onlyPlatformMaintainer {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.PLATFORM) ||
				accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.MAINTAINER), "Access denied due to missing role!");
		_;
	}

}