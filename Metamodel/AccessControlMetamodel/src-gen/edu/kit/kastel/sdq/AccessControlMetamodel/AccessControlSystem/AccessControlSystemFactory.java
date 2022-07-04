/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage
 * @generated
 */
public interface AccessControlSystemFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccessControlSystemFactory eINSTANCE = edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Function To Function Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function To Function Relation</em>'.
	 * @generated
	 */
	FunctionToFunctionRelation createFunctionToFunctionRelation();

	/**
	 * Returns a new object of class '<em>Access Control System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Control System</em>'.
	 * @generated
	 */
	AccessControlSystem createAccessControlSystem();

	/**
	 * Returns a new object of class '<em>Variable To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable To Variable Relation</em>'.
	 * @generated
	 */
	VariableToVariableRelation createVariableToVariableRelation();

	/**
	 * Returns a new object of class '<em>Role To Function Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role To Function Relation</em>'.
	 * @generated
	 */
	RoleToFunctionRelation createRoleToFunctionRelation();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns a new object of class '<em>Role To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role To Variable Relation</em>'.
	 * @generated
	 */
	RoleToVariableRelation createRoleToVariableRelation();

	/**
	 * Returns a new object of class '<em>Mutual Role Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutual Role Exclusion</em>'.
	 * @generated
	 */
	MutualRoleExclusion createMutualRoleExclusion();

	/**
	 * Returns a new object of class '<em>Time Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Context</em>'.
	 * @generated
	 */
	TimeContext createTimeContext();

	/**
	 * Returns a new object of class '<em>Boolean Variable Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Variable Context</em>'.
	 * @generated
	 */
	BooleanVariableContext createBooleanVariableContext();

	/**
	 * Returns a new object of class '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function To Csm Relation</em>'.
	 * @generated
	 */
	FunctionToCsmRelation createFunctionToCsmRelation();

	/**
	 * Returns a new object of class '<em>Function To State Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function To State Variable Relation</em>'.
	 * @generated
	 */
	FunctionToStateVariableRelation createFunctionToStateVariableRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AccessControlSystemPackage getAccessControlSystemPackage();

} //AccessControlSystemFactory
