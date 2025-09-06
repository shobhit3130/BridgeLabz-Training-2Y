import java.util.Scanner;

public class WordLengthTable {

    // 🔹 Method to find string length without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // 🔹 Method to split text into words manually
    public static String[] manualSplit(String text) {
        int length = getLength(text);
        int spaceCount = 0;

        // Count spaces
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];
        int start = 0, wordIndex = 0;

        for (int i = 0; i <= length; i++) {
            if (i == length || text.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word += text.charAt(j);
                }
                words[wordIndex++] = word;
                start = i + 1;
            }
        }

        return words;
    }

    // 🔹 Method to create 2D array of word and its length
    public static String[][] getWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i]; // word
            table[i][1] = String.valueOf(getLength(words[i])); // length as String
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take full sentence input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 🔹 Process input
        String[] words = manualSplit(input);
        String[][] wordTable = getWordLengthTable(words);

        // 🔹 Display results in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");
        for (String[] row : wordTable) {
            String word = row[0];
            int length = Integer.parseInt(row[1]); // Convert back to int
            System.out.println(word + "\t\t" + length);
        }

        scanner.close();
    }
}