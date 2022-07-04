pragma solidity >=0.5.0 <0.6.0;

import "./IdentityManagement.sol";
import "./Software.sol";
/*--80 char margin------------------------------------------------------------*/
/* Some additional comments are at the end of the file.
*/

/* This contract binary hashes published for binaries of one software type  */
contract BinaryHashStorage {

  /* Definition of a struct, which combines the hash of a published statement
  together with the used publishingCount. */
  struct BinStatement {
    uint256 publishNumber; /* publishingCounter of the published hash */
    uint256 binHash; /* Storing the binary hash as integer number */
  }

  /* Root owner address of the contract. Used for contract recovery */
  address public root_owner;

  /* Reference to the Identity Management contract*/
  IdentityManagement public maintainer_control;

  /* Adress of Software contract representing the software */
  Software public software_contract;

  /* SDP ID of the distribution platform on which the binaries are published */
  string public platformID;

  /* This variable controls the initialisation status. Each bit represents whether
  a specifc initialisation status has been executed. Allows the development of a
  "staged" initialisation. Contract is fully initialised with the value of 3. */
  uint8 public initialiseStatus = 0x00;

  /* Attribute indicates the total amount of published binary statements.
  It is only increased.
  IMPORTANT: There is no binary hash with count = 0. */
  uint256 public publishCounter = 0;

  /* Map stores the binary statements containing the hashes. */
  mapping (string => BinStatement) hash_store;

/* ------Events---------------------------------------------------------------*/

  /* Event is raised if the root owner changes the IDM contract (Security) */
  event MaintainerChangeEvent(IdentityManagement _oldAddress, IdentityManagement _newAddress);

  /* Event indicates the change of the root owner address (Security) */
  event OwnerAddressChange(address _oldOwnerAddress, address _newOwnerAddress);

  /* Event is used to document the correct publishing in the tx receipt */
  event PublishingEvent(uint256 indexed _pubCounter,
                        string _hashID, uint256 _hash);

  /* Event is used to document revocation of a binary hash */
  event RevocationEvent(uint256 indexed _pubCounter, string _hashID);

/* ------Constructor----------------------------------------------------------*/

  /* Creator of this contract is root owner and parameter IDM for maintainers */
  constructor(address _mainControl) public
  {
    root_owner = msg.sender;
    maintainer_control = IdentityManagement(_mainControl);
    platformID = "InitialURL";
  }

/* ------Transactions---------------------------------------------------------*/

  /* Modifies the root_owner. Only allowed for the current root owner address */
  function changeRootOwner(address _newAddress) public returns(bool)
  {
    require(msg.sender == root_owner,
      "Operation only allowed for the current root owner address");

    /* Security: A current authorised address should not be the new root owner*/
    require(maintainer_control.checkIdentity(msg.sender) == false,
      "Contained identity cannot be used as root_owner address");

    emit OwnerAddressChange(root_owner, _newAddress);
    root_owner = _newAddress;
    return true;
  }

  /* Control of EOA addresses permitted to act as software maintainer is
  provided by an IDM Contract, which is referenced by using its address.
  Transaction changes this address. */
  function setMaintainer(IdentityManagement _newMaintainer) public returns(bool)
  {
    require(msg.sender == root_owner,
      "Only the root owner can change the maintainer IDM contract");

    emit MaintainerChangeEvent(maintainer_control, _newMaintainer);
    maintainer_control = _newMaintainer;
    return true;
  }

  /* Transaction has to be called for initialisation. This "activates" the
  opportunity to publish hashes in this contract. The stored software contract
  indicates for which software binary hashes are published in this contract.
  Transaction is called within the Software Contract.
  */
  function setSoftwareContract() public returns(bool)
  {
    /* Check if software contract is already set. */
    require(software_contract == Software(0),
      "Contract cannot change the provided software");

    /* Storing the software contract */
    software_contract = Software(msg.sender);

    /* 1. Bit indicates the initialisation with a software contract */
    initialiseStatus |= 0x01;
    return true;
  }

  /* Transaction changes the ID of the Software Distribution Platform
  represented.  This is signaled to the registered Software Contract. */
  function setSDP_ID(string memory _newSDPID) public returns(bool)
  {
    /* Checking if the sending account is permitted to change the platform id.
    Only the maintainer is allowed to do that. */
    require(maintainer_control.checkIdentity(msg.sender) == true,
      "Only a maintainer can change the PlatformID");

    require(bytes(_newSDPID).length > 0,
      "SDP ID should have at least one character");

    /* Call to change the registered platformID name in the software contract */
    if (software_contract != Software(0)) {
      software_contract.updateIDofSDP(platformID, _newSDPID);
    }

    /* Storing the SDP ID in the contract' state*/
    platformID = _newSDPID;

    // 2. Bit indicates the initialisation with platformID
    initialiseStatus |= 0x02;
    return true;
  }

  /*  Transaction places a new binary statement for the hash in the hash store.
  The publishingCounter is increased if the publishing process was successful.
  */
  function publishHash(string memory _hashID, uint256 _hash)
    public returns(bool success)
  {
    require(maintainer_control.checkIdentity(msg.sender),
      "Only the maintainer can publish new hashes");

    /* Prevents to use the empty string as identifier */
    require(bytes(_hashID).length > 0,
      "HashID should have at least one character");

    /* Binary Hashes with zero aren't allowed.
    Otherwise revocation check isn't valid */
    require(_hash != 0x0,
      "Published hash should be unequal to zero.");

    /* HashID shouldn't have been used yet. */
    require(hash_store[_hashID].publishNumber == 0x0,
      "HashID has already been used (Hash could possibly be revoked)");

    /* Checking if a software contract was registered and a platform ID
    was set (Bit 1 and 2 should be set -> 0x03) */
    require(initialiseStatus >= 0x03,
      "Contract initialisation is not completed");

    /* Creation of the binary statement stored in the map.
    The publishingCounter is increased before placing in the statement */
    BinStatement memory newStat = BinStatement(++publishCounter, _hash);
    hash_store[_hashID] = newStat;

    /* Indicate the new stored hash */
    emit PublishingEvent(newStat.publishNumber, _hashID, newStat.binHash);
    return true;
  }

  /* Transaction is used to revoke hash published with the provided HashID */
  function revokeHash(string memory _hashID) public returns(bool success)
  {
    require(maintainer_control.checkIdentity(msg.sender),
            "Only the maintainer can revoke hashes");

    /* Local storage of variable reduces gas costs -> following 2x required */
    BinStatement memory binStat = hash_store[_hashID];

    /* Check if the mapping entry is unequal zero */
    require(binStat.publishNumber != 0,
      "HashID currently unused. Revocation not possible");

    /* Reset of the hash be deleting it from the stored binary statement
    Direct deletion saves additional storage costs */
    delete hash_store[_hashID].binHash;

    /* Indicate the revoked hash */
    emit RevocationEvent(binStat.publishNumber, _hashID);
    return true;
  }

/* ------Calls----------------------------------------------------------------*/

  /* The function delivers 0 for the hash if it wasn't published or the hash was
  revoked. */
  function getBinaryStatement(string memory hashID)
    public view returns (uint256, uint256)
  {
    return (hash_store[hashID].binHash, hash_store[hashID].publishNumber);
  }

  /* Checks if the mapping entry for the hashID is in inital state (is 0).
  That indicates, that a Hash for this hashID has never been published.
  Both entries have to be checked because, otherwise, even an unrevoked binary.
  hash would deliver a revocation information.
  ATTENTION: This function is possibly not needed, if the logic was implemented
  within a client software.
  */
  function checkHashRevoked(string memory _hashID) public view returns (bool)
  {
    BinStatement memory binStat = hash_store[_hashID];
    return ((binStat.binHash == 0) &&
            (binStat.publishNumber != 0));
  }
}

