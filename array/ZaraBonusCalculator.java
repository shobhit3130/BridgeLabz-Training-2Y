
import java.util.Scanner;

public class ZaraBonusCalculator {
    public static void main(String[] args) {
        final int EMPLOYEE_COUNT = 10;
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        Scanner scanner = new Scanner(System.in);

        // Input loop
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee #" + (i + 1));

            System.out.print("Salary: ");
            double inputSalary = scanner.nextDouble();

            System.out.print("Years of Service: ");
            double inputYears = scanner.nextDouble();

            // Validate input
            if (inputSalary <= 0 || inputYears < 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Decrement index to repeat input
                continue;
            }

            salary[i] = inputSalary;
            yearsOfService[i] = inputYears;
        }

        // Bonus calculation loop
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Output results
        System.out.println("\n--- Zara Bonus Summary ---");
        System.out.printf("Total Bonus Payout: ₹%.2f%n", totalBonus);
        System.out.printf("Total Old Salary: ₹%.2f%n", totalOldSalary);
        System.out.printf("Total New Salary: ₹%.2f%n", totalNewSalary);
    }
}