/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function To Csm Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#isAccessWholeMapping <em>Access Whole Mapping</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#getCsm <em>Csm</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToCsmRelation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableTypeNeedsToBeMapping MappingKeyTypeNeedsToBeAddressOrAddressPayable'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot MappingKeyTypeNeedsToBeAddressOrAddressPayable='let map = csm.type.oclAsType(soliditycontracts::Mapping) in map.keyType.oclIsTypeOf(soliditycontracts::PrimitiveType) and (map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address or map.keyType.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::address_payable)' VariableTypeNeedsToBeMapping='csm.type.oclIsTypeOf(soliditycontracts::Mapping)'"
 * @generated
 */
public interface FunctionToCsmRelation extends FunctionToVariableRelation {
	/**
	 * Returns the value of the '<em><b>Access Whole Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Whole Mapping</em>' attribute.
	 * @see #setAccessWholeMapping(boolean)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToCsmRelation_AccessWholeMapping()
	 * @model required="true"
	 * @generated
	 */
	boolean isAccessWholeMapping();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#isAccessWholeMapping <em>Access Whole Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Whole Mapping</em>' attribute.
	 * @see #isAccessWholeMapping()
	 * @generated
	 */
	void setAccessWholeMapping(boolean value);

	/**
	 * Returns the value of the '<em><b>Csm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Csm</em>' reference.
	 * @see #setCsm(StateVariable)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getFunctionToCsmRelation_Csm()
	 * @model required="true"
	 * @generated
	 */
	StateVariable getCsm();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#getCsm <em>Csm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Csm</em>' reference.
	 * @see #getCsm()
	 * @generated
	 */
	void setCsm(StateVariable value);

} // FunctionToCsmRelation
