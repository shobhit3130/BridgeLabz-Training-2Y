import java.util.Scanner;

public class FriendStats {
    public static void main(String[] args) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        Scanner scanner = new Scanner(System.in);

        // Input loop
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i]);

            System.out.print("Age: ");
            ages[i] = scanner.nextInt();

            System.out.print("Height (in cm): ");
            heights[i] = scanner.nextDouble();

            if (ages[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Repeat input for this friend
            }
        }

        // Find youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Output results
        System.out.println("\n--- Friend Stats ---");
        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
    }
}