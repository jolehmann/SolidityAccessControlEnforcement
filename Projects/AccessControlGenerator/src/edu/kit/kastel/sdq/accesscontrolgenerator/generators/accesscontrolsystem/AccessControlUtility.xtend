package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import org.eclipse.emf.ecore.EObject
import tools.mdsd.modelingfoundations.identifier.NamedElement

/**
 * Utility class to provide additional functionality regarding access control
 */
class AccessControlUtility {
	
	private new() {}
	
	/**
	 * Checks for the given smart contract and given access control system if the contract needs to import and
	 * use the resulting access control contract. This is the case when any role can access a function from the contract.
	 * @param system - AccessControlSystem to check for connections
	 * @param toCheck - AccessControlContract to check for access control need
	 * @returns true when reference to access control contract is needed
	 */
	def static boolean checkIfAccessControlContractNeeded(AccessControlSystem system, AccessControlContract toCheck) {
		if(system === null || toCheck === null) {
			return false
		}
		
		if(system.roleToFunctionTuples.isEmpty || 
			system.roleToFunctionTuples.filter[rf | toCheck.functions.contains(rf.function)].isEmpty) {
			return false
		}
		
		return true
	}
	
		/**
	 * Takes the given class, which is a generated implementation class from the EMF and
	 * removes the 'Impl' ending, resulting in the element name from the AccessControlMetamodel
	 */
	def static String removeImplClassEnding(Class<?> cls) {
		return cls.simpleName.replace("Impl", "")
	}

	/**
	 * Tries to cast the given EObject to a NamedElement from the Metamodel-Modeling-Foundation:
	 * https://github.com/MDSD-Tools/Metamodel-Modeling-Foundations
	 * If the cast is possible, its entityName is returned. Otherwise, the object is cast to a string directly.
	 * If the given object is null, an empty string is returned
	 */
	def static String getEntityNameForEObject(EObject obj) {
		if(obj === null) {
			return ""
		}
		
		try {
			val casted = NamedElement.cast(obj)
			return casted.entityName
		} catch(Exception ex) {
			ex.printStackTrace
			return obj.toString
		}
	}
}