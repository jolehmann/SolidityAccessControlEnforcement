package edu.kit.kastel.sdq.accesscontrolgenerator.handlers;

import edu.kit.ipd.sdq.mdsd.ecore2txt.handler.AbstractEcoreIFile2TxtHandler;
import edu.kit.ipd.sdq.mdsd.ecore2txt.util.Ecore2TxtUtil;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.AccessControlGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.AccessControlGeneratorModule;
import java.util.List;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Starting point for the generator.
 * This class is used when the generator is started from the context menu.
 * Based on this explanation:
 * https://sdqweb.ipd.kit.edu/wiki/Generating_code_with_Xtend_and_Xtext_triggered_from_the_Eclipse_context_menu
 */
@SuppressWarnings("all")
public class AccessControlGeneratorHandler extends AbstractEcoreIFile2TxtHandler {
  public void executeEcore2TxtGenerator(final List<IFile> filteredSelection, final ExecutionEvent event, final String plugInID) throws ExecutionException {
    AccessControlGeneratorModule _accessControlGeneratorModule = new AccessControlGeneratorModule();
    AccessControlGenerator _accessControlGenerator = new AccessControlGenerator();
    Ecore2TxtUtil.generateFromSelectedFilesInFolder(filteredSelection, _accessControlGeneratorModule, _accessControlGenerator, false, false);
  }
  
  public String getPlugInID() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("edu.kit.kastel.sdq.accesscontrolgenerator");
    return _builder.toString();
  }
}
