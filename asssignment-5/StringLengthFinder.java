import java.util.Scanner;

public class StringLengthFinder {

    // 🔹 Method to find string length without using length()
    public static int findLengthWithoutLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count); // Try accessing character
                count++;            // If successful, increment count
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception means we've gone past the last character
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input from user
        System.out.print("Enter a string: ");
        String input = scanner.next();

        // 🔹 Get length using both methods
        int manualLength = findLengthWithoutLength(input);
        int builtInLength = input.length();

        // 🔹 Display results
        System.out.println("\nManual length (using charAt + exception): " + manualLength);
        System.out.println("Built-in length (using length()): " + builtInLength);

        // 🔹 Compare results
        if (manualLength == builtInLength) {
            System.out.println("✅ Both methods give the same result.");
        } else {
            System.out.println("⚠️ Results differ. Check your logic.");
        }

        scanner.close();
    }
}