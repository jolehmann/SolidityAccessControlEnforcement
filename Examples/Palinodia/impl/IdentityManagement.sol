// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

import "./AccessControlContract.sol";

contract IdentityManagement {

	struct DeveloperMainIdentity {
		uint arrayIndex;
		string certificateStorageId;
	}

	AccessControlContract private accCtrl = new AccessControlContract(address(this)); // Auto-generated Field
	// Modification by: ROOT_OWNER
	// Influence by: None
	address public rootOwnerAddress; // Auto-generated Field

	// no Role can modify or influence
	bool public managesDevelopers; // Auto-generated Field

	// Modification by: ROOT_OWNER, REGISTERED_IDENTITY
	// Influence by: None
	address[] public identitiesArray; // Auto-generated Field

	// Modification by: ROOT_OWNER, REGISTERED_IDENTITY
	// Influence by: None
	mapping(address => DeveloperMainIdentity) private identitiesMap; // Auto-generated Field

	event OwnerAddressChange(address oldOwnerAddress, address newOwnerAddress);
	event ContractRecoveryEvent(address rootOwnerAddress);

	constructor(bool managesDevs) {
	    managesDevelopers = managesDevs;
		accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);
		identitiesArray.push(msg.sender);
    	identitiesMap[msg.sender] = DeveloperMainIdentity(0, "NotSet");
	}

	/// @notice modifies rootOwnerAddress 
	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function changeRootOwner(address newAddress, string memory newCertificateStorageId) public onlyRootOwner returns (bool ) {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.REGISTERED_IDENTITY) == false,
	      "Contained identity cannot be used as root_owner address");
	
	    emit OwnerAddressChange(rootOwnerAddress, newAddress);
	    accCtrl.changeRootOwnerRoleForEntity(rootOwnerAddress, false);
	    accCtrl.changeRootOwnerRoleForEntity(msg.sender, true);
	    identitiesArray[0] = newAddress;
	    identitiesMap[newAddress] = DeveloperMainIdentity(0, newCertificateStorageId);
	    return true;
	}

	/// @notice modifies identitiesArray 
	function resetIdentitySet() public onlyRootOwner returns (bool ) {
	    // identitiesArray.length = 1;
	    delete identitiesArray;
		identitiesArray.push(rootOwnerAddress);
	    emit ContractRecoveryEvent(rootOwnerAddress);
	    return true;
	}

	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function addIdentity(address newAddress) public onlyRegisteredIdentity returns (bool ) {
		require(accCtrl.checkAccess(newAddress, AccessControlContract.Roles.REGISTERED_IDENTITY) == false,
	      "Identities aren't allowed to be added two times");
		if(managesDevelopers) {
		    accCtrl.changeDeveloperRoleForEntity(newAddress, true);
		} else {
		    accCtrl.changeMaintainerRoleForEntity(newAddress, true);
		}
		
	    identitiesMap[newAddress] = DeveloperMainIdentity(identitiesArray.length, "NotSet");
	    identitiesArray.push(newAddress);
	    return true;
	}

	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function removeIdentity(address removedAddress) public onlyRegisteredIdentity returns (bool ) {
		require(removedAddress != rootOwnerAddress,
	      "The owner root address cannot be removed (use other transaction)");
	    if(managesDevelopers) {
		    accCtrl.changeDeveloperRoleForEntity(removedAddress, false);
		} else {
		    accCtrl.changeMaintainerRoleForEntity(removedAddress, false);
		}	      
	      
	    uint indexOldElement = identitiesMap[removedAddress].arrayIndex;
	    identitiesArray[indexOldElement] = identitiesArray[identitiesArray.length - 1];
	    identitiesMap[identitiesArray[identitiesArray.length - 1]].arrayIndex = indexOldElement;
	    //identitiesArray.length--;
	    identitiesArray.pop();
	    return true;
	}

	/// @notice modifies identitiesMap[msg.sender] 
	function changeCertificateID(string memory newCertificateStorageId) public onlyRegisteredIdentity returns (bool ) {	
	    identitiesMap[msg.sender].certificateStorageId = newCertificateStorageId;
	    return true;
	}

	function getIdentityCertificateId(address toCheck) public view returns (uint idx, string memory certificateId) {
		DeveloperMainIdentity memory mapEntry = identitiesMap[toCheck];
	    return (mapEntry.arrayIndex, mapEntry.certificateStorageId);
	}

	modifier onlyRootOwner {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.ROOT_OWNER), "Access denied due to missing role!");
		_;
	}

	modifier onlyRegisteredIdentity {
		require(accCtrl.checkAccess(msg.sender, AccessControlContract.Roles.REGISTERED_IDENTITY), "Access denied due to missing role!");
		_;
	}

}