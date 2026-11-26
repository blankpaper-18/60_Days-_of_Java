import java.util.ArrayList;
import java.util.List;

/** Day 25 - Generics */

// Generic class
class Box<T> {
    private T value;
    Box(T value) { this.value = value; }
    T get() { return value; }
    void set(T value) { this.value = value; }
    @Override public String toString() { return "Box[" + value + "]"; }
}

// Two type parameters
class Pair<K, V> {
    private final K key;
    private final V value;
    Pair(K key, V value) { this.key = key; this.value = value; }
    K getKey() { return key; }
    V getValue() { return value; }
    @Override public String toString() { return "(" + key + ", " + value + ")"; }
}

// Generic interface
interface Repository<T, ID> {
    void save(T item);
    T findById(ID id);
}

class InMemoryRepo implements Repository<String, Integer> {
    private final List<String> items = new ArrayList<>();
    public void save(String item) { items.add(item); }
    public String findById(Integer id) { return items.get(id); }
}

public class Main {
    // Generic method
    static <T> void printArray(T[] array) {
        for (T t : array) System.out.print(t + " ");
        System.out.println();
    }

    // Bounded type parameter: T must be a Comparable
    static <T extends Comparable<T>> T maxOf(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Bounded to Number
    static <T extends Number> double sum(List<T> list) {
        double total = 0;
        for (T n : list) total += n.doubleValue();
        return total;
    }

    // Wildcards
    static void printAll(List<?> list) {
        for (Object o : list) System.out.print(o + " ");
        System.out.println();
    }

    static double sumAll(List<? extends Number> list) {   // upper-bounded: read from it
        double s = 0;
        for (Number n : list) s += n.doubleValue();
        return s;
    }

    static void addIntegers(List<? super Integer> list) { // lower-bounded: write into it
        list.add(1); list.add(2);
    }

    public static void main(String[] args) {
        Box<String> sb = new Box<>("Hello");
        Box<Integer> ib = new Box<>(42);
        String s = sb.get();               // no cast needed - type safe
        System.out.println(sb + " " + ib + " " + s.length());
        // sb.set(10);                     // <- compile error: wrong type

        Pair<String, Integer> p = new Pair<>("age", 30);
        System.out.println(p + " key=" + p.getKey() + " value=" + p.getValue());

        printArray(new Integer[]{1, 2, 3});
        printArray(new String[]{"a", "b", "c"});

        System.out.println("maxOf(3, 9) = " + maxOf(3, 9));
        System.out.println("maxOf(\"apple\", \"pear\") = " + maxOf("apple", "pear"));
        System.out.println("sum = " + sum(List.of(1, 2, 3, 4)) + ", " + sum(List.of(1.5, 2.5)));

        printAll(List.of("x", 1, 2.5));
        System.out.println("sumAll = " + sumAll(List.of(1, 2, 3)));
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println(numbers);

        InMemoryRepo repo = new InMemoryRepo();
        repo.save("first");
        repo.save("second");
        System.out.println("repo.findById(1) = " + repo.findById(1));
    }
}
