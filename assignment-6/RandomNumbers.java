public class RandomNumbers {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);

        int sum = 0, min = numbers[0], max = numbers[0];
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double avg = (double) sum / numbers.length;

        System.out.print("Random Numbers: ");
        for (int n : numbers) System.out.print(n + " ");
        System.out.println("\nAverage = " + avg);
        System.out.println("Min = " + min + ", Max = " + max);
    }
}
