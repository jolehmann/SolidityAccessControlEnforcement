/**
 */
package edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.util;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.mdsd.modelingfoundations.identifier.Entity;
import tools.mdsd.modelingfoundations.identifier.Identifier;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage
 * @generated
 */
public class AccessControlSystemSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AccessControlSystemPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlSystemSwitch() {
		if (modelPackage == null) {
			modelPackage = AccessControlSystemPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case AccessControlSystemPackage.FUNCTION_TO_FUNCTION_RELATION: {
			FunctionToFunctionRelation functionToFunctionRelation = (FunctionToFunctionRelation) theEObject;
			T result = caseFunctionToFunctionRelation(functionToFunctionRelation);
			if (result == null)
				result = caseEntity(functionToFunctionRelation);
			if (result == null)
				result = caseIdentifier(functionToFunctionRelation);
			if (result == null)
				result = caseNamedElement(functionToFunctionRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.ACCESS_CONTROL_SYSTEM: {
			AccessControlSystem accessControlSystem = (AccessControlSystem) theEObject;
			T result = caseAccessControlSystem(accessControlSystem);
			if (result == null)
				result = caseEntity(accessControlSystem);
			if (result == null)
				result = caseIdentifier(accessControlSystem);
			if (result == null)
				result = caseNamedElement(accessControlSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.VARIABLE_TO_VARIABLE_RELATION: {
			VariableToVariableRelation variableToVariableRelation = (VariableToVariableRelation) theEObject;
			T result = caseVariableToVariableRelation(variableToVariableRelation);
			if (result == null)
				result = caseEntity(variableToVariableRelation);
			if (result == null)
				result = caseIdentifier(variableToVariableRelation);
			if (result == null)
				result = caseNamedElement(variableToVariableRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.FUNCTION_TO_VARIABLE_RELATION: {
			FunctionToVariableRelation functionToVariableRelation = (FunctionToVariableRelation) theEObject;
			T result = caseFunctionToVariableRelation(functionToVariableRelation);
			if (result == null)
				result = caseEntity(functionToVariableRelation);
			if (result == null)
				result = caseIdentifier(functionToVariableRelation);
			if (result == null)
				result = caseNamedElement(functionToVariableRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.ROLE_TO_FUNCTION_RELATION: {
			RoleToFunctionRelation roleToFunctionRelation = (RoleToFunctionRelation) theEObject;
			T result = caseRoleToFunctionRelation(roleToFunctionRelation);
			if (result == null)
				result = caseEntity(roleToFunctionRelation);
			if (result == null)
				result = caseIdentifier(roleToFunctionRelation);
			if (result == null)
				result = caseNamedElement(roleToFunctionRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.ROLE: {
			Role role = (Role) theEObject;
			T result = caseRole(role);
			if (result == null)
				result = caseEntity(role);
			if (result == null)
				result = caseIdentifier(role);
			if (result == null)
				result = caseNamedElement(role);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.ROLE_TO_VARIABLE_RELATION: {
			RoleToVariableRelation roleToVariableRelation = (RoleToVariableRelation) theEObject;
			T result = caseRoleToVariableRelation(roleToVariableRelation);
			if (result == null)
				result = caseEntity(roleToVariableRelation);
			if (result == null)
				result = caseIdentifier(roleToVariableRelation);
			if (result == null)
				result = caseNamedElement(roleToVariableRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.MUTUAL_ROLE_EXCLUSION: {
			MutualRoleExclusion mutualRoleExclusion = (MutualRoleExclusion) theEObject;
			T result = caseMutualRoleExclusion(mutualRoleExclusion);
			if (result == null)
				result = caseEntity(mutualRoleExclusion);
			if (result == null)
				result = caseIdentifier(mutualRoleExclusion);
			if (result == null)
				result = caseNamedElement(mutualRoleExclusion);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.CONTEXT: {
			Context context = (Context) theEObject;
			T result = caseContext(context);
			if (result == null)
				result = caseIdentifier(context);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.TIME_CONTEXT: {
			TimeContext timeContext = (TimeContext) theEObject;
			T result = caseTimeContext(timeContext);
			if (result == null)
				result = caseContext(timeContext);
			if (result == null)
				result = caseIdentifier(timeContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.BOOLEAN_VARIABLE_CONTEXT: {
			BooleanVariableContext booleanVariableContext = (BooleanVariableContext) theEObject;
			T result = caseBooleanVariableContext(booleanVariableContext);
			if (result == null)
				result = caseContext(booleanVariableContext);
			if (result == null)
				result = caseIdentifier(booleanVariableContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.FUNCTION_TO_CSM_RELATION: {
			FunctionToCsmRelation functionToCsmRelation = (FunctionToCsmRelation) theEObject;
			T result = caseFunctionToCsmRelation(functionToCsmRelation);
			if (result == null)
				result = caseFunctionToVariableRelation(functionToCsmRelation);
			if (result == null)
				result = caseEntity(functionToCsmRelation);
			if (result == null)
				result = caseIdentifier(functionToCsmRelation);
			if (result == null)
				result = caseNamedElement(functionToCsmRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case AccessControlSystemPackage.FUNCTION_TO_STATE_VARIABLE_RELATION: {
			FunctionToStateVariableRelation functionToStateVariableRelation = (FunctionToStateVariableRelation) theEObject;
			T result = caseFunctionToStateVariableRelation(functionToStateVariableRelation);
			if (result == null)
				result = caseFunctionToVariableRelation(functionToStateVariableRelation);
			if (result == null)
				result = caseEntity(functionToStateVariableRelation);
			if (result == null)
				result = caseIdentifier(functionToStateVariableRelation);
			if (result == null)
				result = caseNamedElement(functionToStateVariableRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function To Function Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function To Function Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionToFunctionRelation(FunctionToFunctionRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Control System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Control System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessControlSystem(AccessControlSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable To Variable Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableToVariableRelation(VariableToVariableRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function To Variable Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionToVariableRelation(FunctionToVariableRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role To Function Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role To Function Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleToFunctionRelation(RoleToFunctionRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role To Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role To Variable Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleToVariableRelation(RoleToVariableRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutual Role Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutual Role Exclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutualRoleExclusion(MutualRoleExclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeContext(TimeContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Variable Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Variable Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanVariableContext(BooleanVariableContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function To Csm Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function To Csm Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionToCsmRelation(FunctionToCsmRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function To State Variable Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function To State Variable Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionToStateVariableRelation(FunctionToStateVariableRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AccessControlSystemSwitch
