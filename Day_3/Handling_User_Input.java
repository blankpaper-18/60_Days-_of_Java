
import java.util.Scanner;


public class Handling_User_Input {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String name = scanner.nextLine();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.");
        System.out.println("Enter number a: ");
        int a = scanner.nextInt();
        System.out.println("Enter number b: ");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("The sum of a and b is: " + sum);
        // System.out.println("Hello, " + name + "!");
        scanner.close();
        
        
    
}
}