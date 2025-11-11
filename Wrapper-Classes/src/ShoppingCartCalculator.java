public class ShoppingCartCalculator {
    public static void main(String[] args) {
        // Prices stored as strings
        String[] priceStrings = { "250", "499", "99", "abc", "100" };

        int totalPrice = 0;

        System.out.println("🧾 Price Breakdown:");
        for (String price : priceStrings) {
            try {
                int value = Integer.parseInt(price);
                System.out.println("Valid price: ₹" + value);
                totalPrice += value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price skipped: \"" + price + "\"");
            }
        }

        System.out.println("\n🛍️ Total Price: ₹" + totalPrice);
    }
}