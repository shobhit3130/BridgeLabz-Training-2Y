package map;

import java.util.*;

public class StoreInventory {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();


        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Oranges", 20);
        inventory.put("Milk", 10);


        purchaseProduct(inventory, "Apples", 20);   // 30 left
        purchaseProduct(inventory, "Milk", 10);     // 0 left, out of stock
        purchaseProduct(inventory, "Bananas", 35);  // goes below 0, out of stock


        restockProduct(inventory, "Oranges", 40);   // now 60
        restockProduct(inventory, "Milk", 25);      // now 25


        queryProduct(inventory, "Apples");
        queryProduct(inventory, "Bananas");
        queryProduct(inventory, "Bread"); // not stocked


        System.out.println("\nOut-of-stock products:");
        for (String product : getOutOfStockProducts(inventory)) {
            System.out.println(product);
        }
    }


    public static void purchaseProduct(Map<String, Integer> inventory, String product, int quantity) {
        if (inventory.containsKey(product)) {
            int current = inventory.get(product) - quantity;
            if (current <= 0) {
                inventory.remove(product);
                System.out.println(product + " is now out of stock.");
            } else {
                inventory.put(product, current);
                System.out.println("Purchased " + quantity + " " + product + ". Remaining: " + current);
            }
        } else {
            System.out.println(product + " is not stocked.");
        }
    }


    public static void restockProduct(Map<String, Integer> inventory, String product, int quantity) {
        int current = inventory.getOrDefault(product, 0) + quantity;
        inventory.put(product, current);
        System.out.println("Restocked " + product + ". New quantity: " + current);
    }


    public static void queryProduct(Map<String, Integer> inventory, String product) {
        if (inventory.containsKey(product)) {
            System.out.println(product + " has " + inventory.get(product) + " units in stock.");
        } else {
            System.out.println(product + " is not stocked.");
        }
    }


    public static List<String> getOutOfStockProducts(Map<String, Integer> inventory) {
        List<String> outOfStock = new ArrayList<>();
        // Products removed from inventory are considered out of stock
        Set<String> allProducts = new HashSet<>(Arrays.asList("Apples", "Bananas", "Oranges", "Milk", "Bread"));
        for (String product : allProducts) {
            if (!inventory.containsKey(product) || inventory.get(product) == 0) {
                outOfStock.add(product);
            }
        }
        return outOfStock;
    }
}
