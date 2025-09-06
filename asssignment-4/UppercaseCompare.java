import java.util.Scanner;

public class UppercaseCompare {

    // 🔹 Convert lowercase letters to uppercase manually using ASCII logic
    public static String manualToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is lowercase (ASCII range: 97 to 122)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); // Convert to uppercase
            }

            result += ch;
        }

        return result;
    }

    // 🔹 Compare two strings character by character
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take full line input from user
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 🔹 Convert using manual method and built-in method
        String manualUpper = manualToUpperCase(input);
        String builtInUpper = input.toUpperCase();

        // 🔹 Compare both results
        boolean areEqual = compareUsingCharAt(manualUpper, builtInUpper);

        // 🔹 Display results
        System.out.println("\nManual uppercase: " + manualUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Are both results equal? " + areEqual);

        scanner.close();
    }
}