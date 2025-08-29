import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        // Taking input for 10 students
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age entered.");
            } else if (age >= 18) {
                System.out.println("Student " + (i + 1) + " with age " + age + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}