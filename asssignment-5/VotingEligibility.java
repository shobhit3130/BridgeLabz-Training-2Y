import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {

    // 🔹 Generate random 2-digit ages
    public static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10; // Range: 10 to 99
        }
        return ages;
    }

    // 🔹 Check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false"; // Invalid age
            } else if (age >= 18) {
                result[i][1] = "true";  // Can vote
            } else {
                result[i][1] = "false"; // Cannot vote
            }
        }

        return result;
    }

    // 🔹 Display results in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("\nStudent\tAge\tCan Vote?");
        System.out.println("-----------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Ask user for number of students (default: 10)
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // 🔹 Generate random ages
        int[] ages = generateRandomAges(n);

        // 🔹 Check eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // 🔹 Display result
        displayTable(eligibility);

        scanner.close();
    }
}
