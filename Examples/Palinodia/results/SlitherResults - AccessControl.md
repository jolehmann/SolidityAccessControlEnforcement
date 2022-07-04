Contract AccessControlContract
+------------------+-------------+
|     Variable     | Influencers |
+------------------+-------------+
|  roleAssignment  |      []     |
| rootOwnerCounter |      []     |
+------------------+-------------+
+-----------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------+
|                       Function                      |                                                 Internal & External Calls                                                  |
+-----------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------+
|                 constructor(address)                |                                                             []                                                             |
|   checkAccess(address,AccessControlContract.Roles)  |                                                             []                                                             |
|      changeRootOwnerRoleForEntity(address,bool)     |                            ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()']                             |
| changeRegisteredIdentityRoleForEntity(address,bool) |                            ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()']                             |
|      changeDeveloperRoleForEntity(address,bool)     | ['checkAccess(address,AccessControlContract.Roles)', 'changeRegisteredIdentityRoleForEntity(address,bool)', 'onlyAdmin()'] |
|     changeMaintainerRoleForEntity(address,bool)     | ['checkAccess(address,AccessControlContract.Roles)', 'changeRegisteredIdentityRoleForEntity(address,bool)', 'onlyAdmin()'] |
|      changePlatformRoleForEntity(address,bool)      |                            ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()']                             |
|        changeAdminRoleForEntity(address,bool)       |                            ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()']                             |
|            slitherConstructorVariables()            |                                                             []                                                             |
|                     onlyAdmin()                     |                                    ['checkAccess(address,AccessControlContract.Roles)']                                    |
+-----------------------------------------------------+----------------------------------------------------------------------------------------------------------------------------+
Function constructor(address)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function checkAccess(address,AccessControlContract.Roles)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function changeRootOwnerRoleForEntity(address,bool)
+----------------------------------------+-------------------------------------+
|                Variable                |             Influencers             |
+----------------------------------------+-------------------------------------+
|  AccessControlContract.roleAssignment  |                  []                 |
| AccessControlContract.rootOwnerCounter | ['giveRole', 'msg.sender', 'Roles'] |
+----------------------------------------+-------------------------------------+
Function changeRegisteredIdentityRoleForEntity(address,bool)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function changeDeveloperRoleForEntity(address,bool)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function changeMaintainerRoleForEntity(address,bool)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function changePlatformRoleForEntity(address,bool)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function changeAdminRoleForEntity(address,bool)
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function slitherConstructorVariables()
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
Function onlyAdmin()
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|  AccessControlContract.roleAssignment  |      []     |
| AccessControlContract.rootOwnerCounter |      []     |
+----------------------------------------+-------------+
