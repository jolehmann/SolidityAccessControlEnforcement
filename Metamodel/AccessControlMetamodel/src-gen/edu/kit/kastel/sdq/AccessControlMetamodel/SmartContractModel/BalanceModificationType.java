/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Balance Modification Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage#getBalanceModificationType()
 * @model
 * @generated
 */
public enum BalanceModificationType implements Enumerator {
	/**
	 * The '<em><b>Modifies Both Ways</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFIES_BOTH_WAYS_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFIES_BOTH_WAYS(0, "modifiesBothWays", "modifiesBothWays"),

	/**
	 * The '<em><b>Only Increase</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_INCREASE_VALUE
	 * @generated
	 * @ordered
	 */
	ONLY_INCREASE(1, "onlyIncrease", "onlyIncrease"),

	/**
	 * The '<em><b>Only Decrease</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_DECREASE_VALUE
	 * @generated
	 * @ordered
	 */
	ONLY_DECREASE(2, "onlyDecrease", "onlyDecrease"),

	/**
	 * The '<em><b>Does Not Modify</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOES_NOT_MODIFY_VALUE
	 * @generated
	 * @ordered
	 */
	DOES_NOT_MODIFY(3, "doesNotModify", "doesNotModify");

	/**
	 * The '<em><b>Modifies Both Ways</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFIES_BOTH_WAYS
	 * @model name="modifiesBothWays"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFIES_BOTH_WAYS_VALUE = 0;

	/**
	 * The '<em><b>Only Increase</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_INCREASE
	 * @model name="onlyIncrease"
	 * @generated
	 * @ordered
	 */
	public static final int ONLY_INCREASE_VALUE = 1;

	/**
	 * The '<em><b>Only Decrease</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLY_DECREASE
	 * @model name="onlyDecrease"
	 * @generated
	 * @ordered
	 */
	public static final int ONLY_DECREASE_VALUE = 2;

	/**
	 * The '<em><b>Does Not Modify</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOES_NOT_MODIFY
	 * @model name="doesNotModify"
	 * @generated
	 * @ordered
	 */
	public static final int DOES_NOT_MODIFY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Balance Modification Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final BalanceModificationType[] VALUES_ARRAY = new BalanceModificationType[] { MODIFIES_BOTH_WAYS,
			ONLY_INCREASE, ONLY_DECREASE, DOES_NOT_MODIFY, };

	/**
	 * A public read-only list of all the '<em><b>Balance Modification Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<BalanceModificationType> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Balance Modification Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BalanceModificationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BalanceModificationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Balance Modification Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BalanceModificationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BalanceModificationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Balance Modification Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static BalanceModificationType get(int value) {
		switch (value) {
		case MODIFIES_BOTH_WAYS_VALUE:
			return MODIFIES_BOTH_WAYS;
		case ONLY_INCREASE_VALUE:
			return ONLY_INCREASE;
		case ONLY_DECREASE_VALUE:
			return ONLY_DECREASE;
		case DOES_NOT_MODIFY_VALUE:
			return DOES_NOT_MODIFY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private BalanceModificationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //BalanceModificationType
