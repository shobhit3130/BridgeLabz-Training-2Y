import java.util.Scanner;

public class DigitAnalyzer {
    public static void main(String[] args) {
        final int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Extract digits and store in array
        while (number != 0 && index < maxDigit) {
            int digit = number % 10;
            digits[index] = digit;
            number /= 10;
            index++;
        }

        // Initialize largest and second largest
        int largest = -1;
        int secondLargest = -1;

        // Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("\n--- Digit Analysis ---");
        System.out.println("Largest Digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second Largest Digit: " + secondLargest);
        } else {
            System.out.println("Second Largest Digit: Not found (all digits are the same)");
        }
    }
}