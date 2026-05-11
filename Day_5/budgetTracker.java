import java.util.Scanner;

public class budgetTracker {
    public static  void main (String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter your monthly Income:");
        double Income = scanner.nextDouble();

        System.out.println("Enter your monthly Rent: ");
        double Rent = scanner.nextDouble();

        System.out.println("Enter your monthly groceries expences:");
        double Groceries = scanner.nextDouble();

        System.out.println("Enter your monthly transport expences:");
        double Transport = scanner.nextDouble();

        System.out.println("Enter your monthly entertaiment expences:");
        double Entertiment = scanner.nextDouble();

        double totalExpence = Entertiment + Transport + Groceries + Rent;
        
        double remainingIncome = Income - totalExpence;

        double rentPercentage = Rent/Income*100;
        double groceriesPercentage = Groceries/Income*100;
        double transportPercentage = Transport/Income*100;
        double entertimentPercentage = Entertiment/Income*100;

        System.out.println( "\n******** Budget Summary ********");
        System.out.printf("Monthly Income: Rs%.2f\n",Income);
        System.out.printf("Rent: Rs%.2f (%.2f%%)\n", Rent, rentPercentage);
        System.out.printf("Groceries: Rs%.2f (%.2f%%)\n", Groceries, groceriesPercentage);
        System.out.printf("Transport: Rs%.2f (%.2f%%)\n", Transport, transportPercentage);
        System.out.printf("Entertainment: Rs%.2f (%.2f%%)\n", Entertiment, entertimentPercentage);
        System.out.printf("Total Expenses: Rs%.2f\n", totalExpence);
        System.out.printf("Remaining Income: Rs%.2f\n", remainingIncome);

    
}
}