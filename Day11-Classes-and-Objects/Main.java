/** Day 11 - Classes and Objects */
class Car {
    // Fields (state)
    String brand;
    String color;
    int speed;

    // Methods (behaviour)
    void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + " accelerates to " + speed + " km/h");
    }

    void brake() {
        speed = 0;
        System.out.println(brand + " stopped.");
    }

    void showInfo() {
        System.out.println("Car{brand=" + brand + ", color=" + color + ", speed=" + speed + "}");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.color = "Red";
        c1.accelerate(40);
        c1.accelerate(30);
        c1.showInfo();
        c1.brake();

        Car c2 = new Car();
        c2.brand = "Honda";
        c2.color = "Blue";
        c2.showInfo();

        // Objects are references
        Car c3 = c1;            // c3 points to the same object as c1
        c3.color = "Black";
        System.out.println("c1 color is now: " + c1.color);

        Car c4 = null;
        System.out.println("c4 is null: " + (c4 == null));
    }
}
