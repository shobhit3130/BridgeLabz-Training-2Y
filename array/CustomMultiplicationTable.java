import java.util.Scanner;

public class CustomMultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input from user
        System.out.print("Enter a number to generate its multiplication table (from 6 to 9): ");
        int number = scanner.nextInt();

        // Step 2: Define array to store results from 6 to 9 (4 elements)
        int[] multiplicationResult = new int[4];

        // Step 3: Calculate and store results
        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6; // Starts from 6 to 9
            multiplicationResult[i] = number * multiplier;
        }

        // Step 4: Display results
        System.out.println("\nMultiplication table of " + number + " from 6 to 9:");
        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}