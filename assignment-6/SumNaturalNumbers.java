public class SumNaturalNumbers {

    public static int sumNaturalNumbers(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        if (num < 1) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = sumNaturalNumbers(num);
            System.out.println("The sum of the first " + num + " natural numbers is: " + sum);
        }
    }
    
}
