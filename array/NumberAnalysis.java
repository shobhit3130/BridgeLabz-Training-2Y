import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input: Get 5 numbers from user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nAnalysis of each number:");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("Number " + (i + 1) + " (" + num + "): ");

            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Positive and Even");
                } else {
                    System.out.println("Positive and Odd");
                }
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        // Final comparison between first and last elements
        System.out.println("\nComparison between first and last elements:");
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("First and last elements are equal.");
        } else if (first > last) {
            System.out.println("First element is greater than the last.");
        } else {
            System.out.println("First element is less than the last.");
        }

        scanner.close();
    }
}