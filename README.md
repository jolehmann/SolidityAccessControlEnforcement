# Modeling and Enforcing Access Control Policies for Smart Contracts

Due to the immutable nature of the blockchain platform, data can not be changed after it is initially submitted. 
The same property holds true for smart contracts, which cannot be modified after their deployment. 
This allows for an easier tracing of malicious behaviour but comes with the need for high expenses upfront since the correctness of the smart contract needs to be verified before the initial deploy.
One security aspect that needs to be verified as early as possible is access control. 
Due to the public nature of the blockchain, every address on the chain can access every public function and read all variables. 
However, changes to the state variables of a contract should, in many cases, be restricted to certain addresses instead of every possible blockchain user. 
In a banking application for example, the functions to deposit or withdraw money are publicly available while the access to a certain account should be limited to the registered account holder.

To check this property as soon as possible during the development process, we develop the [AccessControlMetamodel](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/Metamodel) for modelling the role-based access control requirements on an architectural level as well as deriving formal specifications from these requirements with the [AccessControlGenerator](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/AccessControlGenerator). 
For this, we combine model-driven software development (*MDSD*) using the Eclipse Modeling Framework (*EMF*) with formal methods and verification.
To do so, we focus on defining the information needed to model access control policies on an architectural level as well as how the resulting elements can be connected.
Additionally, we define how these policies can be translated into formal specifications that enforce the access control policies using verification tools like [solc-verify](https://github.com/SRI-CSL/solidity) & [Slither](https://github.com/crytic/slither).
This allows the developer to see violations and possible security risks very early in the development process.

## Project Structure

- [AccessControlGenerator](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/AccessControlGenerator): the generator based on the Metamodel
- [Examples](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/Examples): contains the concrete instances of the example use cases and scenarios
- [Metamodel](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/Metamodel): Ecore / EMF Project containing the created metamodel as well as the generated .edit & .editor
- [influence_and_calls_plugin](https://github.com/KASTEL-CSSDA/SolidityAccessControlEnforcement/tree/main/influence_and_calls_plugin): printer extension for the Slither framework to reason about indirect influences

## Installation

### Installing the Metamodel & Generator Project

To employ the metamodel and the generator, you can use the included Eclipse projects. In the following, we will explain how to install and use them:

1. Download [Eclipse IDE 2021-09](https://www.eclipse.org/downloads/) and install the Eclipse Modelling Tools
2. Start Eclipse and create a new workspace (or choose an already existing one)
3. Under "Help" > "Install New Software..." click "Add" and enter add the following to installation sites (each needs to be a single entry and the name can be arbitrary):
	1. https://updatesite.mdsd.tools/metamodel-modeling-foundations/nightly/
	2. http://download.eclipse.org/modeling/mdt/ocl/updates/releases
	3. https://download.eclipse.org/modeling/tmf/xtext/updates/composite/marketplace/
	4. https://kit-sdq.github.io/updatesite/release/commons
4. Afterwards choose "--All Available Sites--" in the drop-down menu next to the "Add..." button and install the following packages:
	1. MDSD.tools Modeling Foundations
	2. OCL All-In-One SDK
	3. Xtend & Xtend IDE
    4. SDQ Commons
	
	If a security warning is shown, just click "Install anyway". For completeness, you can view a list of all installed software packages as well as their version for a running eclipse configuration here ![Needed projects](/NeededInstalls.png).
5. Restart Eclipse (you will be prompted to do so)
6. If you close the welcoming screen, the "Model Explorer" View should be open. If not, you can open it under "Window" > "Show View" > "Model Explorer".
7. Import the Projects from the "AccessControlGenerator" and "Metamodel" folder as follows: 
8. In the "Model Explorer", navigate to "AccessControlMetamodel" > "model" > "AccessControlMetamodel.ecore" > "AccessControlMetamodel" and either "AccessControlSystem or "SmartContractModel".

### Looking at the Examples & Using the Generator

To look at the created examples or create your own examples, as well as run the generator on these examples, the following steps need to be followed:

1. In your set-up Eclipse environment, Right-click on either the "AccessControlGenerator" or the "AccessControlMetamodel.editor" folder and "Run As" > "1 Eclipse application". Now, a new Eclipse window should open.
2. There should be no project open in the ProjectExplorer view, so you can click "Import projects..." and follow the same steps beginning with step 6 from the previous installation. This time, choose the "Examples" folder and select the only available option "Examples".
3. Now you have the different folders for each example and use cases available
4. To create a new metamodel instance, you need to make a right-click on any object in the Project Explorer and choose "New" > "Other...". In the newly opened window, naviagte to "Example EMF Model Creation Wizards", where you can select either the "AccessControlSystem Model" or the "SmartContractModel Model". Press "Next".
5. Now you can choose the filename and its location. Press "Next".
6. Now you can choose the "Model Object" and the "XML Encoding". For the "Model Object" you need to choose either "Access Control System" or "Smart Contract". The Encoding does not need to be changed ("UTF-8"). Finish the creation.
7. Now the newly created file is opened and new elements can be added with a right-click. Their properties can be looked at and changed in the "Properties" view.
8. If you want to generate Solidity code based on the models, you need to select at least one ".smartcontractmodel" and one ".accesscontrolsystem" file and right-click. Now the generator can be started by selecting "Access Control Generator" > "Generate Smart Contract with Access Control". Now a soundness check is started before the generation. If that check finds any problems, it communicates them back to the developer. In any case, a new folder called "gen" is created. The generator puts the created smart contracts there or a .log file if the soundness check fails.

### Installing the Slither printer

To use slither and our implemented printer on a Solidity smart contract, we employ Linux. To setup all necessary tools and packages, you need to follow these steps:
1. Install Python 3.6+ with pip (no further instructions are given since it is often pre-installed or the installation depends on the linux system you are using)
2. Install solc, the Solidity compiler by following [these instructions](https://docs.soliditylang.org/en/latest/installing-solidity.html\#building-from-source)
3. Install Slither using the following command:
    ```Bash
	$ git clone https://github.com/crytic/slither.git
	$ cd slither
	$ python3 setup.py install
    ```
    If for some reason that does not work, you can see some alternatives in [Slithers documentation](https://github.com/crytic/slither\#how-to-install)
4. Copy the "influence_and_calls_plugin" folder to the same folder where slither was installed
5. Navigate inside the "influence_and_calls_plugin" folder and open a new terminal
6. Enter the following command to install the custom printer:
    ```Bash
	$ python3 setup.py develop
    ```
7. If no errors occured during the installation, the printer is now successfully installed. To test it, you can enter the following command in any folder that contains the Solidity file *Filename* that you want to analyze:
    ```Bash
	$ slither <Filename>.sol --print influence-and-calls
    ```

### Troubleshooting

If there are over 200 errors in the edu.kit.kastel.sdq.soliditycodegenerator folder that state that a certain sequence cannot be resolved to a type (e.g. "Â cannot be resolved to a type."), you need to right-click on the folder > "Properties" > "Resource" (should already be selected) and change the "Text file encoding" from "Inherited from container" to "Other:" > "UTF-8". Now apply and close the properties window and after a re-build there should be no errors left.

