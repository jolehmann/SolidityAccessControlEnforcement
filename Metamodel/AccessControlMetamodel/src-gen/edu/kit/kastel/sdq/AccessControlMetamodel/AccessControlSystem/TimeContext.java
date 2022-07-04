/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#isIsUpperBound <em>Is Upper Bound</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeValue <em>Time Value</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getTimeContext()
 * @model
 * @generated
 */
public interface TimeContext extends Context {
	/**
	 * Returns the value of the '<em><b>Is Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Upper Bound</em>' attribute.
	 * @see #setIsUpperBound(boolean)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getTimeContext_IsUpperBound()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsUpperBound();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#isIsUpperBound <em>Is Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Upper Bound</em>' attribute.
	 * @see #isIsUpperBound()
	 * @generated
	 */
	void setIsUpperBound(boolean value);

	/**
	 * Returns the value of the '<em><b>Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Value</em>' attribute.
	 * @see #setTimeValue(int)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getTimeContext_TimeValue()
	 * @model required="true"
	 * @generated
	 */
	int getTimeValue();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeValue <em>Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Value</em>' attribute.
	 * @see #getTimeValue()
	 * @generated
	 */
	void setTimeValue(int value);

	/**
	 * Returns the value of the '<em><b>Time Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Unit</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
	 * @see #setTimeUnit(TimeUnits)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getTimeContext_TimeUnit()
	 * @model required="true"
	 * @generated
	 */
	TimeUnits getTimeUnit();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeUnit <em>Time Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Unit</em>' attribute.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
	 * @see #getTimeUnit()
	 * @generated
	 */
	void setTimeUnit(TimeUnits value);

} // TimeContext
