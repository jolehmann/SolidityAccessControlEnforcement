/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable To Variable Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluencer <em>Influencer</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluenced <em>Influenced</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getVariableToVariableRelation()
 * @model
 * @generated
 */
public interface VariableToVariableRelation extends Entity {
	/**
	 * Returns the value of the '<em><b>Influencer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influencer</em>' reference.
	 * @see #setInfluencer(StateVariable)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getVariableToVariableRelation_Influencer()
	 * @model required="true"
	 * @generated
	 */
	StateVariable getInfluencer();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluencer <em>Influencer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influencer</em>' reference.
	 * @see #getInfluencer()
	 * @generated
	 */
	void setInfluencer(StateVariable value);

	/**
	 * Returns the value of the '<em><b>Influenced</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influenced</em>' reference.
	 * @see #setInfluenced(StateVariable)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getVariableToVariableRelation_Influenced()
	 * @model required="true"
	 * @generated
	 */
	StateVariable getInfluenced();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluenced <em>Influenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influenced</em>' reference.
	 * @see #getInfluenced()
	 * @generated
	 */
	void setInfluenced(StateVariable value);

} // VariableToVariableRelation
