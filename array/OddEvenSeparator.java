
import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Check if the input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            return;
        }

        // Create arrays for odd and even numbers
        int size = number / 2 + 1;
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];

        // Initialize index counters
        int oddIndex = 0;
        int evenIndex = 0;

        // Iterate from 1 to the entered number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Print odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println();

        // Print even numbers
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        System.out.println();
    }
}