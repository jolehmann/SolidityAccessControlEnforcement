Contract InsuranceManagement
+--------------------+-------------+
|      Variable      | Influencers |
+--------------------+-------------+
|      accCtrl       |      []     |
|  insuranceCounter  |      []     |
|     insurances     |      []     |
| airTrafficDatabase |      []     |
+--------------------+-------------+
+-----------------------------------+----------------------------+
|              Function             | Internal & External Calls  |
+-----------------------------------+----------------------------+
|           constructor()           |             []             |
| changeAirTrafficDatabase(address) | ['onlyInsuranceCompany()'] |
|  takeOutInsurance(string,uint256) |             []             |
|   slitherConstructorVariables()   |             []             |
|       onlyInsuranceCompany()      |             []             |
+-----------------------------------+----------------------------+
Function constructor()
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|      InsuranceManagement.accCtrl       |      []     |
|  InsuranceManagement.insuranceCounter  |      []     |
|     InsuranceManagement.insurances     |      []     |
| InsuranceManagement.airTrafficDatabase |      []     |
+----------------------------------------+-------------+
Function changeAirTrafficDatabase(address)
+----------------------------------------+-----------------+
|                Variable                |   Influencers   |
+----------------------------------------+-----------------+
|      InsuranceManagement.accCtrl       |        []       |
|  InsuranceManagement.insuranceCounter  |        []       |
|     InsuranceManagement.insurances     |        []       |
| InsuranceManagement.airTrafficDatabase | ['newDatabase'] |
+----------------------------------------+-----------------+
Function takeOutInsurance(string,uint256)
+----------------------------------------+------------------------------------+
|                Variable                |            Influencers             |
+----------------------------------------+------------------------------------+
|      InsuranceManagement.accCtrl       |                 []                 |
|  InsuranceManagement.insuranceCounter  |                 []                 |
|     InsuranceManagement.insurances     | ['amount', 'flight', 'msg.sender'] |
| InsuranceManagement.airTrafficDatabase |                 []                 |
+----------------------------------------+------------------------------------+
Function slitherConstructorVariables()
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|      InsuranceManagement.accCtrl       |      []     |
|  InsuranceManagement.insuranceCounter  |      []     |
|     InsuranceManagement.insurances     |      []     |
| InsuranceManagement.airTrafficDatabase |      []     |
+----------------------------------------+-------------+
Function onlyInsuranceCompany()
+----------------------------------------+-------------+
|                Variable                | Influencers |
+----------------------------------------+-------------+
|      InsuranceManagement.accCtrl       |      []     |
|  InsuranceManagement.insuranceCounter  |      []     |
|     InsuranceManagement.insurances     |      []     |
| InsuranceManagement.airTrafficDatabase |      []     |
+----------------------------------------+-------------+
