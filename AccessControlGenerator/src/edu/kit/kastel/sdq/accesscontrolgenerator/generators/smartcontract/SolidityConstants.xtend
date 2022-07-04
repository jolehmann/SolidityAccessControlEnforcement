package edu.kit.kastel.sdq.accesscontrolgenerator.generators.smartcontract

import java.io.File

/**
 * Utility class to collect all constant strings needed throughout the Solidity code generation.
 * This class is taken from the SolidityCodeGenerator.
 */
class SolidityConstants {
	private new() {}
	
	static def String getTargetFileExt() '''.sol'''
	
	static def String getTargetFolderPrefix() '''gen«getSeparator(false)»'''
	
	static def String getSeparatorAtEnd(boolean pkg) {
		return if (pkg) "" else getSeparator(pkg)
	}
	
	static def String getSeparator(boolean pkg) {
		return if (pkg) "." else File.separator
	}
}