/*
binStatement:
This has to be respected in the client implementation (e.g. if client
estimates a number in hex format)
The publishingNumber is used to determine if a HashID was already used.
It can be seen as a kind of flag
*/

/*
Root owner:
This address is the recovery address of the contract. If the contract of
maintainer_control is corrupted, this address is allwoed to set another
SWDeveloperMaintainer
*/

 /*
initialiseStatus:
    This variable controls the initialisation status.
    Each bit represents if a specifc initialisation status was executed.
    This also allows the development of a "staged" initialisation
    (a initialisation step can only be executed if the "lower" initisalisation
    are accomplished, which can be checked with one simple comparison)
    1.Bit (LSB) : If set this indicates that the software_contract was set
    2.Bit : If set this indicates, that the platformID was set.
    3.Bit
    4.Bit
    5.Bit
    6.Bit
    7.Bit (MSB)

    Contract is fully initialised with the value of 3.
  */

/*
Publishing counter
Otherwise the checkRevokedHash Function would possibly deliver a false result.
  This has to be cosidered if the publishing count should be used as potential
  array index
*/

/*
hash_store:
The mapping could possibly optimizd by using a fixed size input.
  In that case also the getter function could be prevented
*/

/*
Constructor:
Problem: If the provided address _mainControl doesn't refer to the correct
  type of contract, this could result in an unuseable contract.
Current Solution: This can be done using the Root Owner Identity. If a Contract
creates this smart contract this contract should solve the problem.
*/

/*
setSoftwareContract:
TODO Check that only the adress of a Software SmartContract can be
    entered here.This can't be done with the following call, because each
    contract could provide a similar named function.
    e.g. require(Software(msg.sender).isSoftwareContract() == true, ...);
*/

/*
publishHash:
  If only the platformID is required a init value of 0x02 can be used.
*/
