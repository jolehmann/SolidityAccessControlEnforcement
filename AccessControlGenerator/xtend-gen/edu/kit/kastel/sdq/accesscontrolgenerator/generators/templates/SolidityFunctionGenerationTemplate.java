package edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Template for the generation of a Solidity method.
 * Describing the abstract structure of a solidity method to be filled by the concrete generator.
 */
@SuppressWarnings("all")
public abstract class SolidityFunctionGenerationTemplate implements M2TGenerator {
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _generateComments = this.generateComments();
    _builder.append(_generateComments);
    _builder.newLineIfNotEmpty();
    String _generateHeader = this.generateHeader();
    _builder.append(_generateHeader);
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateBody = this.generateBody();
    _builder.append(_generateBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  protected abstract String generateComments();

  protected abstract String generateHeader();

  protected abstract String generateBody();
}
