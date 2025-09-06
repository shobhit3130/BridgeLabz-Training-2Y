import java.util.Scanner;

public class AthleteRun {

    public static int calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(distance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double a = sc.nextDouble();
        System.out.print("Enter side2: ");
        double b = sc.nextDouble();
        System.out.print("Enter side3: ");
        double c = sc.nextDouble();

        int rounds = calculateRounds(a, b, c, 5000); // 5km = 5000m
        System.out.println("The athlete must complete " + rounds + " rounds.");
    }
}
