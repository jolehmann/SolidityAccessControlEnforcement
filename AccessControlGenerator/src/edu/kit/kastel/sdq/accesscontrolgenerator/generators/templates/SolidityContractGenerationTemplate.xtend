package edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates

/**
 * Template for the generation of a Solidity contract.
 * Describing the abstract structure of a solidity contract to be filled by the concrete generators.
 */
abstract class SolidityContractGenerationTemplate implements M2TGenerator {
	
	val SOLIDITY_VERSION = '''>=0.7.0 <0.9.0'''
	
	override String generate(){
		return 
		'''
		«generatePragma»
		
		«generateImports»
		
		«generateDeclaration» {
			«generateEnums»
			
			«generateStructs»
			
			«generateFields»
			
			«generateEvents»
			
			«generateConstructor»
			
			«generateMethods»
			
			«generateModifiers»
		}'''
	}
	
	protected def String generatePragma() {
		return '''// SPDX-License-Identifier: GPL-3.0
pragma solidity «SOLIDITY_VERSION»;'''
	}
	
	protected def String generateImports()
	protected def String generateDeclaration()
	protected def String generateEnums()
	protected def String generateStructs()
	protected def String generateFields()
	protected def String generateEvents()
	protected def String generateConstructor()
	protected def String generateMethods()
	protected def String generateModifiers()
}