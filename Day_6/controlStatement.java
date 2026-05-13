import java.util.Scanner;

public class controlStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // if statement 
            System.out.println("Enter a number: ");
            Double number = scanner.nextDouble();
            if(number > 0 ){
                System.out.println("The number is positive");
            }
            else if(number < 0){
                System.out.println("The number is negative");
            }
            else{
                System.out.println("The number is zero");   

            }
        
        
    }
}