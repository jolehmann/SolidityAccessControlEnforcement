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
		rootOwnerAddress = msg.sender;
		accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);	
	    developerControl = IdentityManagement(devControl);
	    accCtrl.changeDeveloperRoleForEntity(devControl, true);
	    storageContracts.push(BinaryHashStorage(address(0)));
	}

	/// @notice modifies rootOwnerAddress 
	function changeRootOwner(address newAddress) public onlyRootOwner returns (bool ) {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.REGISTERED_IDENTITY) == false,
	      "Contained identity cannot be used as root owner address");
	
	    emit OwnerAddressChange(rootOwnerAddress, newAddress);
	    accCtrl.changeRootOwnerRoleForEntity(rootOwnerAddress, false);
	    accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);
	    rootOwnerAddress = newAddress;
	    return true;
	}

	/// @notice modifies developerControl 
	function setDeveloper(IdentityManagement newDev) public onlyRootOwner returns (bool ) {
		emit DeveloperChangeEvent(developerControl, newDev);
	    accCtrl.changeDeveloperRoleForEntity(address(developerControl), false);
	    accCtrl.changeDeveloperRoleForEntity(address(newDev), true);
	    developerControl = newDev;
	    return true;
	}

	/// @notice modifies softwareName 
	function setSoftwareName(string memory newName) public onlyDeveloper returns (bool ) {
		softwareName = newName;
	    return true;
	}

	/// @notice modifies platformsStore 
	/// @notice modifies storageContracts 
	function registerBinaryHashStorageContract(address binaryHashStore) public onlyDeveloper returns (bool ) {
		BinaryHashStorage storeContract = BinaryHashStorage(binaryHashStore);
	    string memory newPlatID = storeContract.platformId();
	    require(platformsStore[newPlatID] == 0, "Only one BHS contract per platformID can be registered.");
	    
	    accCtrl.changePlatformRoleForEntity(binaryHashStore, true);
	    storeContract.setSoftwareContract();
	    platformsStore[newPlatID] = storageContracts.length;
	    storageContracts.push(storeContract);
	    return true;
	}

	/// @notice modifies platformsStore 
	/// @notice modifies storageContracts 
	function deregisterBinaryHashStorageContract(string memory platformId) public onlyDeveloper returns (bool ) {
		uint indexOldElement = platformsStore[platformId];
	    require(indexOldElement != 0, "PlatformID is unknown. Deregistration not possible");
	    
	    accCtrl.changePlatformRoleForEntity(getBinaryHashStorageContract(platformId), false);
	    storageContracts[indexOldElement] = storageContracts[storageContracts.length - 1];
	    platformsStore[storageContracts[storageContracts.length - 1].platformId()] = indexOldElement;
	    storageContracts.pop();
	    // storageContracts.length--;
	    delete platformsStore[platformId];
	    return true;
	}

	/// @notice modifies platformsStore 
	function updateIdofSDP(string memory currentPlatformId, string memory newPlatformId) public onlyPlatformMaintainer returns (bool ) {
		require(platformsStore[newPlatformId] != 0, "Only already registered SDPs can be renamed");

	    platformsStore[newPlatformId] = platformsStore[currentPlatformId];
	    delete platformsStore[currentPlatformId];
	    return true;
	}

	function isVerifiedSDP(string memory platformId) public view returns (bool ) {
		return platformsStore[platformId] != 0;
	}

	function getBinaryHashStorageContract(string memory platformId) public view returns (address ) {
		return address(storageContracts[platformsStore[platformId]]);
	}

	function getPlatforms() public view returns (BinaryHashStorage[] memory ) {
		return storageContracts;
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