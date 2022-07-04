package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract;

import java.io.File;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Utility class to collect all constant strings needed throughout the Solidity code generation.
 * This class is taken from the SolidityCodeGenerator.
 */
@SuppressWarnings("all")
public class SolidityConstants {
  private SolidityConstants() {
  }
  
  public static String getTargetFileExt() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".sol");
    return _builder.toString();
  }
  
  public static String getTargetFolderPrefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("gen");
    String _separator = SolidityConstants.getSeparator(false);
    _builder.append(_separator);
    return _builder.toString();
  }
  
  public static String getSeparatorAtEnd(final boolean pkg) {
    String _xifexpression = null;
    if (pkg) {
      _xifexpression = "";
    } else {
      _xifexpression = SolidityConstants.getSeparator(pkg);
    }
    return _xifexpression;
  }
  
  public static String getSeparator(final boolean pkg) {
    String _xifexpression = null;
    if (pkg) {
      _xifexpression = ".";
    } else {
      _xifexpression = File.separator;
    }
    return _xifexpression;
  }
}
