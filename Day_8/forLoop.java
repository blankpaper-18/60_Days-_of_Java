
import java.util.Scanner;



public class forLoop {
    public static void main(String[]args){
        for (int i =0 ; i<10; i+=2){
            System.out.println("The value of i is: " + i);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the level of the pyramid you want to print");
        int level = scanner.nextInt();
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= level - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
         }
           for (int i = 0; i <= level; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
                for (int k = 1; k <= 2 * (level - i) - 1; k++){
                    System.out.print("*");
                }
            System.out.println();
           }            
            
            
            
               
        }

    }
    

