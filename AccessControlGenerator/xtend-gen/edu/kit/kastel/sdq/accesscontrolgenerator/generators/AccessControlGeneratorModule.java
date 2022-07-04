package edu.kit.kastel.sdq.accesscontrolgenerator.generators;

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGeneratorModule;

/**
 * Generator module class using the Ecore2Txt project:
 * https://sdqweb.ipd.kit.edu/wiki/Generating_code_with_Xtend_and_Xtext_triggered_from_the_Eclipse_context_menu
 */
@SuppressWarnings("all")
public class AccessControlGeneratorModule extends AbstractEcore2TxtGeneratorModule {
  protected String getLanguageName() {
    return "";
  }
  
  protected String getFileExtensions() {
    return "accesscontrolsystem";
  }
}
