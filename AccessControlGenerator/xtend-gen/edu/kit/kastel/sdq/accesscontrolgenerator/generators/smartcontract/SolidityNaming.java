package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract;

import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Contract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.ContractType;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.CustomArray;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.DataLocation;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.DefaultArray;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.DefaultArrayEnum;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Function;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.FunctionMutability;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.FunctionType;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.FunctionTypeVisibility;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.GlobalFunctionVisibility;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.LocalFunctionVisibility;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Mapping;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Modifier;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.PrimitiveType;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.PrimitiveTypeEnum;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Struct;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Type;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.VariableMutability;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.VariableVisibility;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Utility class to handle everything related to solidity naming throughout the Solidity code generation.
 * This class is taken completely from the SolidityCodeGenerator.
 */
@SuppressWarnings("all")
public class SolidityNaming {
  private SolidityNaming() {
  }
  
  public static String getTargetFileNameForContract(final Contract contract) {
    return StringExtensions.toFirstUpper(contract.getEntityName());
  }
  
  public static String getFunctionName(final Function function) {
    return StringExtensions.toFirstLower(function.getEntityName().replaceAll(" ", ""));
  }
  
  public static String getModifierName(final Modifier modifier) {
    return StringExtensions.toFirstLower(modifier.getEntityName());
  }
  
  public static String normalizeSpaces(final String string) {
    return string.replaceAll(" +", " ");
  }
  
