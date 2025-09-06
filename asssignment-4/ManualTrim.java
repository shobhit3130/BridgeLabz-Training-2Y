import java.util.Scanner;

public class ManualTrim {

    // 🔹 Method to find start and end indices of non-space characters
    public static int[] findTrimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find first non-space character
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space character
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // 🔹 Method to create substring using charAt()
    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // 🔹 Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Input string with spaces
        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = scanner.nextLine();

        // 🔹 Find trim indices
        int[] indices = findTrimIndices(input);
        int start = indices[0];
        int end = indices[1];

        // 🔹 Create trimmed string manually
        String manuallyTrimmed = customSubstring(input, start, end);

        // 🔹 Use built-in trim() for comparison
        String builtInTrimmed = input.trim();

        // 🔹 Compare both results
        boolean isSame = compareStrings(manuallyTrimmed, builtInTrimmed);

        // 🔹 Display results
        System.out.println("\nManual Trim Result: \"" + manuallyTrimmed + "\"");
        System.out.println("Built-in Trim Result: \"" + builtInTrimmed + "\"");
        System.out.println("Are both results same? " + isSame);

        scanner.close();
    }
}