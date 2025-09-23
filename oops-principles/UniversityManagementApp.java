
import java.util.*;

public class UniversityManagementApp {

    // Course class
    static class Course {
        private String name;
        private Professor professor;
        private List<Student> enrolledStudents;

        public Course(String name) {
            this.name = name;
            this.enrolledStudents = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void assignProfessor(Professor prof) {
            this.professor = prof;
            System.out.println("Professor " + prof.getName() + " assigned to course " + name);
        }

        public void enrollStudent(Student student) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
                student.addCourse(this); // maintain bidirectional association
                System.out.println("Student " + student.getName() + " enrolled in course " + name);
            }
        }

        public void showDetails() {
            System.out.println("Course: " + name);
            System.out.println("  Professor: " + (professor != null ? professor.getName() : "None"));
            System.out.println("  Enrolled Students:");
            for (Student s : enrolledStudents) {
                System.out.println("    - " + s.getName());
            }
        }
    }

    // Student class
    static class Student {
        private String name;
        private List<Course> courses;

        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
            }
        }

        public void viewCourses() {
            System.out.println("Student: " + name + " is enrolled in:");
            for (Course c : courses) {
                System.out.println("  - " + c.getName());
            }
        }
    }

    // Professor class
    static class Professor {
        private String name;

        public Professor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // University class (aggregates students and professors)
    static class University {
        private String name;
        private List<Student> students;
        private List<Professor> professors;

        public University(String name) {
            this.name = name;
            this.students = new ArrayList<>();
            this.professors = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void addProfessor(Professor professor) {
            professors.add(professor);
        }

        public void showPeople() {
            System.out.println("University: " + name);
            System.out.println("Students:");
            for (Student s : students) {
                System.out.println("  - " + s.getName());
            }
            System.out.println("Professors:");
            for (Professor p : professors) {
                System.out.println("  - " + p.getName());
            }
        }
    }

    // Main method to demonstrate relationships and communication
    public static void main(String[] args) {
        University uni = new University("National University");

        // Create professors
        Professor profJohn = new Professor("John");
        Professor profEmma = new Professor("Emma");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create courses
        Course math = new Course("Mathematics");
        Course history = new Course("History");

        // Assign professors
        math.assignProfessor(profJohn);
        history.assignProfessor(profEmma);

        // Enroll students
        math.enrollStudent(alice);
        math.enrollStudent(bob);
        history.enrollStudent(alice);

        // Add people to university
        uni.addStudent(alice);
        uni.addStudent(bob);
        uni.addProfessor(profJohn);
        uni.addProfessor(profEmma);

        // Display university structure
        System.out.println();
        uni.showPeople();

        System.out.println();
        alice.viewCourses();
        bob.viewCourses();

        System.out.println();
        math.showDetails();
        history.showDetails();
    }
}