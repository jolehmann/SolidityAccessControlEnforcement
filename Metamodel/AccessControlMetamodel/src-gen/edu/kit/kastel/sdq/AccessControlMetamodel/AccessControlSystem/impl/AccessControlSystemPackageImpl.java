/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Context;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.util.AccessControlSystemValidator;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl;

import edu.kit.kastel.sdq.soliditymetamodel.rbac.RBACPackage;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.SolidityContractsPackage;

import edu.kit.kastel.sdq.soliditymetamodel.soliditysystem.SoliditySystemPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessControlSystemPackageImpl extends EPackageImpl implements AccessControlSystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionToFunctionRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessControlSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableToVariableRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionToVariableRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleToFunctionRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleToVariableRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutualRoleExclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanVariableContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionToCsmRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionToStateVariableRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum timeUnitsEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AccessControlSystemPackageImpl() {
		super(eNS_URI, AccessControlSystemFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AccessControlSystemPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AccessControlSystemPackage init() {
		if (isInited)
			return (AccessControlSystemPackage) EPackage.Registry.INSTANCE
					.getEPackage(AccessControlSystemPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAccessControlSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AccessControlSystemPackageImpl theAccessControlSystemPackage = registeredAccessControlSystemPackage instanceof AccessControlSystemPackageImpl
				? (AccessControlSystemPackageImpl) registeredAccessControlSystemPackage
				: new AccessControlSystemPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		RBACPackage.eINSTANCE.eClass();
		SolidityContractsPackage.eINSTANCE.eClass();
		SoliditySystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SmartContractModelPackage.eNS_URI);
		SmartContractModelPackageImpl theSmartContractModelPackage = (SmartContractModelPackageImpl) (registeredPackage instanceof SmartContractModelPackageImpl
				? registeredPackage
				: SmartContractModelPackage.eINSTANCE);

		// Create package meta-data objects
		theAccessControlSystemPackage.createPackageContents();
		theSmartContractModelPackage.createPackageContents();

		// Initialize created meta-data
		theAccessControlSystemPackage.initializePackageContents();
		theSmartContractModelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theAccessControlSystemPackage, new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return AccessControlSystemValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theAccessControlSystemPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AccessControlSystemPackage.eNS_URI, theAccessControlSystemPackage);
		return theAccessControlSystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionToFunctionRelation() {
		return functionToFunctionRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToFunctionRelation_Caller() {
		return (EReference) functionToFunctionRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToFunctionRelation_Callee() {
		return (EReference) functionToFunctionRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessControlSystem() {
		return accessControlSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_RoleToVariableTuples() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_Roles() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_RoleToFunctionTuples() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_RoleExclusions() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_FunctionToVariableTuples() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_FunctionToFunctionTuples() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlSystem_VariableToVariableTuples() {
		return (EReference) accessControlSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableToVariableRelation() {
		return variableToVariableRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableToVariableRelation_Influencer() {
		return (EReference) variableToVariableRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableToVariableRelation_Influenced() {
		return (EReference) variableToVariableRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionToVariableRelation() {
		return functionToVariableRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToVariableRelation_Function() {
		return (EReference) functionToVariableRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToVariableRelation_Conditions() {
		return (EReference) functionToVariableRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoleToFunctionRelation() {
		return roleToFunctionRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleToFunctionRelation_Function() {
		return (EReference) roleToFunctionRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleToFunctionRelation_Role() {
		return (EReference) roleToFunctionRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleToFunctionRelation_Conditions() {
		return (EReference) roleToFunctionRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_Description() {
		return (EAttribute) roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_Cardinality() {
		return (EAttribute) roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_Prerequisite() {
		return (EReference) roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_Superior() {
		return (EReference) roleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoleToVariableRelation() {
		return roleToVariableRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleToVariableRelation_Variable() {
		return (EReference) roleToVariableRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleToVariableRelation_Role() {
		return (EReference) roleToVariableRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRoleToVariableRelation_Modifies() {
		return (EAttribute) roleToVariableRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMutualRoleExclusion() {
		return mutualRoleExclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutualRoleExclusion_Roles() {
		return (EReference) mutualRoleExclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTimeContext() {
		return timeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeContext_IsUpperBound() {
		return (EAttribute) timeContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeContext_TimeValue() {
		return (EAttribute) timeContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimeContext_TimeUnit() {
		return (EAttribute) timeContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanVariableContext() {
		return booleanVariableContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBooleanVariableContext_Variable() {
		return (EReference) booleanVariableContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanVariableContext_ValueToCheck() {
		return (EAttribute) booleanVariableContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionToCsmRelation() {
		return functionToCsmRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionToCsmRelation_AccessWholeMapping() {
		return (EAttribute) functionToCsmRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToCsmRelation_Csm() {
		return (EReference) functionToCsmRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionToStateVariableRelation() {
		return functionToStateVariableRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionToStateVariableRelation_Variable() {
		return (EReference) functionToStateVariableRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTimeUnits() {
		return timeUnitsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlSystemFactory getAccessControlSystemFactory() {
		return (AccessControlSystemFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		functionToFunctionRelationEClass = createEClass(FUNCTION_TO_FUNCTION_RELATION);
		createEReference(functionToFunctionRelationEClass, FUNCTION_TO_FUNCTION_RELATION__CALLER);
		createEReference(functionToFunctionRelationEClass, FUNCTION_TO_FUNCTION_RELATION__CALLEE);

		accessControlSystemEClass = createEClass(ACCESS_CONTROL_SYSTEM);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__ROLES);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES);
		createEReference(accessControlSystemEClass, ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES);

		variableToVariableRelationEClass = createEClass(VARIABLE_TO_VARIABLE_RELATION);
		createEReference(variableToVariableRelationEClass, VARIABLE_TO_VARIABLE_RELATION__INFLUENCER);
		createEReference(variableToVariableRelationEClass, VARIABLE_TO_VARIABLE_RELATION__INFLUENCED);

		functionToVariableRelationEClass = createEClass(FUNCTION_TO_VARIABLE_RELATION);
		createEReference(functionToVariableRelationEClass, FUNCTION_TO_VARIABLE_RELATION__FUNCTION);
		createEReference(functionToVariableRelationEClass, FUNCTION_TO_VARIABLE_RELATION__CONDITIONS);

		roleToFunctionRelationEClass = createEClass(ROLE_TO_FUNCTION_RELATION);
		createEReference(roleToFunctionRelationEClass, ROLE_TO_FUNCTION_RELATION__FUNCTION);
		createEReference(roleToFunctionRelationEClass, ROLE_TO_FUNCTION_RELATION__ROLE);
		createEReference(roleToFunctionRelationEClass, ROLE_TO_FUNCTION_RELATION__CONDITIONS);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__DESCRIPTION);
		createEAttribute(roleEClass, ROLE__CARDINALITY);
		createEReference(roleEClass, ROLE__PREREQUISITE);
		createEReference(roleEClass, ROLE__SUPERIOR);

		roleToVariableRelationEClass = createEClass(ROLE_TO_VARIABLE_RELATION);
		createEReference(roleToVariableRelationEClass, ROLE_TO_VARIABLE_RELATION__VARIABLE);
		createEReference(roleToVariableRelationEClass, ROLE_TO_VARIABLE_RELATION__ROLE);
		createEAttribute(roleToVariableRelationEClass, ROLE_TO_VARIABLE_RELATION__MODIFIES);

		mutualRoleExclusionEClass = createEClass(MUTUAL_ROLE_EXCLUSION);
		createEReference(mutualRoleExclusionEClass, MUTUAL_ROLE_EXCLUSION__ROLES);

		contextEClass = createEClass(CONTEXT);

		timeContextEClass = createEClass(TIME_CONTEXT);
		createEAttribute(timeContextEClass, TIME_CONTEXT__IS_UPPER_BOUND);
		createEAttribute(timeContextEClass, TIME_CONTEXT__TIME_VALUE);
		createEAttribute(timeContextEClass, TIME_CONTEXT__TIME_UNIT);

		booleanVariableContextEClass = createEClass(BOOLEAN_VARIABLE_CONTEXT);
		createEReference(booleanVariableContextEClass, BOOLEAN_VARIABLE_CONTEXT__VARIABLE);
		createEAttribute(booleanVariableContextEClass, BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK);

		functionToCsmRelationEClass = createEClass(FUNCTION_TO_CSM_RELATION);
		createEAttribute(functionToCsmRelationEClass, FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING);
		createEReference(functionToCsmRelationEClass, FUNCTION_TO_CSM_RELATION__CSM);

		functionToStateVariableRelationEClass = createEClass(FUNCTION_TO_STATE_VARIABLE_RELATION);
		createEReference(functionToStateVariableRelationEClass, FUNCTION_TO_STATE_VARIABLE_RELATION__VARIABLE);

		// Create enums
		timeUnitsEEnum = createEEnum(TIME_UNITS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
				.getEPackage(IdentifierPackage.eNS_URI);
		SolidityContractsPackage theSolidityContractsPackage = (SolidityContractsPackage) EPackage.Registry.INSTANCE
				.getEPackage(SolidityContractsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionToFunctionRelationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		accessControlSystemEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		variableToVariableRelationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		functionToVariableRelationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleToFunctionRelationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleToVariableRelationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		mutualRoleExclusionEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		contextEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		timeContextEClass.getESuperTypes().add(this.getContext());
		booleanVariableContextEClass.getESuperTypes().add(this.getContext());
		functionToCsmRelationEClass.getESuperTypes().add(this.getFunctionToVariableRelation());
		functionToStateVariableRelationEClass.getESuperTypes().add(this.getFunctionToVariableRelation());

		// Initialize classes, features, and operations; add parameters
		initEClass(functionToFunctionRelationEClass, FunctionToFunctionRelation.class, "FunctionToFunctionRelation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionToFunctionRelation_Caller(), theSolidityContractsPackage.getFunction(), null,
				"caller", null, 1, 1, FunctionToFunctionRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionToFunctionRelation_Callee(), theSolidityContractsPackage.getFunction(), null,
				"callee", null, 1, 1, FunctionToFunctionRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessControlSystemEClass, AccessControlSystem.class, "AccessControlSystem", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessControlSystem_RoleToVariableTuples(), this.getRoleToVariableRelation(), null,
				"roleToVariableTuples", null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_Roles(), this.getRole(), null, "roles", null, 0, -1,
				AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_RoleToFunctionTuples(), this.getRoleToFunctionRelation(), null,
				"roleToFunctionTuples", null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_RoleExclusions(), this.getMutualRoleExclusion(), null, "roleExclusions",
				null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_FunctionToVariableTuples(), this.getFunctionToVariableRelation(), null,
				"functionToVariableTuples", null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_FunctionToFunctionTuples(), this.getFunctionToFunctionRelation(), null,
				"functionToFunctionTuples", null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlSystem_VariableToVariableTuples(), this.getVariableToVariableRelation(), null,
				"variableToVariableTuples", null, 0, -1, AccessControlSystem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableToVariableRelationEClass, VariableToVariableRelation.class, "VariableToVariableRelation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableToVariableRelation_Influencer(), theSolidityContractsPackage.getStateVariable(), null,
				"influencer", null, 1, 1, VariableToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableToVariableRelation_Influenced(), theSolidityContractsPackage.getStateVariable(), null,
				"influenced", null, 1, 1, VariableToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionToVariableRelationEClass, FunctionToVariableRelation.class, "FunctionToVariableRelation",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionToVariableRelation_Function(), theSolidityContractsPackage.getFunction(), null,
				"function", null, 1, 1, FunctionToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionToVariableRelation_Conditions(), this.getContext(), null, "conditions", null, 0, -1,
				FunctionToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleToFunctionRelationEClass, RoleToFunctionRelation.class, "RoleToFunctionRelation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleToFunctionRelation_Function(), theSolidityContractsPackage.getFunction(), null,
				"function", null, 1, 1, RoleToFunctionRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleToFunctionRelation_Role(), this.getRole(), null, "role", null, 1, 1,
				RoleToFunctionRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleToFunctionRelation_Conditions(), this.getContext(), null, "conditions", null, 0, -1,
				RoleToFunctionRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_Description(), ecorePackage.getEString(), "description", null, 0, 1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Cardinality(), ecorePackage.getEInt(), "cardinality", "-1", 1, 1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Prerequisite(), this.getRole(), null, "prerequisite", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Superior(), this.getRole(), null, "superior", null, 0, -1, Role.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(roleToVariableRelationEClass, RoleToVariableRelation.class, "RoleToVariableRelation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleToVariableRelation_Variable(), theSolidityContractsPackage.getStateVariable(), null,
				"variable", null, 1, 1, RoleToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleToVariableRelation_Role(), this.getRole(), null, "role", null, 1, 1,
				RoleToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoleToVariableRelation_Modifies(), ecorePackage.getEBoolean(), "modifies", "true", 1, 1,
				RoleToVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutualRoleExclusionEClass, MutualRoleExclusion.class, "MutualRoleExclusion", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutualRoleExclusion_Roles(), this.getRole(), null, "roles", null, 2, 2,
				MutualRoleExclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeContextEClass, TimeContext.class, "TimeContext", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeContext_IsUpperBound(), ecorePackage.getEBoolean(), "isUpperBound", null, 1, 1,
				TimeContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeContext_TimeValue(), ecorePackage.getEInt(), "timeValue", null, 1, 1, TimeContext.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeContext_TimeUnit(), this.getTimeUnits(), "timeUnit", null, 1, 1, TimeContext.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanVariableContextEClass, BooleanVariableContext.class, "BooleanVariableContext", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanVariableContext_Variable(), theSolidityContractsPackage.getStateVariable(), null,
				"variable", null, 1, 1, BooleanVariableContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBooleanVariableContext_ValueToCheck(), ecorePackage.getEBoolean(), "valueToCheck", null, 1, 1,
				BooleanVariableContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionToCsmRelationEClass, FunctionToCsmRelation.class, "FunctionToCsmRelation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionToCsmRelation_AccessWholeMapping(), ecorePackage.getEBoolean(), "accessWholeMapping",
				null, 1, 1, FunctionToCsmRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionToCsmRelation_Csm(), theSolidityContractsPackage.getStateVariable(), null, "csm",
				null, 1, 1, FunctionToCsmRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionToStateVariableRelationEClass, FunctionToStateVariableRelation.class,
				"FunctionToStateVariableRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionToStateVariableRelation_Variable(), theSolidityContractsPackage.getStateVariable(),
				null, "variable", null, 1, 1, FunctionToStateVariableRelation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(timeUnitsEEnum, TimeUnits.class, "TimeUnits");
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.SECOND);
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.MINUTE);
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.HOUR);
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.DAY);
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.WEEK);
		addEEnumLiteral(timeUnitsEEnum, TimeUnits.YEAR);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation(this, source,
				new String[] { "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "validationDelegates",
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot" });
		addAnnotation(functionToVariableRelationEClass, source,
				new String[] { "constraints", "ForbidTimeContextConditions" });
		addAnnotation(roleEClass, source, new String[] { "constraints",
				"CardinalityIsValid NoRoleCanBePrerequisiteForItself NoRoleCanBeSuperiorToItself NoRoleInPrerequisiteAndSuperiorSet" });
		addAnnotation(mutualRoleExclusionEClass, source,
				new String[] { "constraints", "RolesCannotBeInHierarchyOrPrerequisite" });
		addAnnotation(booleanVariableContextEClass, source,
				new String[] { "constraints", "VariableTypeNeedsToBeBoolean" });
		addAnnotation(functionToCsmRelationEClass, source, new String[] { "constraints",
				"VariableTypeNeedsToBeMapping MappingKeyTypeNeedsToBeAddressOrAddressPayable" });
		addAnnotation(functionToStateVariableRelationEClass, source,
				new String[] { "constraints", "VariableTypeIsNoMappingWithAddressAsKeytype" });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation(functionToVariableRelationEClass, source, new String[] { "ForbidTimeContextConditions",
				"conditions -> forAll(c | c.oclIsTypeOf(TimeContext) <> true)" });
		addAnnotation(roleEClass, source,
				new String[] { "CardinalityIsValid", "cardinality = -1 or cardinality > 0",
						"NoRoleCanBePrerequisiteForItself", "prerequisite->excludes(self)",
						"NoRoleCanBeSuperiorToItself", "superior->excludes(self)", "NoRoleInPrerequisiteAndSuperiorSet",
						"prerequisite->excludesAll(superior)" });
		addAnnotation(mutualRoleExclusionEClass, source, new String[] { "RolesCannotBeInHierarchyOrPrerequisite",
				"roles->excludesAll(roles->first().prerequisite->union(roles->last().prerequisite)->union(roles->first().superior)->union(roles->last().superior))" });
		addAnnotation(booleanVariableContextEClass, source, new String[] { "VariableTypeNeedsToBeBoolean",
				"variable.type.oclIsTypeOf(soliditycontracts::PrimitiveType) and variable.type.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::bool" });
		addAnnotation(functionToCsmRelationEClass, source, new String[] {
				"MappingKeyTypeNeedsToBeAddressOrAddressPayable",
				"let map = csm.type.oclAsType(soliditycontracts::Mapping) in map.keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable)",
				"VariableTypeNeedsToBeMapping", "csm.type.oclIsTypeOf(soliditycontracts::Mapping)" });
		addAnnotation(functionToStateVariableRelationEClass, source, new String[] {
				"VariableTypeIsNoMappingWithAddressAsKeytype",
				"not (variable.type.oclIsTypeOf(soliditycontracts::Mapping) and variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable))" });
	}

} //AccessControlSystemPackageImpl
