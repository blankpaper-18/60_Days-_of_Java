import java.util.Scanner;

/**
 * Day 10 - Mini Project: Console ATM
 * Uses: variables, loops, switch, methods, Scanner.
 */
public class Main {
    static double balance = 1000.00;
    static final int PIN = 1234;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to Java Bank ATM ===");

        if (!login(sc)) {
            System.out.println("Too many wrong attempts. Card blocked.");
            return;
        }

        boolean running = true;
        while (running) {
            showMenu();
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> System.out.printf("Balance: Rs. %.2f%n", balance);
                case 2 -> deposit(sc);
                case 3 -> withdraw(sc);
                case 4 -> { System.out.println("Thank you for banking with us!"); running = false; }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        sc.close();
    }

    static boolean login(Scanner sc) {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Enter PIN: ");
            if (sc.hasNextInt() && sc.nextInt() == PIN) {
                System.out.println("Login successful.");
                return true;
            }
            System.out.println("Wrong PIN (" + (3 - attempt) + " attempts left).");
        }
        return false;
    }

    static void showMenu() {
        System.out.println("\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Exit");
        System.out.print("Choose an option: ");
    }

    static void deposit(Scanner sc) {
        System.out.print("Amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited Rs. %.2f. New balance: Rs. %.2f%n", amount, balance);
    }

    static void withdraw(Scanner sc) {
        System.out.print("Amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew Rs. %.2f. New balance: Rs. %.2f%n", amount, balance);
        }
    }
}
