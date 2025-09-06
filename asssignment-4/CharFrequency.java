import java.util.Scanner;

public class CharFrequency {

    // 🔹 Method to find character frequencies
    public static char[][] getFrequencies(String text) {
        int[] freq = new int[256]; // ASCII range

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 2: Prepare 2D array for results
        char[][] result = new char[text.length()][2];
        int index = 0;

        // Step 3: Store unique characters and their frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = ch;
                result[index][1] = (char)(freq[ch] + '0'); // Convert int to char
                freq[ch] = 0; // Mark as processed
                index++;
            }
        }

        // Step 4: Trim unused rows
        char[][] trimmedResult = new char[index][2];
        for (int i = 0; i < index; i++) {
            trimmedResult[i][0] = result[i][0];
            trimmedResult[i][1] = result[i][1];
        }

        return trimmedResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Get character frequencies
        char[][] frequencies = getFrequencies(input);

        // 🔹 Display result
        System.out.println("\nCharacter Frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + " => " + (frequencies[i][1] - '0'));
        }

        scanner.close();
    }
}