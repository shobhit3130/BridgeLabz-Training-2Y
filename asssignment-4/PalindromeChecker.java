import java.util.Scanner;

public class PalindromeChecker {

    // 🔹 Logic 1: Iterative check using start/end indexes
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 🔹 Logic 2: Recursive check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // 🔹 Logic 3: Array-based check using reversed char array
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // 🔹 Helper method to reverse string using charAt()
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: Normalize input (remove spaces, lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // 🔹 Check using all three logics
        boolean result1 = isPalindromeIterative(normalized);
        boolean result2 = isPalindromeRecursive(normalized, 0, normalized.length() - 1);
        boolean result3 = isPalindromeArray(normalized);

        // 🔹 Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Iterative): " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive): " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Array-based): " + (result3 ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}
