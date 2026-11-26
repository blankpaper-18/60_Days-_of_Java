# Day 23 - ArrayList and LinkedList

- `ArrayList`: array-backed, O(1) `get`, slow insert/remove in the middle. Default choice.
- `LinkedList`: fast add/remove at the ends, slow `get(i)`. Also works as a queue/stack.
- Program to the interface: `List<String> list = new ArrayList<>();`
- `removeIf` and `forEach` use lambdas; `Collections.sort/reverse/max/min` are handy.

## Run
```bash
javac Main.java
java Main
```
