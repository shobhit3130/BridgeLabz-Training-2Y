import java.util.ArrayList;

public class AutoBoxingDemo {
    public static void main(String[] args) {
        // Create ArrayList of Integer (auto-boxing happens here)
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add 5 integer values using auto-boxing
        numbers.add(10); // auto-boxed to Integer.valueOf(10)
        numbers.add(5);
        numbers.add(15);
        numbers.add(20);
        numbers.add(5);

        // Calculate sum using auto-unboxing
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // auto-unboxed to int
        }

        // Display result
        System.out.println("Sum of numbers = " + sum);
    }
}