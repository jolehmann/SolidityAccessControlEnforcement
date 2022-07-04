/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable To Variable Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl#getInfluencer <em>Influencer</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl#getInfluenced <em>Influenced</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableToVariableRelationImpl extends EntityImpl implements VariableToVariableRelation {
	/**
	 * The cached value of the '{@link #getInfluencer() <em>Influencer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluencer()
	 * @generated
	 * @ordered
	 */
	protected StateVariable influencer;

	/**
	 * The cached value of the '{@link #getInfluenced() <em>Influenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluenced()
	 * @generated
	 * @ordered
	 */
	protected StateVariable influenced;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableToVariableRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.VARIABLE_TO_VARIABLE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateVariable getInfluencer() {
		if (influencer != null && influencer.eIsProxy()) {
			InternalEObject oldInfluencer = (InternalEObject) influencer;
			influencer = (StateVariable) eResolveProxy(oldInfluencer);
			if (influencer != oldInfluencer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER, oldInfluencer,
							influencer));
			}
		}
		return influencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable basicGetInfluencer() {
		return influencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInfluencer(StateVariable newInfluencer) {
		StateVariable oldInfluencer = influencer;
		influencer = newInfluencer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER, oldInfluencer, influencer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateVariable getInfluenced() {
		if (influenced != null && influenced.eIsProxy()) {
			InternalEObject oldInfluenced = (InternalEObject) influenced;
			influenced = (StateVariable) eResolveProxy(oldInfluenced);
			if (influenced != oldInfluenced) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED, oldInfluenced,
							influenced));
			}
		}
		return influenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariable basicGetInfluenced() {
		return influenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInfluenced(StateVariable newInfluenced) {
		StateVariable oldInfluenced = influenced;
		influenced = newInfluenced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED, oldInfluenced, influenced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER:
			if (resolve)
				return getInfluencer();
			return basicGetInfluencer();
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED:
			if (resolve)
				return getInfluenced();
			return basicGetInfluenced();
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
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER:
			setInfluencer((StateVariable) newValue);
			return;
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED:
			setInfluenced((StateVariable) newValue);
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
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER:
			setInfluencer((StateVariable) null);
			return;
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED:
			setInfluenced((StateVariable) null);
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
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCER:
			return influencer != null;
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION__INFLUENCED:
			return influenced != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableToVariableRelationImpl
