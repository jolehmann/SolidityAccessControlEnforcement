package edu.kit.kastel.sdq.accesscontrolgenerator.handlers

import edu.kit.ipd.sdq.mdsd.ecore2txt.handler.AbstractEcoreIFile2TxtHandler
import edu.kit.ipd.sdq.mdsd.ecore2txt.util.Ecore2TxtUtil
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.AccessControlGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.AccessControlGeneratorModule
import java.util.List
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile

/**
 * Starting point for the generator. 
 * This class is used when the generator is started from the context menu.
 * Based on this explanation:
 * https://sdqweb.ipd.kit.edu/wiki/Generating_code_with_Xtend_and_Xtext_triggered_from_the_Eclipse_context_menu
 */
class AccessControlGeneratorHandler extends AbstractEcoreIFile2TxtHandler {
	
	override executeEcore2TxtGenerator(List<IFile> filteredSelection, ExecutionEvent event, String plugInID) 
		throws ExecutionException {
		Ecore2TxtUtil.generateFromSelectedFilesInFolder(filteredSelection, new AccessControlGeneratorModule, 
			new AccessControlGenerator, false, false)
	}
	
	override getPlugInID() {
		return '''edu.kit.kastel.sdq.accesscontrolgenerator'''
	}
}