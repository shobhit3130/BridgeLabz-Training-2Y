import java.util.Scanner;

public class TeamBMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input for number of persons
        System.out.print("Enter the number of persons in the team: ");
        int count = scanner.nextInt();

        // Step 2: Create arrays to store data
        double[] weight = new double[count];
        double[] height = new double[count];
        double[] bmi = new double[count];
        String[] status = new String[count];

        // Step 3: Input weight and height
        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Person #" + (i + 1));

            System.out.print("Weight (kg): ");
            weight[i] = scanner.nextDouble();

            System.out.print("Height (m): ");
            height[i] = scanner.nextDouble();

            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Repeat input for this person
            }
        }

        // Step 4: Calculate BMI and determine status
        for (int i = 0; i < count; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Step 5: Display results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < count; i++) {
            System.out.printf("Person #%d:\n", i + 1);
            System.out.printf("Height: %.2f m\n", height[i]);
            System.out.printf("Weight: %.2f kg\n", weight[i]);
            System.out.printf("BMI: %.2f\n", bmi[i]);
            System.out.println("Status: " + status[i]);
            System.out.println("------------------------");
        }
    }
}