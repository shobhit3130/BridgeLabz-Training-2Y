import java.util.Scanner;

public class VowelConsonantCounter {

    // 🔹 Method to classify a character
    public static String classifyChar(char ch) {
        // Convert to lowercase if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // ASCII conversion
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }
    

    // 🔹 Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = classifyChar(ch);

            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }

        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take full sentence input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 🔹 Count vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // 🔹 Display results
        System.out.println("\nTotal Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);

        scanner.close();
    }
}
