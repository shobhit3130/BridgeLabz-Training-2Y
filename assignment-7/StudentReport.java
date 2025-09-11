import java.util.Scanner;

public class StudentReport {

    // Student class definition
    static class Student {
        String name;
        int rollNumber;
        int marks;

        // Constructor
        public Student(String n, int r, int m) {
            name = n;
            rollNumber = r;
            marks = m;
        }

        // Method to calculate grade
        public String calculateGrade() {
            if (marks >= 90) return "A+";
            else if (marks >= 80) return "A";
            else if (marks >= 70) return "B";
            else if (marks >= 60) return "C";
            else if (marks >= 50) return "D";
            else return "F";
        }

        // Method to display student details and grade
        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Marks: " + marks);
            System.out.println("Grade: " + calculateGrade());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks (out of 100): ");
        int marks = sc.nextInt();

        // Create Student object
        Student s1 = new Student(name, roll, marks);

        // Display student report
        System.out.println("\n--- Student Report ---");
        s1.displayDetails();
    }
}