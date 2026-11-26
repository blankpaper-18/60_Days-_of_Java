# Day 21 - Exceptions

- Checked exceptions (`IOException`) must be handled or declared; unchecked (`RuntimeException`) need not be.
- `try / catch / finally`: `finally` always runs. Catch the most specific exception first.
- try-with-resources closes resources automatically.
- `throw` raises one, `throws` declares one. Never leave a `catch` block empty.

## Run
```bash
javac Main.java
java Main
```
