/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.BalanceModificationType;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Balance Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl#getModifiesMsgSenderBalance <em>Modifies Msg Sender Balance</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.FunctionBalanceModificationImpl#getModifiesThisContractsBalance <em>Modifies This Contracts Balance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionBalanceModificationImpl extends EntityImpl implements FunctionBalanceModification {
	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * The default value of the '{@link #getModifiesMsgSenderBalance() <em>Modifies Msg Sender Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiesMsgSenderBalance()
	 * @generated
	 * @ordered
	 */
	protected static final BalanceModificationType MODIFIES_MSG_SENDER_BALANCE_EDEFAULT = BalanceModificationType.MODIFIES_BOTH_WAYS;

	/**
	 * The cached value of the '{@link #getModifiesMsgSenderBalance() <em>Modifies Msg Sender Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiesMsgSenderBalance()
	 * @generated
	 * @ordered
	 */
	protected BalanceModificationType modifiesMsgSenderBalance = MODIFIES_MSG_SENDER_BALANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModifiesThisContractsBalance() <em>Modifies This Contracts Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiesThisContractsBalance()
	 * @generated
	 * @ordered
	 */
	protected static final BalanceModificationType MODIFIES_THIS_CONTRACTS_BALANCE_EDEFAULT = BalanceModificationType.MODIFIES_BOTH_WAYS;

	/**
	 * The cached value of the '{@link #getModifiesThisContractsBalance() <em>Modifies This Contracts Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiesThisContractsBalance()
	 * @generated
	 * @ordered
	 */
	protected BalanceModificationType modifiesThisContractsBalance = MODIFIES_THIS_CONTRACTS_BALANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBalanceModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartContractModelPackage.Literals.FUNCTION_BALANCE_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject) function;
			function = (Function) eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BalanceModificationType getModifiesMsgSenderBalance() {
		return modifiesMsgSenderBalance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModifiesMsgSenderBalance(BalanceModificationType newModifiesMsgSenderBalance) {
		BalanceModificationType oldModifiesMsgSenderBalance = modifiesMsgSenderBalance;
		modifiesMsgSenderBalance = newModifiesMsgSenderBalance == null ? MODIFIES_MSG_SENDER_BALANCE_EDEFAULT
				: newModifiesMsgSenderBalance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE,
					oldModifiesMsgSenderBalance, modifiesMsgSenderBalance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BalanceModificationType getModifiesThisContractsBalance() {
		return modifiesThisContractsBalance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModifiesThisContractsBalance(BalanceModificationType newModifiesThisContractsBalance) {
		BalanceModificationType oldModifiesThisContractsBalance = modifiesThisContractsBalance;
		modifiesThisContractsBalance = newModifiesThisContractsBalance == null
				? MODIFIES_THIS_CONTRACTS_BALANCE_EDEFAULT
				: newModifiesThisContractsBalance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE,
					oldModifiesThisContractsBalance, modifiesThisContractsBalance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION:
			if (resolve)
				return getFunction();
			return basicGetFunction();
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE:
			return getModifiesMsgSenderBalance();
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE:
			return getModifiesThisContractsBalance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION:
			setFunction((Function) newValue);
			return;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE:
			setModifiesMsgSenderBalance((BalanceModificationType) newValue);
			return;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE:
			setModifiesThisContractsBalance((BalanceModificationType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION:
			setFunction((Function) null);
			return;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE:
			setModifiesMsgSenderBalance(MODIFIES_MSG_SENDER_BALANCE_EDEFAULT);
			return;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE:
			setModifiesThisContractsBalance(MODIFIES_THIS_CONTRACTS_BALANCE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__FUNCTION:
			return function != null;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE:
			return modifiesMsgSenderBalance != MODIFIES_MSG_SENDER_BALANCE_EDEFAULT;
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE:
			return modifiesThisContractsBalance != MODIFIES_THIS_CONTRACTS_BALANCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (modifiesMsgSenderBalance: ");
		result.append(modifiesMsgSenderBalance);
		result.append(", modifiesThisContractsBalance: ");
		result.append(modifiesThisContractsBalance);
		result.append(')');
		return result.toString();
	}

} //FunctionBalanceModificationImpl
