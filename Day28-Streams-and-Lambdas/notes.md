# Day 28 - Streams and Lambdas

- Lambda: `(a, b) -> a + b`. Method reference: `String::toUpperCase`.
- Core functional interfaces: `Function`, `BiFunction`, `Predicate`, `Consumer`, `Supplier`, `UnaryOperator`.
- Pipeline = source, intermediate ops (`filter`, `map`, `sorted`, `distinct`, `limit`), terminal op (`collect`, `sum`, `count`, `reduce`, `forEach`).
- `Collectors.groupingBy`, `partitioningBy`, `joining`, `counting`, `averagingDouble`.
- Streams are lazy and single-use; `Optional` models 'maybe no value'.

## Run
```bash
javac Main.java
java Main
```
