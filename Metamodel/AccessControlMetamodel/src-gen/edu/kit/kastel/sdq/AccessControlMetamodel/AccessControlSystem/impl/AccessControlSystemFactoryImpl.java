/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessControlSystemFactoryImpl extends EFactoryImpl implements AccessControlSystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AccessControlSystemFactory init() {
		try {
			AccessControlSystemFactory theAccessControlSystemFactory = (AccessControlSystemFactory) EPackage.Registry.INSTANCE
					.getEFactory(AccessControlSystemPackage.eNS_URI);
			if (theAccessControlSystemFactory != null) {
				return theAccessControlSystemFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AccessControlSystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlSystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AccessControlSystemPackage.FUNCTION_TO_FUNCTION_RELATION:
			return createFunctionToFunctionRelation();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM:
			return createAccessControlSystem();
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION:
			return createVariableToVariableRelation();
		case AccessControlSystemPackage.ROLE_TO_FUNCTION_RELATION:
			return createRoleToFunctionRelation();
		case AccessControlSystemPackage.ROLE:
			return createRole();
		case AccessControlSystemPackage.ROLE_TO_VARIABLE_RELATION:
			return createRoleToVariableRelation();
		case AccessControlSystemPackage.MUTUAL_ROLE_EXCLUSION:
			return createMutualRoleExclusion();
		case AccessControlSystemPackage.TIME_CONTEXT:
			return createTimeContext();
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT:
			return createBooleanVariableContext();
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION:
			return createFunctionToCsmRelation();
		case AccessControlSystemPackage.FUNCTION_TO_STATE_VARIABLE_RELATION:
			return createFunctionToStateVariableRelation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case AccessControlSystemPackage.TIME_UNITS:
			return createTimeUnitsFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case AccessControlSystemPackage.TIME_UNITS:
			return convertTimeUnitsToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionToFunctionRelation createFunctionToFunctionRelation() {
		FunctionToFunctionRelationImpl functionToFunctionRelation = new FunctionToFunctionRelationImpl();
		return functionToFunctionRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlSystem createAccessControlSystem() {
		AccessControlSystemImpl accessControlSystem = new AccessControlSystemImpl();
		return accessControlSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableToVariableRelation createVariableToVariableRelation() {
		VariableToVariableRelationImpl variableToVariableRelation = new VariableToVariableRelationImpl();
		return variableToVariableRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleToFunctionRelation createRoleToFunctionRelation() {
		RoleToFunctionRelationImpl roleToFunctionRelation = new RoleToFunctionRelationImpl();
		return roleToFunctionRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleToVariableRelation createRoleToVariableRelation() {
		RoleToVariableRelationImpl roleToVariableRelation = new RoleToVariableRelationImpl();
		return roleToVariableRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MutualRoleExclusion createMutualRoleExclusion() {
		MutualRoleExclusionImpl mutualRoleExclusion = new MutualRoleExclusionImpl();
		return mutualRoleExclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeContext createTimeContext() {
		TimeContextImpl timeContext = new TimeContextImpl();
		return timeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanVariableContext createBooleanVariableContext() {
		BooleanVariableContextImpl booleanVariableContext = new BooleanVariableContextImpl();
		return booleanVariableContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionToCsmRelation createFunctionToCsmRelation() {
		FunctionToCsmRelationImpl functionToCsmRelation = new FunctionToCsmRelationImpl();
		return functionToCsmRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionToStateVariableRelation createFunctionToStateVariableRelation() {
		FunctionToStateVariableRelationImpl functionToStateVariableRelation = new FunctionToStateVariableRelationImpl();
		return functionToStateVariableRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnits createTimeUnitsFromString(EDataType eDataType, String initialValue) {
		TimeUnits result = TimeUnits.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeUnitsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlSystemPackage getAccessControlSystemPackage() {
		return (AccessControlSystemPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AccessControlSystemPackage getPackage() {
		return AccessControlSystemPackage.eINSTANCE;
	}

} //AccessControlSystemFactoryImpl
