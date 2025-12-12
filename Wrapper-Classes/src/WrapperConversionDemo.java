import java.util.Scanner;

public class WrapperConversionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take integer input from user
        System.out.print("Enter an integer: ");
        int primitiveValue = scanner.nextInt();

        // Convert primitive to wrapper
        Integer wrapperValue = Integer.valueOf(primitiveValue);

        // Display both forms
        System.out.println("\n🔢 Primitive value: " + primitiveValue);
        System.out.println("📦 Wrapper object value: " + wrapperValue);
    }
}
