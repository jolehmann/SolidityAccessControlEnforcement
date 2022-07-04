/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Variable Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#isValueToCheck <em>Value To Check</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getBooleanVariableContext()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableTypeNeedsToBeBoolean'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot VariableTypeNeedsToBeBoolean='variable.type.oclIsTypeOf(soliditycontracts::PrimitiveType) and variable.type.oclAsType(soliditycontracts::PrimitiveType).type = soliditycontracts::PrimitiveTypeEnum::bool'"
 * @generated
 */
public interface BooleanVariableContext extends Context {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(StateVariable)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getBooleanVariableContext_Variable()
	 * @model required="true"
	 * @generated
	 */
	StateVariable getVariable();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(StateVariable value);

	/**
	 * Returns the value of the '<em><b>Value To Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value To Check</em>' attribute.
	 * @see #setValueToCheck(boolean)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getBooleanVariableContext_ValueToCheck()
	 * @model required="true"
	 * @generated
	 */
	boolean isValueToCheck();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#isValueToCheck <em>Value To Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value To Check</em>' attribute.
	 * @see #isValueToCheck()
	 * @generated
	 */
	void setValueToCheck(boolean value);

} // BooleanVariableContext
