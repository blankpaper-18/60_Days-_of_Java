/** Day 12 - Constructors */
class Student {
    String name;
    int age;
    String course;

    // Default constructor
    Student() {
        this("Unknown", 0, "Undeclared");   // constructor chaining
    }

    // Parameterised constructor
    Student(String name, int age) {
        this(name, age, "Undeclared");
    }

    Student(String name, int age, String course) {
        this.name = name;      // 'this' distinguishes the field from the parameter
        this.age = age;
        this.course = course;
    }

    // Copy constructor
    Student(Student other) {
        this(other.name, other.age, other.course);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", course='" + course + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Ravi", 20);
        Student s3 = new Student("Meena", 22, "Computer Science");
        Student s4 = new Student(s3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        s4.name = "Meena Copy";
        System.out.println("s3 unchanged: " + s3.name);
    }
}
