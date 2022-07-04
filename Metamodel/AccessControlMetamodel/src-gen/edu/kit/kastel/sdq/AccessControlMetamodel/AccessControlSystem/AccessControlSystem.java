/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Control System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToVariableTuples <em>Role To Variable Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoles <em>Roles</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToFunctionTuples <em>Role To Function Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleExclusions <em>Role Exclusions</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToVariableTuples <em>Function To Variable Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToFunctionTuples <em>Function To Function Tuples</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getVariableToVariableTuples <em>Variable To Variable Tuples</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem()
 * @model
 * @generated
 */
public interface AccessControlSystem extends Entity {
	/**
	 * Returns the value of the '<em><b>Role To Variable Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role To Variable Tuples</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_RoleToVariableTuples()
	 * @model containment="true"
	 * @generated
	 */
	EList<RoleToVariableRelation> getRoleToVariableTuples();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Role To Function Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role To Function Tuples</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_RoleToFunctionTuples()
	 * @model containment="true"
	 * @generated
	 */
	EList<RoleToFunctionRelation> getRoleToFunctionTuples();

	/**
	 * Returns the value of the '<em><b>Role Exclusions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Exclusions</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_RoleExclusions()
	 * @model containment="true"
	 * @generated
	 */
	EList<MutualRoleExclusion> getRoleExclusions();

	/**
	 * Returns the value of the '<em><b>Function To Variable Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function To Variable Tuples</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_FunctionToVariableTuples()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionToVariableRelation> getFunctionToVariableTuples();

	/**
	 * Returns the value of the '<em><b>Function To Function Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function To Function Tuples</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_FunctionToFunctionTuples()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionToFunctionRelation> getFunctionToFunctionTuples();

	/**
	 * Returns the value of the '<em><b>Variable To Variable Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable To Variable Tuples</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getAccessControlSystem_VariableToVariableTuples()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableToVariableRelation> getVariableToVariableTuples();

} // AccessControlSystem
