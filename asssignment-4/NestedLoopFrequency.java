import java.util.Scanner;

public class NestedLoopFrequency {

    // 🔹 Method to find character frequencies using nested loops
    public static String[] findFrequencies(String text) {
        char[] chars = text.toCharArray(); // Convert string to char array
        int[] freq = new int[chars.length]; // Frequency array

        // Step 1: Count frequencies using nested loops
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; // Start with frequency 1

            if (chars[i] == '0') continue; // Skip already counted

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate as counted
                }
            }
        }

        // Step 2: Store results in 1D String array
        int count = 0;
        for (char c : chars) {
            if (c != '0') count++;
        }

        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " => " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Get frequencies
        String[] frequencies = findFrequencies(input);

        // 🔹 Display result
        System.out.println("\nCharacter Frequencies:");
        for (String entry : frequencies) {
            System.out.println(entry);
        }

        scanner.close();
    }
}
