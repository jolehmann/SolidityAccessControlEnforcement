/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.provider;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.util.AccessControlSystemAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessControlSystemItemProviderAdapterFactory extends AccessControlSystemAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlSystemItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToFunctionRelationItemProvider functionToFunctionRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionToFunctionRelationAdapter() {
		if (functionToFunctionRelationItemProvider == null) {
			functionToFunctionRelationItemProvider = new FunctionToFunctionRelationItemProvider(this);
		}

		return functionToFunctionRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlSystemItemProvider accessControlSystemItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAccessControlSystemAdapter() {
		if (accessControlSystemItemProvider == null) {
			accessControlSystemItemProvider = new AccessControlSystemItemProvider(this);
		}

		return accessControlSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableToVariableRelationItemProvider variableToVariableRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVariableToVariableRelationAdapter() {
		if (variableToVariableRelationItemProvider == null) {
			variableToVariableRelationItemProvider = new VariableToVariableRelationItemProvider(this);
		}

		return variableToVariableRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleToFunctionRelationItemProvider roleToFunctionRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleToFunctionRelationAdapter() {
		if (roleToFunctionRelationItemProvider == null) {
			roleToFunctionRelationItemProvider = new RoleToFunctionRelationItemProvider(this);
		}

		return roleToFunctionRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleItemProvider roleItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleAdapter() {
		if (roleItemProvider == null) {
			roleItemProvider = new RoleItemProvider(this);
		}

		return roleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleToVariableRelationItemProvider roleToVariableRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRoleToVariableRelationAdapter() {
		if (roleToVariableRelationItemProvider == null) {
			roleToVariableRelationItemProvider = new RoleToVariableRelationItemProvider(this);
		}

		return roleToVariableRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutualRoleExclusionItemProvider mutualRoleExclusionItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMutualRoleExclusionAdapter() {
		if (mutualRoleExclusionItemProvider == null) {
			mutualRoleExclusionItemProvider = new MutualRoleExclusionItemProvider(this);
		}

		return mutualRoleExclusionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeContextItemProvider timeContextItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeContextAdapter() {
		if (timeContextItemProvider == null) {
			timeContextItemProvider = new TimeContextItemProvider(this);
		}

		return timeContextItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableContextItemProvider booleanVariableContextItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanVariableContextAdapter() {
		if (booleanVariableContextItemProvider == null) {
			booleanVariableContextItemProvider = new BooleanVariableContextItemProvider(this);
		}

		return booleanVariableContextItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToCsmRelationItemProvider functionToCsmRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionToCsmRelationAdapter() {
		if (functionToCsmRelationItemProvider == null) {
			functionToCsmRelationItemProvider = new FunctionToCsmRelationItemProvider(this);
		}

		return functionToCsmRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToStateVariableRelationItemProvider functionToStateVariableRelationItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionToStateVariableRelationAdapter() {
		if (functionToStateVariableRelationItemProvider == null) {
			functionToStateVariableRelationItemProvider = new FunctionToStateVariableRelationItemProvider(this);
		}

		return functionToStateVariableRelationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (functionToFunctionRelationItemProvider != null)
			functionToFunctionRelationItemProvider.dispose();
		if (accessControlSystemItemProvider != null)
			accessControlSystemItemProvider.dispose();
		if (variableToVariableRelationItemProvider != null)
			variableToVariableRelationItemProvider.dispose();
		if (roleToFunctionRelationItemProvider != null)
			roleToFunctionRelationItemProvider.dispose();
		if (roleItemProvider != null)
			roleItemProvider.dispose();
		if (roleToVariableRelationItemProvider != null)
			roleToVariableRelationItemProvider.dispose();
		if (mutualRoleExclusionItemProvider != null)
			mutualRoleExclusionItemProvider.dispose();
		if (timeContextItemProvider != null)
			timeContextItemProvider.dispose();
		if (booleanVariableContextItemProvider != null)
			booleanVariableContextItemProvider.dispose();
		if (functionToCsmRelationItemProvider != null)
			functionToCsmRelationItemProvider.dispose();
		if (functionToStateVariableRelationItemProvider != null)
			functionToStateVariableRelationItemProvider.dispose();
	}

}
