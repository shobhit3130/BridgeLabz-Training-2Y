import java.util.ArrayList;

public class PriceAnalysisUtility {
    public static void main(String[] args) {
        // Primitive array
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert to ArrayList<Double> using auto-boxing
        ArrayList<Double> priceList = new ArrayList<>();
        for (double price : prices) {
            priceList.add(price); // auto-boxing
        }

        // Calculate highest and average price
        double maxPrice = Double.MIN_VALUE;
        double total = 0.0;

        for (Double price : priceList) {
            if (price > maxPrice) {
                maxPrice = price;
            }
            total += price; // auto-unboxing
        }

        double averagePrice = total / priceList.size();

        // Display results
        System.out.println("Highest Price: ₹" + maxPrice);
        System.out.println("Average Price: ₹" + averagePrice);
    }
}
