# Weighted Quick Union with Path Compression

As with the __Quick Find__ and __Quick Union__ algorithm, this tries to solve the dynamic connectivity problem:

Here we are trying to improve the both the `union` and `find` operations.

Here instead of nesting nodes, we simply set each examined node's parent to the root of the tree, which keeps the trees almost completely flat.

## Running time
`O(N+M lg* N)` where `lg` is the number of times you need to take the `lg` to get 1 (~5)

## Efficiency

This algorithm is now way more efficient, remember our initial implementation that took `10^9` commands on `10^9` objects, which as an estimate would take 30 years on today's hardware, would be reduced to 6 seconds.

This algorithm is considered near linear time (Fredman-Saks proved that no such algorithm can exist).
