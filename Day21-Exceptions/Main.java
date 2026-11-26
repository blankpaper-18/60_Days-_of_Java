import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Day 21 - Exceptions */
public class Main {

    static int divide(int a, int b) {
        return a / b;     // throws ArithmeticException if b == 0
    }

    // 'throws' declares a checked exception the caller must handle
    static String readFirstLine(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {   // try-with-resources
            return reader.readLine();
        }
    }

    static void checkAge(int age) {
        if (age < 18) throw new IllegalArgumentException("Age must be 18+, got " + age);
        System.out.println("Age OK: " + age);
    }

    public static void main(String[] args) {
        // try / catch / finally
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(10, 0));
            System.out.println("never reached");
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("finally always runs");
        }

        // Multiple catch blocks (most specific first)
        String[] data = {"10", "abc", null};
        for (String s : data) {
            try {
                int n = Integer.parseInt(s);
                System.out.println("Parsed: " + n);
            } catch (NumberFormatException e) {
                System.out.println("Not a number: " + s);
            }
        }

        try {
            int[] arr = new int[3];
            arr[5] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index: " + e.getMessage());
        }

        try {
            String text = null;
            text.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }

        // Multi-catch
        try {
            Object o = "text";
            Integer i = (Integer) o;
        } catch (ClassCastException | IllegalStateException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
        }

        // Checked exception
        try {
            System.out.println(readFirstLine("does-not-exist.txt"));
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // throw
        try {
            checkAge(25);
            checkAge(12);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        System.out.println("Program finished normally.");
    }
}
