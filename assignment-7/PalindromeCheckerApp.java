import java.util.Scanner;

public class PalindromeCheckerApp {

    // PalindromeChecker class definition
    static class PalindromeChecker {
        String text;

        // Constructor
        public PalindromeChecker(String t) {
            text = t;
        }

        // Method to check if text is a palindrome
        public boolean isPalindrome() {
            String cleaned = text.replaceAll("\\s+", "").toLowerCase(); // ignore spaces and case
            int left = 0;
            int right = cleaned.length() - 1;

            while (left < right) {
                if (cleaned.charAt(left) != cleaned.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        // Method to display result
        public void displayResult() {
            System.out.println("Input Text: " + text);
            if (isPalindrome()) {
                System.out.println("Result: It's a palindrome!");
            } else {
                System.out.println("Result: Not a palindrome.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input text
        System.out.print("Enter a string to check: ");
        String input = sc.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(input);

        // Display result
        System.out.println("\n--- Palindrome Check ---");
        checker.displayResult();
    }
}