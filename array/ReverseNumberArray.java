import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Step 2: Count digits
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        // Step 3: Store digits in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Step 4: Create reverse array
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[i];
        }

        // Step 5: Display reversed array
        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
    }
}