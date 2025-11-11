import java.util.ArrayList;

public class WrapperPerformanceBenchmark {
    public static void main(String[] args) {
        final int SIZE = 1_000_000;

        // Benchmark: ArrayList<Integer>
        long startList = System.nanoTime();
        ArrayList<Integer> intList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            intList.add(i); // auto-boxing
        }
        long sumList = 0;
        for (Integer val : intList) {
            sumList += val; // auto-unboxing
        }
        long endList = System.nanoTime();
        long timeList = endList - startList;

        // Benchmark: int[]
        long startArray = System.nanoTime();
        int[] intArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            intArray[i] = i;
        }
        long sumArray = 0;
        for (int val : intArray) {
            sumArray += val;
        }
        long endArray = System.nanoTime();
        long timeArray = endArray - startArray;

        // Results
        System.out.println("📦 ArrayList<Integer> → Time: " + timeList / 1_000_000 + " ms, Sum: " + sumList);
        System.out.println("⚡ int[]              → Time: " + timeArray / 1_000_000 + " ms, Sum: " + sumArray);
    }
}