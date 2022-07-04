package edu.kit.kastel.sdq.accesscontrolgenerator.validation

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import java.util.Collection

/**
 * Interface describing the abstract Strategy for generating violations
 */
interface ViolationGenerator {
	def Collection<String> generateViolations()
	
	def void changeAccessControlSystem(AccessControlSystem system)
	
	def void addNewSmartContract(AccessControlContract contract)
}