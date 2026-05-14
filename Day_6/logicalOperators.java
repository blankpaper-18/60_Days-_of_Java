
import java.util.Scanner;

public class logicalOperators {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
       System.out.println("Enter three numbers: ");
        int a = scanner.nextInt();  
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Logical AND operator (&&)
        if (a < b && b < c) {
            System.out.println("Both conditions are true");
        }

        // Logical OR operator (||)
        if (a > b || b < c) {
            System.out.println("At least one condition is true");
        }

        // Logical NOT operator (!)
        boolean isTrue = true;
        if (!isTrue) {
            System.out.println("This will not be printed");
        } else {
            System.out.println("This will be printed");
        }

    }
    
}
