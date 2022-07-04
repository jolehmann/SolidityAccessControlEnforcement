/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutual Role Exclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion#getRoles <em>Roles</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getMutualRoleExclusion()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='RolesCannotBeInHierarchyOrPrerequisite'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot RolesCannotBeInHierarchyOrPrerequisite='roles-&gt;excludesAll(roles-&gt;first().prerequisite-&gt;union(roles-&gt;last().prerequisite)-&gt;union(roles-&gt;first().superior)-&gt;union(roles-&gt;last().superior))'"
 * @generated
 */
public interface MutualRoleExclusion extends Entity {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage#getMutualRoleExclusion_Roles()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Role> getRoles();

} // MutualRoleExclusion
