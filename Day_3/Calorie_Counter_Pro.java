
import java.util.Scanner;


public class Calorie_Counter_Pro {
    public static void main(String[] args) {
        // Welcome message
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Calorie Counter Pro!");

        // here we will prompt the user to enter the three food items
        System.out.print("Enter the name of food item 1: ");
        String food1 = scanner.nextLine();
        System.out.print("Enter the name of food item 2: ");
        String food2 = scanner.nextLine();
        System.out.print("Enter the name of food item 3: ");
        String food3 = scanner.nextLine();
        // Now we will prompt the user to enter the calorie counts for each food item
        System.out.print("Enter the calorie count for " + food1 + ": ");
        int calories1 = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter the calorie count for " + food2 + ": ");    
        int calories2 = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the calorie count for " + food3 + ": ");
        int calories3 = scanner.nextInt();
        scanner.nextLine();
        // Calculate total calories
        int totalCalories = calories1 + calories2 + calories3;
        // Display the total calorie count
        System.out.println("The total calorie count for " + food1 + ", " + food2 + ", and " + food3 + " is: " + totalCalories + " calories.");
        scanner.close();
    }
    
}
