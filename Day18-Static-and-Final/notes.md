# Day 18 - static and final

- `static` belongs to the class, not to any object. Static methods have no `this`.
- A static block runs once, when the class is first loaded.
- `final` variable: assigned once. `final` method: can't be overridden. `final` class: can't be extended.
- `final` on a reference stops reassignment, not mutation of the object.

## Run
```bash
javac Main.java
java Main
```
