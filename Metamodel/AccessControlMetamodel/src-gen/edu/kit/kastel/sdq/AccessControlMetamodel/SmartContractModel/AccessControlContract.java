/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Contract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getFunctions <em>Functions</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract#getBalanceModifications <em>Balance Modifications</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getAccessControlContract()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='BalanceModificationsReferenceDifferentFunctions BalanceModificationsRegardingThisContractNeedPayableFunction NoAdditionalLocalFunctions NoFunctionOverrides NoMoreBalanceModificationsThanFunctions'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot NoMoreBalanceModificationsThanFunctions='functions -&gt; size() &gt;= balanceModifications -&gt; size()' BalanceModificationsReferenceDifferentFunctions='balanceModifications -&gt; isUnique(function)' BalanceModificationsRegardingThisContractNeedPayableFunction='balanceModifications -&gt; forAll(b | (b.modifiesThisContractsBalance = BalanceModificationType::modifiesBothWays or b.modifiesThisContractsBalance = BalanceModificationType::onlyIncrease) implies b.function.mutability = soliditycontracts::FunctionMutability::payable)' NoAdditionalLocalFunctions='localFunctions -&gt; isEmpty()' NoFunctionOverrides='overrideFunctions -&gt; isEmpty()'"
 * @generated
 */
public interface AccessControlContract extends Contract {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getAccessControlContract_Functions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Balance Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balance Modifications</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getAccessControlContract_BalanceModifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionBalanceModification> getBalanceModifications();

} // AccessControlContract
