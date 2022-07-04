/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Control System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getRoleToVariableTuples <em>Role To Variable Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getRoleToFunctionTuples <em>Role To Function Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getRoleExclusions <em>Role Exclusions</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getFunctionToVariableTuples <em>Function To Variable Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getFunctionToFunctionTuples <em>Function To Function Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl#getVariableToVariableTuples <em>Variable To Variable Tuples</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessControlSystemImpl extends EntityImpl implements AccessControlSystem {
	/**
	 * The cached value of the '{@link #getRoleToVariableTuples() <em>Role To Variable Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleToVariableTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleToVariableRelation> roleToVariableTuples;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getRoleToFunctionTuples() <em>Role To Function Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleToFunctionTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleToFunctionRelation> roleToFunctionTuples;

	/**
	 * The cached value of the '{@link #getRoleExclusions() <em>Role Exclusions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleExclusions()
	 * @generated
	 * @ordered
	 */
	protected EList<MutualRoleExclusion> roleExclusions;

	/**
	 * The cached value of the '{@link #getFunctionToVariableTuples() <em>Function To Variable Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionToVariableTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionToVariableRelation> functionToVariableTuples;

	/**
	 * The cached value of the '{@link #getFunctionToFunctionTuples() <em>Function To Function Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionToFunctionTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionToFunctionRelation> functionToFunctionTuples;

	/**
	 * The cached value of the '{@link #getVariableToVariableTuples() <em>Variable To Variable Tuples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableToVariableTuples()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableToVariableRelation> variableToVariableTuples;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RoleToVariableRelation> getRoleToVariableTuples() {
		if (roleToVariableTuples == null) {
			roleToVariableTuples = new EObjectContainmentEList<RoleToVariableRelation>(RoleToVariableRelation.class,
					this, AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES);
		}
		return roleToVariableTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this,
					AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RoleToFunctionRelation> getRoleToFunctionTuples() {
		if (roleToFunctionTuples == null) {
			roleToFunctionTuples = new EObjectContainmentEList<RoleToFunctionRelation>(RoleToFunctionRelation.class,
					this, AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES);
		}
		return roleToFunctionTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MutualRoleExclusion> getRoleExclusions() {
		if (roleExclusions == null) {
			roleExclusions = new EObjectContainmentEList<MutualRoleExclusion>(MutualRoleExclusion.class, this,
					AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS);
		}
		return roleExclusions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FunctionToVariableRelation> getFunctionToVariableTuples() {
		if (functionToVariableTuples == null) {
			functionToVariableTuples = new EObjectContainmentEList<FunctionToVariableRelation>(
					FunctionToVariableRelation.class, this,
					AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES);
		}
		return functionToVariableTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FunctionToFunctionRelation> getFunctionToFunctionTuples() {
		if (functionToFunctionTuples == null) {
			functionToFunctionTuples = new EObjectContainmentEList<FunctionToFunctionRelation>(
					FunctionToFunctionRelation.class, this,
					AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES);
		}
		return functionToFunctionTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VariableToVariableRelation> getVariableToVariableTuples() {
		if (variableToVariableTuples == null) {
			variableToVariableTuples = new EObjectContainmentEList<VariableToVariableRelation>(
					VariableToVariableRelation.class, this,
					AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES);
		}
		return variableToVariableTuples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
			return ((InternalEList<?>) getRoleToVariableTuples()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
			return ((InternalEList<?>) getRoles()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
			return ((InternalEList<?>) getRoleToFunctionTuples()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
			return ((InternalEList<?>) getRoleExclusions()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
			return ((InternalEList<?>) getFunctionToVariableTuples()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
			return ((InternalEList<?>) getFunctionToFunctionTuples()).basicRemove(otherEnd, msgs);
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			return ((InternalEList<?>) getVariableToVariableTuples()).basicRemove(otherEnd, msgs);
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
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
			return getRoleToVariableTuples();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
			return getRoles();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
			return getRoleToFunctionTuples();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
			return getRoleExclusions();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
			return getFunctionToVariableTuples();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
			return getFunctionToFunctionTuples();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			return getVariableToVariableTuples();
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
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
			getRoleToVariableTuples().clear();
			getRoleToVariableTuples().addAll((Collection<? extends RoleToVariableRelation>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
			getRoles().clear();
			getRoles().addAll((Collection<? extends Role>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
			getRoleToFunctionTuples().clear();
			getRoleToFunctionTuples().addAll((Collection<? extends RoleToFunctionRelation>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
			getRoleExclusions().clear();
			getRoleExclusions().addAll((Collection<? extends MutualRoleExclusion>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
			getFunctionToVariableTuples().clear();
			getFunctionToVariableTuples().addAll((Collection<? extends FunctionToVariableRelation>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
			getFunctionToFunctionTuples().clear();
			getFunctionToFunctionTuples().addAll((Collection<? extends FunctionToFunctionRelation>) newValue);
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			getVariableToVariableTuples().clear();
			getVariableToVariableTuples().addAll((Collection<? extends VariableToVariableRelation>) newValue);
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
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
			getRoleToVariableTuples().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
			getRoles().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
			getRoleToFunctionTuples().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
			getRoleExclusions().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
			getFunctionToVariableTuples().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
			getFunctionToFunctionTuples().clear();
			return;
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			getVariableToVariableTuples().clear();
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
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
			return roleToVariableTuples != null && !roleToVariableTuples.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
			return roles != null && !roles.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
			return roleToFunctionTuples != null && !roleToFunctionTuples.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
			return roleExclusions != null && !roleExclusions.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
			return functionToVariableTuples != null && !functionToVariableTuples.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
			return functionToFunctionTuples != null && !functionToFunctionTuples.isEmpty();
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			return variableToVariableTuples != null && !variableToVariableTuples.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AccessControlSystemImpl
