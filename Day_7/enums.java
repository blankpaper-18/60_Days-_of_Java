import java.util.Scanner;
public class enums {
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Day today = Day.MONDAY;
        Size shirtSize = Size.LARGE;
        System.out.println("Today is: " + today);
        System.out.println("Shirt size: " + shirtSize);

        System.out.println("Enter the size of coffee you want (SMALL, MEDIUM, LARGE): ");
       Size coffeeSize = Size.valueOf(scanner.nextLine().toUpperCase());
       switch (coffeeSize) {
        case SMALL:
            System.out.println("You ordered a small coffee.");
            break;
        case MEDIUM:
            System.out.println("You ordered a medium coffee.");
            break;
        case LARGE:
            System.out.println("You ordered a large coffee.");
            break;
        default:
            System.out.println("Invalid coffee size.");
       }
    }
    
}
