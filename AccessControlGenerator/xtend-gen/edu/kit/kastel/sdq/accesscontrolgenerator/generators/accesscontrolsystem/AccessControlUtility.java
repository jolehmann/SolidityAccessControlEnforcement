package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

/**
 * Utility class to provide additional functionality regarding access control
 */
@SuppressWarnings("all")
public class AccessControlUtility {
  private AccessControlUtility() {
  }
  
  /**
   * Checks for the given smart contract and given access control system if the contract needs to import and
   * use the resulting access control contract. This is the case when any role can access a function from the contract.
   * @param system - AccessControlSystem to check for connections
   * @param toCheck - AccessControlContract to check for access control need
   * @returns true when reference to access control contract is needed
   */
  public static boolean checkIfAccessControlContractNeeded(final AccessControlSystem system, final AccessControlContract toCheck) {
    if (((system == null) || (toCheck == null))) {
      return false;
    }
    if ((system.getRoleToFunctionTuples().isEmpty() || 
      IterableExtensions.isEmpty(IterableExtensions.<RoleToFunctionRelation>filter(system.getRoleToFunctionTuples(), new Function1<RoleToFunctionRelation, Boolean>() {
        public Boolean apply(final RoleToFunctionRelation rf) {
          return Boolean.valueOf(toCheck.getFunctions().contains(rf.getFunction()));
        }
      })))) {
      return false;
    }
    return true;
  }
  
  /**
   * Takes the given class, which is a generated implementation class from the EMF and
   * removes the 'Impl' ending, resulting in the element name from the AccessControlMetamodel
   */
  public static String removeImplClassEnding(final Class<?> cls) {
    return cls.getSimpleName().replace("Impl", "");
  }
  
  /**
   * Tries to cast the given EObject to a NamedElement from the Metamodel-Modeling-Foundation:
   * https://github.com/MDSD-Tools/Metamodel-Modeling-Foundations
   * If the cast is possible, its entityName is returned. Otherwise, the object is cast to a string directly.
   * If the given object is null, an empty string is returned
   */
  public static String getEntityNameForEObject(final EObject obj) {
    if ((obj == null)) {
      return "";
    }
    try {
      final NamedElement casted = NamedElement.class.cast(obj);
      return casted.getEntityName();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ex.printStackTrace();
        return obj.toString();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
