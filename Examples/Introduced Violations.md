# Violations currently in the two use cases

## illegal variable access & postconditions:
- Fizzy - Insurance: cancelInsurance illegally sets the insurant address to zero
- Fizzy - Insurance: payout is modelled to increase the balance of the contract, which it does not (it decreases)
- Augur - Market: closeDisputingWindow illegally deletes the reportedOutcome if a disagreement was found
- Augur - Market: sellShares is modelled to increase the balance of the contract, which it does not (it decreases)

## illegal function calls:
- Augur - Market: allowOpenReport calls claimReporterRole illegally => also introduces illegal modification to the openReporter variable by the allowOpenReport function
- Fizzy - Insurance: cancelInsurance calls payout illegally

## missing VariableToVariableRelation elements:
- Augur - Market: Missing VariableToVariableRelation for the information flow from the designatedReporterReported to the designatedReportAllowed variable

## violations through insecure information flows:
- Augur - Market: Changes to the agreeCounter depend on the current state of the disputesAllowed variable
- Augur - Market: Changes to the disagreeCounter depend on the current state of the disputesAllowed variable
- Fizzy - Insurance: Changing the insurant can only be achieved while the insurance is still open (represented by the insuranceClosed variable)

## violations to the equations on the architectural level:
- see violation logs

## violations to the OCL constraints:
- see violation logs