Contract AccessControlContract
+-------------------------+-------------+
|         Variable        | Influencers |
+-------------------------+-------------+
|      roleAssignment     |      []     |
| insuranceCompanyCounter |      []     |
|     insurantCounter     |      []     |
+-------------------------+-------------+
+---------------------------------------------------+---------------------------------------------------------------------+
|                      Function                     |                      Internal & External Calls                      |
+---------------------------------------------------+---------------------------------------------------------------------+
|                constructor(address)               |                                  []                                 |
|  checkAccess(address,AccessControlContract.Roles) |                                  []                                 |
| changeInsuranceCompanyRoleForEntity(address,bool) | ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()'] |
|     changeInsurantRoleForEntity(address,bool)     | ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()'] |
|       changeAdminRoleForEntity(address,bool)      | ['checkAccess(address,AccessControlContract.Roles)', 'onlyAdmin()'] |
|           slitherConstructorVariables()           |                                  []                                 |
|                    onlyAdmin()                    |         ['checkAccess(address,AccessControlContract.Roles)']        |
+---------------------------------------------------+---------------------------------------------------------------------+
Function constructor(address)
+-----------------------------------------------+-------------+
|                    Variable                   | Influencers |
+-----------------------------------------------+-------------+
|      AccessControlContract.roleAssignment     |      []     |
| AccessControlContract.insuranceCompanyCounter |      []     |
|     AccessControlContract.insurantCounter     |      []     |
+-----------------------------------------------+-------------+
Function checkAccess(address,AccessControlContract.Roles)
+-----------------------------------------------+-------------+
|                    Variable                   | Influencers |
+-----------------------------------------------+-------------+
|      AccessControlContract.roleAssignment     |      []     |
| AccessControlContract.insuranceCompanyCounter |      []     |
|     AccessControlContract.insurantCounter     |      []     |
+-----------------------------------------------+-------------+
Function changeInsuranceCompanyRoleForEntity(address,bool)
+-----------------------------------------------+--------------+
|                    Variable                   | Influencers  |
+-----------------------------------------------+--------------+
|      AccessControlContract.roleAssignment     |      []      |
| AccessControlContract.insuranceCompanyCounter | ['giveRole'] |
|     AccessControlContract.insurantCounter     |      []      |
+-----------------------------------------------+--------------+
Function changeInsurantRoleForEntity(address,bool)
+-----------------------------------------------+--------------+
|                    Variable                   | Influencers  |
+-----------------------------------------------+--------------+
|      AccessControlContract.roleAssignment     |      []      |
| AccessControlContract.insuranceCompanyCounter |      []      |
|     AccessControlContract.insurantCounter     | ['giveRole'] |
+-----------------------------------------------+--------------+
Function changeAdminRoleForEntity(address,bool)
+-----------------------------------------------+-------------+
|                    Variable                   | Influencers |
+-----------------------------------------------+-------------+
|      AccessControlContract.roleAssignment     |      []     |
| AccessControlContract.insuranceCompanyCounter |      []     |
|     AccessControlContract.insurantCounter     |      []     |
+-----------------------------------------------+-------------+
Function slitherConstructorVariables()
+-----------------------------------------------+-------------+
|                    Variable                   | Influencers |
+-----------------------------------------------+-------------+
|      AccessControlContract.roleAssignment     |      []     |
| AccessControlContract.insuranceCompanyCounter |      []     |
|     AccessControlContract.insurantCounter     |      []     |
+-----------------------------------------------+-------------+
Function onlyAdmin()
+-----------------------------------------------+-------------+
|                    Variable                   | Influencers |
+-----------------------------------------------+-------------+
|      AccessControlContract.roleAssignment     |      []     |
| AccessControlContract.insuranceCompanyCounter |      []     |
|     AccessControlContract.insurantCounter     |      []     |
+-----------------------------------------------+-------------+
