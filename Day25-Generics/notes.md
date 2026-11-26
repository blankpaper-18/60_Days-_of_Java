# Day 25 - Generics

- Type parameters (`Box<T>`) give compile-time type safety and remove casts.
- Bounded types: `<T extends Comparable<T>>`.
- Wildcards: `? extends X` to read from (producer), `? super X` to write into (consumer) - 'PECS'.
- Generics are erased at runtime, so you cannot do `new T()` or `T[]`.

## Run
```bash
javac Main.java
java Main
```
