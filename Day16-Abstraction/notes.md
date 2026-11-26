# Day 16 - Abstraction

- An `abstract` class cannot be instantiated and may contain abstract (body-less) methods.
- Subclasses must implement every abstract method (or be abstract themselves).
- Use it for shared code + a required contract (template method idea: `printPayslip` uses abstract `calculateSalary`).

## Run
```bash
javac Main.java
java Main
```
