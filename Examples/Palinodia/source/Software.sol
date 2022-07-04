pragma solidity >=0.5.0 <0.6.0;

import "./BinaryHashStorage.sol";
import "./IdentityManagement.sol";
/*--80 char margin------------------------------------------------------------*/
/* Some additional comments are at the end of the file. */


/* This contract stores different instances of the BHS Contract  */
contract Software{

  /* Root owner address of the contract. Used for contract recovery */
  address public root_owner;

  /* Name of the Software represetend by this smart contract. */
  string public sw_name;

  /* Reference to the Identity Management contract*/
  IdentityManagement public developer_control;

  /* Mapping uses the SDP ID to point to the relevant index in the array.
  The array stores the BHS contract address for the SDP */
  mapping (string => uint) platforms_store;

  /* List of the SDPs used to distribute the software's binaries.
  Array holds the references to the stored BHS Contracts.
  The element at position 0 is a dummy element (added in constructor).
  ATTENTION: Therefore the array length is always + 1 (bigger)
  */
  BinaryHashStorage[] public storage_contracts;

/* ------Events---------------------------------------------------------------*/

  /* Event is raised if the root owner changes the IDM contract (Security) */
  event DeveloperChangeEvent(IdentityManagement _oldAddress, IdentityManagement _newAddress);

  /* Event indicates the change of the root owner address (Security) */
  event OwnerAddressChange(address _oldOwnerAddress, address _newOwnerAddress);

/* ------Constructor----------------------------------------------------------*/

  /* Creator of this contract is root owner and parameter IDM for maintainers */
  constructor(address _devControl) public
  {
    root_owner = msg.sender;
    developer_control = IdentityManagement(_devControl);

    /* Adding dummy element to storage array */
    storage_contracts.push(BinaryHashStorage(address(0)));
  }

/* ------Transactions---------------------------------------------------------*/

  /* Modifies the root_owner. Only allowed for the current root owner address */
  function changeRootOwner(address _newAddress) public returns(bool)
  {
    require(msg.sender == root_owner,
      "Operation only allowed for the current root owner address");

    /* Security: A current authorised address should not be the new root owner*/
    require(developer_control.checkIdentity(msg.sender) == false,
      "Contained identity cannot be used as root owner address");

    emit OwnerAddressChange(root_owner, _newAddress);
    root_owner = _newAddress;
    return true;
  }

  /* Control of EOA addresses permitted to act as software developer is
  provided by an IDM Contract, which is referenced by using its address.
  Transaction changes this address. */
  function setDeveloper(IdentityManagement _newDev) public returns(bool)
  {
    require(msg.sender == root_owner,
      "Only the root owner address can change the developer IDM contract");

    emit DeveloperChangeEvent(developer_control, _newDev);
    developer_control = _newDev;
    return true;
  }

  /* Function stores a human-readable name of the software */
  function setSoftwareName(string memory newName) public returns(bool)
  {
    /* Check address authorisation */
    require(developer_control.checkIdentity(msg.sender) == true,
      "Only a developer can change the name of the software.");

    sw_name = newName;
    return true;
  }

  /* Transaction is called by a software developer and registers a
  Binary Hash Storage contract as permitted to provide binary hashes for this
  software. The function has to be called through a permitted developer address.
  */
  function registerBinaryHashStorageContract(address _binaryHashStore)
    public returns (bool)
  {
    /* Check address authorisation */
    require(developer_control.checkIdentity(msg.sender) == true,
      "Only developers can register Binary Hash Storage Contracts.");

    BinaryHashStorage storeContract = BinaryHashStorage(_binaryHashStore);

    /* Local storage because it is needed two times */
    string memory newPlatID = storeContract.platformID();

    /* Checking if a contract has already been registered for the platformID */
    require(platforms_store[newPlatID] == 0,
      "Only one BHS contract per platformID can be registered.");

    storeContract.setSoftwareContract();

    /* Execute this call before the array push because the length of the array
    is equal to the index of the last array element after the push. */
    platforms_store[newPlatID] = storage_contracts.length;
    storage_contracts.push(storeContract);
    return true;
  }

  /* Transaction doesn't need a length check because irregular platformIDs
  aren't contained in the array. Leading to the fact that an empty string
  isn't accepted (cannot be found)
  */
  function deregisterBinaryHashStorageContract(string memory _platformID)
    public returns (bool)
  {
    /* Check address authorisation */
    require(developer_control.checkIdentity(msg.sender) == true,
      "Only developers can delete Binary Hash Storage Contracts.");

    /* Local storage of variable reduces gas cost -> following 2x required */
    uint indexOldElement = platforms_store[_platformID];

    /* This check is relevant, otherwise the dummy element at the first position
    would be removed which would lead to failures */
    require(indexOldElement != 0,
      "PlatformID is unknown. Deregistration not possible");

    /* Replacing the removed element by the last element of the array */
    storage_contracts[indexOldElement] =
      storage_contracts[storage_contracts.length - 1];

    /* Call has to be placed at this position because, in the next step, the
    last element will be deleted from the array.
    Corrects the index position of the moved element.*/
    platforms_store[storage_contracts[storage_contracts.length - 1].platformID()]
      = indexOldElement;

    /* "Deletes" the last element by a reduction of the array length.
    The next platform is added at this position (Lazy Deletion) */
    storage_contracts.length--;

    /* Delete map entry */
    delete platforms_store[_platformID];
    return true;
  }

  /* Transaction changes the platformID used to reference the array position.
  A length check isn't required because this function is called by the
  BHS contract which checks the name length.
  */
  function updateIDofSDP(string memory _currentPlatformID, string memory _newPlatformID)
    public returns(bool)
  {
    /* Map Entry unequal 0 means that the platform is registered */
    require(platforms_store[_currentPlatformID] != 0,
      "Only already registered SDPs can be renamed");

    /* Only the registered BHS contract is permitted to call this transaction.*/
    require(address(storage_contracts[platforms_store[_currentPlatformID]]) == msg.sender,
            "Only the plaform can change the name.");

    /* Place old index at new map entry and delete the old */
    platforms_store[_newPlatformID] = platforms_store[_currentPlatformID];
    delete platforms_store[_currentPlatformID];
    return true;
  }

/* ------Calls----------------------------------------------------------------*/

  /* Delivers information whether the publishing of software on a certain SDP
  is accepted by the software developer.
  */
  function isVerifiedSDP(string memory _platformID) public view returns(bool)
  {
    return platforms_store[_platformID] != 0;
  }

  /* Delivers the address of the Binary Hash Storage Contract for the provided
  platformID */
  function getBHSContract(string memory _platformID) public view returns(address)
  {
    return address(storage_contracts[platforms_store[_platformID]]);
  }

  /* Delivers a list of addresses of all stored platforms */
  function getPlatforms() public view returns(BinaryHashStorage[] memory)
  {
    return storage_contracts;
  }
}

/*
storage_contracts:
Due to the adding of the Dummy element the array size is always +1
*/

/*
isVerifiedSDP():
If map entry is unequal 0 the platformID is registered.
Asserts that no registerd Platform has the array index 0.
Solution: Usage of a dummy element which is entered at the first array
position in the constructor.
-> storage_contracts */
