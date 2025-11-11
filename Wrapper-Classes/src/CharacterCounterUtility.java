import java.util.Scanner;

public class CharacterCounterUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int letterCount = 0;
        int digitCount = 0;
        int specialCount = 0;

        // Analyze each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (!Character.isWhitespace(ch)) {
                specialCount++;
            }
        }

        // Display results
        System.out.println("\n🔍 Character Analysis:");
        System.out.println("Total Letters: " + letterCount);
        System.out.println("Total Digits: " + digitCount);
        System.out.println("Total Special Characters: " + specialCount);
    }
}