package edu.kit.kastel.sdq.accesscontrolgenerator.generators.templates

/**
 * Template for the generation of a Solidity method.
 * Describing the abstract structure of a solidity method to be filled by the concrete generator.
 */
abstract class SolidityFunctionGenerationTemplate implements M2TGenerator {
	
	override generate() '''
		«generateComments()»
		«generateHeader()»{
			«generateBody()»
		}
	'''
	
	protected def String generateComments()
	protected def String generateHeader()
	protected def String generateBody()
}