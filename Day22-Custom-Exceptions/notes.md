# Day 22 - Custom Exceptions

- Extend `Exception` for checked, `RuntimeException` for unchecked.
- Add useful data (like `shortfall`) to the exception class.
- Chain causes: `new IllegalStateException(msg, cause)` keeps the original stack trace.
- Rule of thumb: checked if the caller can reasonably recover, otherwise unchecked.

## Run
```bash
javac Main.java
java Main
```
