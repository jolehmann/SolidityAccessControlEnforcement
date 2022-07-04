package edu.kit.kastel.sdq.accesscontrolgenerator.validation

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation
import java.util.ArrayList
import java.util.Collection
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role

/**
 * Calculates the transitive closures for the AccessControlSystem to support the later reasoning about
 * possible violations.
 */
class TransitiveClosureCalculator {
	val MIN_AMOUNT_FOR_TRANS_CLOSURE = 2
	val MIN_AMOUNT_FOR_TRANS_ROLE_HIERARCHY = 3
		
	AccessControlSystemFactory factory = AccessControlSystemFactory.eINSTANCE	
	
	/**
	 * Calculates the transitive closures for the influence relation between variables and the call relation between functions.
	 * Both of these are necessary for a complete reasoning about the systems soundness. 
	 * If less then 2 relation tuples exist, nothing is done. Otherwise the transitive tuples are calculated recursively.
	 */
	def void calculateTransitiveClosures(AccessControlSystem system) {
		if(system.variableToVariableTuples.length >= MIN_AMOUNT_FOR_TRANS_CLOSURE) {
			val varClosure = calculateTransitiveClosureForVariableInfluence(system.variableToVariableTuples)
			system.variableToVariableTuples.clear()
			system.variableToVariableTuples.addAll(varClosure)
		}
		
		if(system.functionToFunctionTuples.length >= MIN_AMOUNT_FOR_TRANS_CLOSURE) {
			val funcClosure = calculateTransitiveClosureForFunctionCalls(system.functionToFunctionTuples)
			system.functionToFunctionTuples.clear()
			system.functionToFunctionTuples.addAll(funcClosure)
		}	
		
		if(system.roles.length >= MIN_AMOUNT_FOR_TRANS_ROLE_HIERARCHY) {
			for(role : system.roles) {
				val alreadyConsidered = new ArrayList<Role>()
				alreadyConsidered.add(role)
				val superiors = calculateTransitiveClosureForRoleHierarchy(role, alreadyConsidered)
				role.superior.clear()
				role.superior.addAll(superiors)
			}
		}
	}
	
	/**
	 * Recursively calculates the transitive closure for variable to variable relations.
	 * In each call, all new relations are calculated and the recursion is stopped if no new relations are found.
	 * For each relation, a new relation element is created using the AccessControlSystemFactory.
	 */
	private def Collection<VariableToVariableRelation> calculateTransitiveClosureForVariableInfluence(Collection<VariableToVariableRelation> oldClosure) {
		if(oldClosure.isEmpty) {
			return oldClosure
		}
		
		val newClosure = new ArrayList<VariableToVariableRelation>()
		newClosure.addAll(oldClosure)
		for(varToVar : oldClosure) {
			val transitives = oldClosure.filter[vv | vv.influencer.equals(varToVar.influenced)]
			for(trans : transitives) {
				// Check if no relation already covers this transitive influence
				if(!oldClosure.exists[vv | vv.influencer.equals(varToVar.influencer) && vv.influenced.equals(trans.influenced)]) {
					val newVarToVar = factory.createVariableToVariableRelation()
					newVarToVar.influencer = varToVar.influencer
					newVarToVar.influenced = trans.influenced
					newVarToVar.entityName = '''«newVarToVar.influencer.entityName» to «newVarToVar.influenced.entityName»'''
					newClosure.add(newVarToVar)
				}				
			}
		}
		
		if(newClosure.length == oldClosure.length) {
			return newClosure
		} else {
			return calculateTransitiveClosureForVariableInfluence(newClosure)
		}
	}
	
	/**
	 * Recursively calculates the transitive closure for function to function relations.
	 * In each call, all new relations are calculated and the recursion is stopped if no new relations are found.
	 * For each relation, a new relation element is created using the AccessControlSystemFactory.
	 */
	private def Collection<FunctionToFunctionRelation> calculateTransitiveClosureForFunctionCalls(Collection<FunctionToFunctionRelation> oldClosure) {
		if(oldClosure.isEmpty) {
			return oldClosure
		}
		
		val newClosure = new ArrayList<FunctionToFunctionRelation>()
		newClosure.addAll(oldClosure)
		for(funcToFunc : oldClosure) {
			val transitives = oldClosure.filter[ff | ff.caller.equals(funcToFunc.callee)]
			for(trans : transitives) {
				// Check if no relation already covers this transitive influence
				if(!oldClosure.exists[ff | ff.caller.equals(funcToFunc.caller) && ff.callee.equals(trans.callee)]) {
					val newFuncToFunc = factory.createFunctionToFunctionRelation()
					newFuncToFunc.caller = funcToFunc.caller
					newFuncToFunc.callee = trans.callee
					newFuncToFunc.entityName = '''«newFuncToFunc.caller.entityName» to «newFuncToFunc.callee.entityName»'''
					newClosure.add(newFuncToFunc)
				}				
			}
		}
		
		if(newClosure.length == oldClosure.length) {
			return newClosure
		} else {
			return calculateTransitiveClosureForFunctionCalls(newClosure)
		}
	}
	
	/**
	 * This function calculates the transitive closure for the role hierarchy by recursively
	 * calling itself for all superiors found for the given base role. To keep track of the 
	 * already considered roles, a collection is carried along. If a role is considered, it is
	 * added to that collection.
	 */
	private def Collection<Role> calculateTransitiveClosureForRoleHierarchy(Role base, Collection<Role> alreadyCons) {
		val newClosure = new ArrayList<Role>()
		
		if(base === null ) {
			return newClosure
		}
		
		if(!base.superior.isEmpty) {
			for(superior : base.superior) {
				if(!alreadyCons.contains(superior)) {
					alreadyCons.add(superior)
					newClosure.add(superior)
					newClosure.addAll(calculateTransitiveClosureForRoleHierarchy(superior, alreadyCons))
				}
			}
		}
		
		return newClosure
	}
}