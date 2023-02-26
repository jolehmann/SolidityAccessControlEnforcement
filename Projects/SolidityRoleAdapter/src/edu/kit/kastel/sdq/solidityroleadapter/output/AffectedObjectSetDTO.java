package edu.kit.kastel.sdq.solidityroleadapter.output;

import java.util.ArrayList;
import java.util.List;

public class AffectedObjectSetDTO {

	List<RolesAnnotatedFunctionDTO> functions;
	List<RolesAnnotatedVariableDTO> variables;
	
	public AffectedObjectSetDTO() {
		this.functions = new ArrayList<RolesAnnotatedFunctionDTO>();
		this.variables = new ArrayList<RolesAnnotatedVariableDTO>();
	}
	
	public AffectedObjectSetDTO(List<RolesAnnotatedFunctionDTO> functions, List<RolesAnnotatedVariableDTO> variables) {
		this.functions = functions;
		this.variables = variables;
	}
	
	public List<RolesAnnotatedFunctionDTO> getFunctions() {
		return functions;
	}
	
	public List<RolesAnnotatedVariableDTO> getVariables() {
		return variables;
	}

	public void add(RolesAnnotatedDTO item) {
		if(item.isFunction() ) {
			this.functions.add((RolesAnnotatedFunctionDTO)item);
		} else {
			this.variables.add((RolesAnnotatedVariableDTO)item);
		}
	}
}
