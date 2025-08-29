import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();

        // Step 2: Create 2D array for weight, height, BMI
        double[][] personData = new double[number][3]; // [][0]=weight, [][1]=height, [][2]=BMI
        String[] weightStatus = new String[number];

        // Step 3: Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person #" + (i + 1));

            System.out.print("Weight (kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Height (m): ");
            double height = scanner.nextDouble();

            // Validate input
            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Repeat input for this person
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height); // BMI calculation

            // Step 4: Determine weight status
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Step 5: Display results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person #%d:\n", i + 1);
            System.out.printf("Height: %.2f m\n", personData[i][1]);
            System.out.printf("Weight: %.2f kg\n", personData[i][0]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println("------------------------");
        }
    }
}