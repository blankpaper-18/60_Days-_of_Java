/** Day 15 - Polymorphism */
class Shape {
    double area() { return 0; }
    String describe() { return "Shape"; }
}

class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    @Override double area() { return Math.PI * radius * radius; }
    @Override String describe() { return "Circle(r=" + radius + ")"; }
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    @Override double area() { return w * h; }
    @Override String describe() { return "Rectangle(" + w + "x" + h + ")"; }
}

class Printer {
    // Compile-time polymorphism: method overloading
    void print(int x)    { System.out.println("int: " + x); }
    void print(String s) { System.out.println("String: " + s); }
    void print(double d) { System.out.println("double: " + d); }
}

public class Main {
    public static void main(String[] args) {
        // Runtime polymorphism: parent reference, child object
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Shape() };
        double total = 0;
        for (Shape s : shapes) {
            System.out.printf("%-18s area = %.2f%n", s.describe(), s.area());
            total += s.area();
        }
        System.out.printf("Total area: %.2f%n%n", total);

        // instanceof with pattern matching (Java 16+)
        for (Shape s : shapes) {
            if (s instanceof Circle c) {
                System.out.println("It's a circle with radius " + c.radius);
            } else if (s instanceof Rectangle r) {
                System.out.println("It's a rectangle " + r.w + " by " + r.h);
            } else {
                System.out.println("Just a plain shape");
            }
        }

        System.out.println();
        Printer p = new Printer();
        p.print(10);
        p.print("Hello");
        p.print(3.14);
    }
}
