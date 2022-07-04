/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.provider;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.provider.AccessControlMetamodelEditPlugin;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.mdsd.modelingfoundations.identifier.provider.EntityItemProvider;

/**
 * This is the item provider adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.FunctionBalanceModification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionBalanceModificationItemProvider extends EntityItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBalanceModificationItemProvider(AdapterFactory adapterFactory) {
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

			addFunctionPropertyDescriptor(object);
			addModifiesMsgSenderBalancePropertyDescriptor(object);
			addModifiesThisContractsBalancePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Function feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFunctionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FunctionBalanceModification_function_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_FunctionBalanceModification_function_feature",
						"_UI_FunctionBalanceModification_type"),
				SmartContractModelPackage.Literals.FUNCTION_BALANCE_MODIFICATION__FUNCTION, true, false, true, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Modifies Msg Sender Balance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiesMsgSenderBalancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FunctionBalanceModification_modifiesMsgSenderBalance_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FunctionBalanceModification_modifiesMsgSenderBalance_feature",
						"_UI_FunctionBalanceModification_type"),
				SmartContractModelPackage.Literals.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Modifies This Contracts Balance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiesThisContractsBalancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_FunctionBalanceModification_modifiesThisContractsBalance_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FunctionBalanceModification_modifiesThisContractsBalance_feature",
						"_UI_FunctionBalanceModification_type"),
				SmartContractModelPackage.Literals.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns FunctionBalanceModification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FunctionBalanceModification"));
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
		String label = ((FunctionBalanceModification) object).getEntityName();
		return label == null || label.length() == 0 ? getString("_UI_FunctionBalanceModification_type")
				: getString("_UI_FunctionBalanceModification_type") + " " + label;
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

		switch (notification.getFeatureID(FunctionBalanceModification.class)) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_MSG_SENDER_BALANCE:
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION__MODIFIES_THIS_CONTRACTS_BALANCE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
