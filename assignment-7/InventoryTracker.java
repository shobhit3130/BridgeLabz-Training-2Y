import java.util.Scanner;

public class InventoryTracker {

    // Item class definition
    static class Item {
        int itemCode;
        String itemName;
        double price;

        // Constructor
        public Item(int code, String name, double p) {
            itemCode = code;
            itemName = name;
            price = p;
        }

        // Method to display item details
        public void displayDetails() {
            System.out.println("Item Code: " + itemCode);
            System.out.println("Item Name: " + itemName);
            System.out.println("Price per unit: ₹" + price);
        }

        // Method to calculate total cost
        public double calculateTotalCost(int quantity) {
            return price * quantity;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input item details
        System.out.print("Enter item code: ");
        int code = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter item price: ");
        double price = sc.nextDouble();

        // Create item object
        Item item = new Item(code, name, price);

        // Display item details
        System.out.println("\n--- Item Details ---");
        item.displayDetails();

        // Input quantity and calculate total cost
        System.out.print("\nEnter quantity to purchase: ");
        int qty = sc.nextInt();

        double total = item.calculateTotalCost(qty);
        System.out.println("Total Cost for " + qty + " units: ₹" + total);
    }
}