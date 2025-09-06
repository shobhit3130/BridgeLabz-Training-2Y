import java.util.Scanner;

public class UniqueCharFrequency {

    // 🔹 Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {
        StringBuilder unique = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;

            // Check if character already exists in unique list
            for (int j = 0; j < unique.length(); j++) {
                if (unique.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique.append(ch);
            }
        }

        // Convert StringBuilder to char array
        char[] result = new char[unique.length()];
        for (int i = 0; i < unique.length(); i++) {
            result[i] = unique.charAt(i);
        }

        return result;
    }

    // 🔹 Method to find frequency of unique characters
    public static String[][] getFrequencies(String text) {
        int[] freq = new int[256]; // ASCII range

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Prepare 2D String array for result
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Get frequencies
        String[][] frequencies = getFrequencies(input);

        // 🔹 Display result
        System.out.println("\nCharacter Frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + " => " + frequencies[i][1]);
        }

        scanner.close();
    }
}