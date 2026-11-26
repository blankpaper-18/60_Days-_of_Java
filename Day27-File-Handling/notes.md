# Day 27 - File Handling

- Modern way: `java.nio.file` (`Path`, `Paths`, `Files.readAllLines`, `Files.writeString`, `Files.list`).
- Classic way: `BufferedReader` / `BufferedWriter` inside try-with-resources.
- `NoSuchFileException` and `IOException` are checked: handle them.
- This day writes into an `output/` folder next to where you run it (ignored by git).

## Run
```bash
javac Main.java
java Main
```
