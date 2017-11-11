# Quick Find

This algorithm tries to solve the dynamic connectivity problem:

Given N objects, implement a union command (connect two objects) and find/query their connection (i.e. is there a path between two objects)

We are assuming that “connected to” is an equivalence relation:

* `Reflexive`: an object is connected to itself
* `Symmetrical`: if object 1 is connected to object 2, then object 2 is connected to object 1
* `Transitive`: if obj 1 is connected to object 2 and object 2 is connected to object 3, then 1 is connected to 3

## Efficiency

The cost model is: number of array reads and writes (accesses)

|initialise |union |find |
|-----------|:----:|----:|
|N          |N     |1    |

`Union` is too expensive `O(N^2)`.

It takes `N^2` (`quadratic`) array accesses to process a sequence of `N` union commands on `N` objects. Quadratic algorithms do not scale! Imagine `10^9` commands on `10^9` objects, __Quick Find__ would take more than 10^18 operations.
