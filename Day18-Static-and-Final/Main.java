/** Day 18 - static and final */
class Counter {
    static int instances = 0;          // shared by ALL objects
    final int id;                      // each object's id never changes after construction

    static final double PI = 3.14159;  // constant

    static {                           // static block: runs once when the class loads
        System.out.println("Counter class loaded");
    }

    Counter() {
        instances++;
        id = instances;
    }

    static int getInstances() { return instances; }   // static method: no 'this'

    @Override public String toString() { return "Counter#" + id; }
}

final class ImmutablePoint {           // final class cannot be extended
    private final int x, y;
    ImmutablePoint(int x, int y) { this.x = x; this.y = y; }
    ImmutablePoint withX(int newX) { return new ImmutablePoint(newX, y); }
    @Override public String toString() { return "(" + x + ", " + y + ")"; }
}

class Parent {
    final void rules() { System.out.println("This method cannot be overridden"); }
}

class MathUtil {
    static int square(int n) { return n * n; }
    static int max(int a, int b) { return a >= b ? a : b; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main...");
        Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();
        System.out.println(a + ", " + b + ", " + c);
        System.out.println("Instances created: " + Counter.getInstances());
        System.out.println("PI = " + Counter.PI);

        System.out.println("square(7) = " + MathUtil.square(7));
        System.out.println("max(3, 9) = " + MathUtil.max(3, 9));

        ImmutablePoint p1 = new ImmutablePoint(1, 2);
        ImmutablePoint p2 = p1.withX(10);
        System.out.println(p1 + " -> " + p2);

        new Parent().rules();

        final int[] arr = {1, 2, 3};
        arr[0] = 99;     // allowed: the reference is final, the contents are not
        System.out.println("arr[0] = " + arr[0]);
    }
}
