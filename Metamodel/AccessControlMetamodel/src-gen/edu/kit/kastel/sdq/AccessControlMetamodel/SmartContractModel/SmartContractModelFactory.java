/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.SmartContractModelPackage
 * @generated
 */
public interface SmartContractModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmartContractModelFactory eINSTANCE = edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.impl.SmartContractModelFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Function Balance Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Balance Modification</em>'.
	 * @generated
	 */
	FunctionBalanceModification createFunctionBalanceModification();

	/**
	 * Returns a new object of class '<em>Access Control Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Control Contract</em>'.
	 * @generated
	 */
	AccessControlContract createAccessControlContract();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SmartContractModelPackage getSmartContractModelPackage();

} //SmartContractModelFactory
