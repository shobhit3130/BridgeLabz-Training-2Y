import java.util.Scanner;

public class BMICalculator {

    // 🔹 Method to compute BMI and status
    public static String[][] computeBMI(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4]; // weight, height, BMI, status

        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    // 🔹 Method to display BMI table
    public static void displayBMIReport(String[][] report) {
        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\t%s\n",
                (i + 1),
                report[i][0],
                report[i][1],
                report[i][2],
                report[i][3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int members = 10;
        double[][] data = new double[members][2]; // weight, height

        // 🔹 Input weight and height for each person
        for (int i = 0; i < members; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = scanner.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        // 🔹 Compute BMI and status
        String[][] report = computeBMI(data);

        // 🔹 Display report
        displayBMIReport(report);

        scanner.close();
    }
}