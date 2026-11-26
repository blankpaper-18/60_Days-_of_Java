import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Day 30 - Mini Project: Student Management System with file persistence (CSV).
 * Uses: classes, collections, streams, exceptions, file handling.
 */
class Student {
    private final int id;
    private String name;
    private double gpa;

    Student(int id, String name, double gpa) {
        if (gpa < 0 || gpa > 10) throw new IllegalArgumentException("GPA must be between 0 and 10");
        this.id = id; this.name = name; this.gpa = gpa;
    }

    int getId() { return id; }
    String getName() { return name; }
    double getGpa() { return gpa; }
    void setGpa(double gpa) {
        if (gpa < 0 || gpa > 10) throw new IllegalArgumentException("GPA must be between 0 and 10");
        this.gpa = gpa;
    }

    String toCsv() { return id + "," + name + "," + gpa; }

    static Student fromCsv(String line) {
        String[] p = line.split(",");
        return new Student(Integer.parseInt(p[0].trim()), p[1].trim(), Double.parseDouble(p[2].trim()));
    }

    @Override public String toString() { return String.format("%-4d %-10s %.2f", id, name, gpa); }
}

class StudentManager {
    private final Map<Integer, Student> students = new TreeMap<>();
    private final Path file;

    StudentManager(Path file) { this.file = file; }

    void add(Student s) {
        if (students.containsKey(s.getId())) throw new IllegalStateException("Duplicate id " + s.getId());
        students.put(s.getId(), s);
    }

    Optional<Student> find(int id) { return Optional.ofNullable(students.get(id)); }

    boolean remove(int id) { return students.remove(id) != null; }

    List<Student> topStudents(int n) {
        return students.values().stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(n).collect(Collectors.toList());
    }

    double averageGpa() {
        return students.values().stream().mapToDouble(Student::getGpa).average().orElse(0);
    }

    void printAll() {
        System.out.println("ID   Name       GPA");
        students.values().forEach(System.out::println);
    }

    void save() throws IOException {
        Files.createDirectories(file.getParent());
        List<String> lines = students.values().stream().map(Student::toCsv).collect(Collectors.toList());
        Files.write(file, lines);
    }

    void load() throws IOException {
        students.clear();
        if (!Files.exists(file)) return;
        for (String line : Files.readAllLines(file)) {
            if (!line.isBlank()) {
                Student s = Student.fromCsv(line);
                students.put(s.getId(), s);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Path dataFile = Paths.get("data", "students.csv");
        StudentManager mgr = new StudentManager(dataFile);

        mgr.add(new Student(1, "Asha", 9.1));
        mgr.add(new Student(2, "Ravi", 7.8));
        mgr.add(new Student(3, "Meena", 8.6));
        mgr.add(new Student(4, "Kiran", 6.9));

        try {
            mgr.add(new Student(2, "Duplicate", 5.0));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            new Student(9, "Bad", 15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        mgr.find(4).ifPresent(s -> s.setGpa(7.4));
        mgr.remove(2);
        mgr.printAll();
        System.out.printf("Average GPA: %.2f%n", mgr.averageGpa());
        System.out.println("Top 2: " + mgr.topStudents(2).stream().map(Student::getName).toList());

        mgr.save();
        System.out.println("\nSaved to " + dataFile + ", reloading into a fresh manager...");
        StudentManager fresh = new StudentManager(dataFile);
        fresh.load();
        fresh.printAll();
    }
}
