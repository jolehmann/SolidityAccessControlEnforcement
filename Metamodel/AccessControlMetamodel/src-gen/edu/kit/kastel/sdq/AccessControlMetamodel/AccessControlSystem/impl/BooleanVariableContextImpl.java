/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Variable Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl#isValueToCheck <em>Value To Check</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanVariableContextImpl extends ContextImpl implements BooleanVariableContext {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected StateVariable variable;

	/**
	 * The default value of the '{@link #isValueToCheck() <em>Value To Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValueToCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_TO_CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValueToCheck() <em>Value To Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValueToCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean valueToCheck = VALUE_TO_CHECK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.BOOLEAN_VARIABLE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateVariable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject) variable;
			variable = (StateVariable) eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariable(StateVariable newVariable) {
		StateVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isValueToCheck() {
		return valueToCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueToCheck(boolean newValueToCheck) {
		boolean oldValueToCheck = valueToCheck;
		valueToCheck = newValueToCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK, oldValueToCheck,
					valueToCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK:
			return isValueToCheck();
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
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE:
			setVariable((StateVariable) newValue);
			return;
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK:
			setValueToCheck((Boolean) newValue);
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
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE:
			setVariable((StateVariable) null);
			return;
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK:
			setValueToCheck(VALUE_TO_CHECK_EDEFAULT);
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
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VARIABLE:
			return variable != null;
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK:
			return valueToCheck != VALUE_TO_CHECK_EDEFAULT;
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
		result.append(" (valueToCheck: ");
		result.append(valueToCheck);
		result.append(')');
		return result.toString();
	}

} //BooleanVariableContextImpl
