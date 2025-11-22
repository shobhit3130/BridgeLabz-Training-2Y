package map;

import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        // Step 1: Add products with prices (preserving insertion order)
        LinkedHashMap<String, Double> cart = new LinkedHashMap<>();
        cart.put("Laptop", 45000.0);
        cart.put("Mouse", 500.0);
        cart.put("Keyboard", 1500.0);
        cart.put("Monitor", 8000.0);
        cart.put("USB Cable", 300.0);

        // Simulate quantities for each product
        Map<String, Integer> quantities = new HashMap<>();
        quantities.put("Laptop", 1);
        quantities.put("Mouse", 2);
        quantities.put("Keyboard", 1);
        quantities.put("Monitor", 1);
        quantities.put("USB Cable", 0); // simulate removal

        // Step 2: Display products in order of addition
        System.out.println("Products in cart:");
        for (String product : cart.keySet()) {
            int qty = quantities.getOrDefault(product, 0);
            if (qty > 0) {
                System.out.printf("%s x%d @ ₹%.2f each\n", product, qty, cart.get(product));
            }
        }

        // Step 3: Calculate total bill
        double total = 0;
        for (String product : cart.keySet()) {
            int qty = quantities.getOrDefault(product, 0);
            if (qty > 0) {
                total += cart.get(product) * qty;
            }
        }

        // Step 4: Apply discount if applicable
        double discount = 0;
        if (total > 5000) {
            discount = total * 0.10;
            total -= discount;
        }

        System.out.printf("\nDiscount applied: ₹%.2f\n", discount);
        System.out.printf("Total bill amount: ₹%.2f\n", total);

        // Step 5: Remove items with zero quantity
        cart.entrySet().removeIf(entry -> quantities.getOrDefault(entry.getKey(), 0) == 0);

        System.out.println("\nFinal cart after removing zero-quantity items:");
        for (String product : cart.keySet()) {
            int qty = quantities.get(product);
            System.out.printf("%s x%d\n", product, qty);
        }
    }
}
