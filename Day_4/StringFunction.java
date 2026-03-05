
public class StringFunction {
    public static void main(String args[]){
        String quote = "The only way to do great work is to keep working hard.";
        int lenghtOfQuote = quote.length();
        System.out.println("Length of the quote: " + lenghtOfQuote);
        

        // char firstCharacter = quote.charAt(0);
        // char tenthCharacter = quote.charAt(9);
        //System.out.println("First character of the quote: " + firstCharacter);
       // System.out.println("Tenth character of the quote: " + tenthCharacter);
        String st1 = "Hello";
        String st2 = "Hello";
        String st3 = new String("Hello");
        boolean areEqual = (st1.equals(st2)); // This compares the content of the strings
        boolean areEqual2 = (st1 == st2); // This compares the references, not the content of the strings       
        boolean areEqual1 = st1.equals(st3); // This compares the content of the strings
        System.out.println("Are the two strings equal? " + areEqual);
        System.out.println("Are the two strings equal? " + areEqual1);
        System.out.println("Are the two strings equal? " + areEqual2);
        
    }
    

    
}
