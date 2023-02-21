package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import java.util.Dictionary
import java.util.HashSet
import java.util.Hashtable
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class used to help handling roles and the context conditions defined for a single function
 */
class ModifierRoleAndConditionsHelper {
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) Set<Role> roles
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) Set<BooleanVariableContext> boolConditions
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) Set<TimeContext> timeConditions	
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) Dictionary<Role, Iterable<BooleanVariableContext>> boolCondsForRole
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) Dictionary<Role, Iterable<TimeContext>> timeCondsForRole
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) boolean hasConditions
		
	AccessControlSystem acSystem;
	
	/**
	 * Constructor to create the instance and fill the lists with the fitting elements.
	 */
	new (AccessControlSystem acSystem) {
		if(acSystem === null) {
			return
		}
		
		this.acSystem = acSystem
	}
	
	/**
	 * Fills the different lists containing conditions and roles for the given Function
	 * using the internal AccessControlSystem
	 */
	def extractConditionsForFunction(Function func) {
		if (func === null || acSystem === null) {
			return
		}
		
		roles = new HashSet<Role>()
		boolConditions = new HashSet<BooleanVariableContext>()
		timeConditions = new HashSet<TimeContext>()
		boolCondsForRole = new Hashtable<Role, Iterable<BooleanVariableContext>>()
		timeCondsForRole = new Hashtable<Role, Iterable<TimeContext>>()
		
		roles.addAll(acSystem.roleToFunctionTuples.filter[rf | rf.function.equals(func)].map[rf | rf.role]
			.sortBy[r | r.entityName])
		
		for(rToF : acSystem.roleToFunctionTuples.filter[rf | rf.function.equals(func)]) {
			var bools = rToF.conditions.filter(BooleanVariableContext)
			boolConditions.addAll(bools) 
			boolCondsForRole.put(rToF.role, bools)
			
			var time = rToF.conditions.filter(TimeContext)
			timeConditions.addAll(time)
			timeCondsForRole.put(rToF.role, time)
		}
		
		hasConditions = !boolConditions.isEmpty || !timeConditions.isEmpty		
	}
}