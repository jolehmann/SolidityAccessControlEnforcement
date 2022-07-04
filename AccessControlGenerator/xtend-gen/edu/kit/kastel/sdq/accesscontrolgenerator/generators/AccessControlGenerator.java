package edu.kit.kastel.sdq.accesscontrolgenerator.generators;

import com.google.common.collect.Iterables;
import edu.kit.ipd.sdq.mdsd.ecore2txt.generator.AbstractEcore2TxtGenerator;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlConstants;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.accesscontrolsystem.AccessControlContractGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityConstants;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityContractGenerator;
import edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract.SolidityNaming;
import edu.kit.kastel.sdq.accesscontrolgenerator.validation.AccessControlValidator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.internal.xtend.util.Triplet;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Generator class using the Ecore2Txt project:
 * https://sdqweb.ipd.kit.edu/wiki/Generating_code_with_Xtend_and_Xtext_triggered_from_the_Eclipse_context_menu
 */
@SuppressWarnings("all")
public class AccessControlGenerator extends AbstractEcore2TxtGenerator {
  private final int FILE_URI_SEGMENT_STARTER = 2;
  
  private final String VALIDATION_SUCCESSFUL_MSG = "Validation of the OCL constraints was successful. The generation begins now.";
  
  private final String VALIDATION_SUCCESSFUL_HEADER = "Validation successful";
  
  private final String VALIDATION_FAILED_HEADER = "Error while validating the models";
  
  private final String VIOLATION_FILE_NAME = "Violations.log";
  
  private AccessControlSystem acSystem;
  
  private AccessControlContractGenerator acGenerator;
  
  private AccessControlValidator acValidator;
  
  private SolidityContractGenerator contractGenerator;
  
  private String targetUri;
  
  private String violations;
  
  /**
   * Generates a Solidity contract from the given resource. If violations have been found during the pre processing,
   * a violation log will be generated instead of the smart contracts. Otherwise, the smart contract content is
   * generated based on the given input resource. Additionally, if the resource is an AccessControlSystem, it is
   * saved and set for the other generators.
   */
  public Iterable<Triplet<String, String, String>> generateContentsFromResource(final Resource inputResource) {
    final ArrayList<Triplet<String, String, String>> contents = new ArrayList<Triplet<String, String, String>>();
    this.targetUri = this.getFolderNameForResource(inputResource);
    this.violations = this.removeEmptyLines(this.violations);
    boolean _isBlank = this.violations.isBlank();
    boolean _not = (!_isBlank);
    if (_not) {
      contents.add(this.generateContentTriplet(this.violations, this.VIOLATION_FILE_NAME, false));
      return contents;
    }
    EList<EObject> _contents = inputResource.getContents();
    for (final EObject element : _contents) {
      if ((element instanceof AccessControlSystem)) {
        this.setAcSystem(((AccessControlSystem)element));
      }
    }
    this.generateAndAddContents(inputResource, contents);
    return contents;
  }
  
