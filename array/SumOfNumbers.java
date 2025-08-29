import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[10];  // Array to store up to 10 values
        double total = 0.0;                 // Variable to store the sum
        int index = 0;                      // Index tracker

        System.out.println("Enter up to 10 positive numbers (enter 0 or negative to stop):");

        // Infinite loop to collect input
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double input = scanner.nextDouble();

            // Break if input is 0 or negative
            if (input <= 0) {
                break;
            }

            // Break if array is full
            if (index == 10) {
                System.out.println("Maximum of 10 numbers reached.");
                break;
            }

            // Store input and move to next index
            numbers[index] = input;
            index++;
        }

        // Display all entered numbers
        System.out.println("\nYou entered:");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];  // Add to total
        }

        // Display total
        System.out.println("\nTotal sum of entered numbers: " + total);

        scanner.close();
    }
}