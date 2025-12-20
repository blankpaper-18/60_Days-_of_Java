public class Operators {
    public static void main (String[] args)
    {
        int a = 10;
        int b = 20;
        int sum = a +b;
        System.out.println("The sum of a and b is :"+ sum);
        int diff = b - a;
        System.out.println("The difference of b and a is :"+ diff);
        int prod = a * b;
        System.out.println("The product of a and b is :"+ prod);
        int quot = b / a;
        System.out.println("The quotient of b and a is :"+ quot);
        int mod = b % a;
        System.out.println("The modulus of b and a is :"+ mod);
        a += 5; // a = a + 5
        System.out.println("The value of a after a += 5 is :"+ a);
        b -= 5; // b = b - 5
        System.out.println("The value of b after b -= 5 is :"+ b);
        a *= 2; // a = a * 2
        System.out.println("The value of a after a *= 2 is :"+ a);
        // Increment and Decrement
        a++; // a = a + 1
        System.out.println("The value of a after a++ is :"+ a);
        b--; // b = b - 1
        System.out.println("The value of b after b-- is :"+ b);
        // unary operators
        int c = -a; // unary minus
        System.out.println("The value of c after unary minus is :"+ c);
        int d = +b; // unary plus
        System.out.println("The value of d after unary plus is :"+ d);
        // relational operators
        System.out.println("Is a equal to b? " + (a == b));
        System.out.println("Is a not equal to b? " + (a != b));
        System.out.println("Is a greater than b? " + (a > b));
        System.out.println("Is a less than b? " + (a < b));

        System.out.println("Is a greater than or equal to b? " + (a >= b));
        System.out.println("Is a less than or equal to b? " + (a <= b));
        // Compound Operators
        int e = 5;
        e += 10; // e = e + 10
        System.out.println("The value of e after e += 10 is :"+ e);
        e *= 2; // e = e * 2
        System.out.println("The value of e after e *= 2 is :"+ e);
        e -= 5; // e = e - 5
        System.out.println("The value of e after e -= 5 is :"+ e);
        e /= 3; // e = e / 3
        System.out.println("The value of e after e /= 3 is :"+ e);


    

        
    }
    
}
