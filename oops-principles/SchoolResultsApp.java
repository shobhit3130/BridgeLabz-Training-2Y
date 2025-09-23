import java.util.*;

public class SchoolResultsApp {

    // Subject class
    static class Subject {
        private String name;
        private int marks;

        public Subject(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }
    }

    // Student class
    static class Student {
        private String name;
        private List<Subject> subjects;

        public Student(String name, List<Subject> subjects) {
            this.name = name;
            this.subjects = subjects;
        }

        public String getName() {
            return name;
        }

        public List<Subject> getSubjects() {
            return subjects;
        }
    }

    // GradeCalculator class
    static class GradeCalculator {
        public String calculateGrade(Student student) {
            int totalMarks = 0;
            for (Subject subject : student.getSubjects()) {
                totalMarks += subject.getMarks();
            }

            double average = totalMarks / (double) student.getSubjects().size();

            if (average >= 90) return "A";
            else if (average >= 80) return "B";
            else if (average >= 70) return "C";
            else if (average >= 60) return "D";
            else return "F";
        }
    }

    // Main method
    public static void main(String[] args) {
        Subject maths = new Subject("Maths", 90);
        Subject science = new Subject("Science", 85);

        List<Subject> subjects = Arrays.asList(maths, science);
        Student john = new Student("John", subjects);

        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(john);

        System.out.println("Student: " + john.getName());
        for (Subject subject : john.getSubjects()) {
            System.out.println("Subject: " + subject.getName() + ", Marks: " + subject.getMarks());
        }
        System.out.println("Grade: " + grade);
    }
}