import java.util.Scanner;

public class controlStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // nested if statement 
            System.out.println("Enter a number: ");
            Double number = scanner.nextDouble();
            if(number >= 0 ){
                System.out.println("The number is positive");
            {
             if(number % 2 == 0){
                System.out.println("The number is even");}}

            }
      // if else statement 
            else {
                System.out.println("The number is negative");
            }
    //    nested if else statement 
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();
            if(age < 18){
                System.out.println("You are a minor");
            } else {if (age >= 18 && age < 65) {
                System.out.println("You are an adult");
            } else {
                System.out.println("You are a senior citizen");
            }}
            
        // if else if else statement 
            System.out.println("Enter a grade (A, B, C, D, F): ");
            String grade = scanner.next();
            if(grade.equalsIgnoreCase("A")){
                System.out.println("Excellent!");
            } else if (grade.equalsIgnoreCase("B")) {
                System.out.println("Good job!");
            } else if (grade.equalsIgnoreCase("C")) {
                System.out.println("You passed.");
            } else if (grade.equalsIgnoreCase("D")) {
                System.out.println("You need to improve.");
            } else if (grade.equalsIgnoreCase("F")) {
                System.out.println("You failed.");
            } else {
                System.out.println("Invalid grade entered.");
            }
            // ternary operator
            // syntax: condition ? expressionIfTrue : expressionIfFalse
            System.out.println("Enter a number: ");
            int num = scanner.nextInt();
            String result = (num % 2 == 0) ? "Even" : "Odd";
            System.out.println("The number is: " + result);
            
            
        
        
    }
}