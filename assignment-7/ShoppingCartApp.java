import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartApp {

    // CartItem class definition
    static class CartItem {
        String itemName;
        double price;
        int quantity;

        // Constructor
        public CartItem(String name, double p, int q) {
            itemName = name;
            price = p;
            quantity = q;
        }

        // Method to calculate total cost for this item
        public double getTotalCost() {
            return price * quantity;
        }

        // Method to display item details
        public void displayItem() {
            System.out.println(itemName + " | ₹" + price + " x " + quantity + " = ₹" + getTotalCost());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Total Cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    cart.add(new CartItem(name, price, qty));
                    System.out.println("Item added to cart.");
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).itemName.equalsIgnoreCase(removeName)) {
                            cart.remove(i);
                            removed = true;
                            System.out.println("Item removed from cart.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Item not found in cart.");
                    }
                    break;

                case 3:
                    double total = 0;
                    System.out.println("\n--- Cart Items ---");
                    for (CartItem item : cart) {
                        item.displayItem();
                        total += item.getTotalCost();
                    }
                    System.out.println("Total Cost: ₹" + total);
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}