# influence-and-calls printer for Slither [1]

## Approach

This custom printer combines the current implementation of the data-dependency printer (see [2] & [3]) with the possibility to check if a variable is used in a condition [4] to find indirect influence. 
Additionally, the transitive closure is calculated for these influences as well as for function calls. All these results are printed to the console.

## Problems

The data-dependency printer is only responsible for printing the results of an underlying analysis (see [5]), which seems much more intertwined with the general functionality of Slither to be adapted easily.
However, an extension that only looks for indirect influences and combines its result with the current data-dependency is possible.
Additionally, this extension can circumvent a problem in the current implementation stated in [6].

## References
[1] [Slither](https://github.com/crytic/slither)

[2] Current definition of [data-dependency](https://github.com/crytic/slither/wiki/data-dependency)

[3] [data-dependency printer](https://github.com/crytic/slither/blob/master/slither/printers/summary/data_depenency.py)

[4] Example script to answer the question [Is the variable a used in a condition?](https://github.com/crytic/slither/blob/master/examples/scripts/variable_in_condition.py)

[5] [data-dependency analysis](https://github.com/crytic/slither/blob/master/slither/analyses/data_dependency/data_dependency.py)

[6] Current [Issue](https://github.com/crytic/slither/issues/337) in data-dependency printer