  /**
   * Returns the folder name for the given resource where the generated files will be put.
   * Since the resources URI always begins with "resources/<PROJECTNAME>/...", we skip the first two segments.
   * This allows the generation to place the "gen" folder in the same folder where the original models are located.
   */
  public String getFolderNameForResource(final Resource inputResource) {
    String s = "";
    for (int i = this.FILE_URI_SEGMENT_STARTER; (i < inputResource.getURI().segmentCount()); i++) {
      {
        String seg = inputResource.getURI().segment(i);
        boolean _contains = seg.contains(inputResource.getURI().fileExtension());
        boolean _not = (!_contains);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(s);
          _builder.append("\\");
          _builder.append(seg);
          s = _builder.toString();
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(s);
    _builder.append("\\");
    String _targetFolderPrefix = SolidityConstants.getTargetFolderPrefix();
    _builder.append(_targetFolderPrefix);
    return s = _builder.toString();
  }
  
  /**
   * Returns the file name for the given resource (if the resource is a file)
   */
  public String getFileNameForResource(final Resource inputResource) {
    boolean _isFile = inputResource.getURI().isFile();
    if (_isFile) {
      return inputResource.getURI().toFileString();
    } else {
      return "";
    }
  }
  
  /**
   * Pre processing the list of input files by validating the OCL constraints and RBAC equations on the models.
   * For this, the resources are generated from the files and registered at the validator. At the end,
   * the violations are generated using that validator before its results are displayed back to the developer.
   */
  public List<IFile> preprocessInputFiles(final List<IFile> inputFiles) {
    final ResourceSetImpl resourceSet = new ResourceSetImpl();
    this.violations = "";
    AccessControlValidator _accessControlValidator = new AccessControlValidator();
    this.acValidator = _accessControlValidator;
    for (final IFile file : inputFiles) {
      {
        final IPath fullPath = file.getFullPath();
        String uriString = "";
        if ((fullPath != null)) {
          uriString = fullPath.toString();
        }
        final URI inputURI = URI.createPlatformResourceURI(uriString, true);
        final Resource inputResource = resourceSet.getResource(inputURI, true);
        this.acValidator.registerResource(inputResource);
      }
    }
    this.violations = this.acValidator.checkSoundnessOfSystem();
    boolean _isBlank = this.violations.isBlank();
    if (_isBlank) {
      JOptionPane.showMessageDialog(null, this.VALIDATION_SUCCESSFUL_MSG, this.VALIDATION_SUCCESSFUL_HEADER, 
        JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, this.violations, this.VALIDATION_FAILED_HEADER, JOptionPane.ERROR_MESSAGE);
    }
    return inputFiles;
  }
  
  /**
   * Post processing the generated contents.
   * Since we need no post processing, no modifications are made.
   */
  public String postProcessGeneratedContents(final String contents) {
    return contents;
  }
  
  /**
   * Generating the contents for the different smart contract files based on the given resources.
   * For this, the method first checks for the AccessControlSystem, generating the contracts content and
   * later iterating over all contracts.
   */
  private void generateAndAddContents(final Resource resource, final Collection<Triplet<String, String, String>> contents) {
    SolidityContractGenerator _solidityContractGenerator = new SolidityContractGenerator(this.acSystem);
    this.contractGenerator = _solidityContractGenerator;
    final Iterable<AccessControlContract> contracts = Iterables.<AccessControlContract>filter(resource.getContents(), AccessControlContract.class);
    String acContract = "";
    if ((this.acSystem != null)) {
      AccessControlContractGenerator _accessControlContractGenerator = new AccessControlContractGenerator(this.acSystem);
      this.acGenerator = _accessControlContractGenerator;
      acContract = this.removeEmptyLines(this.generateAccessControlSystem(this.acSystem));
      contents.add(this.generateContentTriplet(acContract, AccessControlConstants.getAccessControlContactName(), true));
    }
    for (final AccessControlContract contract : contracts) {
      {
        final String content = this.removeEmptyLines(this.generateContent(contract));
        if (((content != null) && (!content.equals("")))) {
          contents.add(this.generateContentTriplet(content, SolidityNaming.getTargetFileNameForContract(contract), true));
        }
      }
    }
  }
  
  /**
   * Generate content for the given EObject, differentiating between "normal" and access control smart contracts.
   */
  private String generateContent(final EObject element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof AccessControlContract) {
      _matched=true;
      _switchResult = this.generateContract(((AccessControlContract)element));
    }
    if (!_matched) {
      if (element instanceof EObject) {
        _matched=true;
        _switchResult = this.generateContentUnexpectedEObject(element);
      }
    }
    return _switchResult;
  }
  
  /**
   * Generate the content for a contract file based on the given SmartContract
   * using the general contract generator.
   */
  private String generateContract(final AccessControlContract contract) {
    this.contractGenerator.setCurrentTarget(contract);
    return this.contractGenerator.generate();
  }
  
  /**
   * Generate the content for the access control contract based on the given AccessControlSystem
   * using the access control contract generator.
   */
  private String generateAccessControlSystem(final AccessControlSystem acSys) {
    this.acGenerator.setTarget(acSys);
    return this.acGenerator.generate();
  }
  
  /**
   * Generate a comment when an unexpected EObject is found.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String generateContentUnexpectedEObject(final EObject object) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Cannot generate content for generic EObject \'");
    String _string = object.toString();
    _builder.append(_string);
    _builder.append("\'!");
    return _builder.toString();
  }
  
  /**
   * Removes all empty lines from the given string.
   * This function is taken from the SolidityCodeGenerator.
   */
  private String removeEmptyLines(final String input) {
    return input.replaceAll("(\t?\r?\n){2,}", "\n\n");
  }
  
  /**
   * Generates a content triple based on the given contract content and its fileName for later file creation.
   * Additionally, it can be specified if the general file extentension (.sol) should be added.
   * This function is mostly taken from the SolidityCodeGenerator but enhanced with the third parameter.
   */
  private Triplet<String, String, String> generateContentTriplet(final String content, final String fileName, final boolean needsFileExtension) {
    final String folderName = this.targetUri;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(fileName);
    String _xifexpression = null;
    if (needsFileExtension) {
      _xifexpression = SolidityConstants.getTargetFileExt();
    } else {
      _xifexpression = "";
    }
    _builder.append(_xifexpression);
    final String fileNameWithExtension = _builder.toString();
    final Triplet<String, String, String> contentAndFileName = new Triplet<String, String, String>(content, folderName, fileNameWithExtension);
    return contentAndFileName;
  }
  
  /**
   * Sets the found AccessControlSystem for the static singletons needing it.
   */
  private void setAcSystem(final AccessControlSystem system) {
    this.acSystem = system;
  }
}
