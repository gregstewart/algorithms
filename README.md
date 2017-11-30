# Coursera - Algorithms, Part 1

The actual algorithms from the course are implemented using JavaScript. I wanted to experiment with [Jest]() and [Flow](). The course work is actually in Java as that is the language they expect. I am using [Gradle]() to test drive the assignments.

## Prerequisits

I am assuming you have both Node.js and Java installed.

Install Flow globally:

`brew install flow`

Install Gradle:

`brew install gradle`

## Run the JavaScript

Install dependencies:

`npm i` or `yarn`

Run the tests:

`npm test` or `yarn test`

Output:

```
yarn run v1.3.2
$ jest --coverage
 PASS  union-find/weighted-quick-union-with-path-compression/WeightedQuickUnionWithPathCompression.spec.js
 PASS  union-find/quick-union/QuickUnion.spec.js
 PASS  union-find/weighted-quick-union/WeightedQuickUnion.spec.js
 PASS  union-find/quick-find/QuickFind.spec.js

Test Suites: 4 passed, 4 total
Tests:       28 passed, 28 total
Snapshots:   0 total
Time:        0.555s, estimated 1s
Ran all test suites.
--------------------------------------------|----------|----------|----------|----------|----------------|
File                                        |  % Stmts | % Branch |  % Funcs |  % Lines |Uncovered Lines |
--------------------------------------------|----------|----------|----------|----------|----------------|
All files                                   |      100 |      100 |      100 |      100 |                |
 quick-find                                 |      100 |      100 |      100 |      100 |                |
  QuickFind.js                              |      100 |      100 |      100 |      100 |                |
 quick-union                                |      100 |      100 |      100 |      100 |                |
  QuickUnion.js                             |      100 |      100 |      100 |      100 |                |
 weighted-quick-union                       |      100 |      100 |      100 |      100 |                |
  WeightedQuickUnion.js                     |      100 |      100 |      100 |      100 |                |
 weighted-quick-union-with-path-compression |      100 |      100 |      100 |      100 |                |
  WeightedQuickUnionWithPathCompression.js  |      100 |      100 |      100 |      100 |                |
--------------------------------------------|----------|----------|----------|----------|----------------|
✨  Done in 1.26s.
```

## Course:

### Week 1 - Union Find

Notes:

* [Quick Find](union-find/quick-find/README.md)
* [Quick Union](union-find/quick-union/README.md)
* [Weighted Quick Union](union-find/weighted-quick-union/README.md)
* [Weighted Quick Union with path compression](union-find/weighted-quick-union-with-path-compression/README.md)

#### Union Find assignment

Go to `union-find/assignment/` and assuming you have both Java and Gradle installed, just run:

`./gradlew clean test`

Output:

```
BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

[Feedback from the assignment](union-find/assignment/feedback.md)

### Week 2 - Bags, Queues and Stacks

Notes:

* [Stacks](bags-queues-and-stacks/stacks/README.md)
* [Queues](bags-queues-and-stacks/queues/README.md)

#### Assignment

Go to `bags-queues-and-stacks/assignment/` and assuming you have both Java and Gradle installed, just run:

`./gradlew clean test`

Output:

```
???? Coming soon
```

[Feedback from the assignment](bags-queues-and-stacks/assignment/feedback.md)
