package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract;

import com.google.common.collect.Iterables;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlUtility;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AnnotationGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.ModifierGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates.SolidityContractGenerationTemplate;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Constructor;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ConstructorParameter;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Contract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ContractType;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.EnumMember;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Event;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.EventParameter;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.FunctionParameter;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Modifier;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ModifierParameter;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ReturnVariable;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Struct;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StructMember;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Type;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generator to create a Solidity smart contract from a smart contract model using the contract template
 */
@SuppressWarnings("all")
public class SolidityContractGenerator extends SolidityContractGenerationTemplate {
  @Accessors(AccessorType.PRIVATE_GETTER)
  private boolean currentTargetNeedsAc;

  @Accessors(AccessorType.PRIVATE_GETTER)
  private AccessControlContract currentTarget;

  @Accessors(AccessorType.PRIVATE_GETTER)
  private AccessControlSystem acSystem;

  @Accessors(AccessorType.PRIVATE_GETTER)
  private AnnotationGenerator annotationGenerator;

  @Accessors(AccessorType.PRIVATE_GETTER)
  private ModifierGenerator modifierGenerator;

  @Accessors(AccessorType.PRIVATE_GETTER)
  private SolidityFunctionGenerator functionGenerator;

  private String roleAnnotations;

  /**
   * Constructor creating the necessary sub-generators
   */
  public SolidityContractGenerator(final AccessControlSystem acSystem) {
    ModifierGenerator _modifierGenerator = new ModifierGenerator(acSystem);
    this.modifierGenerator = _modifierGenerator;
    AnnotationGenerator _annotationGenerator = new AnnotationGenerator(acSystem);
    this.annotationGenerator = _annotationGenerator;
    SolidityFunctionGenerator _solidityFunctionGenerator = new SolidityFunctionGenerator(this.annotationGenerator, this.modifierGenerator);
    this.functionGenerator = _solidityFunctionGenerator;
    this.acSystem = acSystem;
    this.roleAnnotations = "";
  }

