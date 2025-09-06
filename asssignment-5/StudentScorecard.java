import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    // 🔹 Generate random PCM scores for n students
    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // Physics, Chemistry, Math

        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(41) + 60; // Physics: 60–100
            scores[i][1] = rand.nextInt(41) + 60; // Chemistry: 60–100
            scores[i][2] = rand.nextInt(41) + 60; // Math: 60–100
        }

        return scores;
    }

    // 🔹 Calculate total, average, percentage
    public static double[][] calculateStats(int[][] scores) {
        int n = scores.length;
        double[][] stats = new double[n][3]; // total, average, percentage

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return stats;
    }

    // 🔹 Assign grade based on percentage
    public static String[] assignGrades(double[][] stats) {
        int n = stats.length;
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            double percent = stats[i][2];

            if (percent >= 90) grades[i] = "A";
            else if (percent >= 80) grades[i] = "B";
            else if (percent >= 70) grades[i] = "C";
            else if (percent >= 60) grades[i] = "D";
            else grades[i] = "F";
        }

        return grades;
    }

    // 🔹 Display scorecard
    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("\nStudent\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\t%s\n",
                (i + 1),
                scores[i][0],
                scores[i][1],
                scores[i][2],
                stats[i][0],
                stats[i][1],
                stats[i][2],
                grades[i]
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Input number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // 🔹 Generate scores and compute stats
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = assignGrades(stats);

        // 🔹 Display scorecard
        displayScorecard(scores, stats, grades);

        scanner.close();
    }
}