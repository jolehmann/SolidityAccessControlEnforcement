Contract Insurance
+------------------+----------------------------------------+
|     Variable     |              Influencers               |
+------------------+----------------------------------------+
|     accCtrl      |                   []                   |
| databaseLocation |                   []                   |
|     insurant     | ['insuranceClosed', 'insuranceAmount'] |
|  insuredFlight   |                   []                   |
| insuranceAmount  |                   []                   |
| insuranceClosed  |    ['insurant', 'insuranceAmount']     |
+------------------+----------------------------------------+
+-------------------------------------+----------------------------------------------------------+
|               Function              |                Internal & External Calls                 |
+-------------------------------------+----------------------------------------------------------+
| constructor(address,string,uint256) |                            []                            |
|          cancelInsurance()          | ['onlyInsuranceCompany()', 'onlyInsurant()', 'payout()'] |
|        changeAccount(address)       |                    ['onlyInsurant()']                    |
|           checkForDelay()           |          ['onlyInsuranceCompany()', 'payout()']          |
|               payout()              |                ['onlyInsuranceCompany()']                |
|    slitherConstructorVariables()    |                            []                            |
|            onlyInsurant()           |                            []                            |
|        onlyInsuranceCompany()       |                            []                            |
+-------------------------------------+----------------------------------------------------------+
Function constructor(address,string,uint256)
+----------------------------+----------------+
|          Variable          |  Influencers   |
+----------------------------+----------------+
|     Insurance.accCtrl      |       []       |
| Insurance.databaseLocation | ['msg.sender'] |
|     Insurance.insurant     |  ['toInsure']  |
|  Insurance.insuredFlight   |   ['flight']   |
| Insurance.insuranceAmount  |   ['amount']   |
| Insurance.insuranceClosed  |       []       |
+----------------------------+----------------+
Function cancelInsurance()
+----------------------------+---------------------+
|          Variable          |     Influencers     |
+----------------------------+---------------------+
|     Insurance.accCtrl      |          []         |
| Insurance.databaseLocation |          []         |
|     Insurance.insurant     | ['insuranceClosed'] |
|  Insurance.insuredFlight   |          []         |
| Insurance.insuranceAmount  |          []         |
| Insurance.insuranceClosed  |          []         |
+----------------------------+---------------------+
Function changeAccount(address)
+----------------------------+------------------------------------+
|          Variable          |            Influencers             |
+----------------------------+------------------------------------+
|     Insurance.accCtrl      |                 []                 |
| Insurance.databaseLocation |                 []                 |
|     Insurance.insurant     | ['newInsurant', 'insuranceClosed'] |
|  Insurance.insuredFlight   |                 []                 |
| Insurance.insuranceAmount  |                 []                 |
| Insurance.insuranceClosed  |                 []                 |
+----------------------------+------------------------------------+
Function checkForDelay()
+----------------------------+-------------+
|          Variable          | Influencers |
+----------------------------+-------------+
|     Insurance.accCtrl      |      []     |
| Insurance.databaseLocation |      []     |
|     Insurance.insurant     |      []     |
|  Insurance.insuredFlight   |      []     |
| Insurance.insuranceAmount  |      []     |
| Insurance.insuranceClosed  |      []     |
+----------------------------+-------------+
Function payout()
+----------------------------+---------------------------------+
|          Variable          |           Influencers           |
+----------------------------+---------------------------------+
|     Insurance.accCtrl      |                []               |
| Insurance.databaseLocation |                []               |
|     Insurance.insurant     |                []               |
|  Insurance.insuredFlight   |                []               |
| Insurance.insuranceAmount  |                []               |
| Insurance.insuranceClosed  | ['insuranceAmount', 'insurant'] |
+----------------------------+---------------------------------+
Function slitherConstructorVariables()
+----------------------------+-------------+
|          Variable          | Influencers |
+----------------------------+-------------+
|     Insurance.accCtrl      |      []     |
| Insurance.databaseLocation |      []     |
|     Insurance.insurant     |      []     |
|  Insurance.insuredFlight   |      []     |
| Insurance.insuranceAmount  |      []     |
| Insurance.insuranceClosed  |      []     |
+----------------------------+-------------+
Function onlyInsurant()
+----------------------------+-------------+
|          Variable          | Influencers |
+----------------------------+-------------+
|     Insurance.accCtrl      |      []     |
| Insurance.databaseLocation |      []     |
|     Insurance.insurant     |      []     |
|  Insurance.insuredFlight   |      []     |
| Insurance.insuranceAmount  |      []     |
| Insurance.insuranceClosed  |      []     |
+----------------------------+-------------+
Function onlyInsuranceCompany()
+----------------------------+-------------+
|          Variable          | Influencers |
+----------------------------+-------------+
|     Insurance.accCtrl      |      []     |
| Insurance.databaseLocation |      []     |
|     Insurance.insurant     |      []     |
|  Insurance.insuredFlight   |      []     |
| Insurance.insuranceAmount  |      []     |
| Insurance.insuranceClosed  |      []     |
+----------------------------+-------------+