  /**
   * Generating the import statements by iterating over all referenced contracts.
   * Additionally, the import for the AccessControl contract is added if necessary.
   */
  protected String generateImports() {
    final Set<ContractType> contractTypes = IterableExtensions.<ContractType>toSet(Iterables.<ContractType>filter(this.currentTarget.getLocalTypes(), ContractType.class));
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final ContractType type : contractTypes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        _builder.append("import \"./");
        String _targetFileNameForContract = SolidityNaming.getTargetFileNameForContract(type.getContract());
        _builder.append(_targetFileNameForContract);
        String _targetFileExt = SolidityConstants.getTargetFileExt();
        _builder.append(_targetFileExt);
        _builder.append("\";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<Contract> _parents = this.currentTarget.getParents();
      boolean _hasElements_1 = false;
      for(final Contract contract : _parents) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          String _lineSeparator_1 = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator_1, "");
        }
        _builder.append("import \"./");
        String _targetFileNameForContract_1 = SolidityNaming.getTargetFileNameForContract(contract);
        _builder.append(_targetFileNameForContract_1);
        String _targetFileExt_1 = SolidityConstants.getTargetFileExt();
        _builder.append(_targetFileExt_1);
        _builder.append("\";");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if (this.currentTargetNeedsAc) {
        _builder.append("import \"./");
        String _accessControlContactName = AccessControlConstants.getAccessControlContactName();
        _builder.append(_accessControlContactName);
        String _targetFileExt_2 = SolidityConstants.getTargetFileExt();
        _builder.append(_targetFileExt_2);
        _builder.append("\";");
      }
    }
    return _builder.toString();
  }

  /**
   * Generating the declaration of the contract with its name and references to its parents
   */
  protected String generateDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("contract ");
    String _entityName = this.currentTarget.getEntityName();
    _builder.append(_entityName);
    {
      EList<Contract> _parents = this.currentTarget.getParents();
      boolean _hasElements = false;
      for(final Contract parent : _parents) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(" is ");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _entityName_1 = parent.getEntityName();
        _builder.append(_entityName_1);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates all enums defined in the contract model.
   * Implementation taken from SolidityCodeGenerator.
   */
  protected String generateEnums() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum> _usedEnumsForCurrentTarget = this.getUsedEnumsForCurrentTarget();
      boolean _hasElements = false;
      for(final edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum en : _usedEnumsForCurrentTarget) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        String _generateEnumDefinition = this.generateEnumDefinition(en);
        _builder.append(_generateEnumDefinition);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates all structs defined in the contract model.
   * Implementation taken from SolidityCodeGenerator.
   */
  protected String generateStructs() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<Struct> _usedStructsForCurrentTarget = this.getUsedStructsForCurrentTarget();
      boolean _hasElements = false;
      for(final Struct struct : _usedStructsForCurrentTarget) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        String _generateStructDefinition = this.generateStructDefinition(struct);
        _builder.append(_generateStructDefinition);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates the state variables of the contract by combining the state variables from the model
   * with the ones needed for the access control.
   */
  protected String generateFields() {
    String _generateFieldForAccessControl = this.generateFieldForAccessControl();
    String _generateFieldsForStateVariables = this.generateFieldsForStateVariables();
    final List<String> fields = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_generateFieldForAccessControl, _generateFieldsForStateVariables));
    return String.join(System.lineSeparator(), fields);
  }

  /**
   * Generates all events defined in the contract model.
   * Implementation taken from SolidityCodeGenerator.
   */
  protected String generateEvents() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Event> _events = this.currentTarget.getEvents();
      boolean _hasElements = false;
      for(final Event event : _events) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        String _generateEventDefinition = this.generateEventDefinition(event);
        _builder.append(_generateEventDefinition);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates the contracts constructor.
   * Implementation taken from SolidityCodeGenerator.
   */
  protected String generateConstructor() {
    final Constructor constructor = this.currentTarget.getConstructor();
    if ((constructor != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("constructor(");
      {
        EList<ConstructorParameter> _parameters = constructor.getParameters();
        boolean _hasElements = false;
        for(final ConstructorParameter param : _parameters) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _targetNameForType = SolidityNaming.getTargetNameForType(param.getType(), true);
          _builder.append(_targetNameForType);
          _builder.append(" ");
          String _firstLower = StringExtensions.toFirstLower(param.getName().replace(" ", ""));
          _builder.append(_firstLower);
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      {
        if (((constructor.getContent() == null) || constructor.getContent().isEmpty())) {
          _builder.append("//TODO: Auto-generated Constructor");
        } else {
          String _content = constructor.getContent();
          _builder.append(_content, "\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      return _builder.toString();
    } else {
      return "";
    }
  }

  /**
   * Generating the methods based on the functions from the model by using the FunctionGenerator
   */
  protected String generateMethods() {
    final EList<Function> functions = this.currentTarget.getFunctions();
    final String methodDefinitions = this.generateMethodDefinitions(functions).toString();
    return methodDefinitions;
  }

  /**
   * Generating the modifiers used for access control by using the ModifierGenerator as well as the ones
   * described in the model. Generating the ones from the model is taken from the SolidityCodeGenerator.
   */
  protected String generateModifiers() {
    final String acModifiers = this.modifierGenerator.generateAccessControlModifiers();
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Modifier> _modifiers = this.currentTarget.getModifiers();
      boolean _hasElements = false;
      for(final Modifier modifier : _modifiers) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        String _generateModifierDefinition = this.generateModifierDefinition(modifier);
        _builder.append(_generateModifierDefinition);
      }
    }
    final String modifiers = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(acModifiers);
    String _lineSeparator_1 = System.lineSeparator();
    _builder_1.append(_lineSeparator_1);
    _builder_1.append(modifiers);
    return _builder_1.toString();
  }

  /**
   * Sets the current contract to generate a solidity file for to the given one.
   * Also checks if it needs a reference to the AccessControl contract.
   */
  public void setCurrentTarget(final AccessControlContract contract) {
    this.currentTarget = contract;
    this.currentTargetNeedsAc = AccessControlUtility.checkIfAccessControlContractNeeded(this.acSystem, contract);
    this.annotationGenerator.setCurrentTarget(contract);
    this.modifierGenerator.setCurrentTarget(contract);
  }

  /**
   * Executes the generation of a method for the given function using the FunctionGenerator
   */
  protected String executeMethodGeneration(final Function function) {
    final String roles = this.annotationGenerator.generateRoleBrackets(function);
    StringConcatenation _builder = new StringConcatenation();
    String _replaceAll = StringExtensions.toFirstLower(function.getEntityName()).replaceAll(" ", "");
    _builder.append(_replaceAll);
    _builder.append(" ");
    _builder.append(roles);
    String _lineSeparator = System.lineSeparator();
    _builder.append(_lineSeparator);
    String _plus = (this.roleAnnotations + _builder);
    this.roleAnnotations = _plus;
    final String roleComments = this.annotationGenerator.generateRoleComments(function);
    this.functionGenerator.setCurrentTarget(function);
    String _lineSeparator_1 = System.lineSeparator();
    String _plus_1 = (roleComments + _lineSeparator_1);
    String _generate = this.functionGenerator.generate();
    return (_plus_1 + _generate);
  }

  /**
   * Generates a state variable referencing the AccessControl contract if necessary
   */
  private String generateFieldForAccessControl() {
    if (this.currentTargetNeedsAc) {
      StringConcatenation _builder = new StringConcatenation();
      String _accessControlContactName = AccessControlConstants.getAccessControlContactName();
      _builder.append(_accessControlContactName);
      _builder.append(" private ");
      String _accessControlVariableName = AccessControlConstants.getAccessControlVariableName();
      _builder.append(_accessControlVariableName);
      _builder.append(" = new ");
      String _accessControlContactName_1 = AccessControlConstants.getAccessControlContactName();
      _builder.append(_accessControlContactName_1);
      _builder.append("(");
      String _thisAddressKeyword = AccessControlConstants.getThisAddressKeyword();
      _builder.append(_thisAddressKeyword);
      _builder.append("); // Auto-generated Field");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    } else {
      return "";
    }
  }

  /**
   * Generates the variables based on all state variables defined in the model.
   * For each variable, a comment summarizing the roles that can access it is generated before its declaration.
   */
  private String generateFieldsForStateVariables() {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<StateVariable> _variables = this.currentTarget.getVariables();
      boolean _hasElements = false;
      for(final StateVariable variable : _variables) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "");
        }
        String _replaceAll = StringExtensions.toFirstLower(variable.getEntityName()).replaceAll(" ", "");
        _builder.append(_replaceAll);
        _builder.append(" ");
        String _generateRoleBrackets = this.annotationGenerator.generateRoleBrackets(variable);
        _builder.append(_generateRoleBrackets);
      }
    }
    String variablesWithRoles = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(variablesWithRoles);
    String _lineSeparator_1 = System.lineSeparator();
    _builder_1.append(_lineSeparator_1);
    String _plus = (this.roleAnnotations + _builder_1);
    this.roleAnnotations = _plus;
    StringConcatenation _builder_2 = new StringConcatenation();
    {
      EList<StateVariable> _variables_1 = this.currentTarget.getVariables();
      boolean _hasElements_1 = false;
      for(final StateVariable variable_1 : _variables_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          String _lineSeparator_2 = System.lineSeparator();
          _builder_2.appendImmediate(_lineSeparator_2, "");
        }
        _builder_2.newLineIfNotEmpty();
        String _generateRoleComments = this.annotationGenerator.generateRoleComments(variable_1);
        _builder_2.append(_generateRoleComments);
        _builder_2.newLineIfNotEmpty();
        String _targetNameForType = SolidityNaming.getTargetNameForType(variable_1.getType(), false);
        _builder_2.append(_targetNameForType);
        _builder_2.append(" ");
        String _targetNameForVariableVisibility = SolidityNaming.getTargetNameForVariableVisibility(variable_1.getVisibility());
        _builder_2.append(_targetNameForVariableVisibility);
        _builder_2.append(" ");
        String _targetNameForVariableMutability = SolidityNaming.getTargetNameForVariableMutability(variable_1.getMutability());
        _builder_2.append(_targetNameForVariableMutability);
        _builder_2.append(" ");
        String _replaceAll_1 = StringExtensions.toFirstLower(variable_1.getEntityName()).replaceAll(" ", "");
        _builder_2.append(_replaceAll_1);
        _builder_2.append("; // Auto-generated Field");
        _builder_2.newLineIfNotEmpty();
      }
    }
    String variables = _builder_2.toString();
    return SolidityNaming.normalizeSpaces(variables);
  }

  /**
   * Describes the general structure of methods that need to be generated for the given list of functions.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateMethodDefinitions(final Iterable<Function> functions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Function function : functions) {
        String _executeMethodGeneration = this.executeMethodGeneration(function);
        _builder.append(_executeMethodGeneration);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    return _builder.toString();
  }

  /**
   * Creates a single enum in solidity code from the given enum object.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateEnumDefinition(final edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum en) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    String _replaceAll = en.getEntityName().replaceAll(" ", "");
    _builder.append(_replaceAll);
    _builder.append(" {");
    {
      EList<EnumMember> _members = en.getMembers();
      boolean _hasElements = false;
      for(final EnumMember member : _members) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(" ");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _value = member.getValue();
        _builder.append(_value);
      }
      if (_hasElements) {
        _builder.append(" ");
      }
    }
    _builder.append("}");
    return _builder.toString();
  }

  /**
   * Collects the enums used in the contract before generating a solidity enum for each.
   * This function is taken from the SolidityCodeGenerator.
   */
  private Iterable<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum> getUsedEnumsForCurrentTarget() {
    final Iterable<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum> localEnums = Iterables.<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum>filter(this.currentTarget.getLocalTypes(), edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum.class);
    final Iterable<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum> usedGlobalEnums = Iterables.<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum>filter(this.getAllUsedTypesForCurrentTarget(), edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum.class);
    return IterableExtensions.<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum>toSet(Iterables.<edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum>concat(localEnums, usedGlobalEnums));
  }

  /**
   * Creates the given event from the metamodel.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateEventDefinition(final Event event) {
    String _xifexpression = null;
    boolean _isAnonymous = event.isAnonymous();
    if (_isAnonymous) {
      _xifexpression = " anonymous";
    } else {
      _xifexpression = "";
    }
    final String anonymous = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("event ");
    String _replace = event.getEntityName().replace(" ", "");
    _builder.append(_replace);
    _builder.append("(");
    {
      EList<EventParameter> _parameters = event.getParameters();
      boolean _hasElements = false;
      for(final EventParameter param : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _targetNameForType = SolidityNaming.getTargetNameForType(param.getType(), false);
        _builder.append(_targetNameForType);
        _builder.append(" ");
        String _xifexpression_1 = null;
        boolean _isIndexed = param.isIndexed();
        if (_isIndexed) {
          _xifexpression_1 = "indexed ";
        } else {
          _xifexpression_1 = "";
        }
        _builder.append(_xifexpression_1);
        String _firstLower = StringExtensions.toFirstLower(param.getName().replaceAll(" ", ""));
        _builder.append(_firstLower);
      }
    }
    _builder.append(")");
    _builder.append(anonymous);
    _builder.append(";");
    return _builder.toString();
  }

  /**
   * Creates a single struct in solidity code from the given struct object.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateStructDefinition(final Struct struct) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("struct ");
    String _replaceAll = struct.getEntityName().replaceAll(" ", "");
    _builder.append(_replaceAll);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<StructMember> _members = struct.getMembers();
      boolean _hasElements = false;
      for(final StructMember member : _members) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          String _lineSeparator = System.lineSeparator();
          _builder.appendImmediate(_lineSeparator, "\t");
        }
        String _targetNameForType = SolidityNaming.getTargetNameForType(member.getType(), false);
        _builder.append(_targetNameForType, "\t");
        _builder.append(" ");
        String _firstLower = StringExtensions.toFirstLower(member.getEntityName().replaceAll(" ", ""));
        _builder.append(_firstLower, "\t");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  /**
   * Collects the structs used in the contract before generating a solidity struct for each.
   * This function is taken from the SolidityCodeGenerator.
   */
  private Iterable<Struct> getUsedStructsForCurrentTarget() {
    final Iterable<Struct> localStructs = Iterables.<Struct>filter(this.currentTarget.getLocalTypes(), Struct.class);
    final Iterable<Struct> usedGlobalStructs = Iterables.<Struct>filter(this.getAllUsedTypesForCurrentTarget(), Struct.class);
    return IterableExtensions.<Struct>toSet(Iterables.<Struct>concat(localStructs, usedGlobalStructs));
  }

  /**
   * Gets all ata types that are used somewhere in the contract (for variables, parameters and function returns).
   * This function is taken from the SolidityCodeGenerator.
   */
  private Iterable<Type> getAllUsedTypesForCurrentTarget() {
    List<Type> _elvis = null;
    EList<StateVariable> _variables = this.currentTarget.getVariables();
    List<Type> _map = null;
    if (_variables!=null) {
      final Function1<StateVariable, Type> _function = new Function1<StateVariable, Type>() {
        public Type apply(final StateVariable it) {
          return it.getType();
        }
      };
      _map=ListExtensions.<StateVariable, Type>map(_variables, _function);
    }
    if (_map != null) {
      _elvis = _map;
    } else {
      _elvis = Collections.<Type>unmodifiableList(CollectionLiterals.<Type>newArrayList());
    }
    final List<Type> stateVariableTypes = _elvis;
    Iterable<Type> _elvis_1 = null;
    EList<Function> _functions = this.currentTarget.getFunctions();
    List<EList<FunctionParameter>> _map_1 = null;
    if (_functions!=null) {
      final Function1<Function, EList<FunctionParameter>> _function_1 = new Function1<Function, EList<FunctionParameter>>() {
        public EList<FunctionParameter> apply(final Function it) {
          return it.getParameters();
        }
      };
      _map_1=ListExtensions.<Function, EList<FunctionParameter>>map(_functions, _function_1);
    }
    final Function1<FunctionParameter, Type> _function_2 = new Function1<FunctionParameter, Type>() {
      public Type apply(final FunctionParameter it) {
        return it.getType();
      }
    };
    Iterable<Type> _map_2 = IterableExtensions.<FunctionParameter, Type>map(Iterables.<FunctionParameter>concat(_map_1), _function_2);
    if (_map_2 != null) {
      _elvis_1 = _map_2;
    } else {
      _elvis_1 = Collections.<Type>unmodifiableList(CollectionLiterals.<Type>newArrayList());
    }
    final Iterable<Type> functionParameterTypes = _elvis_1;
    Iterable<Type> _elvis_2 = null;
    EList<Function> _functions_1 = this.currentTarget.getFunctions();
    List<EList<ReturnVariable>> _map_3 = null;
    if (_functions_1!=null) {
      final Function1<Function, EList<ReturnVariable>> _function_3 = new Function1<Function, EList<ReturnVariable>>() {
        public EList<ReturnVariable> apply(final Function it) {
          return it.getReturnVariables();
        }
      };
      _map_3=ListExtensions.<Function, EList<ReturnVariable>>map(_functions_1, _function_3);
    }
    final Function1<ReturnVariable, Type> _function_4 = new Function1<ReturnVariable, Type>() {
      public Type apply(final ReturnVariable it) {
        return it.getType();
      }
    };
    Iterable<Type> _map_4 = IterableExtensions.<ReturnVariable, Type>map(Iterables.<ReturnVariable>concat(_map_3), _function_4);
    if (_map_4 != null) {
      _elvis_2 = _map_4;
    } else {
      _elvis_2 = Collections.<Type>unmodifiableList(CollectionLiterals.<Type>newArrayList());
    }
    final Iterable<Type> functionReturnTypes = _elvis_2;
    return Iterables.<Type>concat(Collections.<Iterable<Type>>unmodifiableList(CollectionLiterals.<Iterable<Type>>newArrayList(stateVariableTypes, functionParameterTypes, functionReturnTypes)));
  }

  /**
   * Returns the collected RoleAnnotations
   */
  public String getRoleAnnotationsAfterGeneration() {
    return this.roleAnnotations;
  }

  /**
   * Generates the definition for the given modeled modifier.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateModifierDefinition(final Modifier modifier) {
    String _xifexpression = null;
    boolean _isVirtual = modifier.isVirtual();
    if (_isVirtual) {
      _xifexpression = "virtual ";
    } else {
      _xifexpression = "";
    }
    final String virtual = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("modifier ");
    String _modifierName = SolidityNaming.getModifierName(modifier);
    _builder.append(_modifierName);
    _builder.append("(");
    String _generateModifierParametersDefinition = this.generateModifierParametersDefinition(modifier);
    _builder.append(_generateModifierParametersDefinition);
    _builder.append(") ");
    _builder.append(virtual);
    final String modifierHead = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _normalizeSpaces = SolidityNaming.normalizeSpaces(modifierHead);
    _builder_1.append(_normalizeSpaces);
    _builder_1.append("{");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    String _generateModifierBody = this.generateModifierBody(modifier);
    _builder_1.append(_generateModifierBody, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("}");
    return _builder_1.toString();
  }

  /**
   * Creates the parameters for the given modeled modifier.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateModifierParametersDefinition(final Modifier modifier) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ModifierParameter> _parameters = modifier.getParameters();
      boolean _hasElements = false;
      for(final ModifierParameter param : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _targetNameForType = SolidityNaming.getTargetNameForType(param.getType(), true);
        _builder.append(_targetNameForType);
        _builder.append(" ");
        String _name = param.getName();
        _builder.append(_name);
      }
    }
    return _builder.toString();
  }

  /**
   * Generates the body for the given modeled modifier.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateModifierBody(final Modifier modifier) {
    if (((modifier.getContent() == null) || modifier.getContent().isEmpty())) {
      return "_; //TODO: Auto-generated Modifier";
    } else {
      return modifier.getContent();
    }
  }

  @Pure
  private boolean isCurrentTargetNeedsAc() {
    return this.currentTargetNeedsAc;
  }

  @Pure
  private AccessControlContract getCurrentTarget() {
    return this.currentTarget;
  }

  @Pure
  private AccessControlSystem getAcSystem() {
    return this.acSystem;
  }

  @Pure
  private AnnotationGenerator getAnnotationGenerator() {
    return this.annotationGenerator;
  }

  @Pure
  private ModifierGenerator getModifierGenerator() {
    return this.modifierGenerator;
  }

  @Pure
  private SolidityFunctionGenerator getFunctionGenerator() {
    return this.functionGenerator;
  }
}
