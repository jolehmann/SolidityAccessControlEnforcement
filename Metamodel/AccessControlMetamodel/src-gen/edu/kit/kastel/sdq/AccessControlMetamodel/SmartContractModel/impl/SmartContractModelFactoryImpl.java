/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl;

import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmartContractModelFactoryImpl extends EFactoryImpl implements SmartContractModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmartContractModelFactory init() {
		try {
			SmartContractModelFactory theSmartContractModelFactory = (SmartContractModelFactory) EPackage.Registry.INSTANCE
					.getEFactory(SmartContractModelPackage.eNS_URI);
			if (theSmartContractModelFactory != null) {
				return theSmartContractModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmartContractModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartContractModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SmartContractModelPackage.FUNCTION_BALANCE_MODIFICATION:
			return createFunctionBalanceModification();
		case SmartContractModelPackage.ACCESS_CONTROL_CONTRACT:
			return createAccessControlContract();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case SmartContractModelPackage.BALANCE_MODIFICATION_TYPE:
			return createBalanceModificationTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case SmartContractModelPackage.BALANCE_MODIFICATION_TYPE:
			return convertBalanceModificationTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionBalanceModification createFunctionBalanceModification() {
		FunctionBalanceModificationImpl functionBalanceModification = new FunctionBalanceModificationImpl();
		return functionBalanceModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessControlContract createAccessControlContract() {
		AccessControlContractImpl accessControlContract = new AccessControlContractImpl();
		return accessControlContract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BalanceModificationType createBalanceModificationTypeFromString(EDataType eDataType, String initialValue) {
		BalanceModificationType result = BalanceModificationType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBalanceModificationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SmartContractModelPackage getSmartContractModelPackage() {
		return (SmartContractModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmartContractModelPackage getPackage() {
		return SmartContractModelPackage.eINSTANCE;
	}

} //SmartContractModelFactoryImpl
