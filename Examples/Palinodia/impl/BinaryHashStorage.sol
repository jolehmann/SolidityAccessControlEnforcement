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
	    rootOwnerAddress = msg.sender;
		accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);		
    	maintainerControl = IdentityManagement(mainControl);
    	accCtrl.changeMaintainerRoleForEntity(mainControl, true);
    	platformId = "InitialURL";
	}

	/// @notice modifies rootOwnerAddress 
	function changeRootOwner(address newAddress) public onlyRootOwner returns (bool ) {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.REGISTERED_IDENTITY) == false,
	        "Contained identity cannot be used as root_owner address");
	
	    emit OwnerAddressChange(rootOwnerAddress, newAddress);
	    accCtrl.changeRootOwnerRoleForEntity(rootOwnerAddress, false);
	    accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);
	    rootOwnerAddress = newAddress;
	    return true;
	}

	/// @notice modifies maintainerControl 
	function setMaintainer(IdentityManagement newMaintainer) public onlyRootOwner returns (bool ) {
		emit MaintainerChangeEvent(maintainerControl, newMaintainer);
	    accCtrl.changeMaintainerRoleForEntity(address(maintainerControl), false);
	    accCtrl.changeMaintainerRoleForEntity(address(newMaintainer), true);
	    maintainerControl = newMaintainer;
	    return true;
	}

	/// @notice modifies initializeStatus 
	/// @notice modifies softwareContract 
	function setSoftwareContract() public returns (bool ) {
		require(softwareContract == Software(0), "Contract cannot change the provided software");
	
	    softwareContract = Software(msg.sender);
	    initializeStatus |= 0x01;
	    return true;
	}

	/// @notice modifies platformId 
	/// @notice modifies initializeStatus 
	function setSDPId(string memory newSDPId) public onlyMaintainer returns (bool ) {
		require(bytes(newSDPId).length > 0, "SDP ID should have at least one character");
	    if (softwareContract != Software(0)) {
	        softwareContract.updateIdofSDP(platformId, newSDPId);
	    }
	
	    platformId = newSDPId;	
	    initializeStatus |= 0x02;
	    return true;
	}

	/// @notice modifies hashStore 
	/// @notice modifies publishCounter 
	function publishHash(string memory hashId, uint256 hash) public onlyMaintainer returns (bool success) {
		require(bytes(hashId).length > 0, "HashID should have at least one character");
	    require(hash != 0x0, "Published hash should be unequal to zero.");
	    require(hashStore[hashId].publishNumber == 0x0, "HashID has already been used (Hash could possibly be revoked)");
	    require(initializeStatus >= 0x03, "Contract initialisation is not completed");
	
	    BinaryStatement memory newStat = BinaryStatement(++publishCounter, hash);
	    hashStore[hashId] = newStat;
	    emit PublishingEvent(newStat.publishNumber, hashId, newStat.binaryHash);
	    return true;
	}

	/// @notice modifies hashStore 
	function revokeHash(string memory hashId) public onlyMaintainer returns (bool success) {
		BinaryStatement memory binStat = hashStore[hashId];
	    require(binStat.publishNumber != 0, "HashID currently unused. Revocation not possible");
	    delete hashStore[hashId].binaryHash;
	    emit RevocationEvent(binStat.publishNumber, hashId);
	    return true;
	}

	function getBinaryStatement(string memory hashId) public view returns (uint256 hash, uint256 publishNumber) {
		return (hashStore[hashId].binaryHash, hashStore[hashId].publishNumber);
	}

	function checkHashRevoked(string memory hashId) public view returns (bool ) {
		BinaryStatement memory binStat = hashStore[hashId];
	    return ((binStat.binaryHash == 0) && (binStat.publishNumber != 0));
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