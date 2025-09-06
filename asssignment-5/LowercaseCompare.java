import java.util.Scanner;

public class LowercaseCompare {

    // 🔹 Convert uppercase letters to lowercase manually using ASCII logic
    public static String manualToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is uppercase (ASCII range: 65 to 90)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); // Convert to lowercase
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
        String manualLower = manualToLowerCase(input);
        String builtInLower = input.toLowerCase();

        // 🔹 Compare both results
        boolean areEqual = compareUsingCharAt(manualLower, builtInLower);

        // 🔹 Display results
        System.out.println("\nManual lowercase: " + manualLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Are both results equal? " + areEqual);

        scanner.close();
    }
}
