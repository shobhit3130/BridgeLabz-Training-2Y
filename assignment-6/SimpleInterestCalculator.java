
import java.util.Scanner;

public class SimpleInterestCalculator {

    public static int calculateSimpleInterest(int principal, int rate, int time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        int principal = (int) sc.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        int rate = (int) sc.nextDouble();
        System.out.print("Enter Time (in years): ");
        int time = (int) sc.nextDouble();

        double si = calculateSimpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + si +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);
    }
}
