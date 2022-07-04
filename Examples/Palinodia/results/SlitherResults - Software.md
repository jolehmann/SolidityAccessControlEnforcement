Contract Software
+------------------+----------------------+
|     Variable     |     Influencers      |
+------------------+----------------------+
|     accCtrl      |          []          |
| rootOwnerAddress |     ['accCtrl']      |
|   softwareName   |          []          |
|  platformsStore  | ['storageContracts'] |
| developerControl |          []          |
| storageContracts |  ['platformsStore']  |
+------------------+----------------------+
+---------------------------------------------+-------------------------------------------------------------+
|                   Function                  |                  Internal & External Calls                  |
+---------------------------------------------+-------------------------------------------------------------+
|             constructor(address)            |                              []                             |
|           changeRootOwner(address)          |                     ['onlyRootOwner()']                     |
|       setDeveloper(IdentityManagement)      |                     ['onlyRootOwner()']                     |
|           setSoftwareName(string)           |                     ['onlyDeveloper()']                     |
|  registerBinaryHashStorageContract(address) |                     ['onlyDeveloper()']                     |
| deregisterBinaryHashStorageContract(string) | ['getBinaryHashStorageContract(string)', 'onlyDeveloper()'] |
|         updateIdofSDP(string,string)        |                 ['onlyPlatformMaintainer()']                |
|            isVerifiedSDP(string)            |                              []                             |
|     getBinaryHashStorageContract(string)    |                              []                             |
|                getPlatforms()               |                              []                             |
|        slitherConstructorVariables()        |                              []                             |
|               onlyRootOwner()               |                              []                             |
|               onlyDeveloper()               |                              []                             |
|           onlyPlatformMaintainer()          |                              []                             |
+---------------------------------------------+-------------------------------------------------------------+
Function constructor(address)
+---------------------------+----------------+
|          Variable         |  Influencers   |
+---------------------------+----------------+
|      Software.accCtrl     |       []       |
| Software.rootOwnerAddress | ['msg.sender'] |
|   Software.softwareName   |       []       |
|  Software.platformsStore  |       []       |
| Software.developerControl | ['devControl'] |
| Software.storageContracts |       []       |
+---------------------------+----------------+
Function changeRootOwner(address)
+---------------------------+------------------------------------------------------------------+
|          Variable         |                           Influencers                            |
+---------------------------+------------------------------------------------------------------+
|      Software.accCtrl     |                                []                                |
| Software.rootOwnerAddress | ['accCtrl', 'newAddress', 'msg.sender', 'AccessControlContract'] |
|   Software.softwareName   |                                []                                |
|  Software.platformsStore  |                                []                                |
| Software.developerControl |                                []                                |
| Software.storageContracts |                                []                                |
+---------------------------+------------------------------------------------------------------+
Function setDeveloper(IdentityManagement)
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |  ['newDev'] |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function setSoftwareName(string)
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   | ['newName'] |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function registerBinaryHashStorageContract(address)
+---------------------------+-----------------------------------------------------------------------+
|          Variable         |                              Influencers                              |
+---------------------------+-----------------------------------------------------------------------+
|      Software.accCtrl     |                                   []                                  |
| Software.rootOwnerAddress |                                   []                                  |
|   Software.softwareName   |                                   []                                  |
|  Software.platformsStore  | ['storeContract', 'newPlatID', 'storageContracts', 'binaryHashStore'] |
| Software.developerControl |                                   []                                  |
| Software.storageContracts |  ['storeContract', 'newPlatID', 'platformsStore', 'binaryHashStore']  |
+---------------------------+-----------------------------------------------------------------------+
Function deregisterBinaryHashStorageContract(string)
+---------------------------+---------------------+
|          Variable         |     Influencers     |
+---------------------------+---------------------+
|      Software.accCtrl     |          []         |
| Software.rootOwnerAddress |          []         |
|   Software.softwareName   |          []         |
|  Software.platformsStore  | ['indexOldElement'] |
| Software.developerControl |          []         |
| Software.storageContracts | ['indexOldElement'] |
+---------------------------+---------------------+
Function updateIdofSDP(string,string)
+---------------------------+-------------------+
|          Variable         |    Influencers    |
+---------------------------+-------------------+
|      Software.accCtrl     |         []        |
| Software.rootOwnerAddress |         []        |
|   Software.softwareName   |         []        |
|  Software.platformsStore  | ['newPlatformId'] |
| Software.developerControl |         []        |
| Software.storageContracts |         []        |
+---------------------------+-------------------+
Function isVerifiedSDP(string)
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function getBinaryHashStorageContract(string)
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function getPlatforms()
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function slitherConstructorVariables()
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function onlyRootOwner()
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function onlyDeveloper()
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
Function onlyPlatformMaintainer()
+---------------------------+-------------+
|          Variable         | Influencers |
+---------------------------+-------------+
|      Software.accCtrl     |      []     |
| Software.rootOwnerAddress |      []     |
|   Software.softwareName   |      []     |
|  Software.platformsStore  |      []     |
| Software.developerControl |      []     |
| Software.storageContracts |      []     |
+---------------------------+-------------+
