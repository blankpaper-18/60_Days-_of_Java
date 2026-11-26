import java.util.ArrayList;
import java.util.List;

/**
 * Day 20 - Mini Project: Library Management System (in memory)
 * Uses: classes, encapsulation, inheritance, enums, static, interfaces.
 */
enum BookStatus { AVAILABLE, BORROWED }

interface Searchable {
    boolean matches(String keyword);
}

abstract class Item implements Searchable {
    private static int nextId = 1;
    private final int id;
    private final String title;

    Item(String title) {
        this.id = nextId++;
        this.title = title;
    }

    int getId() { return id; }
    String getTitle() { return title; }

    @Override
    public boolean matches(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase());
    }
}

class Book extends Item {
    private final String author;
    private BookStatus status = BookStatus.AVAILABLE;

    Book(String title, String author) {
        super(title);
        this.author = author;
    }

    String getAuthor() { return author; }
    BookStatus getStatus() { return status; }
    void setStatus(BookStatus status) { this.status = status; }

    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) || author.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("#%d %-28s by %-18s [%s]", getId(), getTitle(), author, status);
    }
}

class Member {
    private final String name;
    private final List<Book> borrowed = new ArrayList<>();
    static final int MAX_BOOKS = 2;

    Member(String name) { this.name = name; }
    String getName() { return name; }
    List<Book> getBorrowed() { return borrowed; }
    boolean canBorrow() { return borrowed.size() < MAX_BOOKS; }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    void addBook(Book b) { books.add(b); }

    void showAll() {
        System.out.println("--- Catalogue ---");
        books.forEach(System.out::println);
    }

    List<Book> search(String keyword) {
        List<Book> found = new ArrayList<>();
        for (Book b : books) if (b.matches(keyword)) found.add(b);
        return found;
    }

    boolean borrow(int bookId, Member m) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (b.getStatus() == BookStatus.BORROWED) {
                    System.out.println("Sorry, '" + b.getTitle() + "' is already borrowed.");
                    return false;
                }
                if (!m.canBorrow()) {
                    System.out.println(m.getName() + " has reached the limit of " + Member.MAX_BOOKS + " books.");
                    return false;
                }
                b.setStatus(BookStatus.BORROWED);
                m.getBorrowed().add(b);
                System.out.println(m.getName() + " borrowed '" + b.getTitle() + "'.");
                return true;
            }
        }
        System.out.println("No book with id " + bookId);
        return false;
    }

    boolean giveBack(int bookId, Member m) {
        for (Book b : m.getBorrowed()) {
            if (b.getId() == bookId) {
                b.setStatus(BookStatus.AVAILABLE);
                m.getBorrowed().remove(b);
                System.out.println(m.getName() + " returned '" + b.getTitle() + "'.");
                return true;
            }
        }
        System.out.println(m.getName() + " does not have book " + bookId);
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Effective Java", "Joshua Bloch"));
        lib.addBook(new Book("Clean Code", "Robert C. Martin"));
        lib.addBook(new Book("Head First Java", "Kathy Sierra"));
        lib.addBook(new Book("Java Concurrency in Practice", "Brian Goetz"));

        Member alice = new Member("Alice");
        Member bob = new Member("Bob");

        lib.showAll();
        System.out.println();

        lib.borrow(1, alice);
        lib.borrow(2, alice);
        lib.borrow(3, alice);    // over the limit
        lib.borrow(1, bob);      // already borrowed
        lib.borrow(99, bob);     // doesn't exist
        System.out.println();

        lib.giveBack(1, alice);
        lib.borrow(1, bob);
        System.out.println();

        System.out.println("Search 'java':");
        lib.search("java").forEach(b -> System.out.println("  " + b));
        System.out.println();
        lib.showAll();
    }
}
