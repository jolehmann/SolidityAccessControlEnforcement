# Warnings:
InsuranceManagement.sol:35:3: Warning: Failure condition of 'send' ignored. Consider using 'transfer' instead.
solc-verify warning: Balance modifications due to gas consumption or miner rewards are not modeled

# Checking all functions
AccessControlContract::[constructor]: OK
AccessControlContract::checkAccess: OK
AccessControlContract::changeInsuranceCompanyRoleForEntity: OK
AccessControlContract::changeInsurantRoleForEntity: OK
AccessControlContract::changeAdminRoleForEntity: OK
Insurance::[constructor]: OK
Insurance::cancelInsurance: ERROR
 - Insurance.sol:62:2: Postcondition 'address(this).balance >= __verifier_old_uint(address(this).balance)' might not hold at end of function.
 - Insurance.sol:37:2: Function might modify 'insurant' illegally
Insurance::changeAccount: OK
Insurance::checkForDelay: ERROR
 - Insurance.sol:62:2: Postcondition 'address(this).balance >= __verifier_old_uint(address(this).balance)' might not hold at end of function.
InsuranceManagement::[constructor]: OK
InsuranceManagement::changeAirTrafficDatabase: OK
InsuranceManagement::takeOutInsurance: ERROR
 - InsuranceManagement.sol:33:2: Function might modify balances illegally
Errors were found by the verifier.
