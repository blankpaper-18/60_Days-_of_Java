import java.util.*;

/** Day 26 - Iterators, Comparable and Comparator */
class Person implements Comparable<Person> {
    final String name;
    final int age;
    final double salary;

    Person(String name, int age, double salary) {
        this.name = name; this.age = age; this.salary = salary;
    }

    // Natural ordering: by age
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override public String toString() { return name + "(" + age + ", " + salary + ")"; }
}

public class Main {
    public static void main(String[] args) {
        // Iterator - safe removal while looping
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }
        System.out.println("odds only: " + nums);

        // Removing inside a for-each loop throws ConcurrentModificationException
        try {
            List<Integer> bad = new ArrayList<>(List.of(1, 2, 3, 4));
            for (Integer n : bad) if (n == 2) bad.remove(n);
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught");
        }

        // Comparable
        List<Person> people = new ArrayList<>(List.of(
            new Person("Asha", 30, 70000),
            new Person("Ravi", 25, 55000),
            new Person("Meena", 35, 90000),
            new Person("Kiran", 25, 65000)
        ));
        Collections.sort(people);
        System.out.println("By age (Comparable): " + people);

        // Comparator - custom ordering
        people.sort(Comparator.comparing(p -> p.name));
        System.out.println("By name:  " + people);

        people.sort(Comparator.comparingDouble((Person p) -> p.salary).reversed());
        System.out.println("By salary desc: " + people);

        people.sort(Comparator.comparingInt((Person p) -> p.age).thenComparing(p -> p.name));
        System.out.println("By age, then name: " + people);

        // Old-style anonymous Comparator
        people.sort(new Comparator<Person>() {
            @Override public int compare(Person a, Person b) { return b.name.compareTo(a.name); }
        });
        System.out.println("Name Z-A: " + people);

        // Sorting strings by length, then alphabetically
        List<String> words = new ArrayList<>(List.of("banana", "kiwi", "apple", "fig", "cherry"));
        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(words);

        // TreeSet with a Comparator
        TreeSet<String> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.addAll(words);
        System.out.println(reverseSet);

        // Making your own class iterable
        Range range = new Range(1, 5);
        for (int n : range) System.out.print(n + " ");
        System.out.println();
    }

    static class Range implements Iterable<Integer> {
        private final int start, end;
        Range(int start, int end) { this.start = start; this.end = end; }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                int current = start;
                @Override public boolean hasNext() { return current <= end; }
                @Override public Integer next() { return current++; }
            };
        }
    }
}
