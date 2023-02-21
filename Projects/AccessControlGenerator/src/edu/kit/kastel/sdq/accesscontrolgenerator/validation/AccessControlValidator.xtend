package edu.kit.kastel.sdq.accesscontrolgenerator.validation

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility
import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.ecore.resource.Resource

/**
 * Class to start the validation process by using all available violation generators.
 */
class AccessControlValidator {
		
	int errorCounter
	AccessControlSystem system
	TransitiveClosureCalculator closureCalc = new TransitiveClosureCalculator()
	Collection<ViolationGenerator> violationGens = new ArrayList<ViolationGenerator>()
	Collection<AccessControlContract> smartContracts = new ArrayList<AccessControlContract>()
	
	new() {
		violationGens.add(new RbacViolationGenerator())
		violationGens.add(new OclViolationGenerator())
	}
	
	/**
	 * Registers the given resource at the validator either as the current AccessControlSystem or by 
	 * adding it to the list of SmartContracts
	 */
	def void registerResource(Resource inputResource) {
		for(system : inputResource.contents) {
			if(system instanceof AccessControlSystem) {
				this.system = system
				closureCalc.calculateTransitiveClosures(system)
				for(generator : violationGens) {
					generator.changeAccessControlSystem(system)
				}
			}
			if(system instanceof AccessControlContract) {
				smartContracts.add(system)
				for(generator : violationGens) {
					generator.addNewSmartContract(system)
				}				
			}			
		}
	}
	 
	 /**
	  * Checks the soundness of the system by validating the OCL constraints as well as the systemwide RBAC
	  * equations using the available violation generator. Throughout all of it, the violation messages are collected 
	  * and combined at the end.
	  */
	def String checkSoundnessOfSystem() {		
		errorCounter = 1				
		val violations = new ArrayList<String>()
		
		for(generator : violationGens) {
			violations.addAll(generator.generateViolations())
		}
		
		if(violations.isEmpty) {
			return ""	
		}		
		
		return '''There are violations in the selected AccessControlSystem '«AccessControlUtility.getEntityNameForEObject(this.system)»' and SmartContracts «FOR smaCo : smartContracts SEPARATOR " "»'«AccessControlUtility.getEntityNameForEObject(smaCo)»'«ENDFOR»:
«FOR violation : violations SEPARATOR System.lineSeparator»«errorCounter++») «violation»«ENDFOR»'''
	}
}