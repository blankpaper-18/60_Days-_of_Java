# Day 9 - User Input

- `Scanner sc = new Scanner(System.in);`
- `nextInt()` / `nextDouble()` leave the newline behind: call `nextLine()` once before reading a line.
- Check input with `hasNextInt()` before reading to avoid `InputMismatchException`.
- Close the Scanner when finished.
- Run it by typing answers, or pipe them in: `printf 'Asha\n21\n' | java Main`.

## Run
```bash
javac Main.java
java Main
```
