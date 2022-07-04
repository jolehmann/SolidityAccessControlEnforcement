/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function To State Variable Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToStateVariableRelation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableTypeIsNoMappingWithAddressAsKeytype'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot VariableTypeIsNoMappingWithAddressAsKeytype='not (variable.type.oclIsTypeOf(soliditycontracts::Mapping) and variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or variable.type.oclAsType(soliditycontracts::Mapping).keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable))'"
 * @generated
 */
public interface FunctionToStateVariableRelation extends FunctionToVariableRelation {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(StateVariable)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToStateVariableRelation_Variable()
	 * @model required="true"
	 * @generated
	 */
	StateVariable getVariable();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(StateVariable value);

} // FunctionToStateVariableRelation
