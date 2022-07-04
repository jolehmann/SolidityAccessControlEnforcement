pragma solidity >=0.5.0 <0.6.0;

/*--80 char margin------------------------------------------------------------*/
/* Some additional comments are at the end of the file. */

/* This contract represents a access control for different contracts */
contract IdentityManagement {

  /* Struct is used to combine information about a developer or maintainer identity */
  struct DevMainIdentity {
    uint array_index;
    string certificate_storage_id;
  }

  /* Owner address of the contract. Used for contract recovery */
  address public root_owner;

  /* Usage of a combination of an array and a map to store the identities.
  The array stores the addresses while the map stores the struct element.
  Array is managed separately to have an overview of managed addresses.
  IMPORTANT: The first address (ARRAY_INDEX 0) added to the array is the
  root owner address. Used as recovery address to invalidate the array.
  (not stored separately)
  */
  address[] public arr_idents; /*array identites*/
  mapping (address => DevMainIdentity) private map_idents; /*map identites*/

/* ------Events---------------------------------------------------------------*/

  /* Event indicates the change of the root owner address (Security) */
  event OwnerAddressChange(address _oldOwnerAddress, address _newOwnerAddress);

  /* Event indicates that the contract has been reset (Security) */
  event ContractRecoveryEvent(address _rootOwnerAddress);

/* ------Constructor----------------------------------------------------------*/

  /* Consturctor stores the contract creator as root owner */
  constructor() public
  {
    arr_idents.push(msg.sender);
    map_idents[msg.sender] = DevMainIdentity(0, "NotSet");
  }

/* ------Transactions--------------------------------------------------------*/

  /* Modifies the root owner (which is the first entry within the array)
    Of course this operation is only allowed for the root_owner address
  */
  function changeRootOwner(address _newAddress, string memory _new_cert_storage_id)
    public returns(bool)
  {
    require(msg.sender == arr_idents[0],
      "Operation only allowed for the current owner root address");

    /* The prohibition of already registered address as root_owner prevents The
    implementation of more gas intensiv array movement operations */
    require(checkIdentity(_newAddress) == false,
      "Contained identity cannot be used as root_owner address");

    emit OwnerAddressChange(arr_idents[0], _newAddress);
    arr_idents[0] = _newAddress;
    map_idents[_newAddress] = DevMainIdentity(0, _new_cert_storage_id);
    return true;
  }

  /* This transaction is the last instance to get rid of invalid identities. */
  function resetIdentitySet() public returns(bool){

    require(msg.sender == arr_idents[0],
      "Only the root owner is allowed to execute this operation");

    /* Resets the pointer to the array to the first position.
    Invalidates all array_indexes stored in the map. */
    arr_idents.length = 1;
    emit ContractRecoveryEvent(arr_idents[0]);
    return true;
  }

  /* Transaction adds the submitted address to the identity set */
  function addIdentity(address _newAddress) public returns(bool)
  {
    require(checkIdentity(msg.sender) == true,
      "New identities can only be added by already contained identities");

    require(checkIdentity(_newAddress) == false,
      "Identities aren't allowed to be added two times");

    /* Adding address to the structure.
    The used order of calls is better because it requires less EVM operations*/
    map_idents[_newAddress] = DevMainIdentity(arr_idents.length, "NotSet");
    arr_idents.push(_newAddress);
    return true;
  }

  /* The remove transaction doesn't preserve the order of the entered identities
  in the array. -> reduces required operations
  */
  function removeIdentity(address _removedAddress) public returns(bool)
  {
    require(arr_idents[0] != _removedAddress,
      "The owner root address cannot be removed (use other transaction)");

    require(checkIdentity(msg.sender) == true,
      "Only registered identites are allowed to remove other identities");

    /* Local storage of variable reduces gas costs -> following 2x required */
    uint indexOldElement = map_idents[_removedAddress].array_index;

    /* Replacing the removed element with the last element of the array */
    arr_idents[indexOldElement] = arr_idents[arr_idents.length - 1];

    /* Call has to be placed at this position because, in the next step, the
    last element will be deleted from the array.
    Corrects the index position of the moved element.*/
    map_idents[arr_idents[arr_idents.length - 1]].array_index = indexOldElement;

    /* A separate deletion of the last element of the array isn't executed at
    this position because this would result in higher gas costs.
    "Deleteing" the last element by a reduction of the array length.
    The next identity is added at this position (Lazy Deletion) */
    arr_idents.length--;

    /* Map entry deletion is only required if the checkIdentity function
    evaluates just because of the mapping (not in combination with the array) */
    // map_idents[_removedAddress].array_index = 0;
    return true;
  }

  /* Function replaces the certificate id of the sender address in the
  DevMainIdentity element stored for the sender address.
  */
  function changeCertificateID(string memory _new_cert_storage_id) public returns(bool)
  {
    require(checkIdentity(msg.sender) == true,
      "Only registered identites can store a certificate reference");

    map_idents[msg.sender].certificate_storage_id = _new_cert_storage_id;
    return true;
  }

/* ------Calls----------------------------------------------------------------*/

  /* Function can be used to check if an address is managed in this contract.
  Usage of the identity array to examine whether or not a map entry exists.
  If index stored in the map is out of bounds of the array, the call reverts.
  This return statement uses two data acceses (one for the map entry and one
  for the array entry)
  -> Method is used within transaction methods (Gas costs are relevant)
  */
  function checkIdentity(address _addr) public view returns(bool)
  {
    return (arr_idents[map_idents[_addr].array_index] == _addr);
  }

  /* Deliver the stored certificate id to verify an identity */
  function getIdentityCertID(address _addr)
    public view returns(uint, string memory)
  {
    DevMainIdentity memory mapEntry = map_idents[_addr];
    return (mapEntry.array_index,
            mapEntry.certificate_storage_id);
  }

  /* Additional calls (Debugging) */
  function getOwnerAddress() public view returns(address) {
    return arr_idents[0];
  }

  function getIdentities() public view returns(address[] memory) {
    return arr_idents;
  }

  function getIdentitiesLength() public view returns(uint) {
    return arr_idents.length;
  }
}

