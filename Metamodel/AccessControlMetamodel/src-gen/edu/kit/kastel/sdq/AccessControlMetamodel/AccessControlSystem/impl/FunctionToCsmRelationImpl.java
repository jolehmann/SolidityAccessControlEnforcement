/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function To Csm Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl#isAccessWholeMapping <em>Access Whole Mapping</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl#getCsm <em>Csm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionToCsmRelationImpl extends FunctionToVariableRelationImpl implements FunctionToCsmRelation {
	/**
	 * The default value of the '{@link #isAccessWholeMapping() <em>Access Whole Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAccessWholeMapping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACCESS_WHOLE_MAPPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAccessWholeMapping() <em>Access Whole Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAccessWholeMapping()
	 * @generated
	 * @ordered
	 */
	protected boolean accessWholeMapping = ACCESS_WHOLE_MAPPING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCsm() <em>Csm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCsm()
	 * @generated
	 * @ordered
	 */
	protected StateVariable csm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToCsmRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.FUNCTION_TO_CSM_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAccessWholeMapping() {
		return accessWholeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccessWholeMapping(boolean newAccessWholeMapping) {
		boolean oldAccessWholeMapping = accessWholeMapping;
		accessWholeMapping = newAccessWholeMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING, oldAccessWholeMapping,
					accessWholeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateVariable getCsm() {
		if (csm != null && csm.eIsProxy()) {
			InternalEObject oldCsm = (InternalEObject) csm;
			csm = (StateVariable) eResolveProxy(oldCsm);
			if (csm != oldCsm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM, oldCsm, csm));
			}
		}
		return csm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable basicGetCsm() {
		return csm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCsm(StateVariable newCsm) {
		StateVariable oldCsm = csm;
		csm = newCsm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM, oldCsm, csm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING:
			return isAccessWholeMapping();
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM:
			if (resolve)
				return getCsm();
			return basicGetCsm();
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
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING:
			setAccessWholeMapping((Boolean) newValue);
			return;
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM:
			setCsm((StateVariable) newValue);
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
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING:
			setAccessWholeMapping(ACCESS_WHOLE_MAPPING_EDEFAULT);
			return;
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM:
			setCsm((StateVariable) null);
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
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING:
			return accessWholeMapping != ACCESS_WHOLE_MAPPING_EDEFAULT;
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION__CSM:
			return csm != null;
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
		result.append(" (accessWholeMapping: ");
		result.append(accessWholeMapping);
		result.append(')');
		return result.toString();
	}

} //FunctionToCsmRelationImpl
