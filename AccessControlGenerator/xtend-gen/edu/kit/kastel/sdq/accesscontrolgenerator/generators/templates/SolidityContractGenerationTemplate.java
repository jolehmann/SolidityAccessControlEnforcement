package edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Template for the generation of a Solidity contract.
 * Describing the abstract structure of a solidity contract to be filled by the concrete generators.
 */
@SuppressWarnings("all")
public abstract class SolidityContractGenerationTemplate implements M2TGenerator {
  private final String SOLIDITY_VERSION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(">=0.7.0 <0.9.0");
      return _builder.toString();
    }
  }.apply();
  
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _generatePragma = this.generatePragma();
    _builder.append(_generatePragma);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateImports = this.generateImports();
    _builder.append(_generateImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateDeclaration = this.generateDeclaration();
    _builder.append(_generateDeclaration);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateEnums = this.generateEnums();
    _builder.append(_generateEnums, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateStructs = this.generateStructs();
    _builder.append(_generateStructs, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateFields = this.generateFields();
    _builder.append(_generateFields, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateEvents = this.generateEvents();
    _builder.append(_generateEvents, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateConstructor = this.generateConstructor();
    _builder.append(_generateConstructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateMethods = this.generateMethods();
    _builder.append(_generateMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _generateModifiers = this.generateModifiers();
    _builder.append(_generateModifiers, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  protected String generatePragma() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// SPDX-License-Identifier: GPL-3.0");
    _builder.newLine();
    _builder.append("pragma solidity ");
    _builder.append(this.SOLIDITY_VERSION);
    _builder.append(";");
    return _builder.toString();
  }
  
  protected abstract String generateImports();
  
  protected abstract String generateDeclaration();
  
  protected abstract String generateEnums();
  
  protected abstract String generateStructs();
  
  protected abstract String generateFields();
  
  protected abstract String generateEvents();
  
  protected abstract String generateConstructor();
  
  protected abstract String generateMethods();
  
  protected abstract String generateModifiers();
}