/* TODOs
- Problem, wenn der remove nur durch eine Adresse ausgelöst wird:
  Eine "übernommene" Adresse könnte andere Andressen sofort entfernen und dadurch nicht mehr rausgekickt werden.
  -> Aktuelle Lösung: Root owner
- Possibly kind of "voting" system which is used to invalidate a key (Key-Change-Mechanism)
    - Basic system: Every other key is allowed to delete an existing key. Attention to the case where just one key exists. In this case a recovery adress should be used.
      How can the recovery adresse be changed
    - Advanced system: The vote of a couple of keys is needed to delete a key
*/

/*
Map and Array structure
  This address isn't stored in a separate variable to safe storage.
  Additional this way allows for a simple check within the checkIdentity function
  if the array_index is unequal zero (the root_owner has to be checked separately)
  Optionally the root_owner could be disallowed to execute some operation (to protect the key)
*/

/*
changeRootOwner:
Consider the case that the _newAdress is already contained.
      To reduce the implementation already contained address cannot be used as
      new root owner (would require array movements like the remove)
      Of course the sequnece of remove the address followed by call of this
      function is possible. Nonetheless, this possibly isn't a goot idea because
      of securtiy reasons (Reason: The adress was possibly already used and
      could be compromised. If the case should be allowed, the adress has to be
      moved within the array.
*/

/*
resetIdentitySet:
  Leading to the fact, that all array_indexes stored in the map are invalidated,
  because the checkIdentity function will return false for all indexes than
  0 (because they are out of bounds of the array)
*/

/*
addIdentity:
The used order of calls is better because it requires less command.
Following order would have the same effect.

  arr_identsities.push(_newAddress);
  map_idents[_newAddress] = DevMainIdentity(arr_identsities.length - 1, _newAddress, "NotSet");

The difference is that in this case additional calculations have to be made to reduce the length array by one.
*/

/*
removeIdentity:
To save a delete operation an the last array element is copied
  to the position of the deleted element array_index later on deleted itself
  (from the last array position).

Checking if this would be the last identity which would be removed.
Due to the rooe owner identity this should never happen.
  //require(arr_idents.length > 1, "The last identity cannot be removed of the contract");

A separate delete isn't executed at this position because this would
    result in higher gas costs. With the next adding the old value at this
    place is overwritten, which is cheaper.
  //delete perm_identities[lastArrayElem.array_index]; // Lösche das letzte Element

Check if the following call is needed.
  This call is only required if the checkIdentity function evaluates just
  because of the mapping (not in combination with the array)
  So in the current version this call is commented
  // map_idents[_removedAddress].array_index = 0;

*/

/* Alternative implementation (saving one access)
    Idea: If a address is permitted it has an array_index unequal zero in its
    map_idents entry.
    Problem: This disallwos the root_owner_address to be used in some cases
    (would require separate checks)
    return (map_idents[_addr].array_index != 0);
    */
