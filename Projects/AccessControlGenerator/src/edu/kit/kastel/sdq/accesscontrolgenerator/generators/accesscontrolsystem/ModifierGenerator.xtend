package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function
import java.util.HashSet
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants.*

/**
 * Class to generate the modifiers needed to handle access control in the current contract
 */
class ModifierGenerator {
	
	@Accessors(PRIVATE_SETTER) Set<String> alreadyCoveredModifiers
	@Accessors(PUBLIC_SETTER) AccessControlContract currentTarget
	@Accessors(PRIVATE_SETTER) ModifierRoleAndConditionsHelper conditionsHelper
	
	val ROLE_MOD_SUFFIX = "only"
	val REQUIRE_MSG_ACCESS_DENIED = "Access denied!"
	
	/**
	 * Constructor setting the AccessControlSystem as a basis for the modifiers
	 */
	new(AccessControlSystem acSystem) {
		this.currentTarget = currentTarget
		this.alreadyCoveredModifiers = new HashSet<String>()
		conditionsHelper = new ModifierRoleAndConditionsHelper(acSystem)
	}
	
	/**
	 * Generating and returning the modifier using definition for the given function to add
	 * to the functions header
	 */
	def String generateModifierUsageDefinition(Function func) {
		if(conditionsHelper === null) {
			return ""
		}
		
		conditionsHelper.extractConditionsForFunction(func)
		if(conditionsHelper.roles.isEmpty && !conditionsHelper.hasConditions) {
			return ""
		}
		
		return generateModifierDefinitionUsingConditions()
	}
	
	/**
	 * Generate the modifier using definition by combining the name of all roles that can access
	 * as well as all conditions that restrict the access. For the conditions, not the names but
	 * a more comprehensive name is generated.
	 */
	private def String generateModifierDefinitionUsingConditions() {
		return '''«ROLE_MOD_SUFFIX»«FOR role : conditionsHelper.roles SEPARATOR "" AFTER ""»«role.entityName.replaceAll(" ", "")»«ENDFOR»«IF !conditionsHelper.boolConditions.isEmpty»_Bool«ENDIF»«FOR cond : conditionsHelper.boolConditions SEPARATOR "" AFTER ""»«IF !cond.valueToCheck»Not«ENDIF»«cond.variable.entityName.replaceAll(" ", "")»«ENDFOR»«IF !conditionsHelper.timeConditions.isEmpty»_Time«ENDIF»«FOR cond : conditionsHelper.timeConditions SEPARATOR "" AFTER ""»«IF cond.isIsUpperBound»Less«ELSE»Greater«ENDIF»«cond.timeValue»«convertTimeUnitToString(cond.timeUnit)»«ENDFOR»'''
	}
	
	/**
	 * Generate all modifiers for the currently targeted contract by iterating over all functions
	 */
	def String generateAccessControlModifiers() {
		return '''«FOR func : currentTarget.functions SEPARATOR System.lineSeparator + System.lineSeparator»«generateSingleModifier(func)»«ENDFOR»'''
	}
	
	/**
	 * Generate a single modifier for the given function by first checking if it already exists (through its definition).
	 * Afterwards, the checks for roles and conditions are generated if necessary.
	 */
	private def String generateSingleModifier(Function func) {
		if(conditionsHelper === null) {
			return ""
		}
		
		var msg = '''«REQUIRE_MSG_ACCESS_DENIED»'''
		conditionsHelper.extractConditionsForFunction(func)
		if(!conditionsHelper.hasConditions) {
			msg = '''«getAccessControlRequiresMessage»'''
			if(conditionsHelper.roles.isEmpty) {
				return ""
			}
		}
		
		val modUsage = generateModifierDefinitionUsingConditions()		
		if(checkAlreadyCoveredModifier(modUsage)) {
			return ""
		}
		alreadyCoveredModifiers.add(modUsage)
		
		return '''modifier «modUsage» {
	require(«generateModifierChecks()», "«msg»");
	_;
}'''
	}

	/**
	 * Generates the checks inside the requires statement in the modifier, combining role-specific checks with the
	 * conditions referencing the role as well as the function.
	 */
	private def String generateModifierChecks() {
		var condition = ""
		val checkAccessTemplate = '''«getAccessControlVariableName».«getAccessCheckingFunctionName»(«getMsgSenderKeyword», «getAccessControlContactName».«getRolesEnumName».'''
		
		for(role : conditionsHelper.roles) {
			val hasBoolConds = !conditionsHelper.boolCondsForRole.get(role).isEmpty
			val hasTimeConds = !conditionsHelper.timeCondsForRole.get(role).isEmpty
			val roleCheck = checkAccessTemplate + '''«getRoleEnumValueForRole(role)»)'''
			
			if(!hasBoolConds && !hasTimeConds) {
				condition = '''«IF !condition.isBlank»«condition» ||
		«ENDIF»«roleCheck»'''
			} else {
				condition = '''«IF !condition.isBlank»(«condition» &&«ENDIF»
(«roleCheck»«IF hasBoolConds» && «createBooleanCheckFromConditions(conditionsHelper.boolCondsForRole.get(role))»«ENDIF»
«IF hasTimeConds» && «createTimeCheckFromConditions(conditionsHelper.timeCondsForRole.get(role))»«ENDIF»)'''
			}
		}
		
		return condition
	}
	
	/**
	 * Creates the in-line boolean variable checks from the given list of conditions
	 */
	private def String createBooleanCheckFromConditions(Iterable<BooleanVariableContext> boolConds) {
		return '''«FOR cond : boolConds SEPARATOR "&&" + System.lineSeparator»
«IF !cond.valueToCheck»!«ENDIF»«cond.variable.entityName.replaceAll(" ", "").toFirstLower»
«ENDFOR»'''
	}
	
	/**
	 * Creates the in-line time-based checks from the given list of time conditions
	 */
	private def String createTimeCheckFromConditions(Iterable<TimeContext> timeConds) {
		return '''«FOR cond : timeConds SEPARATOR "&&" + System.lineSeparator»«getAccessControlVariableName».«getTimingCheckFunctionName»( «IF cond.isIsUpperBound»true«ELSE»false«ENDIF», «cond.timeValue» «convertTimeUnitToString(cond.timeUnit)»)«ENDFOR»'''
	}
	
	/**
	 * Converting the TimeUnits enum to its resulting Solidity keyword
	 */
	private def String convertTimeUnitToString(TimeUnits unit) {
		switch(unit) {
			case DAY: {
				return "days"
			}
			case HOUR: {
				return "hours"
			}
			case MINUTE: {
				return "minutes"
			}
			case SECOND: {
				return"seconds"
			}
			case WEEK: {
				return "weeks"
			}
			case YEAR: {
				return "years"
			}
		}
	}
	
	/**
	 * Check if a modifier for the given modifier definition was already created 
	 * to prevent two identical modifiers from being created.
	 */
	private def boolean checkAlreadyCoveredModifier(String toCheck) {
		if(alreadyCoveredModifiers.isEmpty) {
			return false
		}
		
		for(modifier : alreadyCoveredModifiers) {
			if(modifier.equals(toCheck)) {
				return true
			}
		}
		
		return false
	}
}