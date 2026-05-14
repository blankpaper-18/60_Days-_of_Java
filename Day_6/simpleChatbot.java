import java.util.Scanner;

public class simpleChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type hello to start the conversation: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("hello")||input.equalsIgnoreCase("hi")) {
            System.out.println("Chatbot: Hello! How can I help you today?"+ " " + "You can ask me about the weather, or just say bye to end the conversation.");}
        String input2 = scanner.nextLine();
        if (input2.equalsIgnoreCase("bye")) {
            System.out.println("Chatbot: Goodbye! Have a great day!");}
        else if (input2.equalsIgnoreCase("how's the weather?")||input2.equalsIgnoreCase("what's the weather like?")) {
                System.out.println("Chatbot: The weather is sunny and warm today!");
            }else {
                System.out.println("Chatbot: I'm sorry, I didn't understand that. Please try again.");
            }

        


            
            

            
    }}
    

