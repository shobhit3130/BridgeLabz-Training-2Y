// Superclass: Person
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() {
        System.out.println("Generic Person");
    }

    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class to test hierarchical inheritance
public class SchoolTest {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mrs. Sharma", 40, "Mathematics");
        Student s = new Student("Ravi", 16, "10th Grade");
        Staff st = new Staff("Mr. Verma", 35, "Administration");

        t.displayRole();
        t.showDetails();

        System.out.println();

        s.displayRole();
        s.showDetails();

        System.out.println();

        st.displayRole();
        st.showDetails();
    }
}