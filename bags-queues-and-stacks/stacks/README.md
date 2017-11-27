# Stack as a Linked List

Proposition: every operation takes constant time in the worst case.
Proposition: in Java a stack with __N__ items uses `~40*N` bytes. This only accounts for the memory for the stack not for the memory the strings themselves will require.

# Stack as Resizing Array Stack

Essentially faster than a Linked List (fast `push` and `pop`s), but the Linked List does not require any loops, which is highly desirable. Because we are going to copy the contents of our array to the new __resized__ array we want to do this efficiently. Inserting `N` items takes time proportional to `1 + 2 + ... + N ~ N^2/2` (which is infeasible for a large `N` - __quadratic time__!). So we want the resize of our array to happen infrequently...

`Repeated doubling` is the solution to this problem, i.e. if the array is full, create a new one twice the size of the existing one. Consequence is that time will be proportional to `N` and not `N^2` as with the a naive approach.

So that's growing, what about shrinking? Naïvely considering halving it when we get to half full doesn't work for certain scenarios, known as __thrashing__ (`push -> pop -> push -> pop` when half full, leads to `double -> halve -> double -> halve`, i.e. creating new arrays on every operation). More efficient to wait until the array gets to a quarter full to reclaim the space.

## Tradeoffs between the two?

* Linked List: every operation takes constant time in the __worst case__
* Linked List: Uses extra time and space to deal with links
* Resizing Array: every operation takes constant __amortised__ time (total averaged over the whole process)
* Resizing Array: Less wasted space

But consider scenarios like internet switches where there's a large flow of data, you would not want to have a slow down and could lead to data loss while the array doubles/halves. In that case a Linked List might be a better solution.
