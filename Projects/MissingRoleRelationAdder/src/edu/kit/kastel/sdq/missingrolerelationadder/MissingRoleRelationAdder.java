package edu.kit.kastel.sdq.missingrolerelationadder;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystemFactory;
import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.impl.AccessControlSystemFactoryImpl;

public class MissingRoleRelationAdder {

	public static void main(String[] args) {
		
//		EFactory univInstance = univEPackage.getEFactoryInstance();
//		EList<EObject> ModelObjects = new BasicEList<EObject>(); 
//		ModelObjects.add(adultObject);
//
//		myModel.getContents().addAll(ModelObjects);
//		
//		myModel.save(null);
//
//		myMetaModel.save(null);
		
		AccessControlSystem acSystem;
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "ecore",  new EcoreResourceFactoryImpl());
		URI metamodelURI= URI.createFileURI("data/AccessControlMetamodel.ecore");
		Resource metamodel = resourceSet.getResource(metamodelURI, true);
		System.out.println("First object: " + metamodel.getContents().get(0).toString());
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "accesscontrolsystem",  new XMLResourceFactoryImpl());
		
		Resource res = new XMLResourceImpl(URI.createFileURI("data/Augur.accesscontrolsystem"));
		ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "accesscontrolsystem",  new AccessControlSystemFactoryImpl());
		Resource resourceRepository = resSet.getResource(URI.createFileURI("data/Augur.accesscontrolsystem"), true);
		EcoreUtil.resolveAll(resourceRepository);
		
		try {
			resourceRepository.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "accesscontrolsystem",  new AccessControlSystemFactoryImpl());
		
//		URI fileURI= URI.createFileURI("data/Augur.accesscontrolsystem");
//		Resource model = resourceSet.getResource(fileURI, true);
		
		System.out.println("First object: " + res);
		
		
	}

}
