/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getPrerequisite <em>Prerequisite</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getSuperior <em>Superior</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getRole()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='CardinalityIsValid NoRoleCanBePrerequisiteForItself NoRoleCanBeSuperiorToItself NoRoleInPrerequisiteAndSuperiorSet'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot CardinalityIsValid='cardinality = -1 or cardinality &gt; 0' NoRoleCanBePrerequisiteForItself='prerequisite-&gt;excludes(self)' NoRoleCanBeSuperiorToItself='superior-&gt;excludes(self)' NoRoleInPrerequisiteAndSuperiorSet='prerequisite-&gt;excludesAll(superior)'"
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getRole_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(int)
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getRole_Cardinality()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getCardinality();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(int value);

	/**
	 * Returns the value of the '<em><b>Prerequisite</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prerequisite</em>' reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getRole_Prerequisite()
	 * @model
	 * @generated
	 */
	EList<Role> getPrerequisite();

	/**
	 * Returns the value of the '<em><b>Superior</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Superior</em>' reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getRole_Superior()
	 * @model
	 * @generated
	 */
	EList<Role> getSuperior();

} // Role
