import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input for a number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Step 2: Handle negative numbers
        if (number < 0) {
            number = Math.abs(number);
        }

        // Step 3: Count digits and store them in an array
        int digitCount = String.valueOf(number).length();
        int[] digits = new int[digitCount];

        long temp = number;
        for (int i = 0; i < digitCount; i++) {
            digits[i] = (int)(temp % 10);
            temp /= 10;
        }

        // Step 4: Frequency array for digits 0–9
        int[] frequency = new int[10];
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        // Step 5: Display frequency of each digit
        System.out.println("\n--- Digit Frequency ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
    }
}