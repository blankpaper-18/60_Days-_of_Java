# Day 13 - Encapsulation

- Make fields `private`, expose controlled access through getters/setters.
- Setters and constructors are the place for validation.
- Not every field needs a setter; `final` fields with only a getter are read-only.
- Prefer behaviour methods (`deposit`, `withdraw`) over raw setters.

## Run
```bash
javac Main.java
java Main
```
