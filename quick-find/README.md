# Quick Find

This algorithm tries to solve the dynamic connectivity problem:

Given N objects, implement a union command (connect two objects) and find/query their connection (i.e. is there a path between two objects)

We are assuming that “connected to” is an equivalence relation:

* `Reflexive`: an object is connected to itself
* `Symmetrical`: if object 1 is connected to object 2, then object 2 is connected to object 1
* `Transitive`: if obj 1 is connected to object 2 and object 2 is connected to object 3, then 1 is connected to 3
