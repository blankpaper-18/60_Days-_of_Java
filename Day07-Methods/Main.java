/** Day 7 - Methods */
public class Main {

    // No parameters, no return value
    static void greet() {
        System.out.println("Hello from a method!");
    }

    // Parameters + return value
    static int add(int a, int b) {
        return a + b;
    }

    // Method overloading - same name, different parameters
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c)   { return a + b + c; }

    // Varargs
    static int sum(int... values) {
        int total = 0;
        for (int v : values) total += v;
        return total;
    }

    // Recursion
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    // Java is pass-by-value: the copy changes, not the original
    static void tryToChange(int x) { x = 100; }
    static void changeArray(int[] arr) { arr[0] = 100; }   // the array contents CAN change

    public static void main(String[] args) {
        greet();
        System.out.println("add(2, 3) = " + add(2, 3));
        System.out.println("add(2.5, 3.5) = " + add(2.5, 3.5));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
        System.out.println("sum() = " + sum() + ", sum(1,2,3,4,5) = " + sum(1, 2, 3, 4, 5));
        System.out.println("5! = " + factorial(5));

        System.out.print("Fibonacci: ");
        for (int i = 0; i < 10; i++) System.out.print(fibonacci(i) + " ");
        System.out.println();

        System.out.print("Primes under 30: ");
        for (int i = 1; i < 30; i++) if (isPrime(i)) System.out.print(i + " ");
        System.out.println();

        int value = 5;
        tryToChange(value);
        System.out.println("value after tryToChange = " + value);
        int[] arr = {1, 2, 3};
        changeArray(arr);
        System.out.println("arr[0] after changeArray = " + arr[0]);
    }
}
