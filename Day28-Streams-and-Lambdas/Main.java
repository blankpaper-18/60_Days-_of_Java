import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/** Day 28 - Lambdas, Functional Interfaces and the Stream API */
public class Main {
    record Employee(String name, String dept, double salary, int age) {}

    public static void main(String[] args) {
        // Lambdas and built-in functional interfaces
        Function<Integer, Integer> square = x -> x * x;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Predicate<String> isLong = s -> s.length() > 4;
        Consumer<String> shout = s -> System.out.println(s.toUpperCase() + "!");
        Supplier<Double> random = () -> 4.0;     // fixed value for repeatable output
        UnaryOperator<String> twice = s -> s + s;

        System.out.println(square.apply(6) + " " + add.apply(2, 3) + " " + isLong.test("lambda"));
        shout.accept("hello");
        System.out.println(random.get() + " " + twice.apply("ab"));
        System.out.println("andThen: " + square.andThen(x -> x + 1).apply(5));

        // Method references
        List<String> names = List.of("zara", "adam", "mia", "liam", "eve");
        names.forEach(System.out::println);

        // Stream basics
        List<Integer> nums = List.of(5, 12, 8, 3, 21, 14, 7, 10);
        System.out.println("evens squared: " + nums.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList()));
        System.out.println("sum: " + nums.stream().mapToInt(Integer::intValue).sum());
        System.out.println("average: " + nums.stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println("max: " + nums.stream().max(Integer::compare).get());
        System.out.println("sorted desc: " + nums.stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println("first 3: " + nums.stream().limit(3).toList());
        System.out.println("any > 20? " + nums.stream().anyMatch(n -> n > 20));
        System.out.println("all > 0?  " + nums.stream().allMatch(n -> n > 0));
        System.out.println("reduce (product of 1..5): " + IntStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * b));
        System.out.println("distinct: " + Stream.of(1, 2, 2, 3, 3, 3).distinct().toList());
        System.out.println("joined: " + names.stream().map(String::toUpperCase).collect(Collectors.joining(", ", "[", "]")));

        // Streams on objects
        List<Employee> staff = List.of(
            new Employee("Asha", "Engineering", 90000, 30),
            new Employee("Ravi", "Engineering", 75000, 26),
            new Employee("Meena", "HR", 60000, 35),
            new Employee("Kiran", "Sales", 55000, 28),
            new Employee("Zoya", "Sales", 65000, 32),
            new Employee("Dev", "Engineering", 105000, 40)
        );

        System.out.println("High earners: " + staff.stream().filter(e -> e.salary() > 70000).map(Employee::name).toList());

        Map<String, List<String>> byDept = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept, TreeMap::new,
                     Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println("By dept: " + byDept);

        Map<String, Double> avgSalary = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept, TreeMap::new, Collectors.averagingDouble(Employee::salary)));
        System.out.println("Avg salary: " + avgSalary);

        Map<String, Long> counts = staff.stream()
            .collect(Collectors.groupingBy(Employee::dept, TreeMap::new, Collectors.counting()));
        System.out.println("Headcount: " + counts);

        System.out.println("Highest paid: " + staff.stream().max(Comparator.comparingDouble(Employee::salary)).get().name());
        DoubleSummaryStatistics stats = staff.stream().mapToDouble(Employee::salary).summaryStatistics();
        System.out.printf("Salary stats: min=%.0f max=%.0f avg=%.0f total=%.0f%n",
                          stats.getMin(), stats.getMax(), stats.getAverage(), stats.getSum());

        Map<Boolean, List<String>> partition = staff.stream()
            .collect(Collectors.partitioningBy(e -> e.age() >= 32, Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println("32 and over? " + partition);

        // Optional
        Optional<Employee> found = staff.stream().filter(e -> e.name().equals("Zoya")).findFirst();
        found.ifPresent(e -> System.out.println("Found " + e));
        System.out.println(staff.stream().filter(e -> e.name().equals("Nobody")).findFirst().map(Employee::name).orElse("not found"));
    }
}
