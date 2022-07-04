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
		//TODO: Auto-generated Constructor
	}

	/// @notice modifies rootOwnerAddress 
	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function changeRootOwner(address newAddress, string memory newCertificateStorageId) public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies identitiesArray 
	function resetIdentitySet() public onlyRootOwner returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function addIdentity(address newAddress) public onlyRegisteredIdentity returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies identitiesArray 
	/// @notice modifies identitiesMap 
	function removeIdentity(address removedAddress) public onlyRegisteredIdentity returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	/// @notice modifies identitiesMap[msg.sender] 
	function changeCertificateID(string memory newCertificateStorageId) public onlyRegisteredIdentity returns (bool ) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
	}

	function getIdentityCertificateId(address toCheck) public view returns (uint idx, string memory certificateId) {
		// TODO: implement and verify auto-generated method stub
		revert("TODO: auto-generated method stub");
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