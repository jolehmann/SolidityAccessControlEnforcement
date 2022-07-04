/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelFactory;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.util.SmartContractModelValidator;

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
public class SmartContractModelPackageImpl extends EPackageImpl implements SmartContractModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBalanceModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessControlContractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum balanceModificationTypeEEnum = null;

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
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SmartContractModelPackageImpl() {
		super(eNS_URI, SmartContractModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SmartContractModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SmartContractModelPackage init() {
		if (isInited)
			return (SmartContractModelPackage) EPackage.Registry.INSTANCE
					.getEPackage(SmartContractModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSmartContractModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SmartContractModelPackageImpl theSmartContractModelPackage = registeredSmartContractModelPackage instanceof SmartContractModelPackageImpl
				? (SmartContractModelPackageImpl) registeredSmartContractModelPackage
				: new SmartContractModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		RBACPackage.eINSTANCE.eClass();
		SolidityContractsPackage.eINSTANCE.eClass();
		SoliditySystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AccessControlSystemPackage.eNS_URI);
		AccessControlSystemPackageImpl theAccessControlSystemPackage = (AccessControlSystemPackageImpl) (registeredPackage instanceof AccessControlSystemPackageImpl
				? registeredPackage
				: AccessControlSystemPackage.eINSTANCE);

		// Create package meta-data objects
		theSmartContractModelPackage.createPackageContents();
		theAccessControlSystemPackage.createPackageContents();

		// Initialize created meta-data
		theSmartContractModelPackage.initializePackageContents();
		theAccessControlSystemPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theSmartContractModelPackage, new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return SmartContractModelValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theSmartContractModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SmartContractModelPackage.eNS_URI, theSmartContractModelPackage);
		return theSmartContractModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionBalanceModification() {
		return functionBalanceModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionBalanceModification_Function() {
		return (EReference) functionBalanceModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionBalanceModification_ModifiesMsgSenderBalance() {
		return (EAttribute) functionBalanceModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionBalanceModification_ModifiesThisContractsBalance() {
		return (EAttribute) functionBalanceModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessControlContract() {
		return accessControlContractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlContract_Functions() {
		return (EReference) accessControlContractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccessControlContract_BalanceModifications() {
		return (EReference) accessControlContractEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getBalanceModificationType() {
		return balanceModificationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SmartContractModelFactory getSmartContractModelFactory() {
		return (SmartContractModelFactory) getEFactoryInstance();
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
		functionBalanceModificationEClass = createEClass(FUNCTION_BALANCE_MODIFICATION);
		createEReference(functionBalanceModificationEClass, FUNCTION_BALANCE_MODIFICATION__FUNCTION);
		createEAttribute(functionBalanceModificationEClass, FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE);
		createEAttribute(functionBalanceModificationEClass,
				FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE);

		accessControlContractEClass = createEClass(ACCESS_CONTROL_CONTRACT);
		createEReference(accessControlContractEClass, ACCESS_CONTROL_CONTRACT__FUNCTIONS);
		createEReference(accessControlContractEClass, ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS);

		// Create enums
		balanceModificationTypeEEnum = createEEnum(BALANCE_MODIFICATION_TYPE);
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
		functionBalanceModificationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		accessControlContractEClass.getESuperTypes().add(theSolidityContractsPackage.getContract());

		// Initialize classes, features, and operations; add parameters
		initEClass(functionBalanceModificationEClass, FunctionBalanceModification.class, "FunctionBalanceModification",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBalanceModification_Function(), theSolidityContractsPackage.getFunction(), null,
				"function", null, 1, 1, FunctionBalanceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionBalanceModification_ModifiesMsgSenderBalance(), this.getBalanceModificationType(),
				"modifiesMsgSenderBalance", null, 1, 1, FunctionBalanceModification.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionBalanceModification_ModifiesThisContractsBalance(), this.getBalanceModificationType(),
				"modifiesThisContractsBalance", null, 1, 1, FunctionBalanceModification.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessControlContractEClass, AccessControlContract.class, "AccessControlContract", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccessControlContract_Functions(), theSolidityContractsPackage.getFunction(), null,
				"functions", null, 1, -1, AccessControlContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccessControlContract_BalanceModifications(), this.getFunctionBalanceModification(), null,
				"balanceModifications", null, 0, -1, AccessControlContract.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(balanceModificationTypeEEnum, BalanceModificationType.class, "BalanceModificationType");
		addEEnumLiteral(balanceModificationTypeEEnum, BalanceModificationType.MODIFIES_BOTH_WAYS);
		addEEnumLiteral(balanceModificationTypeEEnum, BalanceModificationType.ONLY_INCREASE);
		addEEnumLiteral(balanceModificationTypeEEnum, BalanceModificationType.ONLY_DECREASE);
		addEEnumLiteral(balanceModificationTypeEEnum, BalanceModificationType.DOES_NOT_MODIFY);

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
		addAnnotation(accessControlContractEClass, source, new String[] { "constraints",
				"BalanceModificationsReferenceDifferentFunctions BalanceModificationsRegardingThisContractNeedPayableFunction NoAdditionalLocalFunctions NoFunctionOverrides NoMoreBalanceModificationsThanFunctions" });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation(accessControlContractEClass, source, new String[] { "NoMoreBalanceModificationsThanFunctions",
				"functions -> size() >= balanceModifications -> size()",
				"BalanceModificationsReferenceDifferentFunctions", "balanceModifications -> isUnique(function)",
				"BalanceModificationsRegardingThisContractNeedPayableFunction",
				"balanceModifications -> forAll(b | (b.modifiesThisContractsBalance = BalanceModificationType::modifiesBothWays or b.modifiesThisContractsBalance = BalanceModificationType::onlyIncrease) implies b.function.mutability = soliditycontracts::FunctionMutability::payable)",
				"NoAdditionalLocalFunctions", "localFunctions -> isEmpty()", "NoFunctionOverrides",
				"overrideFunctions -> isEmpty()" });
	}

} //SmartContractModelPackageImpl
