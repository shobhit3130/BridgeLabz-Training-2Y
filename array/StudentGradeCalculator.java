import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of students
        System.out.print("Enter the number of students: ");
        int number = scanner.nextInt();

        // Step 2: Create arrays
        int[][] marks = new int[number][3]; // [][0]=Physics, [][1]=Chemistry, [][2]=Maths
        double[] percentage = new double[number];
        String[] grade = new String[number];

        // Step 3: Input marks
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter marks for Student #" + (i + 1));

            System.out.print("Physics: ");
            int physics = scanner.nextInt();

            System.out.print("Chemistry: ");
            int chemistry = scanner.nextInt();

            System.out.print("Maths: ");
            int maths = scanner.nextInt();

            // Validate marks
            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("Invalid input. Marks must be non-negative.");
                i--; // Repeat input for this student
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            // Step 4: Calculate percentage
            percentage[i] = (physics + chemistry + maths) / 3.0;

            // Step 5: Assign grade
            if (percentage[i] >= 90) {
                grade[i] = "A";
            } else if (percentage[i] >= 80) {
                grade[i] = "B";
            } else if (percentage[i] >= 70) {
                grade[i] = "C";
            } else if (percentage[i] >= 60) {
                grade[i] = "D";
            } else {
                grade[i] = "F";
            }
        }

        // Step 6: Display results
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Student #%d:\n", i + 1);
            System.out.printf("Physics: %d, Chemistry: %d, Maths: %d\n",
                              marks[i][0], marks[i][1], marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println("------------------------");
        }
    }
}