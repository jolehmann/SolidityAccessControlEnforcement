package edu.kit.kastel.sdq.accesscontrolgenerator.generators

import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGenerator
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlContractGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityContractGenerator
import edu.kit.kastel.sdq.accesscontrolgenerator.validation.AccessControlValidator
import java.util.ArrayList
import java.util.List
import javax.swing.JOptionPane
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.internal.xtend.util.Triplet

import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants.*
import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityConstants.*
import static edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityNaming.*
import java.util.Collection

/**
 * Generator class using the Ecore2Txt project:
 * https://sdqweb.ipd.kit.edu/wiki/Generating_code_with_Xtend_and_Xtext_triggered_from_the_Eclipse_context_menu
 */
class AccessControlGenerator extends AbstractEcore2TxtGenerator {
	
	val FILE_URI_SEGMENT_STARTER = 2
	val VALIDATION_SUCCESSFUL_MSG = "Validation of the OCL constraints was successful. The generation begins now."
	val VALIDATION_SUCCESSFUL_HEADER = "Validation successful"
	val VALIDATION_FAILED_HEADER = "Error while validating the models"
	val VIOLATION_FILE_NAME = "Violations.log"
	
	AccessControlSystem acSystem
	AccessControlContractGenerator acGenerator
	AccessControlValidator acValidator	
	SolidityContractGenerator contractGenerator
	String targetUri
	String violations
	
	/**
	 * Generates a Solidity contract from the given resource. If violations have been found during the pre processing,
	 * a violation log will be generated instead of the smart contracts. Otherwise, the smart contract content is 
	 * generated based on the given input resource. Additionally, if the resource is an AccessControlSystem, it is
	 * saved and set for the other generators.
	 */
	override generateContentsFromResource(Resource inputResource) {
		val contents = new ArrayList<Triplet<String, String, String>>
		targetUri = getFolderNameForResource(inputResource)
		
		violations = violations.removeEmptyLines
		if(!violations.isBlank) {
			contents.add(generateContentTriplet(violations, VIOLATION_FILE_NAME, false))
			return contents
		}
		
		for (element : inputResource.contents) {
			if(element instanceof AccessControlSystem) {
				setAcSystem(element)
			}
		}

		generateAndAddContents(inputResource, contents)
		return contents
	}	
	
	/**
	 * Returns the folder name for the given resource where the generated files will be put.
	 * Since the resources URI always begins with "resources/<PROJECTNAME>/...", we skip the first two segments.
	 * This allows the generation to place the "gen" folder in the same folder where the original models are located.
	 */
	override getFolderNameForResource(Resource inputResource) {
		var s = ""
		for(var int i = FILE_URI_SEGMENT_STARTER; i < inputResource.URI.segmentCount; i++) {
			var seg = inputResource.URI.segment(i)
			if(!seg.contains(inputResource.URI.fileExtension)) {
				s = '''«s»\«seg»'''		
			}
		}
		return s = '''«s»\«getTargetFolderPrefix»'''
	}
	
	/**
	 * Returns the file name for the given resource (if the resource is a file)
	 */
	override getFileNameForResource(Resource inputResource) {
		if(inputResource.URI.file) {
			return inputResource.URI.toFileString
		} else {
			return ""
		}		
	}
	
	/**
	 * Pre processing the list of input files by validating the OCL constraints and RBAC equations on the models.
	 * For this, the resources are generated from the files and registered at the validator. At the end,
	 * the violations are generated using that validator before its results are displayed back to the developer.
	 */
	override List<IFile> preprocessInputFiles(List<IFile> inputFiles) {
		val resourceSet = new ResourceSetImpl()
		violations = ""
		acValidator = new AccessControlValidator()
		for(file : inputFiles) {
			val fullPath = file.getFullPath()
		    var uriString = ""
		    if(fullPath !== null) {
		    	uriString = fullPath.toString()
		    }
		    val inputURI = URI.createPlatformResourceURI(uriString, true)
			val inputResource = resourceSet.getResource(inputURI, true)
			acValidator.registerResource(inputResource)
		}
		
		violations = acValidator.checkSoundnessOfSystem()		
		if(violations.isBlank) {
			JOptionPane.showMessageDialog(null, VALIDATION_SUCCESSFUL_MSG, VALIDATION_SUCCESSFUL_HEADER,
				JOptionPane.INFORMATION_MESSAGE
			)
		} else {
			JOptionPane.showMessageDialog(null, violations, VALIDATION_FAILED_HEADER, JOptionPane.ERROR_MESSAGE)
		}
		return inputFiles
	}
	
