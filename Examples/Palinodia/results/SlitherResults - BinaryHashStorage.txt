Contract BinaryHashStorage
+-------------------+------------------------------------------------------------+
|      Variable     |                        Influencers                         |
+-------------------+------------------------------------------------------------+
|      accCtrl      |                             []                             |
|  rootOwnerAddress |                        ['accCtrl']                         |
|     platformId    |                             []                             |
|  initializeStatus |                    ['softwareContract']                    |
|   publishCounter  |   ['initializeStatus', 'softwareContract', 'hashStore']    |
|     hashStore     | ['initializeStatus', 'softwareContract', 'publishCounter'] |
| maintainerControl |                             []                             |
|  softwareContract |                             []                             |
+-------------------+------------------------------------------------------------+
+-----------------------------------+---------------------------+
|              Function             | Internal & External Calls |
+-----------------------------------+---------------------------+
|        constructor(address)       |             []            |
|      changeRootOwner(address)     |    ['onlyRootOwner()']    |
| setMaintainer(IdentityManagement) |    ['onlyRootOwner()']    |
|       setSoftwareContract()       |             []            |
|          setSDPId(string)         |    ['onlyMaintainer()']   |
|    publishHash(string,uint256)    |    ['onlyMaintainer()']   |
|         revokeHash(string)        |    ['onlyMaintainer()']   |
|     getBinaryStatement(string)    |             []            |
|      checkHashRevoked(string)     |             []            |
|   slitherConstructorVariables()   |             []            |
|          onlyRootOwner()          |             []            |
|          onlyMaintainer()         |             []            |
+-----------------------------------+---------------------------+
Function constructor(address)
+-------------------------------------+-----------------+
|               Variable              |   Influencers   |
+-------------------------------------+-----------------+
|      BinaryHashStorage.accCtrl      |        []       |
|  BinaryHashStorage.rootOwnerAddress |  ['msg.sender'] |
|     BinaryHashStorage.platformId    |        []       |
|  BinaryHashStorage.initializeStatus |        []       |
|   BinaryHashStorage.publishCounter  |        []       |
|     BinaryHashStorage.hashStore     |        []       |
| BinaryHashStorage.maintainerControl | ['mainControl'] |
|  BinaryHashStorage.softwareContract |        []       |
+-------------------------------------+-----------------+
Function changeRootOwner(address)
+-------------------------------------+------------------------------------------------------------------+
|               Variable              |                           Influencers                            |
+-------------------------------------+------------------------------------------------------------------+
|      BinaryHashStorage.accCtrl      |                                []                                |
|  BinaryHashStorage.rootOwnerAddress | ['accCtrl', 'newAddress', 'msg.sender', 'AccessControlContract'] |
|     BinaryHashStorage.platformId    |                                []                                |
|  BinaryHashStorage.initializeStatus |                                []                                |
|   BinaryHashStorage.publishCounter  |                                []                                |
|     BinaryHashStorage.hashStore     |                                []                                |
| BinaryHashStorage.maintainerControl |                                []                                |
|  BinaryHashStorage.softwareContract |                                []                                |
+-------------------------------------+------------------------------------------------------------------+
Function setMaintainer(IdentityManagement)
+-------------------------------------+-------------------+
|               Variable              |    Influencers    |
+-------------------------------------+-------------------+
|      BinaryHashStorage.accCtrl      |         []        |
|  BinaryHashStorage.rootOwnerAddress |         []        |
|     BinaryHashStorage.platformId    |         []        |
|  BinaryHashStorage.initializeStatus |         []        |
|   BinaryHashStorage.publishCounter  |         []        |
|     BinaryHashStorage.hashStore     |         []        |
| BinaryHashStorage.maintainerControl | ['newMaintainer'] |
|  BinaryHashStorage.softwareContract |         []        |
+-------------------------------------+-------------------+
Function setSoftwareContract()
+-------------------------------------+----------------------+
|               Variable              |     Influencers      |
+-------------------------------------+----------------------+
|      BinaryHashStorage.accCtrl      |          []          |
|  BinaryHashStorage.rootOwnerAddress |          []          |
|     BinaryHashStorage.platformId    |          []          |
|  BinaryHashStorage.initializeStatus | ['softwareContract'] |
|   BinaryHashStorage.publishCounter  |          []          |
|     BinaryHashStorage.hashStore     |          []          |
| BinaryHashStorage.maintainerControl |          []          |
|  BinaryHashStorage.softwareContract |    ['msg.sender']    |
+-------------------------------------+----------------------+
Function setSDPId(string)
+-------------------------------------+--------------+
|               Variable              | Influencers  |
+-------------------------------------+--------------+
|      BinaryHashStorage.accCtrl      |      []      |
|  BinaryHashStorage.rootOwnerAddress |      []      |
|     BinaryHashStorage.platformId    | ['newSDPId'] |
|  BinaryHashStorage.initializeStatus |      []      |
|   BinaryHashStorage.publishCounter  |      []      |
|     BinaryHashStorage.hashStore     |      []      |
| BinaryHashStorage.maintainerControl |      []      |
|  BinaryHashStorage.softwareContract |      []      |
+-------------------------------------+--------------+
Function publishHash(string,uint256)
+-------------------------------------+---------------------------------------------------------------------+
|               Variable              |                             Influencers                             |
+-------------------------------------+---------------------------------------------------------------------+
|      BinaryHashStorage.accCtrl      |                                  []                                 |
|  BinaryHashStorage.rootOwnerAddress |                                  []                                 |
|     BinaryHashStorage.platformId    |                                  []                                 |
|  BinaryHashStorage.initializeStatus |                                  []                                 |
|   BinaryHashStorage.publishCounter  |         ['hashStore', 'hash', 'hashId', 'initializeStatus']         |
|     BinaryHashStorage.hashStore     | ['hashId', 'publishCounter', 'newStat', 'hash', 'initializeStatus'] |
| BinaryHashStorage.maintainerControl |                                  []                                 |
|  BinaryHashStorage.softwareContract |                                  []                                 |
+-------------------------------------+---------------------------------------------------------------------+
Function revokeHash(string)
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     | ['binStat'] |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
Function getBinaryStatement(string)
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     |      []     |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
Function checkHashRevoked(string)
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     |      []     |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
Function slitherConstructorVariables()
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     |      []     |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
Function onlyRootOwner()
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     |      []     |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
Function onlyMaintainer()
+-------------------------------------+-------------+
|               Variable              | Influencers |
+-------------------------------------+-------------+
|      BinaryHashStorage.accCtrl      |      []     |
|  BinaryHashStorage.rootOwnerAddress |      []     |
|     BinaryHashStorage.platformId    |      []     |
|  BinaryHashStorage.initializeStatus |      []     |
|   BinaryHashStorage.publishCounter  |      []     |
|     BinaryHashStorage.hashStore     |      []     |
| BinaryHashStorage.maintainerControl |      []     |
|  BinaryHashStorage.softwareContract |      []     |
+-------------------------------------+-------------+
