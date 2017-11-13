# Quick Union

As with the Quick Find algorithm, this tries to solve the dynamic connectivity problem:

Given N objects, implement a union command (connect two objects) and find/query their connection (i.e. is there a path between two objects)

We are assuming that “connected to” is an equivalence relation:

* `Reflexive`: an object is connected to itself
* `Symmetrical`: if object 1 is connected to object 2, then object 2 is connected to object 1
* `Transitive`: if obj 1 is connected to object 2 and object 2 is connected to object 3, then 1 is connected to 3

Here we are trying to improve the `union` operation, which was more costly in the __Quick Find__ solution as the union solution was a `quadratic` algorithm.

## Efficiency

The cost model is: number of array reads and writes (accesses)

|initialise |union |find |
|-----------|:----:|----:|
|N          |[N][1]     |[N][2]    |

Where in the __Quick Find__ solution `Union` is too expensive (`O(N^2)`), here the find operation is too expensive, because the trees can get tall and therefore `find` could be `N` array accesses. This algorithm is `linear` => `O(N)` accesses.

[1]: includes the cost of finding roots

[2]: worst case scenario