  public static String getTargetNameForDataLocation(final DataLocation location) {
    String _switchResult = null;
    if (location != null) {
      switch (location) {
        case CALLDATA:
          _switchResult = "calldata";
          break;
        case STORAGE:
          _switchResult = "storage";
          break;
        case MEMORY:
          _switchResult = "memory";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForVariableMutability(final VariableMutability mutability) {
    String _switchResult = null;
    if (mutability != null) {
      switch (mutability) {
        case DEFAULT:
          _switchResult = "";
          break;
        case CONSTANT:
          _switchResult = "constant";
          break;
        case IMMUTABLE:
          _switchResult = "immutable";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForVariableVisibility(final VariableVisibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case PUBLIC:
          _switchResult = "public";
          break;
        case INTERNAL:
          _switchResult = "internal";
          break;
        case PRIVATE:
          _switchResult = "private";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected static String _getTargetNameForFunctionVisibility(final GlobalFunctionVisibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case PUBLIC:
          _switchResult = "public";
          break;
        case EXTERNAL:
          _switchResult = "external";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected static String _getTargetNameForFunctionVisibility(final LocalFunctionVisibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case INTERNAL:
          _switchResult = "internal";
          break;
        case PRIVATE:
          _switchResult = "private";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForFunctionMutability(final FunctionMutability mutability) {
    String _switchResult = null;
    if (mutability != null) {
      switch (mutability) {
        case DEFAULT:
          _switchResult = "";
          break;
        case PURE:
          _switchResult = "pure";
          break;
        case VIEW:
          _switchResult = "view";
          break;
        case PAYABLE:
          _switchResult = "payable";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForFunctionTypeVisibility(final FunctionTypeVisibility visibility) {
    String _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case INTERNAL:
          _switchResult = "internal";
          break;
        case EXTERNAL:
          _switchResult = "external";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForPrimitiveTypeEnum(final PrimitiveTypeEnum pt) {
    String _switchResult = null;
    if (pt != null) {
      switch (pt) {
        case ADDRESS:
          _switchResult = "address";
          break;
        case ADDRESS_PAYABLE:
          _switchResult = "address payable";
          break;
        case BOOL:
          _switchResult = "bool";
          break;
        case INT:
          _switchResult = "int";
          break;
        case UINT:
          _switchResult = "uint";
          break;
        case BYTES1:
          _switchResult = "bytes1";
          break;
        case BYTES2:
          _switchResult = "bytes2";
          break;
        case BYTES3:
          _switchResult = "bytes3";
          break;
        case BYTES4:
          _switchResult = "bytes4";
          break;
        case BYTES5:
          _switchResult = "bytes5";
          break;
        case BYTES6:
          _switchResult = "bytes6";
          break;
        case BYTES7:
          _switchResult = "bytes7";
          break;
        case BYTES8:
          _switchResult = "bytes8";
          break;
        case BYTES9:
          _switchResult = "bytes9";
          break;
        case BYTES10:
          _switchResult = "bytes10";
          break;
        case BYTES11:
          _switchResult = "bytes11";
          break;
        case BYTES12:
          _switchResult = "bytes12";
          break;
        case BYTES13:
          _switchResult = "bytes13";
          break;
        case BYTES14:
          _switchResult = "bytes14";
          break;
        case BYTES15:
          _switchResult = "bytes15";
          break;
        case BYTES16:
          _switchResult = "bytes16";
          break;
        case BYTES17:
          _switchResult = "bytes17";
          break;
        case BYTES18:
          _switchResult = "bytes18";
          break;
        case BYTES19:
          _switchResult = "bytes19";
          break;
        case BYTES20:
          _switchResult = "bytes20";
          break;
        case BYTES21:
          _switchResult = "bytes21";
          break;
        case BYTES22:
          _switchResult = "bytes22";
          break;
        case BYTES23:
          _switchResult = "bytes23";
          break;
        case BYTES24:
          _switchResult = "bytes24";
          break;
        case BYTES25:
          _switchResult = "bytes25";
          break;
        case BYTES26:
          _switchResult = "bytes26";
          break;
        case BYTES27:
          _switchResult = "bytes27";
          break;
        case BYTES28:
          _switchResult = "bytes28";
          break;
        case BYTES29:
          _switchResult = "bytes29";
          break;
        case BYTES30:
          _switchResult = "bytes30";
          break;
        case BYTES31:
          _switchResult = "bytes31";
          break;
        case BYTES32:
          _switchResult = "bytes32";
          break;
        case INT8:
          _switchResult = "int8";
          break;
        case INT16:
          _switchResult = "int16";
          break;
        case INT24:
          _switchResult = "int24";
          break;
        case INT32:
          _switchResult = "int32";
          break;
        case INT40:
          _switchResult = "int40";
          break;
        case INT48:
          _switchResult = "int48";
          break;
        case INT56:
          _switchResult = "int56";
          break;
        case INT64:
          _switchResult = "int64";
          break;
        case INT72:
          _switchResult = "int72";
          break;
        case INT80:
          _switchResult = "int80";
          break;
        case INT88:
          _switchResult = "int88";
          break;
        case INT96:
          _switchResult = "int96";
          break;
        case INT104:
          _switchResult = "int104";
          break;
        case INT112:
          _switchResult = "int112";
          break;
        case INT120:
          _switchResult = "int120";
          break;
        case INT128:
          _switchResult = "int128";
          break;
        case INT136:
          _switchResult = "int136";
          break;
        case INT144:
          _switchResult = "int144";
          break;
        case INT152:
          _switchResult = "int152";
          break;
        case INT160:
          _switchResult = "int160";
          break;
        case INT168:
          _switchResult = "int168";
          break;
        case INT176:
          _switchResult = "int176";
          break;
        case INT184:
          _switchResult = "int184";
          break;
        case INT192:
          _switchResult = "int192";
          break;
        case INT200:
          _switchResult = "int200";
          break;
        case INT208:
          _switchResult = "int208";
          break;
        case INT216:
          _switchResult = "int216";
          break;
        case INT224:
          _switchResult = "int224";
          break;
        case INT232:
          _switchResult = "int232";
          break;
        case INT240:
          _switchResult = "int240";
          break;
        case INT248:
          _switchResult = "int248";
          break;
        case INT256:
          _switchResult = "int256";
          break;
        case UINT8:
          _switchResult = "uint8";
          break;
        case UINT16:
          _switchResult = "uint16";
          break;
        case UINT24:
          _switchResult = "uint24";
          break;
        case UINT32:
          _switchResult = "uint32";
          break;
        case UINT40:
          _switchResult = "uint40";
          break;
        case UINT48:
          _switchResult = "uint48";
          break;
        case UINT56:
          _switchResult = "uint56";
          break;
        case UINT64:
          _switchResult = "uint64";
          break;
        case UINT72:
          _switchResult = "uint72";
          break;
        case UINT80:
          _switchResult = "uint80";
          break;
        case UINT88:
          _switchResult = "uint88";
          break;
        case UINT96:
          _switchResult = "uint96";
          break;
        case UINT104:
          _switchResult = "uint104";
          break;
        case UINT112:
          _switchResult = "uint112";
          break;
        case UINT120:
          _switchResult = "uint120";
          break;
        case UINT128:
          _switchResult = "uint128";
          break;
        case UINT136:
          _switchResult = "uint136";
          break;
        case UINT144:
          _switchResult = "uint144";
          break;
        case UINT152:
          _switchResult = "uint152";
          break;
        case UINT160:
          _switchResult = "uint160";
          break;
        case UINT168:
          _switchResult = "uint168";
          break;
        case UINT176:
          _switchResult = "uint176";
          break;
        case UINT184:
          _switchResult = "uint184";
          break;
        case UINT192:
          _switchResult = "uint192";
          break;
        case UINT200:
          _switchResult = "uint200";
          break;
        case UINT208:
          _switchResult = "uint208";
          break;
        case UINT216:
          _switchResult = "uint216";
          break;
        case UINT224:
          _switchResult = "uint224";
          break;
        case UINT232:
          _switchResult = "uint232";
          break;
        case UINT240:
          _switchResult = "uint240";
          break;
        case UINT248:
          _switchResult = "uint248";
          break;
        case UINT256:
          _switchResult = "uint256";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public static String getTargetNameForDefaultArrayEnum(final DefaultArrayEnum array) {
    String _switchResult = null;
    if (array != null) {
      switch (array) {
        case BYTES:
          _switchResult = "bytes";
          break;
        case STRING:
          _switchResult = "string";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected static String _getTargetNameForType(final PrimitiveType pt, final boolean includeDataLocation) {
    return SolidityNaming.getTargetNameForPrimitiveTypeEnum(pt.getType());
  }
  
  protected static String _getTargetNameForType(final edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum en, final boolean includeDataLocation) {
    return en.getEntityName().replaceAll(" ", "");
  }
  
  protected static String _getTargetNameForType(final ContractType ct, final boolean includeDataLocation) {
    return ct.getContract().getEntityName().replaceAll(" ", "");
  }
  
  protected static String _getTargetNameForType(final DefaultArray array, final boolean includeDataLocation) {
    StringConcatenation _builder = new StringConcatenation();
    String _targetNameForDefaultArrayEnum = SolidityNaming.getTargetNameForDefaultArrayEnum(array.getType());
    _builder.append(_targetNameForDefaultArrayEnum);
    {
      if (includeDataLocation) {
        _builder.append(" ");
        String _targetNameForDataLocation = SolidityNaming.getTargetNameForDataLocation(array.getDataLocation());
        _builder.append(_targetNameForDataLocation);
      }
    }
    return _builder.toString();
  }
  
  protected static String _getTargetNameForType(final CustomArray array, final boolean includeDataLocation) {
    StringConcatenation _builder = new StringConcatenation();
    String _targetNameForType = SolidityNaming.getTargetNameForType(array.getType(), false);
    _builder.append(_targetNameForType);
    _builder.append("[");
    {
      int _size = array.getSize();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        int _size_1 = array.getSize();
        _builder.append(_size_1);
      }
    }
    _builder.append("]");
    {
      if (includeDataLocation) {
        _builder.append(" ");
        String _targetNameForDataLocation = SolidityNaming.getTargetNameForDataLocation(array.getDataLocation());
        _builder.append(_targetNameForDataLocation);
      }
    }
    return _builder.toString();
  }
  
  protected static String _getTargetNameForType(final Mapping map, final boolean includeDataLocation) {
    String _xifexpression = null;
    if (includeDataLocation) {
      _xifexpression = SolidityNaming.getTargetNameForDataLocation(map.getDataLocation());
    } else {
      _xifexpression = "";
    }
    final String dataLocation = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mapping(");
    String _targetNameForType = SolidityNaming.getTargetNameForType(map.getKeyType(), false);
    _builder.append(_targetNameForType);
    _builder.append(" => ");
    String _targetNameForType_1 = SolidityNaming.getTargetNameForType(map.getValueType(), false);
    _builder.append(_targetNameForType_1);
    _builder.append(") ");
    _builder.append(dataLocation);
    return _builder.toString();
  }
  
  protected static String _getTargetNameForType(final Struct struct, final boolean includeDataLocation) {
    StringConcatenation _builder = new StringConcatenation();
    String _replaceAll = struct.getEntityName().replaceAll(" ", "");
    _builder.append(_replaceAll);
    {
      if (includeDataLocation) {
        _builder.append(" ");
        String _targetNameForDataLocation = SolidityNaming.getTargetNameForDataLocation(struct.getDataLocation());
        _builder.append(_targetNameForDataLocation);
      }
    }
    return _builder.toString();
  }
  
  protected static String _getTargetNameForType(final FunctionType ft, final boolean includeDataLocation) {
    String _xifexpression = null;
    int _size = ft.getReturnTypes().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[returns (");
      {
        EList<Type> _returnTypes = ft.getReturnTypes();
        boolean _hasElements = false;
        for(final Type type : _returnTypes) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _targetNameForType = SolidityNaming.getTargetNameForType(type, true);
          _builder.append(_targetNameForType);
        }
      }
      _builder.append(")]");
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = "";
    }
    final String returns = _xifexpression;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("function(");
    {
      EList<Type> _parameterTypes = ft.getParameterTypes();
      boolean _hasElements_1 = false;
      for(final Type type_1 : _parameterTypes) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder_1.appendImmediate(", ", "");
        }
        String _targetNameForType_1 = SolidityNaming.getTargetNameForType(type_1, true);
        _builder_1.append(_targetNameForType_1);
      }
    }
    _builder_1.append(") ");
    String _targetNameForFunctionTypeVisibility = SolidityNaming.getTargetNameForFunctionTypeVisibility(ft.getVisibility());
    _builder_1.append(_targetNameForFunctionTypeVisibility);
    _builder_1.append(" ");
    String _targetNameForFunctionMutability = SolidityNaming.getTargetNameForFunctionMutability(ft.getMutability());
    _builder_1.append(_targetNameForFunctionMutability);
    _builder_1.append(" ");
    _builder_1.append(returns);
    final String type_2 = _builder_1.toString();
    return SolidityNaming.normalizeSpaces(type_2);
  }
  
  public static String getTargetNameForFunctionVisibility(final Enum<?> visibility) {
    if (visibility instanceof GlobalFunctionVisibility) {
      return _getTargetNameForFunctionVisibility((GlobalFunctionVisibility)visibility);
    } else if (visibility instanceof LocalFunctionVisibility) {
      return _getTargetNameForFunctionVisibility((LocalFunctionVisibility)visibility);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(visibility).toString());
    }
  }
  
  public static String getTargetNameForType(final Type ct, final boolean includeDataLocation) {
    if (ct instanceof ContractType) {
      return _getTargetNameForType((ContractType)ct, includeDataLocation);
    } else if (ct instanceof DefaultArray) {
      return _getTargetNameForType((DefaultArray)ct, includeDataLocation);
    } else if (ct instanceof edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum) {
      return _getTargetNameForType((edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.Enum)ct, includeDataLocation);
    } else if (ct instanceof PrimitiveType) {
      return _getTargetNameForType((PrimitiveType)ct, includeDataLocation);
    } else if (ct instanceof CustomArray) {
      return _getTargetNameForType((CustomArray)ct, includeDataLocation);
    } else if (ct instanceof FunctionType) {
      return _getTargetNameForType((FunctionType)ct, includeDataLocation);
    } else if (ct instanceof Mapping) {
      return _getTargetNameForType((Mapping)ct, includeDataLocation);
    } else if (ct instanceof Struct) {
      return _getTargetNameForType((Struct)ct, includeDataLocation);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ct, includeDataLocation).toString());
    }
  }
}
