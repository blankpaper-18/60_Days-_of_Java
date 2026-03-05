import java.util.Scanner;

public class Calorie_Counter_Pro {
   public Calorie_Counter_Pro() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Welcome to the Calorie Counter Pro!");
      System.out.print("Enter the name of food item 1: ");
      String var2 = var1.nextLine();
      System.out.print("Enter the name of food item 2: ");
      String var3 = var1.nextLine();
      System.out.print("Enter the name of food item 3: ");
      String var4 = var1.nextLine();
      System.out.print("Enter the calorie count for " + var2 + ": ");
      int var5 = var1.nextInt();
      var1.nextLine();
      System.out.print("Enter the calorie count for " + var3 + ": ");
      int var6 = var1.nextInt();
      var1.nextLine();
      System.out.print("Enter the calorie count for " + var4 + ": ");
      int var7 = var1.nextInt();
      var1.nextLine();
      int var8 = var5 + var6 + var7;
      System.out.println("The total calorie count for " + var2 + ", " + var3 + ", and " + var4 + " is: " + var8 + " calories.");
      var1.close();
   }
}
