import java.util.Arrays;

/** Day 8 - Strings */
public class Main {
    public static void main(String[] args) {
        String s = "  Java Programming  ";

        System.out.println("length: " + s.length());
        System.out.println("trim: '" + s.trim() + "'");
        s = s.trim();
        System.out.println("upper: " + s.toUpperCase() + ", lower: " + s.toLowerCase());
        System.out.println("charAt(5): " + s.charAt(5));
        System.out.println("indexOf(\"Pro\"): " + s.indexOf("Pro"));
        System.out.println("substring(5): " + s.substring(5) + ", substring(0,4): " + s.substring(0, 4));
        System.out.println("replace: " + s.replace('a', '@'));
        System.out.println("contains(\"gram\"): " + s.contains("gram"));
        System.out.println("startsWith/endsWith: " + s.startsWith("Java") + "/" + s.endsWith("ing"));
        System.out.println("isEmpty/isBlank: " + "".isEmpty() + "/" + "   ".isBlank());

        // == vs equals
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        System.out.println("a == b: " + (a == b));               // same pooled object
        System.out.println("a == c: " + (a == c));               // different object
        System.out.println("a.equals(c): " + a.equals(c));       // same content
        System.out.println("equalsIgnoreCase: " + "HELLO".equalsIgnoreCase(a));
        System.out.println("compareTo: " + "apple".compareTo("banana"));

        // split / join
        String csv = "red,green,blue";
        String[] colors = csv.split(",");
        System.out.println(Arrays.toString(colors));
        System.out.println(String.join(" | ", colors));

        // StringBuilder - mutable and faster for many changes
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) sb.append(i).append(',');
        sb.setLength(sb.length() - 1);
        sb.insert(0, "[").append("]");
        System.out.println(sb);
        System.out.println("reversed: " + sb.reverse());

        // Formatting
        System.out.println(String.format("Name: %s | Age: %d | GPA: %.2f", "Asha", 21, 3.756));

        // Text block (Java 15+)
        String json = """
                {
                  "language": "Java",
                  "day": 8
                }
                """;
        System.out.print(json);

        // Palindrome check
        String word = "Madam";
        String cleaned = word.toLowerCase();
        boolean palindrome = new StringBuilder(cleaned).reverse().toString().equals(cleaned);
        System.out.println(word + " palindrome? " + palindrome);

        // Count vowels
        int vowels = 0;
        for (char ch : "Programming Language".toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) vowels++;
        }
        System.out.println("Vowels: " + vowels);
    }
}
