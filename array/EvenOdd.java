import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define dimensions of the 2D array
        int rows = 3;
        int cols = 3;
        int[][] matrix = new int[rows][cols];

        // Input: Fill the 2D array
        System.out.println("Enter elements for a " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Output: Check even or odd
        System.out.println("\nEven/Odd status of each element:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = matrix[i][j];
                String status = (value % 2 == 0) ? "Even" : "Odd";
                System.out.println("Element [" + i + "][" + j + "] = " + value + " → " + status);
            }
        }

        scanner.close();
    }
}