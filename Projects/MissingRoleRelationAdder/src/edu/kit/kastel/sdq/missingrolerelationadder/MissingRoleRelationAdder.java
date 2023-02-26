package edu.kit.kastel.sdq.missingrolerelationadder;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemPackage;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.Role;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.RoleToVariableRelation;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemFactoryImpl;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import edu.kit.kastel.sdq.soliditymetamodel.soliditycontracts.StateVariable;
import edu.kit.kastel.sdq.solidityroleadapter.output.AffectedObjectSetDTO;
import edu.kit.kastel.sdq.solidityroleadapter.output.RolesAnnotatedVariableDTO;

/**
 * Loads an AccessControlSystem file and a SmartContractModel file and adds
 * missing relations to the System Model. The missing relations are taken from a
 * JSON file.
 * 
 * @author Jonas Lehmann
 */
public class MissingRoleRelationAdder {

	private static final String FILE_URI_ACS = "data/Augur.accesscontrolsystem";
	private static final String FILE_URI_UPDATED_ACS = "data/Augur_new.accesscontrolsystem";
	private static final String FILE_EXTENSION_ACS = "accesscontrolsystem";

	private static final String FILE_URI_SCM = "data/Market.smartcontractmodel";
	private static final String FILE_EXTENSION_SCM = "smartcontractmodel";

	private static final String JSON_FILE_URI = "data/SolidityRoleAdapter - Results.json";

	private static ResourceSet resourceSet = new ResourceSetImpl();
	private static AccessControlSystemFactory relationFactory = new AccessControlSystemFactoryImpl();

	public static void main(String[] args) {

		// Load AccessControlSystem and AccessControlContract
		EPackage.Registry.INSTANCE.put(AccessControlSystemPackage.eNS_URI, AccessControlSystemPackage.eINSTANCE);

		AccessControlSystem acSystem = (AccessControlSystem) loadModel(FILE_EXTENSION_ACS, FILE_URI_ACS).getContents()
				.get(0);
		AccessControlContract acContract = (AccessControlContract) loadModel(FILE_EXTENSION_SCM, FILE_URI_SCM)
				.getContents().get(0);

		// Load Missing Relations that should be added from JSON
		AffectedObjectSetDTO missingRoleRelations = loadFromJSON(JSON_FILE_URI);

		// Create new RoleToVariableRelations
		for (RolesAnnotatedVariableDTO variableDTO : missingRoleRelations.getVariables()) {
			for (String missingRole : variableDTO.getMissingModRoles()) {

				Role role = getRole(missingRole, acSystem);
				StateVariable variable = getVariable(variableDTO.getName(), acContract);

				if (role != null && variable != null) {

					System.out.println("Create Relation: " + missingRole + " --> " + variable.getEntityName());

					acSystem.getRoleToVariableTuples().add(createRelation(role, variable));
				}
			}
		}

		// Create new Resource, add the model to it and write back to result file
		Resource newAccessControlSystemRes = createResource(FILE_EXTENSION_ACS, FILE_URI_UPDATED_ACS);

		newAccessControlSystemRes.getContents().add(acSystem);

		saveModel(newAccessControlSystemRes);
	}

	/**
	 * Search for the Role object with the specified name in the
	 * AccessControlSystem.
	 * 
	 * @param name     the name in MACRO_CASE
	 * @param acSystem the AccessControlSystem in which should be searched
	 * @return the Role or null if nothing is found
	 */

	private static Role getRole(String name, AccessControlSystem acSystem) {

		for (Role role : acSystem.getRoles()) {
			if (role.getEntityName().replaceAll(" ", "_").toUpperCase().equals(name)) {
				return role;
			}
		}
		return null;
	}

	/**
	 * Search for the StateVariable object with the specified name in the
	 * AccessControlContract.
	 * 
	 * @param name       the name in lowerCamelCase
	 * @param acContract the AccessControlContract in which should be searched
	 * @return the StateVariable or null if nothing is found
	 */

	private static StateVariable getVariable(String name, AccessControlContract acContract) {

		for (StateVariable variable : acContract.getVariables()) {
			if (firstToLower(variable.getEntityName().replaceAll(" ", "")).equals(name)) {
				return variable;
			}
		}
		return null;
	}

	/**
	 * Creates a RoleToVariableRelation with the specified role and variable. <br>
	 * The EntityName is set to "Generated Relation: role# is able to modify
	 * variable#"
	 * 
	 * @param role     the Role
	 * @param variable the Variable
	 * @return A new RoleToVariableRelation
	 */

	private static RoleToVariableRelation createRelation(Role role, StateVariable variable) {
		RoleToVariableRelation relation = relationFactory.createRoleToVariableRelation();
		relation.setRole(role);
		relation.setVariable(variable);
		relation.setEntityName(
				"Generated Relation: " + role.getEntityName() + " is able to modify " + variable.getEntityName());
		return relation;
	}

	/**
	 * Returns the Resource located at the specified URI.
	 * 
	 * @param fileExtension the models file extension
	 * @param fileURI the path to the file of the model
	 * @return the Resource
	 */
	
	private static Resource loadModel(String fileExtension, String fileURI) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
				new XMIResourceFactoryImpl());
		return resourceSet.getResource(URI.createFileURI(fileURI), true);
	}

	/**
	 * Returns a new Resource located at the specified URI. <br>
	 * It can be saved to the specified path with {@link #saveModel(Resource resource)}
	 * 
	 * @param fileExtension the models file extension
	 * @param fileURI the path to the file of the model
	 * @return the created Resource
	 */
	
	private static Resource createResource(String fileExtension, String fileURI) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
				new XMIResourceFactoryImpl());
		return resourceSet.createResource(URI.createFileURI(fileURI));
	}

	/**
	 * Saves changes of the specified Resource to its file.
	 * 
	 * @param resource the Resource which should be saved
	 */
	
	private static void saveModel(Resource resource) {
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

	/**
	 * Returns the input string with its first letter switched to lower case.
	 * 
	 * @param input the input String
	 * @return the new String
	 */
	
	private static String firstToLower(String input) {
		char[] sequence = input.toCharArray();
		sequence[0] = Character.toLowerCase(sequence[0]);
		return new String(sequence);
	}

	/**
	 * Creates an AffectedObjectSetDTO from a JSON File located at the specified URI.
	 * 
	 * @param uri its file path
	 * @return the parsed Object
	 */
	
	private static AffectedObjectSetDTO loadFromJSON(String uri) {
		AffectedObjectSetDTO affectedObjectSetDTO = new AffectedObjectSetDTO();

		try {
			ObjectMapper jacksonMapper = new ObjectMapper();
			affectedObjectSetDTO = jacksonMapper.readValue(new File(uri), AffectedObjectSetDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedObjectSetDTO;
	}

}
