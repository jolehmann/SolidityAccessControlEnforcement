package edu.kit.kastel.sdq.accesscontrolgenerator.validation

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility
import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician

class OclViolationGenerator implements ViolationGenerator {
	
	AccessControlSystem system
	Collection<AccessControlContract> smartContracts = new ArrayList<AccessControlContract>()
	
	/**
	 * Implementation of the interface describing the concrete Strategy for generating violations.
	 * This contains the control of all OCL constraints in the model
	 */
	override generateViolations() {			
		val violations = new ArrayList<String>()
		violations.addAll(validateElementSpecificOclConstraints(system))
		for(contract : smartContracts) {
			violations.addAll(validateContractSpecificOclConstraints(contract))
			violations.addAll(validateElementSpecificOclConstraints(contract))
		}		
		return violations
	}
	
	/**
	 * Set the system to the given one
	 */
	override changeAccessControlSystem(AccessControlSystem system) {
		this.system = system
	}
	
	/**
	 * Adds the given SmartContract to the contract list
	 */
	override addNewSmartContract(AccessControlContract smaCo) {
		smartContracts.add(smaCo)
	}
	
	/**
	 * Validates the OCL constraints only for the given smart contract system container from the resource files by returning all error messages.
	 * To do so, only the relevant constraints are handled. To get the name of a constraint, they are extracted from the following error message:
	 * "The 'CardinalityIsValid' constraint is violated on 'edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl@53a470b5{platform:/resource/Examples/EdgeCase/EdgeCase.accesscontrolsystem#_KwQ8ISs9EeyOxbte1tTmVQ}'"
	 */
	private def Collection<String> validateContractSpecificOclConstraints(EObject system) {
		val violations = new ArrayList<String>()
		val dia = Diagnostician.INSTANCE.validate(system)
		if(dia.severity == Diagnostic.ERROR) {			
			for(d : dia.children.filter[d | d !== null]) {
				val first = d.message.indexOf("'") + 1
				val constraint = d.message.substring(first, d.message.indexOf("'", first + 1))
				if(isViolatedTopLevelContainerConstraint(constraint)) {
					violations.add('''Violation for OCL constraint '«constraint»':
«getErrorMessageForOclConstraint(constraint)»''')
				}
			}
		}		
		return violations
	}
	
	/**
	 * Validates the OCL constraints for all elements of the given system by returning all error messages.
	 * To do so, the names of the constraints are extracted from the following error message to look for more extensive error messages:
	 * "The 'CardinalityIsValid' constraint is violated on 'edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl@53a470b5{platform:/resource/Examples/EdgeCase/EdgeCase.accesscontrolsystem#_KwQ8ISs9EeyOxbte1tTmVQ}'"
	 */
	private def Collection<String> validateElementSpecificOclConstraints(EObject system) {
		val violations = new ArrayList<String>()
		for(obj : system.eContents) {			
			val dia = Diagnostician.INSTANCE.validate(obj)
			if(dia.getSeverity() == Diagnostic.ERROR) {
				for(d : dia.children.filter[d | d !== null]) {
					val first = d.message.indexOf("'") + 1
					val constraint = d.message.substring(first, d.message.indexOf("'", first + 1))
					violations.add('''«AccessControlUtility.removeImplClassEnding(obj.class)» '«AccessControlUtility.getEntityNameForEObject(obj)»' - Violation for OCL constraint '«constraint»':
«getErrorMessageForOclConstraint(constraint)»''')
				}
			}						
		}
		return violations
	}
	
	/**
	 * Returns a more extensive error message for the given OCL constraint from the AccessControlMetamodel.
	 */
	private def String getErrorMessageForOclConstraint(String constraint) {
		switch(constraint) {
			case "CardinalityIsValid": return "The role cardinality needs to be -1 or bigger than 0"
			case "NoRoleCanBePrerequisiteForItself": return "The prerequisites need to be different from the role itself"
			case "NoRoleCanBeSuperiorToItself": return "The superior roles need to be different from the role itself"
			case "NoRoleInPrerequisiteAndSuperiorSet": return "One role cannot be a prerequisite and a superior role"
			case "ForbidTimeContextConditions": return "FunctionToVariable relations are not allowed to have time-based constraints"
			case "RolesCannotBeInHierarchyOrPrerequisite": return "The two mutually exclusive roles cannot be superiors or prerequisites to each other"
			case "VariableTypeNeedsToBeBoolean": return "The referenced variable needs to be a boolean variable"
			case "VariableTypeNeedsToBeMapping": return "The referenced variable needs to be a mapping"
			case "MappingKeyTypeNeedsToBeAddressOrAddressPayable": return "The referenced mappings key needs to have the data type 'address' or 'address payable'"
			case "VariableTypeIsNoMappingWithAddressAsKeytype": return "The referenced variable is not allowed to be mapping with 'address' as its key data type"
			case "NoMoreBalanceModificationsThanFunctions": return "There are more function balance modifications than functions"
			case "BalanceModificationsReferenceDifferentFunctions": return "All balance modifications need to reference different functions"
			case "BalanceModificationsRegardingThisContractNeedPayableFunction": return "A function that is allowed to increase the balance of this contract needs to be marked as 'payable'"
			case "NoAdditionalLocalFunctions": return "Local functions defined not as 'Function' are not covered by the generator"
			case "NoFunctionOverrides": return "The generator does not support the usage of function overrides"

			default: return "No Message found."
		}
	}
	 
	/**
	 * Checks if a given OCL constraint from the AccessControlMetamodel is linked to a top-level container (f.e. a SmartContract element).
	 * If that is the case, true is returned. Currently, there are three constraints defined for the SmartContract element:
	 * NotMoreBalanceModificationsThenFunctions, BalanceModificationsReferenceDifferentFunctions & BalanceModificationsRegardingThisContractNeedPayableFunction
	 */
	private def boolean isViolatedTopLevelContainerConstraint(String constraint) {
		if (constraint.equals("NoMoreBalanceModificationsThanFunctions") ||
			constraint.equals("BalanceModificationsReferenceDifferentFunctions") ||
			constraint.equals("BalanceModificationsRegardingThisContractNeedPayableFunction") ||
			constraint.equals("NoAdditionalLocalFunctions") ||
			constraint.equals("NoFunctionOverrides")) {
			return true
		} else {
			return false
		}
	}
}