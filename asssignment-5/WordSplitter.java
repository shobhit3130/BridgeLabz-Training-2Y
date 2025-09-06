import java.util.Scanner;

public class WordSplitter {

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

    // 🔹 Method to split string into words manually
    public static String[] manualSplit(String text) {
        int length = getLength(text);

        // Step 1: Count spaces to determine number of words
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;
        int[] spaceIndexes = new int[spaceCount];
        int index = 0;

        // Step 2: Store space indexes
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Step 3: Extract words using space indexes
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        // Last word
        String lastWord = "";
        for (int i = start; i < length; i++) {
            lastWord += text.charAt(i);
        }
        words[wordCount - 1] = lastWord;

        return words;
    }

    // 🔹 Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take full line input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 🔹 Manual split and built-in split
        String[] manualWords = manualSplit(input);
        String[] builtInWords = input.split(" ");

        // 🔹 Compare both arrays
        boolean areEqual = compareArrays(manualWords, builtInWords);

        // 🔹 Display results
        System.out.println("\nManual split:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both splits equal? " + areEqual);

        scanner.close();
    }
}
