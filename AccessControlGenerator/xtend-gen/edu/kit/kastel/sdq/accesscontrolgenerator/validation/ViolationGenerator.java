package edu.kit.kastel.sdq.accesscontrolgenerator.validation;

import edu.kit.kastel.sdq.AccessControlMetamodel.AccessControlSystem.AccessControlSystem;
import edu.kit.kastel.sdq.AccessControlMetamodel.SmartContractModel.AccessControlContract;
import java.util.Collection;

/**
 * Interface describing the abstract Strategy for generating violations
 */
@SuppressWarnings("all")
public interface ViolationGenerator {
  Collection<String> generateViolations();

  void changeAccessControlSystem(final AccessControlSystem system);

  void addNewSmartContract(final AccessControlContract contract);
}
