/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.provider;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.mdsd.modelingfoundations.identifier.provider.EntityItemProvider;

/**
 * This is the item provider adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessControlSystemItemProvider extends EntityItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlSystemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES);
			childrenFeatures.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLES);
			childrenFeatures.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES);
			childrenFeatures.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS);
			childrenFeatures
					.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES);
			childrenFeatures
					.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES);
			childrenFeatures
					.add(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AccessControlSystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AccessControlSystem"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AccessControlSystem) object).getEntityName();
		return label == null || label.length() == 0 ? getString("_UI_AccessControlSystem_type")
				: getString("_UI_AccessControlSystem_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AccessControlSystem.class)) {
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLES:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES:
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(
				createChildParameter(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES,
						AccessControlSystemFactory.eINSTANCE.createRoleToVariableRelation()));

		newChildDescriptors.add(createChildParameter(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLES,
				AccessControlSystemFactory.eINSTANCE.createRole()));

		newChildDescriptors.add(
				createChildParameter(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES,
						AccessControlSystemFactory.eINSTANCE.createRoleToFunctionRelation()));

		newChildDescriptors
				.add(createChildParameter(AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS,
						AccessControlSystemFactory.eINSTANCE.createMutualRoleExclusion()));

		newChildDescriptors.add(createChildParameter(
				AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES,
				AccessControlSystemFactory.eINSTANCE.createFunctionToCsmRelation()));

		newChildDescriptors.add(createChildParameter(
				AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES,
				AccessControlSystemFactory.eINSTANCE.createFunctionToStateVariableRelation()));

		newChildDescriptors.add(createChildParameter(
				AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES,
				AccessControlSystemFactory.eINSTANCE.createFunctionToFunctionRelation()));

		newChildDescriptors.add(createChildParameter(
				AccessControlSystemPackage.Literals.ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES,
				AccessControlSystemFactory.eINSTANCE.createVariableToVariableRelation()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AccessControlMetamodelEditPlugin.INSTANCE;
	}

}
