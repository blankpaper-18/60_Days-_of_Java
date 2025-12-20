
import java.util.Scanner;

public class Nwxt_Line_buffer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character
        // otherwise it will go to next line without waiting for user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    
}
