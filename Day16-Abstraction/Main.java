/** Day 16 - Abstraction (abstract classes and methods) */
abstract class Employee {
    private final String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method - subclasses MUST implement it
    abstract double calculateSalary();

    // Concrete method - shared by all subclasses
    void printPayslip() {
        System.out.printf("%-8s | %-16s | Rs. %,.2f%n", name, getClass().getSimpleName(), calculateSalary());
    }

    String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double baseSalary) { super(name, baseSalary); }

    @Override
    double calculateSalary() { return baseSalary + baseSalary * 0.20; }   // 20% allowances
}

class PartTimeEmployee extends Employee {
    private final int hoursWorked;
    private final double hourlyRate;

    PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() { return hoursWorked * hourlyRate; }
}

class Manager extends Employee {
    private final double bonus;

    Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() { return baseSalary * 1.30 + bonus; }
}

public class Main {
    public static void main(String[] args) {
        // Employee e = new Employee("X", 1000);   // <- compile error: abstract
        Employee[] staff = {
            new FullTimeEmployee("Anita", 50_000),
            new PartTimeEmployee("Bharat", 80, 400),
            new Manager("Chitra", 90_000, 25_000)
        };
        for (Employee e : staff) e.printPayslip();
    }
}
