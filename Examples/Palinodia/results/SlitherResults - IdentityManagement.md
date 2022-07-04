Contract IdentityManagement
+-------------------+----------------------------------------------------+
|      Variable     |                    Influencers                     |
+-------------------+----------------------------------------------------+
|      accCtrl      |                         []                         |
|  rootOwnerAddress |                         []                         |
| managesDevelopers |                         []                         |
|  identitiesArray  |          ['rootOwnerAddress', 'accCtrl']           |
|   identitiesMap   | ['rootOwnerAddress', 'accCtrl', 'identitiesArray'] |
+-------------------+----------------------------------------------------+
+-----------------------------------+------------------------------+
|              Function             |  Internal & External Calls   |
+-----------------------------------+------------------------------+
|         constructor(bool)         |              []              |
|  changeRootOwner(address,string)  |     ['onlyRootOwner()']      |
|         resetIdentitySet()        |     ['onlyRootOwner()']      |
|        addIdentity(address)       | ['onlyRegisteredIdentity()'] |
|      removeIdentity(address)      | ['onlyRegisteredIdentity()'] |
|    changeCertificateID(string)    | ['onlyRegisteredIdentity()'] |
| getIdentityCertificateId(address) |              []              |
|   slitherConstructorVariables()   |              []              |
|          onlyRootOwner()          |              []              |
|      onlyRegisteredIdentity()     |              []              |
+-----------------------------------+------------------------------+
Function constructor(bool)
+--------------------------------------+-----------------+
|               Variable               |   Influencers   |
+--------------------------------------+-----------------+
|      IdentityManagement.accCtrl      |        []       |
| IdentityManagement.rootOwnerAddress  |        []       |
| IdentityManagement.managesDevelopers | ['managesDevs'] |
|  IdentityManagement.identitiesArray  |  ['msg.sender'] |
|   IdentityManagement.identitiesMap   |        []       |
+--------------------------------------+-----------------+
Function changeRootOwner(address,string)
+--------------------------------------+-------------------------------------------------------------------------------+
|               Variable               |                                  Influencers                                  |
+--------------------------------------+-------------------------------------------------------------------------------+
|      IdentityManagement.accCtrl      |                                       []                                      |
| IdentityManagement.rootOwnerAddress  |                                       []                                      |
| IdentityManagement.managesDevelopers |                                       []                                      |
|  IdentityManagement.identitiesArray  |        ['accCtrl', 'newAddress', 'msg.sender', 'AccessControlContract']       |
|   IdentityManagement.identitiesMap   | ['newCertificateStorageId', 'accCtrl', 'msg.sender', 'AccessControlContract'] |
+--------------------------------------+-------------------------------------------------------------------------------+
Function resetIdentitySet()
+--------------------------------------+----------------------+
|               Variable               |     Influencers      |
+--------------------------------------+----------------------+
|      IdentityManagement.accCtrl      |          []          |
| IdentityManagement.rootOwnerAddress  |          []          |
| IdentityManagement.managesDevelopers |          []          |
|  IdentityManagement.identitiesArray  | ['rootOwnerAddress'] |
|   IdentityManagement.identitiesMap   |          []          |
+--------------------------------------+----------------------+
Function addIdentity(address)
+--------------------------------------+-----------------------------------+
|               Variable               |            Influencers            |
+--------------------------------------+-----------------------------------+
|      IdentityManagement.accCtrl      |                 []                |
| IdentityManagement.rootOwnerAddress  |                 []                |
| IdentityManagement.managesDevelopers |                 []                |
|  IdentityManagement.identitiesArray  |           ['newAddress']          |
|   IdentityManagement.identitiesMap   | ['identitiesArray', 'newAddress'] |
+--------------------------------------+-----------------------------------+
Function removeIdentity(address)
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
Function changeCertificateID(string)
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
Function getIdentityCertificateId(address)
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
Function slitherConstructorVariables()
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
Function onlyRootOwner()
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
Function onlyRegisteredIdentity()
+--------------------------------------+-------------+
|               Variable               | Influencers |
+--------------------------------------+-------------+
|      IdentityManagement.accCtrl      |      []     |
| IdentityManagement.rootOwnerAddress  |      []     |
| IdentityManagement.managesDevelopers |      []     |
|  IdentityManagement.identitiesArray  |      []     |
|   IdentityManagement.identitiesMap   |      []     |
+--------------------------------------+-------------+
