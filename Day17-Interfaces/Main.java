import java.util.List;

/** Day 17 - Interfaces */
interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);

    // default method (Java 8+)
    default void reset() { System.out.println("Resetting to original size"); }

    // static method in an interface
    static String version() { return "Resizable v1.0"; }
}

// A class can implement multiple interfaces
class Square implements Drawable, Resizable {
    private double side;
    Square(double side) { this.side = side; }

    @Override public void draw() { System.out.println("Drawing a square of side " + side); }
    @Override public void resize(double factor) {
        side *= factor;
        System.out.println("Square resized to side " + side);
    }
}

class Icon implements Drawable {
    @Override public void draw() { System.out.println("Drawing an icon"); }
}

// Functional interface
@FunctionalInterface
interface Greeter {
    String greet(String name);
}

// Interface with constants
interface Config {
    int MAX_USERS = 100;    // implicitly public static final
}

public class Main {
    public static void main(String[] args) {
        Square sq = new Square(4);
        sq.draw();
        sq.resize(2.5);
        sq.reset();
        System.out.println(Resizable.version());

        // Programming to an interface
        List<Drawable> items = List.of(new Square(1), new Icon());
        for (Drawable d : items) d.draw();

        // Lambda implementing a functional interface
        Greeter formal = name -> "Good day, " + name + ".";
        Greeter casual = name -> "Hey " + name + "!";
        System.out.println(formal.greet("Sir"));
        System.out.println(casual.greet("buddy"));

        // Anonymous class
        Drawable anon = new Drawable() {
            @Override public void draw() { System.out.println("Anonymous drawable"); }
        };
        anon.draw();

        System.out.println("Max users: " + Config.MAX_USERS);
    }
}
