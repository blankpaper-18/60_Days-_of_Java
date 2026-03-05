
import java.util.Scanner;
public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String moring = "Good morning!";
        System.out.println(moring);

        String night = "Good night!";
        System.out.println(night);
        night = "Bad night!";
        System.out.println(night);
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt() ;
        String message = "Hello, my name is " + fullName + " and I am " + age + " years old.";
        System.out.println(message);
}
}
