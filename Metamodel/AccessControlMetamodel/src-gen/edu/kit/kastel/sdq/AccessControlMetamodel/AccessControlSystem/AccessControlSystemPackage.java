/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface AccessControlSystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "AccessControlSystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.kastel.kit.edu/AccessControlMetamodel/AccessControlSystem";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "AccessControlSystem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccessControlSystemPackage eINSTANCE = edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToFunctionRelationImpl <em>Function To Function Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToFunctionRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToFunctionRelation()
	 * @generated
	 */
	int FUNCTION_TO_FUNCTION_RELATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION__CALLER = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Callee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION__CALLEE = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function To Function Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function To Function Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_FUNCTION_RELATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl <em>Access Control System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getAccessControlSystem()
	 * @generated
	 */
	int ACCESS_CONTROL_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Role To Variable Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ROLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Role To Function Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Role Exclusions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Function To Variable Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Function To Function Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Variable To Variable Tuples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Access Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Access Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_SYSTEM_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl <em>Variable To Variable Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getVariableToVariableRelation()
	 * @generated
	 */
	int VARIABLE_TO_VARIABLE_RELATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Influencer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION__INFLUENCER = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Influenced</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION__INFLUENCED = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_VARIABLE_RELATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl <em>Function To Variable Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToVariableRelation()
	 * @generated
	 */
	int FUNCTION_TO_VARIABLE_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION__FUNCTION = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION__CONDITIONS = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_VARIABLE_RELATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToFunctionRelationImpl <em>Role To Function Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToFunctionRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRoleToFunctionRelation()
	 * @generated
	 */
	int ROLE_TO_FUNCTION_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION__FUNCTION = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION__ROLE = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION__CONDITIONS = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Role To Function Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Role To Function Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_FUNCTION_RELATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__CARDINALITY = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prerequisite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PREREQUISITE = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Superior</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SUPERIOR = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToVariableRelationImpl <em>Role To Variable Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToVariableRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRoleToVariableRelation()
	 * @generated
	 */
	int ROLE_TO_VARIABLE_RELATION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION__VARIABLE = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION__ROLE = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION__MODIFIES = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Role To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Role To Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TO_VARIABLE_RELATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.MutualRoleExclusionImpl <em>Mutual Role Exclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.MutualRoleExclusionImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getMutualRoleExclusion()
	 * @generated
	 */
	int MUTUAL_ROLE_EXCLUSION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_ROLE_EXCLUSION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_ROLE_EXCLUSION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_ROLE_EXCLUSION__ROLES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mutual Role Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_ROLE_EXCLUSION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mutual Role Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_ROLE_EXCLUSION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.ContextImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = IdentifierPackage.IDENTIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl <em>Time Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getTimeContext()
	 * @generated
	 */
	int TIME_CONTEXT = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Is Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT__IS_UPPER_BOUND = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT__TIME_VALUE = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT__TIME_UNIT = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Time Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Time Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONTEXT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl <em>Boolean Variable Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getBooleanVariableContext()
	 * @generated
	 */
	int BOOLEAN_VARIABLE_CONTEXT = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_CONTEXT__VARIABLE = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value To Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Variable Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Boolean Variable Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VARIABLE_CONTEXT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl <em>Function To Csm Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToCsmRelation()
	 * @generated
	 */
	int FUNCTION_TO_CSM_RELATION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__ID = FUNCTION_TO_VARIABLE_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__ENTITY_NAME = FUNCTION_TO_VARIABLE_RELATION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__FUNCTION = FUNCTION_TO_VARIABLE_RELATION__FUNCTION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__CONDITIONS = FUNCTION_TO_VARIABLE_RELATION__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Access Whole Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING = FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Csm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION__CSM = FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function To Csm Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION_FEATURE_COUNT = FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function To Csm Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_CSM_RELATION_OPERATION_COUNT = FUNCTION_TO_VARIABLE_RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToStateVariableRelationImpl <em>Function To State Variable Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToStateVariableRelationImpl
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToStateVariableRelation()
	 * @generated
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION__ID = FUNCTION_TO_VARIABLE_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION__ENTITY_NAME = FUNCTION_TO_VARIABLE_RELATION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION__FUNCTION = FUNCTION_TO_VARIABLE_RELATION__FUNCTION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION__CONDITIONS = FUNCTION_TO_VARIABLE_RELATION__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION__VARIABLE = FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function To State Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION_FEATURE_COUNT = FUNCTION_TO_VARIABLE_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Function To State Variable Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TO_STATE_VARIABLE_RELATION_OPERATION_COUNT = FUNCTION_TO_VARIABLE_RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits <em>Time Units</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getTimeUnits()
	 * @generated
	 */
	int TIME_UNITS = 13;

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation <em>Function To Function Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function To Function Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation
	 * @generated
	 */
	EClass getFunctionToFunctionRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCaller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Caller</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCaller()
	 * @see #getFunctionToFunctionRelation()
	 * @generated
	 */
	EReference getFunctionToFunctionRelation_Caller();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCallee <em>Callee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Callee</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToFunctionRelation#getCallee()
	 * @see #getFunctionToFunctionRelation()
	 * @generated
	 */
	EReference getFunctionToFunctionRelation_Callee();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem <em>Access Control System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control System</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
	 * @generated
	 */
	EClass getAccessControlSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToVariableTuples <em>Role To Variable Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role To Variable Tuples</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToVariableTuples()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_RoleToVariableTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoles()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToFunctionTuples <em>Role To Function Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role To Function Tuples</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleToFunctionTuples()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_RoleToFunctionTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleExclusions <em>Role Exclusions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role Exclusions</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getRoleExclusions()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_RoleExclusions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToVariableTuples <em>Function To Variable Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function To Variable Tuples</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToVariableTuples()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_FunctionToVariableTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToFunctionTuples <em>Function To Function Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function To Function Tuples</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getFunctionToFunctionTuples()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_FunctionToFunctionTuples();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getVariableToVariableTuples <em>Variable To Variable Tuples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable To Variable Tuples</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem#getVariableToVariableTuples()
	 * @see #getAccessControlSystem()
	 * @generated
	 */
	EReference getAccessControlSystem_VariableToVariableTuples();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation <em>Variable To Variable Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable To Variable Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation
	 * @generated
	 */
	EClass getVariableToVariableRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluencer <em>Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Influencer</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluencer()
	 * @see #getVariableToVariableRelation()
	 * @generated
	 */
	EReference getVariableToVariableRelation_Influencer();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluenced <em>Influenced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Influenced</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.VariableToVariableRelation#getInfluenced()
	 * @see #getVariableToVariableRelation()
	 * @generated
	 */
	EReference getVariableToVariableRelation_Influenced();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation <em>Function To Variable Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function To Variable Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation
	 * @generated
	 */
	EClass getFunctionToVariableRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation#getFunction()
	 * @see #getFunctionToVariableRelation()
	 * @generated
	 */
	EReference getFunctionToVariableRelation_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToVariableRelation#getConditions()
	 * @see #getFunctionToVariableRelation()
	 * @generated
	 */
	EReference getFunctionToVariableRelation_Conditions();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation <em>Role To Function Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role To Function Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation
	 * @generated
	 */
	EClass getRoleToFunctionRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getFunction()
	 * @see #getRoleToFunctionRelation()
	 * @generated
	 */
	EReference getRoleToFunctionRelation_Function();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getRole()
	 * @see #getRoleToFunctionRelation()
	 * @generated
	 */
	EReference getRoleToFunctionRelation_Role();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation#getConditions()
	 * @see #getRoleToFunctionRelation()
	 * @generated
	 */
	EReference getRoleToFunctionRelation_Conditions();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getDescription()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Description();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getCardinality()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Cardinality();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getPrerequisite <em>Prerequisite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Prerequisite</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getPrerequisite()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Prerequisite();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getSuperior <em>Superior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Superior</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role#getSuperior()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Superior();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation <em>Role To Variable Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role To Variable Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation
	 * @generated
	 */
	EClass getRoleToVariableRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#getVariable()
	 * @see #getRoleToVariableRelation()
	 * @generated
	 */
	EReference getRoleToVariableRelation_Variable();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Role</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#getRole()
	 * @see #getRoleToVariableRelation()
	 * @generated
	 */
	EReference getRoleToVariableRelation_Role();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#isModifies <em>Modifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifies</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation#isModifies()
	 * @see #getRoleToVariableRelation()
	 * @generated
	 */
	EAttribute getRoleToVariableRelation_Modifies();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion <em>Mutual Role Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutual Role Exclusion</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion
	 * @generated
	 */
	EClass getMutualRoleExclusion();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.MutualRoleExclusion#getRoles()
	 * @see #getMutualRoleExclusion()
	 * @generated
	 */
	EReference getMutualRoleExclusion_Roles();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext <em>Time Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Context</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext
	 * @generated
	 */
	EClass getTimeContext();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#isIsUpperBound <em>Is Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Upper Bound</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#isIsUpperBound()
	 * @see #getTimeContext()
	 * @generated
	 */
	EAttribute getTimeContext_IsUpperBound();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeValue <em>Time Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Value</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeValue()
	 * @see #getTimeContext()
	 * @generated
	 */
	EAttribute getTimeContext_TimeValue();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Unit</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext#getTimeUnit()
	 * @see #getTimeContext()
	 * @generated
	 */
	EAttribute getTimeContext_TimeUnit();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext <em>Boolean Variable Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Variable Context</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext
	 * @generated
	 */
	EClass getBooleanVariableContext();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#getVariable()
	 * @see #getBooleanVariableContext()
	 * @generated
	 */
	EReference getBooleanVariableContext_Variable();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#isValueToCheck <em>Value To Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value To Check</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext#isValueToCheck()
	 * @see #getBooleanVariableContext()
	 * @generated
	 */
	EAttribute getBooleanVariableContext_ValueToCheck();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation <em>Function To Csm Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function To Csm Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation
	 * @generated
	 */
	EClass getFunctionToCsmRelation();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#isAccessWholeMapping <em>Access Whole Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Whole Mapping</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#isAccessWholeMapping()
	 * @see #getFunctionToCsmRelation()
	 * @generated
	 */
	EAttribute getFunctionToCsmRelation_AccessWholeMapping();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#getCsm <em>Csm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Csm</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToCsmRelation#getCsm()
	 * @see #getFunctionToCsmRelation()
	 * @generated
	 */
	EReference getFunctionToCsmRelation_Csm();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation <em>Function To State Variable Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function To State Variable Relation</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation
	 * @generated
	 */
	EClass getFunctionToStateVariableRelation();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.FunctionToStateVariableRelation#getVariable()
	 * @see #getFunctionToStateVariableRelation()
	 * @generated
	 */
	EReference getFunctionToStateVariableRelation_Variable();

	/**
	 * Returns the meta object for enum '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits <em>Time Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Units</em>'.
	 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
	 * @generated
	 */
	EEnum getTimeUnits();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AccessControlSystemFactory getAccessControlSystemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToFunctionRelationImpl <em>Function To Function Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToFunctionRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToFunctionRelation()
		 * @generated
		 */
		EClass FUNCTION_TO_FUNCTION_RELATION = eINSTANCE.getFunctionToFunctionRelation();

		/**
		 * The meta object literal for the '<em><b>Caller</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_FUNCTION_RELATION__CALLER = eINSTANCE.getFunctionToFunctionRelation_Caller();

		/**
		 * The meta object literal for the '<em><b>Callee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_FUNCTION_RELATION__CALLEE = eINSTANCE.getFunctionToFunctionRelation_Callee();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl <em>Access Control System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getAccessControlSystem()
		 * @generated
		 */
		EClass ACCESS_CONTROL_SYSTEM = eINSTANCE.getAccessControlSystem();

		/**
		 * The meta object literal for the '<em><b>Role To Variable Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__ROLE_TO_VARIABLE_TUPLES = eINSTANCE
				.getAccessControlSystem_RoleToVariableTuples();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__ROLES = eINSTANCE.getAccessControlSystem_Roles();

		/**
		 * The meta object literal for the '<em><b>Role To Function Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__ROLE_TO_FUNCTION_TUPLES = eINSTANCE
				.getAccessControlSystem_RoleToFunctionTuples();

		/**
		 * The meta object literal for the '<em><b>Role Exclusions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__ROLE_EXCLUSIONS = eINSTANCE.getAccessControlSystem_RoleExclusions();

		/**
		 * The meta object literal for the '<em><b>Function To Variable Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__FUNCTION_TO_VARIABLE_TUPLES = eINSTANCE
				.getAccessControlSystem_FunctionToVariableTuples();

		/**
		 * The meta object literal for the '<em><b>Function To Function Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__FUNCTION_TO_FUNCTION_TUPLES = eINSTANCE
				.getAccessControlSystem_FunctionToFunctionTuples();

		/**
		 * The meta object literal for the '<em><b>Variable To Variable Tuples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_CONTROL_SYSTEM__VARIABLE_TO_VARIABLE_TUPLES = eINSTANCE
				.getAccessControlSystem_VariableToVariableTuples();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl <em>Variable To Variable Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.VariableToVariableRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getVariableToVariableRelation()
		 * @generated
		 */
		EClass VARIABLE_TO_VARIABLE_RELATION = eINSTANCE.getVariableToVariableRelation();

		/**
		 * The meta object literal for the '<em><b>Influencer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TO_VARIABLE_RELATION__INFLUENCER = eINSTANCE.getVariableToVariableRelation_Influencer();

		/**
		 * The meta object literal for the '<em><b>Influenced</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TO_VARIABLE_RELATION__INFLUENCED = eINSTANCE.getVariableToVariableRelation_Influenced();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl <em>Function To Variable Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToVariableRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToVariableRelation()
		 * @generated
		 */
		EClass FUNCTION_TO_VARIABLE_RELATION = eINSTANCE.getFunctionToVariableRelation();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_VARIABLE_RELATION__FUNCTION = eINSTANCE.getFunctionToVariableRelation_Function();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_VARIABLE_RELATION__CONDITIONS = eINSTANCE.getFunctionToVariableRelation_Conditions();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToFunctionRelationImpl <em>Role To Function Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToFunctionRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRoleToFunctionRelation()
		 * @generated
		 */
		EClass ROLE_TO_FUNCTION_RELATION = eINSTANCE.getRoleToFunctionRelation();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_FUNCTION_RELATION__FUNCTION = eINSTANCE.getRoleToFunctionRelation_Function();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_FUNCTION_RELATION__ROLE = eINSTANCE.getRoleToFunctionRelation_Role();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_FUNCTION_RELATION__CONDITIONS = eINSTANCE.getRoleToFunctionRelation_Conditions();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__DESCRIPTION = eINSTANCE.getRole_Description();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__CARDINALITY = eINSTANCE.getRole_Cardinality();

		/**
		 * The meta object literal for the '<em><b>Prerequisite</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__PREREQUISITE = eINSTANCE.getRole_Prerequisite();

		/**
		 * The meta object literal for the '<em><b>Superior</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__SUPERIOR = eINSTANCE.getRole_Superior();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToVariableRelationImpl <em>Role To Variable Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.RoleToVariableRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getRoleToVariableRelation()
		 * @generated
		 */
		EClass ROLE_TO_VARIABLE_RELATION = eINSTANCE.getRoleToVariableRelation();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_VARIABLE_RELATION__VARIABLE = eINSTANCE.getRoleToVariableRelation_Variable();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_TO_VARIABLE_RELATION__ROLE = eINSTANCE.getRoleToVariableRelation_Role();

		/**
		 * The meta object literal for the '<em><b>Modifies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_TO_VARIABLE_RELATION__MODIFIES = eINSTANCE.getRoleToVariableRelation_Modifies();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.MutualRoleExclusionImpl <em>Mutual Role Exclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.MutualRoleExclusionImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getMutualRoleExclusion()
		 * @generated
		 */
		EClass MUTUAL_ROLE_EXCLUSION = eINSTANCE.getMutualRoleExclusion();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTUAL_ROLE_EXCLUSION__ROLES = eINSTANCE.getMutualRoleExclusion_Roles();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.ContextImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl <em>Time Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.TimeContextImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getTimeContext()
		 * @generated
		 */
		EClass TIME_CONTEXT = eINSTANCE.getTimeContext();

		/**
		 * The meta object literal for the '<em><b>Is Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONTEXT__IS_UPPER_BOUND = eINSTANCE.getTimeContext_IsUpperBound();

		/**
		 * The meta object literal for the '<em><b>Time Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONTEXT__TIME_VALUE = eINSTANCE.getTimeContext_TimeValue();

		/**
		 * The meta object literal for the '<em><b>Time Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONTEXT__TIME_UNIT = eINSTANCE.getTimeContext_TimeUnit();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl <em>Boolean Variable Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.BooleanVariableContextImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getBooleanVariableContext()
		 * @generated
		 */
		EClass BOOLEAN_VARIABLE_CONTEXT = eINSTANCE.getBooleanVariableContext();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_VARIABLE_CONTEXT__VARIABLE = eINSTANCE.getBooleanVariableContext_Variable();

		/**
		 * The meta object literal for the '<em><b>Value To Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VARIABLE_CONTEXT__VALUE_TO_CHECK = eINSTANCE.getBooleanVariableContext_ValueToCheck();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl <em>Function To Csm Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToCsmRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToCsmRelation()
		 * @generated
		 */
		EClass FUNCTION_TO_CSM_RELATION = eINSTANCE.getFunctionToCsmRelation();

		/**
		 * The meta object literal for the '<em><b>Access Whole Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_TO_CSM_RELATION__ACCESS_WHOLE_MAPPING = eINSTANCE
				.getFunctionToCsmRelation_AccessWholeMapping();

		/**
		 * The meta object literal for the '<em><b>Csm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_CSM_RELATION__CSM = eINSTANCE.getFunctionToCsmRelation_Csm();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToStateVariableRelationImpl <em>Function To State Variable Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.FunctionToStateVariableRelationImpl
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getFunctionToStateVariableRelation()
		 * @generated
		 */
		EClass FUNCTION_TO_STATE_VARIABLE_RELATION = eINSTANCE.getFunctionToStateVariableRelation();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_TO_STATE_VARIABLE_RELATION__VARIABLE = eINSTANCE
				.getFunctionToStateVariableRelation_Variable();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits <em>Time Units</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeUnits
		 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemPackageImpl#getTimeUnits()
		 * @generated
		 */
		EEnum TIME_UNITS = eINSTANCE.getTimeUnits();

	}

} //AccessControlSystemPackage
