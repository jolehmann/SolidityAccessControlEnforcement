/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.util;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.*;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.util.SolidityContractsValidator;

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
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage
 * @generated
 */
public class SmartContractModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SmartContractModelValidator INSTANCE = new SmartContractModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel";

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolidityContractsValidator solidityContractsValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartContractModelValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
		solidityContractsValidator = SolidityContractsValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return SmartContractModelPackage.eINSTANCE;
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
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION:
			return validateFunctionBalanceModification((FunctionBalanceModification) value, diagnostics, context);
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT:
			return validateAccessControlContract((AccessControlContract) value, diagnostics, context);
		case SmartContractModelPackage.BALANCE_MODIFICATION_TYPE:
			return validateBalanceModificationType((BalanceModificationType) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionBalanceModification(FunctionBalanceModification functionBalanceModification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionBalanceModification, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(functionBalanceModification, diagnostics, context);
		if (result || diagnostics != null)
			result &= identifierValidator.validateIdentifier_identifierIsUnique(functionBalanceModification,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract(AccessControlContract accessControlContract,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(accessControlContract, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator.validateContract_ModifierNamesMustBeUnique(accessControlContract,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator.validateContract_StateVariableNamesMustBeUnique(accessControlContract,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator.validateContract_ContractCannotInheritFromItself(accessControlContract,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator
					.validateContract_ContractsReferencedInFunctionOverridesMustBeIncludedInParents(
							accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator
					.validateContract_ContractsReferencedInOverrideOfModifiersMustBeIncludedInParents(
							accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= solidityContractsValidator.validateContract_ContractMustContainOverrridingFunctions(
					accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAccessControlContract_BalanceModificationsReferenceDifferentFunctions(
					accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAccessControlContract_BalanceModificationsRegardingThisContractNeedPayableFunction(
					accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAccessControlContract_NoAdditionalLocalFunctions(accessControlContract, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= validateAccessControlContract_NoFunctionOverrides(accessControlContract, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAccessControlContract_NoMoreBalanceModificationsThanFunctions(accessControlContract,
					diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the BalanceModificationsReferenceDifferentFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS_REFERENCE_DIFFERENT_FUNCTIONS__EEXPRESSION = "balanceModifications -> isUnique(function)";

	/**
	 * Validates the BalanceModificationsReferenceDifferentFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract_BalanceModificationsReferenceDifferentFunctions(
			AccessControlContract accessControlContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT, accessControlContract, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				"BalanceModificationsReferenceDifferentFunctions",
				ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS_REFERENCE_DIFFERENT_FUNCTIONS__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the BalanceModificationsRegardingThisContractNeedPayableFunction constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS_REGARDING_THIS_CONTRACT_NEED_PAYABLE_FUNCTION__EEXPRESSION = "balanceModifications -> forAll(b | (b.modifiesThisContractsBalance = BalanceModificationType::modifiesBothWays or b.modifiesThisContractsBalance = BalanceModificationType::onlyIncrease) implies b.function.mutability = soliditycontracts::FunctionMutability::payable)";

	/**
	 * Validates the BalanceModificationsRegardingThisContractNeedPayableFunction constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract_BalanceModificationsRegardingThisContractNeedPayableFunction(
			AccessControlContract accessControlContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT, accessControlContract, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				"BalanceModificationsRegardingThisContractNeedPayableFunction",
				ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS_REGARDING_THIS_CONTRACT_NEED_PAYABLE_FUNCTION__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoAdditionalLocalFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CONTRACT__NO_ADDITIONAL_LOCAL_FUNCTIONS__EEXPRESSION = "localFunctions -> isEmpty()";

	/**
	 * Validates the NoAdditionalLocalFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract_NoAdditionalLocalFunctions(AccessControlContract accessControlContract,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT, accessControlContract, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoAdditionalLocalFunctions",
				ACCESS_CONTROL_CONTRACT__NO_ADDITIONAL_LOCAL_FUNCTIONS__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoFunctionOverrides constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CONTRACT__NO_FUNCTION_OVERRIDES__EEXPRESSION = "overrideFunctions -> isEmpty()";

	/**
	 * Validates the NoFunctionOverrides constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract_NoFunctionOverrides(AccessControlContract accessControlContract,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT, accessControlContract, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoFunctionOverrides",
				ACCESS_CONTROL_CONTRACT__NO_FUNCTION_OVERRIDES__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the NoMoreBalanceModificationsThanFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACCESS_CONTROL_CONTRACT__NO_MORE_BALANCE_MODIFICATIONS_THAN_FUNCTIONS__EEXPRESSION = "functions -> size() >= balanceModifications -> size()";

	/**
	 * Validates the NoMoreBalanceModificationsThanFunctions constraint of '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAccessControlContract_NoMoreBalanceModificationsThanFunctions(
			AccessControlContract accessControlContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT, accessControlContract, diagnostics,
				context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", "NoMoreBalanceModificationsThanFunctions",
				ACCESS_CONTROL_CONTRACT__NO_MORE_BALANCE_MODIFICATIONS_THAN_FUNCTIONS__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBalanceModificationType(BalanceModificationType balanceModificationType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //SmartContractModelValidator
