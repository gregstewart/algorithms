# Weighted Quick Union

As with the __Quick Find__ and __Quick Union__ algorithm, this tries to solve the dynamic connectivity problem:

Here we are trying to improve the both the `union` and `find` operations.

## Running time
__Find__: takes time proportional to the depth of p and q
__Union__: takes constant time, given roots

## Efficiency

The cost model is: number of array reads and writes (accesses)

The depth of any node `x` is at most `lg N`

|initialise |union |find |
|-----------|:----:|----:|
|N          |[lg N][1]     |[lg N][2]    |

This algorithm is now way more efficient.

[1]: includes the cost of finding roots

[2]: worst case scenario
