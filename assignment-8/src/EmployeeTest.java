// Base class
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("Employee: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayInfo() {
        System.out.println("Manager: " + name + ", ID: " + id + ", Salary: " + salary + ", Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayInfo() {
        System.out.println("Developer: " + name + ", ID: " + id + ", Salary: " + salary + ", Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    int durationMonths;

    Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    @Override
    void displayInfo() {
        System.out.println("Intern: " + name + ", ID: " + id + ", Salary: " + salary + ", Duration: " + durationMonths + " months");
    }
}

// Main class
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Alice", 101, 90000, 5),
                new Developer("Bob", 102, 75000, "Java"),
                new Intern("Charlie", 103, 20000, 6)
        };

        for (Employee e : employees) {
            e.displayInfo(); // Polymorphic call
        }
    }
}