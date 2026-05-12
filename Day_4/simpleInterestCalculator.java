import java.util.Scanner;
public class simpleInterestCalculator {
    public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
           System.out.print("Enter the principal : ");
           double P = scanner.nextDouble();
           System.out.print("Enter the rate of interest: ");
           double R = scanner.nextDouble();
           System.out.print("Enter the time period: ");
           double T = scanner.nextDouble();
           double SI = (P * R * T) / 100;
           System.out.println("The simple interest is: " + SI);
       }
    }
}

