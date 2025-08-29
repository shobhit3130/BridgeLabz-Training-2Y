import java.util.Scanner;

public class DynamicDigitAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits and store in array
        while (number != 0) {
            if (index == maxDigit) {
                // Increase maxDigit by 10
                maxDigit += 10;

                // Create new temp array and copy existing digits
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign temp to digits
                digits = temp;
            }

            digits[index] = number % 10;
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