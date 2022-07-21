# Warnings:
BinaryHashStorage.sol:84:6: solc-verify error: Unsupported binary operator in 'mod' encoding |=
BinaryHashStorage.sol:97:6: solc-verify error: Unsupported binary operator in 'mod' encoding |=
solc-verify warning: Balance modifications due to gas consumption or miner rewards are not modeled
BinaryHashStorage.sol:80:2: solc-verify warning: Errors while translating function body, will be skipped
BinaryHashStorage.sol:90:2: solc-verify warning: Errors while translating function body, will be skipped

# Checking all functions
AccessControlContract::[constructor]: OK
AccessControlContract::checkAccess: OK
AccessControlContract::changeRootOwnerRoleForEntity: OK
AccessControlContract::changeRegisteredIdentityRoleForEntity: OK
AccessControlContract::changeDeveloperRoleForEntity: OK
AccessControlContract::changeMaintainerRoleForEntity: OK
AccessControlContract::changePlatformRoleForEntity: OK
AccessControlContract::changeAdminRoleForEntity: OK
BinaryHashStorage::[constructor]: OK
BinaryHashStorage::changeRootOwner: OK
BinaryHashStorage::setMaintainer: OK
BinaryHashStorage::publishHash: OK
BinaryHashStorage::revokeHash: OK
BinaryHashStorage::getBinaryStatement: OK
BinaryHashStorage::checkHashRevoked: OK
IdentityManagement::[constructor]: OK
IdentityManagement::changeRootOwner: OK
IdentityManagement::resetIdentitySet: OK
IdentityManagement::addIdentity: OK
IdentityManagement::removeIdentity: OK
IdentityManagement::changeCertificateID: OK
IdentityManagement::getIdentityCertificateId: OK
Software::[constructor]: OK
Software::changeRootOwner: OK
Software::setDeveloper: OK
Software::setSoftwareName: OK
Software::registerBinaryHashStorageContract: OK
Software::deregisterBinaryHashStorageContract: OK
Software::updateIdofSDP: OK
Software::isVerifiedSDP: OK
Software::getBinaryHashStorageContract: OK
Software::getPlatforms: OK
BinaryHashStorage::setSoftwareContract: SKIPPED
BinaryHashStorage::setSDPId: SKIPPED
No errors found.
