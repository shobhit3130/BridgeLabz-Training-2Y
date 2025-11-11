import java.util.Scanner;

public class Sum_of_n_natural_numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;

            int i = 1, loopSum = 0;
            while (i <= n) {
                loopSum += i;
                i++;
            }

            System.out.println("Formula sum = " + formulaSum);
            System.out.println("While loop sum = " + loopSum);
        } else {
            System.out.println("Not a natural number.");
        }

        input.close();
    }
}