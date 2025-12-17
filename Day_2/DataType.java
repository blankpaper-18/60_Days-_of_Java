public class DataType {

    public static void main (String args[]) {
        // Primitive Data Types
        int myNum = 5;               // Integer
        float myFloatNum = 5.99f;    // Floating point number
        char myLetter = 'D';         // Character we use single quotes for char
        boolean myBool = true;       // Boolean
        double myDouble = 19.99; 
        boolean myBool2 = false;     // Boolean
        // also include long, short, byte if needed also boolean 
        // byte 8 bits to calculate how mauch memory is used we will do 2^8 and divide by 2 to get positive values only
        // short 16 bits same calculation 2^16 /2 
        // int 32 bits
        // long 64 bits
        // float 32 bits
        // double 64 bits
        // Non-Primitive Data Types(Reference Data Types)
        String myText = "Hello , Java";     // String

        System.out.println("Integer: " + myNum);
        System.out.println("Float: " + myFloatNum);
        System.out.println("Character: " + myLetter);
        System.out.println("Boolean: " + myBool);
        System.out.println("Double: " + myDouble);
        System.out.println("String: " + myText);
        System.out.println("Boolean: " + myBool2);

        int num1, num2, sum;
        num1 = 10;
        num2 = 20;
        sum = num1 + num2;
        System.out.println("Sum: " + sum);
        // declare multiple variables in one line
        int difference, product, quotient;
        difference = num2 - num1;
        product = num1 * num2;  
        quotient = num2 / num1;
        System.out.println("Difference: "+ difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        // type casting
        // widening conversion/Implicit casting : converting a smaller data type to a larger data type
        int myInt = 9;
        double myDouble2 = myInt; // Automatic casting: int to double
        System.out.println("Widening Conversion: " + myDouble2); // Outputs 9.0
        // narrowing conversion/Explicit casting : converting a larger data type to a smaller data type
        // data loss may occur
        double myDouble3 = 9.78;
        int myInt2 = (int) myDouble3; // Manual casting: double to int
        System.out.println("Narrowing Conversion: " + myInt2); // Outputs 9
        double shapeValue = 7.25;
        System.out.println("Current Shape (double): " + shapeValue  );
        int intshape = (int) shapeValue;
        System.out.println("Current Shape (int): " + intshape );
        long longShape = (long) shapeValue;
        System.out.println("Current Shape (long): " + longShape );
        
    }
}