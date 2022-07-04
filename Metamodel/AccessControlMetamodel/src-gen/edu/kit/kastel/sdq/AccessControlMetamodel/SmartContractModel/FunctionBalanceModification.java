/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Balance Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesMsgSenderBalance <em>Modifies Msg Sender Balance</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesThisContractsBalance <em>Modifies This Contracts Balance</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getFunctionBalanceModification()
 * @model
 * @generated
 */
public interface FunctionBalanceModification extends Entity {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getFunctionBalanceModification_Function()
	 * @model required="true"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Modifies Msg Sender Balance</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifies Msg Sender Balance</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @see #setModifiesMsgSenderBalance(BalanceModificationType)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getFunctionBalanceModification_ModifiesMsgSenderBalance()
	 * @model required="true"
	 * @generated
	 */
	BalanceModificationType getModifiesMsgSenderBalance();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesMsgSenderBalance <em>Modifies Msg Sender Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifies Msg Sender Balance</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @see #getModifiesMsgSenderBalance()
	 * @generated
	 */
	void setModifiesMsgSenderBalance(BalanceModificationType value);

	/**
	 * Returns the value of the '<em><b>Modifies This Contracts Balance</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifies This Contracts Balance</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @see #setModifiesThisContractsBalance(BalanceModificationType)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getFunctionBalanceModification_ModifiesThisContractsBalance()
	 * @model required="true"
	 * @generated
	 */
	BalanceModificationType getModifiesThisContractsBalance();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification#getModifiesThisContractsBalance <em>Modifies This Contracts Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifies This Contracts Balance</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType
	 * @see #getModifiesThisContractsBalance()
	 * @generated
	 */
	void setModifiesThisContractsBalance(BalanceModificationType value);

} // FunctionBalanceModification
