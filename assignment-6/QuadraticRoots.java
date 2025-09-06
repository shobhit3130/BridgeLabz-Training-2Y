import java.util.Scanner;

public class QuadraticRoots {

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) return new double[]{}; // no real roots
        else if (delta == 0) return new double[]{-b / (2 * a)};
        else {
            double sqrtDelta = Math.sqrt(delta);
            return new double[]{(-b + sqrtDelta) / (2 * a), (-b - sqrtDelta) / (2 * a)};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) System.out.println("No Real Roots");
        else if (roots.length == 1) System.out.println("One Root: " + roots[0]);
        else System.out.println("Roots: " + roots[0] + " and " + roots[1]);
    }
}