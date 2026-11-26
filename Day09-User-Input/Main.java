import java.util.Scanner;

/** Day 9 - User Input with Scanner */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your height in metres: ");
        double height = sc.nextDouble();
        sc.nextLine();   // consume the leftover newline after a number

        System.out.print("Enter your favourite language: ");
        String language = sc.nextLine();

        System.out.printf("Hi %s! You are %d years old, %.2f m tall, and you love %s.%n",
                name, age, height, language);

        // Simple calculator
        System.out.print("Enter two numbers separated by a space: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.print("Choose operator (+ - * /): ");
        char op = sc.next().charAt(0);

        double result;
        switch (op) {
            case '+' -> result = x + y;
            case '-' -> result = x - y;
            case '*' -> result = x * y;
            case '/' -> {
                if (y == 0) {
                    System.out.println("Cannot divide by zero.");
                    sc.close();
                    return;
                }
                result = x / y;
            }
            default -> {
                System.out.println("Invalid operator.");
                sc.close();
                return;
            }
        }
        System.out.println(x + " " + op + " " + y + " = " + result);

        // Validating input with hasNextInt()
        System.out.print("Enter a whole number: ");
        while (!sc.hasNextInt()) {
            System.out.print("That's not a whole number. Try again: ");
            sc.next();
        }
        System.out.println("You entered: " + sc.nextInt());
        sc.close();
    }
}
