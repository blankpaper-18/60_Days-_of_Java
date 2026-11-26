# Day 26 - Iterators and Comparators

- `Iterator.remove()` is the safe way to delete while looping; removing inside for-each throws `ConcurrentModificationException`.
- `Comparable` = a class's natural order (`compareTo`). `Comparator` = any custom order.
- Build comparators with `Comparator.comparing(...).thenComparing(...).reversed()`.
- Implement `Iterable<T>` to make your own class work in for-each.

## Run
```bash
javac Main.java
java Main
```
