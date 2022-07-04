/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Context;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function To Variable Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FunctionToVariableRelationImpl extends EntityImpl implements FunctionToVariableRelation {
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
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> conditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToVariableRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.FUNCTION_TO_VARIABLE_RELATION;
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
							AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION, oldFunction, function));
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
					AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Context> getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList<Context>(Context.class, this,
					AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS:
			return ((InternalEList<?>) getConditions()).basicRemove(otherEnd, msgs);
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
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION:
			if (resolve)
				return getFunction();
			return basicGetFunction();
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS:
			return getConditions();
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
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION:
			setFunction((Function) newValue);
			return;
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS:
			getConditions().clear();
			getConditions().addAll((Collection<? extends Context>) newValue);
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
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION:
			setFunction((Function) null);
			return;
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS:
			getConditions().clear();
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
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__FUNCTION:
			return function != null;
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION__CONDITIONS:
			return conditions != null && !conditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionToVariableRelationImpl
