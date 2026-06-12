# Data Structures (Java)

A progression of Java data structure implementations, from binary number arithmetic to probabilistic self-balancing trees — each with unit tests.

## Implementations

### HW1 — Binary Number (`BinaryNumber.java`)
Represents binary numbers as integer arrays. Implements bitwise operations (AND, OR, addition with carry propagation) and decimal-to-binary conversion.
- Demonstrates array manipulation and low-level numeric representation

### HW2 — Dictionary (`Dictionary.java`, `DictionaryItem.java`)
A BST-based dictionary mapping string keys to values. Supports insert, search, and in-order iteration. The `DictionaryCreator` populates the dictionary from a file and benchmarks lookup times.
- **Concepts:** BST insertion and search, comparable keys, file I/O

### HW3 — Task List with Queue (`TaskList.java`, `ListQueue.java`)
A linked-list-backed queue used to manage a task list. Supports enqueue, dequeue, priority reordering, and iteration.
- **Concepts:** Linked list internals, queue ADT, generics

### HW4 — Treap (`Treap.java`)
A randomized BST that maintains both BST ordering (by key) and heap ordering (by random priority), guaranteeing O(log n) expected height. Implements insertion with rotations to restore heap invariants.
- **Concepts:** Probabilistic data structures, BST + heap combined, rotations, generics
- Includes `JUnitTest.java` with test coverage

### HW6 — Counting Sort (`CountingSort.java`)
A non-comparison sort for integer arrays with a bounded range. Runs in O(n + k) time where k is the range of values.
- **Concepts:** Linear-time sorting, trade-offs between comparison and counting sorts
- Includes `CountingSortTest.java`

## Tech Stack

- **Language:** Java 17
- **Testing:** JUnit 5
- **Build:** IntelliJ IDEA / `javac`

## Running Tests

Open in IntelliJ and run the JUnit test classes, or from the command line:
```bash
javac -cp .:junit-platform-console-standalone.jar *.java
java -jar junit-platform-console-standalone.jar --scan-class-path
```

## Concepts Demonstrated

- Binary arithmetic and bitwise operations
- BST operations (insert, search, traversal)
- Queue ADT backed by a linked list
- Probabilistic / randomized data structures (Treap)
- Linear-time sorting (Counting Sort)
- Java generics and comparable interfaces
- Unit testing with JUnit
