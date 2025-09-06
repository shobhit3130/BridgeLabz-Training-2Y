import java.util.Scanner;

public class Uniquecharcater{

    // 🔹 Method to find length without using .length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Reached end of string
        }
        return count;
    }

    // 🔹 Method to find unique characters using charAt()
    public static char[] findUniqueChars(String str) {
        int len = getLength(str);
        char[] unique = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            // Check if current char already exists in unique[]
            for (int j = 0; j < uniqueCount; j++) {
                if (unique[j] == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // 🔹 Create final array with only unique characters
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Take input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Find unique characters
        char[] uniqueChars = findUniqueChars(input);

        // 🔹 Display result
        System.out.println("\nUnique characters in the string:");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }

        scanner.close();
    }
}