/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.impl.ContractImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Control Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.AccessControlContractImpl#getBalanceModifications <em>Balance Modifications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessControlContractImpl extends ContractImpl implements AccessControlContract {
	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getBalanceModifications() <em>Balance Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalanceModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBalanceModification> balanceModifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmartContractModelPackage.Literals.ACCESS_CONTROL_CONTRACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this,
					SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FunctionBalanceModification> getBalanceModifications() {
		if (balanceModifications == null) {
			balanceModifications = new EObjectContainmentEList<FunctionBalanceModification>(
					FunctionBalanceModification.class, this,
					SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS);
		}
		return balanceModifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS:
			return ((InternalEList<?>) getFunctions()).basicRemove(otherEnd, msgs);
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS:
			return ((InternalEList<?>) getBalanceModifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS:
			return getFunctions();
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS:
			return getBalanceModifications();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS:
			getFunctions().clear();
			getFunctions().addAll((Collection<? extends Function>) newValue);
			return;
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS:
			getBalanceModifications().clear();
			getBalanceModifications().addAll((Collection<? extends FunctionBalanceModification>) newValue);
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
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS:
			getFunctions().clear();
			return;
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS:
			getBalanceModifications().clear();
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
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__FUNCTIONS:
			return functions != null && !functions.isEmpty();
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT__BALANCE_MODIFICATIONS:
			return balanceModifications != null && !balanceModifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AccessControlContractImpl
