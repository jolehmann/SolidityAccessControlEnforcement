/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function To Function Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCaller <em>Caller</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCallee <em>Callee</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToFunctionRelation()
 * @model
 * @generated
 */
public interface FunctionToFunctionRelation extends Entity {
	/**
	 * Returns the value of the '<em><b>Caller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller</em>' reference.
	 * @see #setCaller(Function)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToFunctionRelation_Caller()
	 * @model required="true"
	 * @generated
	 */
	Function getCaller();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCaller <em>Caller</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller</em>' reference.
	 * @see #getCaller()
	 * @generated
	 */
	void setCaller(Function value);

	/**
	 * Returns the value of the '<em><b>Callee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee</em>' reference.
	 * @see #setCallee(Function)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToFunctionRelation_Callee()
	 * @model required="true"
	 * @generated
	 */
	Function getCallee();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCallee <em>Callee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee</em>' reference.
	 * @see #getCallee()
	 * @generated
	 */
	void setCallee(Function value);

} // FunctionToFunctionRelation
