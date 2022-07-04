package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import com.google.common.collect.Iterables;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.BooleanVariableContext;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToFunctionRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.TimeContext;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class used to help handling roles and the context conditions defined for a single function
 */
@SuppressWarnings("all")
public class ModifierRoleAndConditionsHelper {
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private Set<Role> roles;
  
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private Set<BooleanVariableContext> boolConditions;
  
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private Set<TimeContext> timeConditions;
  
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private Dictionary<Role, Iterable<BooleanVariableContext>> boolCondsForRole;
  
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private Dictionary<Role, Iterable<TimeContext>> timeCondsForRole;
  
  @Accessors({ AccessorType.PRIVATE_SETTER, AccessorType.PUBLIC_GETTER })
  private boolean hasConditions;
  
  private AccessControlSystem acSystem;
  
  /**
   * Constructor to create the instance and fill the lists with the fitting elements.
   */
  public ModifierRoleAndConditionsHelper(final AccessControlSystem acSystem) {
    if ((acSystem == null)) {
      return;
    }
    this.acSystem = acSystem;
  }
  
  /**
   * Fills the different lists containing conditions and roles for the given Function
   * using the internal AccessControlSystem
   */
  public void extractConditionsForFunction(final Function func) {
    if (((func == null) || (this.acSystem == null))) {
      return;
    }
    HashSet<Role> _hashSet = new HashSet<Role>();
    this.roles = _hashSet;
    HashSet<BooleanVariableContext> _hashSet_1 = new HashSet<BooleanVariableContext>();
    this.boolConditions = _hashSet_1;
    HashSet<TimeContext> _hashSet_2 = new HashSet<TimeContext>();
    this.timeConditions = _hashSet_2;
    Hashtable<Role, Iterable<BooleanVariableContext>> _hashtable = new Hashtable<Role, Iterable<BooleanVariableContext>>();
    this.boolCondsForRole = _hashtable;
    Hashtable<Role, Iterable<TimeContext>> _hashtable_1 = new Hashtable<Role, Iterable<TimeContext>>();
    this.timeCondsForRole = _hashtable_1;
    final Function1<RoleToFunctionRelation, Boolean> _function = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation rf) {
        return Boolean.valueOf(rf.getFunction().equals(func));
      }
    };
    final Function1<RoleToFunctionRelation, Role> _function_1 = new Function1<RoleToFunctionRelation, Role>() {
      public Role apply(final RoleToFunctionRelation rf) {
        return rf.getRole();
      }
    };
    final Function1<Role, String> _function_2 = new Function1<Role, String>() {
      public String apply(final Role r) {
        return r.getEntityName();
      }
    };
    this.roles.addAll(IterableExtensions.<Role, String>sortBy(IterableExtensions.<RoleToFunctionRelation, Role>map(IterableExtensions.<RoleToFunctionRelation>filter(this.acSystem.getRoleToFunctionTuples(), _function), _function_1), _function_2));
    final Function1<RoleToFunctionRelation, Boolean> _function_3 = new Function1<RoleToFunctionRelation, Boolean>() {
      public Boolean apply(final RoleToFunctionRelation rf) {
        return Boolean.valueOf(rf.getFunction().equals(func));
      }
    };
    Iterable<RoleToFunctionRelation> _filter = IterableExtensions.<RoleToFunctionRelation>filter(this.acSystem.getRoleToFunctionTuples(), _function_3);
    for (final RoleToFunctionRelation rToF : _filter) {
      {
        Iterable<BooleanVariableContext> bools = Iterables.<BooleanVariableContext>filter(rToF.getConditions(), BooleanVariableContext.class);
        Iterables.<BooleanVariableContext>addAll(this.boolConditions, bools);
        this.boolCondsForRole.put(rToF.getRole(), bools);
        Iterable<TimeContext> time = Iterables.<TimeContext>filter(rToF.getConditions(), TimeContext.class);
        Iterables.<TimeContext>addAll(this.timeConditions, time);
        this.timeCondsForRole.put(rToF.getRole(), time);
      }
    }
    this.hasConditions = ((!this.boolConditions.isEmpty()) || (!this.timeConditions.isEmpty()));
  }
  
  @Pure
  public Set<Role> getRoles() {
    return this.roles;
  }
  
  private void setRoles(final Set<Role> roles) {
    this.roles = roles;
  }
  
  @Pure
  public Set<BooleanVariableContext> getBoolConditions() {
    return this.boolConditions;
  }
  
  private void setBoolConditions(final Set<BooleanVariableContext> boolConditions) {
    this.boolConditions = boolConditions;
  }
  
  @Pure
  public Set<TimeContext> getTimeConditions() {
    return this.timeConditions;
  }
  
  private void setTimeConditions(final Set<TimeContext> timeConditions) {
    this.timeConditions = timeConditions;
  }
  
  @Pure
  public Dictionary<Role, Iterable<BooleanVariableContext>> getBoolCondsForRole() {
    return this.boolCondsForRole;
  }
  
  private void setBoolCondsForRole(final Dictionary<Role, Iterable<BooleanVariableContext>> boolCondsForRole) {
    this.boolCondsForRole = boolCondsForRole;
  }
  
  @Pure
  public Dictionary<Role, Iterable<TimeContext>> getTimeCondsForRole() {
    return this.timeCondsForRole;
  }
  
  private void setTimeCondsForRole(final Dictionary<Role, Iterable<TimeContext>> timeCondsForRole) {
    this.timeCondsForRole = timeCondsForRole;
  }
  
  @Pure
  public boolean isHasConditions() {
    return this.hasConditions;
  }
  
  private void setHasConditions(final boolean hasConditions) {
    this.hasConditions = hasConditions;
  }
}
