import java.util.*;

/** Day 24 - HashMap, HashSet, TreeMap, LinkedHashMap */
public class Main {
    public static void main(String[] args) {
        // HashMap: key -> value, no ordering guarantee
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Asha", 88);
        marks.put("Ravi", 72);
        marks.put("Meena", 95);
        marks.put("Ravi", 75);                // same key replaces the value
        System.out.println(marks);

        System.out.println("get(Asha): " + marks.get("Asha"));
        System.out.println("getOrDefault(Zed): " + marks.getOrDefault("Zed", 0));
        System.out.println("containsKey(Meena): " + marks.containsKey("Meena"));
        marks.putIfAbsent("Kiran", 60);
        marks.remove("Kiran");

        for (Map.Entry<String, Integer> e : marks.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        marks.forEach((k, v) -> System.out.println(k + " scored " + v));

        // Word frequency counter
        String text = "to be or not to be that is the question to be";
        Map<String, Integer> freq = new TreeMap<>();   // TreeMap keeps keys sorted
        for (String w : text.split(" ")) freq.merge(w, 1, Integer::sum);
        System.out.println("Word counts: " + freq);

        // LinkedHashMap keeps insertion order
        Map<String, String> capitals = new LinkedHashMap<>();
        capitals.put("India", "New Delhi");
        capitals.put("Japan", "Tokyo");
        capitals.put("France", "Paris");
        System.out.println(capitals);

        // HashSet: unique values only
        Set<Integer> unique = new HashSet<>(Arrays.asList(5, 3, 5, 1, 3, 9, 1));
        System.out.println("unique: " + unique + " size=" + unique.size());
        System.out.println("add(3) -> " + unique.add(3) + ", add(42) -> " + unique.add(42));

        // Set operations
        Set<Integer> a = new TreeSet<>(Set.of(1, 2, 3, 4, 5));
        Set<Integer> b = new TreeSet<>(Set.of(4, 5, 6, 7));
        Set<Integer> union = new TreeSet<>(a);        union.addAll(b);
        Set<Integer> intersection = new TreeSet<>(a); intersection.retainAll(b);
        Set<Integer> difference = new TreeSet<>(a);   difference.removeAll(b);
        System.out.println("union=" + union + " intersection=" + intersection + " difference=" + difference);

        // Remove duplicates from a list while keeping order
        List<String> withDupes = List.of("a", "b", "a", "c", "b", "d");
        System.out.println(new ArrayList<>(new LinkedHashSet<>(withDupes)));

        // Queue and Deque
        Queue<String> line = new LinkedList<>();
        line.offer("first"); line.offer("second"); line.offer("third");
        System.out.println("poll: " + line.poll() + ", peek: " + line.peek());

        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(5, 1, 8, 3));
        System.out.print("PriorityQueue order: ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();
    }
}
