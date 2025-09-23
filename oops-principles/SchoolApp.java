import java.util.*;

public class SchoolApp {

    // Course class
    static class Course {
        private String name;
        private List<Student> enrolledStudents;

        public Course(String name) {
            this.name = name;
            this.enrolledStudents = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void enrollStudent(Student student) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
                student.addCourse(this); // maintain bidirectional association
            }
        }

        public void showEnrolledStudents() {
            System.out.println("Course: " + name);
            for (Student student : enrolledStudents) {
                System.out.println("  - " + student.getName());
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
            System.out.println("Student: " + name);
            for (Course course : courses) {
                System.out.println("  - " + course.getName());
            }
        }
    }

    // School class (aggregates students)
    static class School {
        private String name;
        private List<Student> students;

        public School(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void showStudents() {
            System.out.println("School: " + name);
            for (Student student : students) {
                System.out.println("  - " + student.getName());
            }
        }
    }

    // Main method to demonstrate aggregation and association
    public static void main(String[] args) {
        School greenValley = new School("Green Valley School");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Aggregation: School has students
        greenValley.addStudent(alice);
        greenValley.addStudent(bob);

        // Association: Students enroll in courses
        math.enrollStudent(alice);
        math.enrollStudent(bob);
        science.enrollStudent(alice);

        // Display structure
        greenValley.showStudents();
        System.out.println();
        alice.viewCourses();
        System.out.println();
        bob.viewCourses();
        System.out.println();
        math.showEnrolledStudents();
        System.out.println();
        science.showEnrolledStudents();
    }
}