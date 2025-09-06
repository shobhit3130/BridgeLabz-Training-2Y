import java.util.Scanner;

public class FirstUniqueChar {

    // 🔹 Method to find first non-repeating character
    public static char findFirstUnique(String text) {
        int[] freq = new int[256]; // ASCII range

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // No unique character found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Find first non-repeating character
        char result = findFirstUnique(input);

        // 🔹 Display result
        if (result != '\0') {
            System.out.println("\nFirst non-repeating character: " + result);
        } else {
            System.out.println("\nNo non-repeating character found.");
        }

        scanner.close();
    }
}