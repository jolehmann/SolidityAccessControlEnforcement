/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.util;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import tools.mdsd.modelingfoundations.identifier.util.IdentifierValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage
 * @generated
 */
public class AccessControlSystemValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AccessControlSystemValidator INSTANCE = new AccessControlSystemValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlSystemValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return AccessControlSystemPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
		case AccessControlSystemPackage.FUNCTION_TO_FUNCTION_RELATION:
			return validateFunctionToFunctionRelation((FunctionToFunctionRelation) value, diagnostics, context);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM:
			return validateAccessControlSystem((AccessControlSystem) value, diagnostics, context);
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION:
			return validateVariableToVariableRelation((VariableToVariableRelation) value, diagnostics, context);
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION:
			return validateFunctionToVariableRelation((FunctionToVariableRelation) value, diagnostics, context);
		case AccessControlSystemPackage.ROLE_TO_FUNCTION_RELATION:
			return validateRoleToFunctionRelation((RoleToFunctionRelation) value, diagnostics, context);
		case AccessControlSystemPackage.ROLE:
			return validateRole((Role) value, diagnostics, context);
		case AccessControlSystemPackage.ROLE_TO_VARIABLE_RELATION:
			return validateRoleToVariableRelation((RoleToVariableRelation) value, diagnostics, context);
		case AccessControlSystemPackage.MUTUAL_ROLE_EXCLUSION:
			return validateMutualRoleExclusion((MutualRoleExclusion) value, diagnostics, context);
		case AccessControlSystemPackage.CONTEXT:
			return validateContext((Context) value, diagnostics, context);
		case AccessControlSystemPackage.TIME_CONTEXT:
			return validateTimeContext((TimeContext) value, diagnostics, context);
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT:
			return validateBooleanVariableContext((BooleanVariableContext) value, diagnostics, context);
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION:
			return validateFunctionToCsmRelation((FunctionToCsmRelation) value, diagnostics, context);
		case AccessControlSystemPackage.FUNCTION_TO_STATE_VARIABLE_RELATION:
			return validateFunctionToStateVariableRelation((FunctionToStateVariableRelation) value, diagnostics,
					context);
		case AccessControlSystemPackage.TIME_UNITS:
			return validateTimeUnits((TimeUnits) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToFunctionRelation(FunctionToFunctionRelation functionToFunctionRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionToFunctionRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(functionToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(functionToFunctionRelation, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlSystem(AccessControlSystem accessControlSystem, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessControlSystem, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(accessControlSystem, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(accessControlSystem, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableToVariableRelation(VariableToVariableRelation variableToVariableRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableToVariableRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(variableToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(variableToVariableRelation, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToVariableRelation(FunctionToVariableRelation functionToVariableRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionToVariableRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(functionToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(functionToVariableRelation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateFunctionToVariableRelation_ForbidTimeContextConditions(functionToVariableRelation,
					diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the ForbidTimeContextConditions constraint of '<em>Function To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION_TO_VARIABLE_RELATION__FORBID_TIME_CONTEXT_CONDITIONS__EEXPRESSION = "conditions -> forAll(c | c.oclIsTypeOf(TimeContext) <> true)";

	/**
	 * Validates the ForbidTimeContextConditions constraint of '<em>Function To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToVariableRelation_ForbidTimeContextConditions(
			FunctionToVariableRelation functionToVariableRelation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.FUNCTION_TO_VARIABLE_RELATION, functionToVariableRelation,
				diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "ForbidTimeContextConditions",
				FUNCTION_TO_VARIABLE_RELATION__FORBID_TIME_CONTEXT_CONDITIONS__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleToFunctionRelation(RoleToFunctionRelation roleToFunctionRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(roleToFunctionRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(roleToFunctionRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(roleToFunctionRelation, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(role, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRole_CardinalityIsValid(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRole_NoRoleCanBePrerequisiteForItself(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRole_NoRoleCanBeSuperiorToItself(role, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRole_NoRoleInPrerequisiteAndSuperiorSet(role, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the CardinalityIsValid constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE__CARDINALITY_IS_VALID__EEXPRESSION = "cardinality = -1 or cardinality > 0";

	/**
	 * Validates the CardinalityIsValid constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole_CardinalityIsValid(Role role, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.ROLE, role, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "CardinalityIsValid",
				ROLE__CARDINALITY_IS_VALID__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoRoleCanBePrerequisiteForItself constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE__NO_ROLE_CAN_BE_PREREQUISITE_FOR_ITSELF__EEXPRESSION = "prerequisite->excludes(self)";

	/**
	 * Validates the NoRoleCanBePrerequisiteForItself constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole_NoRoleCanBePrerequisiteForItself(Role role, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.ROLE, role, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoRoleCanBePrerequisiteForItself",
				ROLE__NO_ROLE_CAN_BE_PREREQUISITE_FOR_ITSELF__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoRoleCanBeSuperiorToItself constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE__NO_ROLE_CAN_BE_SUPERIOR_TO_ITSELF__EEXPRESSION = "superior->excludes(self)";

	/**
	 * Validates the NoRoleCanBeSuperiorToItself constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole_NoRoleCanBeSuperiorToItself(Role role, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.ROLE, role, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoRoleCanBeSuperiorToItself",
				ROLE__NO_ROLE_CAN_BE_SUPERIOR_TO_ITSELF__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoRoleInPrerequisiteAndSuperiorSet constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ROLE__NO_ROLE_IN_PREREQUISITE_AND_SUPERIOR_SET__EEXPRESSION = "prerequisite->excludesAll(superior)";

	/**
	 * Validates the NoRoleInPrerequisiteAndSuperiorSet constraint of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole_NoRoleInPrerequisiteAndSuperiorSet(Role role, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.ROLE, role, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoRoleInPrerequisiteAndSuperiorSet",
				ROLE__NO_ROLE_IN_PREREQUISITE_AND_SUPERIOR_SET__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoleToVariableRelation(RoleToVariableRelation roleToVariableRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(roleToVariableRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(roleToVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(roleToVariableRelation, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMutualRoleExclusion(MutualRoleExclusion mutualRoleExclusion, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mutualRoleExclusion, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(mutualRoleExclusion, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(mutualRoleExclusion, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateMutualRoleExclusion_RolesCannotBeInHierarchyOrPrerequisite(mutualRoleExclusion,
					diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the RolesCannotBeInHierarchyOrPrerequisite constraint of '<em>Mutual Role Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MUTUAL_ROLE_EXCLUSION__ROLES_CANNOT_BE_IN_HIERARCHY_OR_PREREQUISITE__EEXPRESSION = "roles->excludesAll(roles->first().prerequisite->union(roles->last().prerequisite)->union(roles->first().superior)->union(roles->last().superior))";

	/**
	 * Validates the RolesCannotBeInHierarchyOrPrerequisite constraint of '<em>Mutual Role Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMutualRoleExclusion_RolesCannotBeInHierarchyOrPrerequisite(
			MutualRoleExclusion mutualRoleExclusion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.MUTUAL_ROLE_EXCLUSION, mutualRoleExclusion, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "RolesCannotBeInHierarchyOrPrerequisite",
				MUTUAL_ROLE_EXCLUSION__ROLES_CANNOT_BE_IN_HIERARCHY_OR_PREREQUISITE__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
		if (!validate_NoCircularContainment(context, diagnostics, theContext))
			return false;
		boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_UniqueID(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(context, diagnostics, theContext);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeContext(TimeContext timeContext, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(timeContext, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(timeContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(timeContext, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanVariableContext(BooleanVariableContext booleanVariableContext,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanVariableContext, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(booleanVariableContext, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(booleanVariableContext, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateBooleanVariableContext_VariableTypeNeedsToBeBoolean(booleanVariableContext, diagnostics,
					context);
		return result;
	}

	/**
	 * The cached validation expression for the VariableTypeNeedsToBeBoolean constraint of '<em>Boolean Variable Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BOOLEAN_VARIABLE_CONTEXT__VARIABLE_TYPE_NEEDS_TO_BE_BOOLEAN__EEXPRESSION = "variable.type.oclIsTypeOf(soliditycontracts::PrimitiveType) and variable.type.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::bool";

	/**
	 * Validates the VariableTypeNeedsToBeBoolean constraint of '<em>Boolean Variable Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanVariableContext_VariableTypeNeedsToBeBoolean(
			BooleanVariableContext booleanVariableContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.BOOLEAN_VARIABLE_CONTEXT, booleanVariableContext,
				diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "VariableTypeNeedsToBeBoolean",
				BOOLEAN_VARIABLE_CONTEXT__VARIABLE_TYPE_NEEDS_TO_BE_BOOLEAN__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToCsmRelation(FunctionToCsmRelation functionToCsmRelation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionToCsmRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(functionToCsmRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(functionToCsmRelation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateFunctionToVariableRelation_ForbidTimeContextConditions(functionToCsmRelation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateFunctionToCsmRelation_VariableTypeNeedsToBeMapping(functionToCsmRelation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateFunctionToCsmRelation_MappingKeyTypeNeedsToBeAddressOrAddressPayable(
					functionToCsmRelation, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the VariableTypeNeedsToBeMapping constraint of '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION_TO_CSM_RELATION__VARIABLE_TYPE_NEEDS_TO_BE_MAPPING__EEXPRESSION = "csm.type.oclIsTypeOf(soliditycontracts::Mapping)";

	/**
	 * Validates the VariableTypeNeedsToBeMapping constraint of '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToCsmRelation_VariableTypeNeedsToBeMapping(
			FunctionToCsmRelation functionToCsmRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.FUNCTION_TO_CSM_RELATION, functionToCsmRelation,
				diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "VariableTypeNeedsToBeMapping",
				FUNCTION_TO_CSM_RELATION__VARIABLE_TYPE_NEEDS_TO_BE_MAPPING__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the MappingKeyTypeNeedsToBeAddressOrAddressPayable constraint of '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION_TO_CSM_RELATION__MAPPING_KEY_TYPE_NEEDS_TO_BE_ADDRESS_OR_ADDRESS_PAYABLE__EEXPRESSION = "let map = csm.type.oclAsType(soliditycontracts::Mapping) in map.keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable)";

	/**
	 * Validates the MappingKeyTypeNeedsToBeAddressOrAddressPayable constraint of '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToCsmRelation_MappingKeyTypeNeedsToBeAddressOrAddressPayable(
			FunctionToCsmRelation functionToCsmRelation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.FUNCTION_TO_CSM_RELATION, functionToCsmRelation,
				diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				"MappingKeyTypeNeedsToBeAddressOrAddressPayable",
				FUNCTION_TO_CSM_RELATION__MAPPING_KEY_TYPE_NEEDS_TO_BE_ADDRESS_OR_ADDRESS_PAYABLE__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToStateVariableRelation(
			FunctionToStateVariableRelation functionToStateVariableRelation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionToStateVariableRelation, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(functionToStateVariableRelation, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(functionToStateVariableRelation, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(functionToStateVariableRelation,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFunctionToVariableRelation_ForbidTimeContextConditions(functionToStateVariableRelation,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFunctionToStateVariableRelation_VariableTypeIsNoMappingWithAddressAsKeytype(
					functionToStateVariableRelation, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the VariableTypeIsNoMappingWithAddressAsKeytype constraint of '<em>Function To State Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION_TO_STATE_VARIABLE_RELATION__VARIABLE_TYPE_IS_NO_MAPPING_WITH_ADDRESS_AS_KEYTYPE__EEXPRESSION = "not (variable.type.oclIsTypeOf(soliditycontracts::Mapping) and variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable))";

	/**
	 * Validates the VariableTypeIsNoMappingWithAddressAsKeytype constraint of '<em>Function To State Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionToStateVariableRelation_VariableTypeIsNoMappingWithAddressAsKeytype(
			FunctionToStateVariableRelation functionToStateVariableRelation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(AccessControlSystemPackage.Literals.FUNCTION_TO_STATE_VARIABLE_RELATION,
				functionToStateVariableRelation, diagnostics, context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "VariableTypeIsNoMappingWithAddressAsKeytype",
				FUNCTION_TO_STATE_VARIABLE_RELATION__VARIABLE_TYPE_IS_NO_MAPPING_WITH_ADDRESS_AS_KEYTYPE__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeUnits(TimeUnits timeUnits, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //AccessControlSystemValidator
