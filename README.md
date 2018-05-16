# Coiffe
## Alexia Leong :dancer:, Lynne Wang :neutral_face:, Lily Yan :tennis:
## Lab #03

### Decisions
We decided to stick with the time complexity suggestions from the API, which are O(1) for `add(String x)` and O(n) for `peekMin()` and `removeMin()`. To achieve these runtimes, the `add(String x)` algorithm must be just to add x to the end of the queue, and the algorithm for the other two methods are to traverse through the queue until the minimum is found, and then return (and, in the case of `removeMin()`, remove) that value. These algorithms allow one to maintain the order of a queue.

Another way of writing these methods without following the API runtime specifications are to sort the queue at the adding stage, which would make `add(String x)` have a runtime of O(n) and `peekMin()` and `removeMin()` have runtimes of O(1). While this may seem more efficient, we believed there was value in keeping the order of when elements were added in the queue, in cases where the user may want to preserve the order of how they added elements to the queue. 

### Time Complexities
* `void add(String x)` -- O(1)
* `boolean isEmpty()` -- O(1)
* `String peekMin()` -- O(n)
* `String removeMin()` -- O(n)

### Heap Todo
- [x] `isEmpty()`
- [x] `add( Integer addVal )`
- [x] `peekMin()`
- [x] `removeMin()`
- [x] `to.String()`

