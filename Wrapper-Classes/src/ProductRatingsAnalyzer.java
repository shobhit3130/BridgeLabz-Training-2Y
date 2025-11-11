import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        // Ratings from old system (primitive int[])
        int[] oldRatings = {4, 5, 3, 2};

        // Ratings from new system (ArrayList<Integer> with possible nulls)
        ArrayList<Integer> newRatings = new ArrayList<>(Arrays.asList(5, null, 4, 3, null));

        // Combine both into a single list of Integer
        ArrayList<Integer> combinedRatings = new ArrayList<>();

        // Auto-boxing from int[] to Integer
        for (int rating : oldRatings) {
            combinedRatings.add(rating); // auto-boxed
        }

        // Add all new ratings
        combinedRatings.addAll(newRatings);

        // Filter out nulls
        List<Integer> validRatings = combinedRatings.stream()
                .filter(Objects::nonNull)
                .toList();

        // Calculate average
        double total = 0;
        for (int rating : validRatings) {
            total += rating;
        }

        double average = validRatings.isEmpty() ? 0.0 : total / validRatings.size();

        // Display results
        System.out.println("📊 Combined Ratings: " + validRatings);
        System.out.println("⭐ Average Rating: " + average);
    }
}