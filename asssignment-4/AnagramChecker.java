import java.util.Scanner;

public class AnagramChecker {

    // 🔹 Method to check if two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {
        // Step 1: Check if lengths are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays
        int[] freq1 = new int[256]; // ASCII range
        int[] freq2 = new int[256];

        // Step 3: Count frequencies for both texts
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Step 4: Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input strings
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        // Optional: Normalize input (remove spaces, lowercase)
        String normalized1 = text1.replaceAll("\\s+", "").toLowerCase();
        String normalized2 = text2.replaceAll("\\s+", "").toLowerCase();

        // 🔹 Check for anagram
        boolean result = areAnagrams(normalized1, normalized2);

        // 🔹 Display result
        System.out.println("\nAnagram Check Result:");
        if (result) {
            System.out.println("✅ The texts are anagrams.");
        } else {
            System.out.println("❌ The texts are not anagrams.");
        }

        scanner.close();
    }
}
