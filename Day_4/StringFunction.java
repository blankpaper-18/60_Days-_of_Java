
public class StringFunction {
    public static void main(String args[]){
        String quote = "The only way to do great work is to keep working hard.";
        int lenghtOfQuote = quote.length();
        System.out.println("Length of the quote: " + lenghtOfQuote);
        

         char firstCharacter = quote.charAt(0);
        // char tenthCharacter = quote.charAt(9);
        System.out.println("First character of the quote: " + firstCharacter);
       // System.out.println("Tenth character of the quote: " + tenthCharacter);
        String st1 = "Hello";
        String st2 = "Hello";
        String st3 = new String("Hello");
        boolean areEqual = (st1.equals(st2)); // This compares the content of the strings
        boolean areEqual2 = (st1 == st2); // This compares the references, not the content of the strings       
        boolean areEqual1 = st1.equals(st3); // This compares the content of the strings if we wil use == it will return false because st1 and st3 are different objects in memory
        System.out.println("Are the two strings equal? " + areEqual);
        System.out.println("Are the two strings equal? " + areEqual1);
        System.out.println("Are the two strings equal? " + areEqual2);
        
        // we can you ingnore case sensitivity by using equalsIgnoreCase() method
        String st4 = "hello";
        boolean areEqual3 = st1.equalsIgnoreCase(st4);
        System.out.println("Are the two strings equal? " + areEqual3);
        // The compareTo() method is used to compare two strings lexicographically. It returns a negative integer, zero, or a positive integer as this string is less than, equal to, or greater than the specified object.
        String animal1 = "cat";
        String animal2 = "dog";
        String animal3 = "cat";

        System.out.println("Comparing animal1 to animal 2 using  compareTo: " + animal1.compareTo(animal2)); // returns a negative value because "cat" comes before "dog" in lexicographical order
        System.out.println("Comparing animal1 to animal3 using compareTo: " + animal1.compareTo(animal3)); // returns 0 because "cat" is equal to "cat"
        System.out.println("Comparing animal2 to animal1 using compareTo: " + animal2.compareTo(animal1)); // returns a positive value because "dog" comes after "cat" in lexicographical order
     // cutting string into substring
     String phase = "enjoying the until you can ";
        String subPhase = phase.substring(0, 9); // this will return "enjoying" here the first parameter is the starting index and the second parameter is the ending index (exclusive)
        String subPhase2 = phase.substring(10); // this will return "the until you can " here the parameter is the starting index and it will return the rest of the string
        System.out.println("Substring of the phase: " + subPhase2);
        System.out.println("Substring of the phase: " + subPhase);
    // string replace, toUppercase  and lowercase
    String phrase = " sea the world with your eyes wide open";
    String replaceString = phrase.replace("sea", "see"); // this will replace "sea" with "see"
    System.out.println(replaceString);
    String upperCasePhrase = phrase.toUpperCase(); // this will convert the string to uppercase
    String lowerCasePhrase = phrase.toLowerCase(); // this will convert the string to lowercase
    System.out.println("Uppercase phrase: " + upperCasePhrase);
    System.out.println("Lowercase phrase: " + lowerCasePhrase);
    // string formatting string create strings with embrdded variables or expressions and formats them in a specific way.
    String name = "Alice";
    int age = 30;
    String message = String.format("My name is %s and I am %d years old.", name, age); // this will create a formatted string with the name and age variables
    System.out.println(message);
    float price = 19.912229f;
    String priceMessage = String.format("the price of the item is %.2f dollars.", price); // this will create a formatted string with the price variable and format it to 2 decimal places
    System.out.println(priceMessage);
    System.out.println(message + " " + priceMessage);  // this will print both messages in one line
    // presedence and associativity: Determines the order in which operator evaluation order.Unary highest precedence, then multiplicative, then additive, and so on. Associativity determines the order of evaluation for operators with the same precedence level. For example, in the expression "3 + 4 * 5", the multiplication operator has higher precedence than the addition operator, so it is evaluated first, resulting in "3 + 20", which then evaluates to "23". In the expression "10 - 5 - 2", the subtraction operator has left-to-right associativity, so it is evaluated from left to right, resulting in "5 - 2", which then evaluates to "3".
    
    }
    

    
}