	/**
	 * Post processing the generated contents.
	 * Since we need no post processing, no modifications are made.
	 */
	override postProcessGeneratedContents(String contents) {
		return contents
	}
	
	/**
	 * Generating the contents for the different smart contract files based on the given resources.
	 * For this, the method first checks for the AccessControlSystem, generating the contracts content and
	 * later iterating over all contracts.
	 */
	private def void generateAndAddContents(Resource resource, Collection<Triplet<String, String, String>> contents) {
		this.contractGenerator = new SolidityContractGenerator(acSystem)			
		val contracts = resource.contents.filter(AccessControlContract)
		var acContract = ""
		
		if(acSystem !== null) {
			 this.acGenerator = new AccessControlContractGenerator(acSystem)
			 acContract = generateAccessControlSystem(acSystem).removeEmptyLines
			 contents.add(generateContentTriplet(acContract, getAccessControlContactName(), true))
		}	
		
		for(contract : contracts) {
			val content = generateContent(contract).removeEmptyLines
					
			if (content !== null && !content.equals("")) {
				contents.add(generateContentTriplet(content, getTargetFileNameForContract(contract), true))
			}
		}
	}
	
	/**
	 * Generate content for the given EObject, differentiating between "normal" and access control smart contracts.
	 */
	private def String generateContent(EObject element) {
		switch element {
			AccessControlContract: generateContract(element)
			EObject: generateContentUnexpectedEObject(element)
		}
	}
	
	/**
	 * Generate the content for a contract file based on the given SmartContract 
	 * using the general contract generator.
	 */
	private def String generateContract(AccessControlContract contract) {
		contractGenerator.currentTarget = contract
		return contractGenerator.generate()
	}
	
	/**
	 * Generate the content for the access control contract based on the given AccessControlSystem 
	 * using the access control contract generator.
	 */
	private def String generateAccessControlSystem(AccessControlSystem acSys) {
		acGenerator.target = acSys
		return acGenerator.generate()
	}
	
	/**
	 * Generate a comment when an unexpected EObject is found.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String generateContentUnexpectedEObject(EObject object) {
		return '''Cannot generate content for generic EObject '«object.toString»'!'''
	}
	
	/**
	 * Removes all empty lines from the given string.
	 * This function is taken from the SolidityCodeGenerator.
	 */
	private def String removeEmptyLines(String input)  {
		return input.replaceAll("(\t?\r?\n){2,}","\n\n")
	}
	
	/**
	 * Generates a content triple based on the given contract content and its fileName for later file creation.
	 * Additionally, it can be specified if the general file extentension (.sol) should be added.
	 * This function is mostly taken from the SolidityCodeGenerator but enhanced with the third parameter.
	 */
	private def Triplet<String, String, String> generateContentTriplet(String content, String fileName, 
		boolean needsFileExtension){
		val folderName = targetUri
		val fileNameWithExtension = '''«fileName»«needsFileExtension ? getTargetFileExt() : ""»'''
		val contentAndFileName = new Triplet<String, String, String>(content, folderName, fileNameWithExtension)
		
		return contentAndFileName
	}
	
	/**
	 * Sets the found AccessControlSystem for the static singletons needing it.
	 */
	private def void setAcSystem(AccessControlSystem system) {
		this.acSystem = system
	}	
}