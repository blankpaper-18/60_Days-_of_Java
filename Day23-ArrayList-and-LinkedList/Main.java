import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** Day 23 - ArrayList and LinkedList */
public class Main {
    public static void main(String[] args) {
        // ArrayList - backed by a resizable array, fast random access
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add(1, "Zara");         // insert at index
        System.out.println(names);

        System.out.println("get(2): " + names.get(2));
        System.out.println("size: " + names.size());
        System.out.println("contains Bob: " + names.contains("Bob"));
        System.out.println("indexOf Alice: " + names.indexOf("Alice"));

        names.set(0, "Charles");
        names.remove("Zara");
        names.remove(0);
        System.out.println("after edits: " + names);

        Collections.sort(names);
        System.out.println("sorted: " + names);
        Collections.reverse(names);
        System.out.println("reversed: " + names);

        for (String n : names) System.out.print(n.toUpperCase() + " ");
        System.out.println();

        // removeIf + forEach
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        nums.removeIf(n -> n % 2 == 0);
        nums.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("max=" + Collections.max(nums) + ", min=" + Collections.min(nums));

        // LinkedList - doubly linked, fast insert/remove at the ends
        LinkedList<String> queue = new LinkedList<>();
        queue.add("first");
        queue.addFirst("zero");
        queue.addLast("last");
        System.out.println(queue);
        System.out.println("removeFirst: " + queue.removeFirst());
        System.out.println("peekLast: " + queue.peekLast());

        // Stack-like and queue-like behaviour
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println("pop: " + stack.pop() + ", stack now: " + stack);

        // Rough timing: ArrayList vs LinkedList insert at the front
        int n = 50_000;
        List<Integer> al = new ArrayList<>();
        List<Integer> ll = new LinkedList<>();
        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) al.add(0, i);
        long t2 = System.nanoTime();
        for (int i = 0; i < n; i++) ll.add(0, i);
        long t3 = System.nanoTime();
        System.out.println("ArrayList front inserts: " + (t2 - t1) / 1_000_000 + " ms");
        System.out.println("LinkedList front inserts: " + (t3 - t2) / 1_000_000 + " ms");
    }
}
