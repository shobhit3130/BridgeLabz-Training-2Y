import java.util.Scanner;

public class SubstringCompare {

    // 🔹 Create substring manually using charAt()
    public static String manualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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

        // 🔹 Take input from user
        System.out.print("Enter a string: ");
        String input = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // 🔹 Create substrings
        String manualSub = manualSubstring(input, start, end);
        String builtInSub = input.substring(start, end);

        // 🔹 Compare substrings
        boolean areEqual = compareUsingCharAt(manualSub, builtInSub);

        // 🔹 Display results
        System.out.println("\nManual substring: " + manualSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Are both substrings equal? " + areEqual);

        scanner.close();
    }
}
