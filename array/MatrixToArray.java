import java.util.Scanner;

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        // Step 2: Create and fill the 2D array
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter elements of the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Step 3: Create 1D array to hold all elements
        int[] array = new int[rows * columns];
        int index = 0;

        // Step 4: Copy elements from 2D to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Step 5: Display the 1D array
        System.out.println("Elements copied into 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}