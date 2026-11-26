import java.io.*;
import java.nio.file.*;
import java.util.List;

/** Day 27 - File Handling (java.io and java.nio.file) */
public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get("output");
        Path file = dir.resolve("notes.txt");

        try {
            // Create a directory and write a file
            Files.createDirectories(dir);
            Files.writeString(file, "Line 1: Hello files\nLine 2: Java NIO is neat\n");
            System.out.println("Wrote: " + file.toAbsolutePath());

            // Append
            Files.writeString(file, "Line 3: appended\n", StandardOpenOption.APPEND);

            // Read everything
            List<String> lines = Files.readAllLines(file);
            lines.forEach(l -> System.out.println("  " + l));
            System.out.println("Lines: " + lines.size() + ", bytes: " + Files.size(file));

            // Classic java.io with try-with-resources
            try (BufferedWriter w = new BufferedWriter(new FileWriter(dir.resolve("numbers.txt").toFile()))) {
                for (int i = 1; i <= 5; i++) {
                    w.write(String.valueOf(i * i));
                    w.newLine();
                }
            }

            int sum = 0;
            try (BufferedReader r = new BufferedReader(new FileReader(dir.resolve("numbers.txt").toFile()))) {
                String line;
                while ((line = r.readLine()) != null) sum += Integer.parseInt(line.trim());
            }
            System.out.println("Sum of squares read from file: " + sum);

            // File info
            File f = file.toFile();
            System.out.println("exists=" + f.exists() + ", isFile=" + f.isFile() + ", name=" + f.getName());

            // List directory
            try (var stream = Files.list(dir)) {
                stream.forEach(p -> System.out.println("Found: " + p.getFileName()));
            }

            // Copy and delete
            Path backup = dir.resolve("notes-backup.txt");
            Files.copy(file, backup, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(backup);
            System.out.println("Backup created and deleted.");

            // Reading a missing file
            Files.readAllLines(Paths.get("missing.txt"));
        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
