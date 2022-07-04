# AccessControlMetamodel

Our created metamodel consists of two different packages that are separated to enhance the separation of concerns. The first package can be seen in ![here](/SmartContractModel.png) and covers all aspects of our model needed to describe a basic Solidity contract. 
This includes the functions, state variables and the needed data types as well as the possible balance modifications. 
This package uses elements from the [SolidityMetaModel](https://github.com/KASTEL-CSSDA/SolidityMetaModel).

The second package covers the remaining aspects of our approach by describing all elements needed to model RBAC policies for the smart contract described with the first package. 
It can be seen in ![here](/AccessControlSystem.png) and covers roles as well as all relation elements that relate functions, state variables and roles with each other. 
Additionally, a context can be provided for certain kinds of relations.