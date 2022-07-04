/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl#isIsUpperBound <em>Is Upper Bound</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl#getTimeValue <em>Time Value</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeContextImpl extends ContextImpl implements TimeContext {
	/**
	 * The default value of the '{@link #isIsUpperBound() <em>Is Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UPPER_BOUND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUpperBound() <em>Is Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUpperBound()
	 * @generated
	 * @ordered
	 */
	protected boolean isUpperBound = IS_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeValue() <em>Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeValue()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimeValue() <em>Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeValue()
	 * @generated
	 * @ordered
	 */
	protected int timeValue = TIME_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected static final TimeUnits TIME_UNIT_EDEFAULT = TimeUnits.SECOND;

	/**
	 * The cached value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected TimeUnits timeUnit = TIME_UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.TIME_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUpperBound() {
		return isUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUpperBound(boolean newIsUpperBound) {
		boolean oldIsUpperBound = isUpperBound;
		isUpperBound = newIsUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.TIME_CONTEXT__IS_UPPER_BOUND, oldIsUpperBound, isUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTimeValue() {
		return timeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeValue(int newTimeValue) {
		int oldTimeValue = timeValue;
		timeValue = newTimeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccessControlSystemPackage.TIME_CONTEXT__TIME_VALUE,
					oldTimeValue, timeValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimeUnits getTimeUnit() {
		return timeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeUnit(TimeUnits newTimeUnit) {
		TimeUnits oldTimeUnit = timeUnit;
		timeUnit = newTimeUnit == null ? TIME_UNIT_EDEFAULT : newTimeUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AccessControlSystemPackage.TIME_CONTEXT__TIME_UNIT,
					oldTimeUnit, timeUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AccessControlSystemPackage.TIME_CONTEXT__IS_UPPER_BOUND:
			return isIsUpperBound();
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_VALUE:
			return getTimeValue();
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_UNIT:
			return getTimeUnit();
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
		case AccessControlSystemPackage.TIME_CONTEXT__IS_UPPER_BOUND:
			setIsUpperBound((Boolean) newValue);
			return;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_VALUE:
			setTimeValue((Integer) newValue);
			return;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_UNIT:
			setTimeUnit((TimeUnits) newValue);
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
		case AccessControlSystemPackage.TIME_CONTEXT__IS_UPPER_BOUND:
			setIsUpperBound(IS_UPPER_BOUND_EDEFAULT);
			return;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_VALUE:
			setTimeValue(TIME_VALUE_EDEFAULT);
			return;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_UNIT:
			setTimeUnit(TIME_UNIT_EDEFAULT);
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
		case AccessControlSystemPackage.TIME_CONTEXT__IS_UPPER_BOUND:
			return isUpperBound != IS_UPPER_BOUND_EDEFAULT;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_VALUE:
			return timeValue != TIME_VALUE_EDEFAULT;
		case AccessControlSystemPackage.TIME_CONTEXT__TIME_UNIT:
			return timeUnit != TIME_UNIT_EDEFAULT;
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
		result.append(" (isUpperBound: ");
		result.append(isUpperBound);
		result.append(", timeValue: ");
		result.append(timeValue);
		result.append(", timeUnit: ");
		result.append(timeUnit);
		result.append(')');
		return result.toString();
	}

} //TimeContextImpl
