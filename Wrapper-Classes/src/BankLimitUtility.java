public class BankLimitUtility {
    // Method to return remaining withdrawal limit
    public static double getRemainingLimit(Double limit) {
        if (limit == null) {
            return 0.0;
        }
        return limit;
    }

    public static void main(String[] args) {
        // Test cases
        Double[] limits = { 5000.0, null, 0.0, 1200.75 };

        System.out.println("💳 Remaining Withdrawal Limits:");
        for (Double limit : limits) {
            double remaining = getRemainingLimit(limit);
            System.out.println("Limit: " + limit + " → Remaining: ₹" + remaining);
        }
    }
}