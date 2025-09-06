import java.util.Scanner;

public class CharArrayCompare {

    // 🔹 Method to manually convert String to char array using charAt()
    public static char[] manualToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    // 🔹 Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input from user
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // 🔹 Get char arrays
        char[] manualArray = manualToCharArray(input);
        char[] builtInArray = input.toCharArray();

        // 🔹 Compare arrays
        boolean areEqual = compareCharArrays(manualArray, builtInArray);

        // 🔹 Display results
        System.out.println("\nManual char array:");
        for (char c : manualArray) {
            System.out.print(c + " ");
        }

        System.out.println("\nBuilt-in char array:");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nAre both arrays equal? " + areEqual);

        scanner.close();
    }
}