import java.util.Scanner;
public class galaxyWeatherAdvisor {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Welcome to the Galaxy Weather Advisor!");
        System.out.println("Please enter the planet you are on(Earth, Mars, Venus,Jupiter): ");
        String planet = scanner.nextLine().toLowerCase();
        System.out.println("Please enter the current temperature in Celsius:");
        double temperature = scanner.nextDouble();

        String advice;
        
        if (planet.equals("earth")){
            if (temperature < 0){
                advice = "It's freezing on Earth! Stay indoors and keep warm.";
            } else if (temperature >= 0 && temperature < 20){
                advice = "It's chilly on Earth. Wear a jacket!";
            } else {
                advice = "It's warm on Earth. Enjoy the weather!";
            }
        } else if (planet.equals("mars")){
            if (temperature < -80){
                advice = "It's extremely cold on Mars! Stay inside your habitat.";
            } else if (temperature >= -80 && temperature < -20){
                advice = "It's cold on Mars. Dress warmly!";
            } else {
                advice = "It's relatively mild on Mars. Enjoy your day!";
            }
        } else if (planet.equals("venus")){
            if (temperature < 450){
                advice = "It's scorching hot on Venus! Avoid going outside.";
            } else {
                advice = "Venus is always hot! Stay hydrated and cool.";
            }
        } else if (planet.equals("jupiter")){
            if (temperature < -145){
                advice   = "It's extremely cold on Jupiter! Stay in your spacecraft.";
            } else {
                advice = "Jupiter's weather is unpredictable. Be prepared for anything!";
            }
        } else {
            advice = "Unknown planet! Please enter a valid planet name.";
        }

        System.out.println(advice);
    }
    
}
