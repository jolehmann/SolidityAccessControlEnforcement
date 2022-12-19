package edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Utility class to collect all constant strings needed throughout the Solidity code generation
 * for everything related to access control
 */
@SuppressWarnings("all")
public class AccessControlConstants {
  private AccessControlConstants() {
  }

  public static String getAccessControlContactName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AccessControlContract");
    return _builder.toString();
  }

  public static String getAccessControlVariableName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("accCtrl");
    return _builder.toString();
  }

  public static String getSolcVerifyModificationSpecifier() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/// @notice modifies");
    return _builder.toString();
  }

  public static String getMsgSenderKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("msg.sender");
    return _builder.toString();
  }

  public static String getThisAddressKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("address(this)");
    return _builder.toString();
  }

  /**
   * Returning the enum Value for the given role object by replacing empty spaces with _
   * and converting it all to upper case.
   * @param role - Role with name to convert
   * @returns enum value for the given role
   */
  public static String getRoleEnumValueForRole(final Role role) {
    String name = role.getEntityName().replaceAll(" ", "_");
    return name.toUpperCase();
  }

  public static String getRolesEnumName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Roles");
    return _builder.toString();
  }

  public static String getAccessCheckingFunctionName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("checkAccess");
    return _builder.toString();
  }

  public static String getTimingCheckFunctionName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("checkTiming");
    return _builder.toString();
  }

  public static String getAccessControlRequiresMessage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Access denied due to missing role!");
    return _builder.toString();
  }

  public static String getCounterMimimumRequiresMessage(final String role) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("There needs to be at least one ");
    _builder.append(role);
    _builder.append(" before any role can be removed.");
    return _builder.toString();
  }

  public static String getCounterMaximumRequiresMessage(final int amount, final String role) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("There are already ");
    String _string = Integer.valueOf(amount).toString();
    _builder.append(_string);
    _builder.append(" ");
    _builder.append(role);
    _builder.append("(s).");
    return _builder.toString();
  }

  public static String getPrerequisiteRequiresMessage(final String role) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The address needs to be a ");
    _builder.append(role);
    _builder.append(" as well.");
    return _builder.toString();
  }

  public static String getMutualExclusionRequiresMessage(final String role) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The address cannot be a ");
    _builder.append(role);
    _builder.append(" as well.");
    return _builder.toString();
  }
}
