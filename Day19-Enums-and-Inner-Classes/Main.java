/** Day 19 - Enums and Inner Classes */
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

// Enum with fields, a constructor and methods
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    EARTH(5.976e+24, 6.37814e6),
    JUPITER(1.9e+27, 7.1492e7);

    private final double mass;      // in kg
    private final double radius;    // in metres

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}

enum Level {
    LOW("Green"), MEDIUM("Yellow"), HIGH("Red");
    final String colour;
    Level(String colour) { this.colour = colour; }
}

class Outer {
    private final String secret = "outer-secret";
    private static int created = 0;

    // Inner (non-static) class: tied to an Outer instance
    class Inner {
        void reveal() { System.out.println("Inner can read: " + secret); }
    }

    // Static nested class: independent of an Outer instance
    static class Nested {
        void hello() { System.out.println("Static nested class. Outer instances so far: " + created); }
    }

    Outer() { created++; }

    void localClassDemo() {
        class Local {              // local class, lives inside a method
            void run() { System.out.println("Local class inside a method"); }
        }
        new Local().run();
    }
}

public class Main {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        System.out.println("Today: " + today + ", ordinal: " + today.ordinal());

        switch (today) {
            case SATURDAY, SUNDAY -> System.out.println("Weekend!");
            default -> System.out.println("Weekday");
        }

        for (Day d : Day.values()) System.out.print(d.name().charAt(0) + " ");
        System.out.println();
        System.out.println("valueOf: " + Day.valueOf("FRIDAY"));

        for (Planet p : Planet.values()) {
            System.out.printf("%-8s gravity = %.2f m/s^2%n", p, p.surfaceGravity());
        }

        for (Level l : Level.values()) System.out.println(l + " -> " + l.colour);

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.reveal();
        new Outer.Nested().hello();
        outer.localClassDemo();
    }
}
