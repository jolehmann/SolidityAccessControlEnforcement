/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.SolidityContractsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface SmartContractModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SmartContractModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.kastel.kit.edu/AccessControlMetamodel/SmartContractModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SmartContractModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmartContractModelPackage eINSTANCE = edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl <em>Function Balance Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getFunctionBalanceModification()
	 * @generated
	 */
	int FUNCTION_BALANCE_MODIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION__FUNCTION = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifies Msg Sender Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifies This Contracts Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function Balance Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Function Balance Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_BALANCE_MODIFICATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl <em>Access Control Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getAccessControlContract()
	 * @generated
	 */
	int ACCESS_CONTROL_CONTRACT = 1;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__ENTITY_NAME = SolidityContractsPackage.CONTRACT__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__VARIABLES = SolidityContractsPackage.CONTRACT__VARIABLES;

	/**
	 * The feature id for the '<em><b>Provided Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__PROVIDED_FUNCTIONS = SolidityContractsPackage.CONTRACT__PROVIDED_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__CONSTRUCTOR = SolidityContractsPackage.CONTRACT__CONSTRUCTOR;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__EVENTS = SolidityContractsPackage.CONTRACT__EVENTS;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__PARENTS = SolidityContractsPackage.CONTRACT__PARENTS;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__MODIFIERS = SolidityContractsPackage.CONTRACT__MODIFIERS;

	/**
	 * The feature id for the '<em><b>Local Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__LOCAL_TYPES = SolidityContractsPackage.CONTRACT__LOCAL_TYPES;

	/**
	 * The feature id for the '<em><b>Required Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__REQUIRED_FUNCTIONS = SolidityContractsPackage.CONTRACT__REQUIRED_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Local Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__LOCAL_FUNCTIONS = SolidityContractsPackage.CONTRACT__LOCAL_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Override Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__OVERRIDE_FUNCTIONS = SolidityContractsPackage.CONTRACT__OVERRIDE_FUNCTIONS;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__FUNCTIONS = SolidityContractsPackage.CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Balance Modifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS = SolidityContractsPackage.CONTRACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Access Control Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT_FEATURE_COUNT = SolidityContractsPackage.CONTRACT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Access Control Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_CONTRACT_OPERATION_COUNT = SolidityContractsPackage.CONTRACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType <em>Balance Modification Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getBalanceModificationType()
	 * @generated
	 */
	int BALANCE_MODIFICATION_TYPE = 2;

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification <em>Function Balance Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Balance Modification</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification
	 * @generated
	 */
	EClass getFunctionBalanceModification();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getFunction()
	 * @see #getFunctionBalanceModification()
	 * @generated
	 */
	EReference getFunctionBalanceModification_Function();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesMsgSenderBalance <em>Modifies Msg Sender Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifies Msg Sender Balance</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesMsgSenderBalance()
	 * @see #getFunctionBalanceModification()
	 * @generated
	 */
	EAttribute getFunctionBalanceModification_ModifiesMsgSenderBalance();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesThisContractsBalance <em>Modifies This Contracts Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifies This Contracts Balance</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesThisContractsBalance()
	 * @see #getFunctionBalanceModification()
	 * @generated
	 */
	EAttribute getFunctionBalanceModification_ModifiesThisContractsBalance();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract <em>Access Control Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control Contract</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
	 * @generated
	 */
	EClass getAccessControlContract();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getFunctions()
	 * @see #getAccessControlContract()
	 * @generated
	 */
	EReference getAccessControlContract_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getBalanceModifications <em>Balance Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Balance Modifications</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getBalanceModifications()
	 * @see #getAccessControlContract()
	 * @generated
	 */
	EReference getAccessControlContract_BalanceModifications();

	/**
	 * Returns the meta object for enum '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType <em>Balance Modification Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Balance Modification Type</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @generated
	 */
	EEnum getBalanceModificationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmartContractModelFactory getSmartContractModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl <em>Function Balance Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getFunctionBalanceModification()
		 * @generated
		 */
		EClass FUNCTION_BALANCE_MODIFICATION = eINSTANCE.getFunctionBalanceModification();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_BALANCE_MODIFICATION__FUNCTION = eINSTANCE.getFunctionBalanceModification_Function();

		/**
		 * The meta object literal for the '<em><b>Modifies Msg Sender Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE = eINSTANCE
				.getFunctionBalanceModification_ModifiesMsgSenderBalance();

		/**
		 * The meta object literal for the '<em><b>Modifies This Contracts Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE = eINSTANCE
				.getFunctionBalanceModification_ModifiesThisContractsBalance();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl <em>Access Control Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getAccessControlContract()
		 * @generated
		 */
		EClass ACCESS_CONTROL_CONTRACT = eINSTANCE.getAccessControlContract();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CONTRACT__FUNCTIONS = eINSTANCE.getAccessControlContract_Functions();

		/**
		 * The meta object literal for the '<em><b>Balance Modifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS = eINSTANCE
				.getAccessControlContract_BalanceModifications();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType <em>Balance Modification Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelPackageImpl#getBalanceModificationType()
		 * @generated
		 */
		EEnum BALANCE_MODIFICATION_TYPE = eINSTANCE.getBalanceModificationType();

	}

} //SmartContractModelPackage
