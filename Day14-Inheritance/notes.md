# Day 14 - Inheritance

- `class Dog extends Animal`: Dog gets Animal's non-private members. Java allows one parent class.
- `super(...)` calls the parent constructor and must come first; `super.method()` calls the parent version.
- `@Override` makes the compiler check you really are overriding.
- `protected` = visible to subclasses and the same package. Use inheritance for 'is-a' relationships.

## Run
```bash
javac Main.java
java Main
```
