/** Day 14 - Inheritance (extends, super, method overriding) */
class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }

    void eat()   { System.out.println(name + " is eating."); }
    void sound() { System.out.println(name + " makes a sound."); }
}

class Dog extends Animal {
    private String breed;

    Dog(String name, String breed) {
        super(name);               // must be the first statement
        this.breed = breed;
        System.out.println("Dog constructor: " + breed);
    }

    @Override
    void sound() { System.out.println(name + " barks: Woof!"); }

    void fetch() { System.out.println(name + " the " + breed + " fetches the ball."); }
}

class Cat extends Animal {
    Cat(String name) { super(name); }

    @Override
    void sound() {
        super.sound();             // call the parent version first
        System.out.println(name + " meows: Meow!");
    }
}

// Multilevel inheritance
class Puppy extends Dog {
    Puppy(String name) { super(name, "Mixed"); }
    void weep() { System.out.println(name + " whimpers."); }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bruno", "Labrador");
        dog.eat();        // inherited
        dog.sound();      // overridden
        dog.fetch();      // own method

        System.out.println();
        Cat cat = new Cat("Whiskers");
        cat.sound();

        System.out.println();
        Puppy pup = new Puppy("Tiny");
        pup.eat();
        pup.sound();
        pup.weep();

        System.out.println("\npup instanceof Animal: " + (pup instanceof Animal));
    }
}
