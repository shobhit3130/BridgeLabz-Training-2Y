import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input
        System.out.print("Enter a number to print its multiplication table: ");
        int number = scanner.nextInt();

        // Step 2: Define array to store results
        int[] table = new int[10];

        // Step 3: Fill array with multiplication results
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 1);
        }

        // Step 4: Display the table
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }

        scanner.close();
    }
}