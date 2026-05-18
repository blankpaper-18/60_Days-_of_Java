import java.util.Scanner;
public class switchStatement {
    public static void main(String[] args)
    {
        //  the switch statement offers a readable alternative to if-else-if for handling multiple conditions based on the value of a single variable.
        // Enums is defined a fixed set of contants(Example days of the week)
        // when enums are used with the switch statement:Execute differnt code blocks based on enum values,ehancing the code readability and maintaianability.
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter a number (1-7) to get the corresponding day of the week: ");
        int day = scanner.nextInt();
         switch(day)
         {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");}
         // we also can write the above code using the new switch expression syntax introduced in Java 12, which allows for a more concise and expressive way to handle multiple cases. Here's how you can rewrite the above code using switch expressions:
         String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
            };
           System.out.println(dayName);
        // Example no.2
        System.out.println("My weekly schedule:");
        System.out.println("Enter a day of the week (1-7) to see your schedule:");
        int scheduleDay = scanner.nextInt();
        // switch(scheduleDay){
        //     case 1:
        //         System.out.println("Monday: Gym in the morning, work from 9 to 5, dinner with friends at 7.");
        //         break;
        //     case 2:
        //         System.out.println("Tuesday: Yoga class in the morning, work from 9 to 5, movie night at 8.");
        //         break;
        //     case 3:
        //         System.out.println("Wednesday: Swimming in the morning, work from 9 to 5, family dinner at 7.");
        //         break;
        //     case 4:
        //         System.out.println("Thursday: Running in the morning, work from 9 to 5, game night with friends at 8.");
        //         break;
        //     case 5:
        //         System.out.println("Friday: Rest day, work from 9 to 5, date night at 7.");
        //         break;
        //     case 6:
        //         System.out.println("Saturday: Hiking in the morning, free time in the afternoon, party night at 9.");
        //         break;
        //     case 7:
        //         System.out.println("Sunday: Brunch with family, relax at home, early night.");
        //         break;
        //     default:
        //         System.out.println("Invalid day");
            String schedule = switch (scheduleDay) {
                case 1 -> "Monday: Gym in the morning, work from 9 to 5, dinner with friends at 7.";
                case 2 -> "Tuesday: Yoga class in the morning, work from 9 to 5, movie night at 8.";
                case 3 -> "Wednesday: Swimming in the morning, work from 9 to 5, family dinner at 7.";
                case 4 -> "Thursday: Running in the morning, work from 9 to 5, game night with friends at 8.";
                case 5 -> "Friday: Rest day, work from 9 to 5, date night at 7.";
                case 6 -> "Saturday: Hiking in the morning, free time in the afternoon, party night at 9.";
                case 7 -> "Sunday: Brunch with family, relax at home, early night.";
                default -> "Invalid day";
            };
   System.out.println(schedule);
// if Statement vs  Switch Statement
// 1. Use Case: If statements are more flexible and can handle a wider range of conditions, including complex expressions and multiple variables. Switch statements are typically used when you have a single variable that can take on a limited set of discrete values (like enums or integers).
// Example
System.out.println("Enter your mark to get the grade:");
int mark = scanner.nextInt();
if (mark >= 90) {
    System.out.println("Grade: A");
} else if (mark >= 80) {
    System.out.println("Grade: B");
} else if (mark >= 70) {
    System.out.println("Grade: C");
} else if (mark >= 60) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
switch (mark / 10) {
    case 1:
        System.out.println("Grade: A");
        break;
    case 9:
        System.out.println("Grade: A"); 
        break;
    case 8:
        System.out.println("Grade: B");
        break;
    case 7:
        System.out.println("Grade: C");
        break;
    case 6:
        System.out.println("Grade: D");
        break;
    default:
        System.out.println("Grade: F");



}
        // Switch statement with char

System.out.println("Enter your grade (A-F):");
char grade = scanner.next().charAt(0);
grade = Character.toUpperCase(grade); 
switch (grade) {
    case 'A':
        System.out.println("Excellent!");
        break;
    case 'B':
        System.out.println("Good job!");
        break;
    case 'C':
        System.out.println("You passed.");
        break;
    case 'D':
        System.out.println("You barely passed.");
        break;
    case 'F':
        System.out.println("You failed.");
        break;
    default:
        System.out.println("Invalid grade.");
}
// Switch statement with String
System.out.println("Enter a command (start, stop, pause):");
String command = scanner.nextLine().toLowerCase();
switch (command) {
    case "start":
        System.out.println("Machine started.");
        break;
    case "stop":
        System.out.println("Machine stopped.");
        break;
    case "pause":
        System.out.println("Machine paused.");
        break;
    default:
        System.out.println("Unknown command.");
}
// switch statement within a switch statement
System.out.println("Enter the row number (1-10):");
int row = scanner.nextInt();
System.out.println("Enter the column number (1-10):");
int column = scanner.nextInt();
switch (row) {
    case 1, 2, 3:
        switch (column) {
            case 1, 2, 3:
                System.out.println("You are in the top-left section.");
                break;
            case 4, 5, 6:
                System.out.println("You are in the top-middle section.");
                break;
            case 7, 8, 9, 10:
                System.out.println("You are in the top-right section.");
                break;
            default:
                System.out.println("Invalid column number.");
        }
        break;
    case 4, 5, 6:
        switch (column) {
            case 1, 2, 3:
                System.out.println("You are in the middle-left section.");
                break;
            case 4, 5, 6:
                System.out.println("You are in the center section.");
                break;
            case 7, 8, 9, 10:
                System.out.println("You are in the middle-right section.");
                break;
            default:
                System.out.println("Invalid column number.");
        }
        break;
    case 7, 8, 9, 10:
        switch (column) {
            case 1, 2, 3:
                System.out.println("You are in the bottom-left section.");
                break;
            case 4, 5, 6:
                System.out.println("You are in the bottom-middle section.");
                break;
            case 7, 8, 9, 10:
                System.out.println("You are in the bottom-right section.");
                break;
            default:
                System.out.println("Invalid column number.");
        }
        break;
    default:
        System.out.println("Invalid row number.");}
// exampple no.2:
System.out.println("Welcome we have 2 fan clubs: 1. Football Fan Club 2. Basketball  Fan Club");
System.out.println("Enter the number of the fan club you want to join:");
int clubChoice = scanner.nextInt();
switch (clubChoice) {
    case 1:
        System.out.println("Welcome to the Football Fan Club! Please choose your favorite team:");
        System.out.println("1. Team A");
        System.out.println("2. Team B");
        int footballTeam = scanner.nextInt();
        switch (footballTeam) {
            case 1:
                System.out.println("You joined Team A's fan club!");
                break;
            case 2:
                System.out.println("You joined Team B's fan club!");
                break;
            default:
                System.out.println("Invalid team choice.");
        }
        break;
    case 2:
        System.out.println("Welcome to the Basketball Fan Club! Please choose your favorite team:");
        System.out.println("1. Team X");
        System.out.println("2. Team Y");
        int basketballTeam = scanner.nextInt();
        switch (basketballTeam) {
            case 1:
                System.out.println("You joined Team X's fan club!");
                break;
            case 2:
                System.out.println("You joined Team Y's fan club!");
                break;
            default:
                System.out.println("Invalid team choice.");
        }
        break;
    default:
        System.out.println("Invalid fan club choice.");
}   
}

