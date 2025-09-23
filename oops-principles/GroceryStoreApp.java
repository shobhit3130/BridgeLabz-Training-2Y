import java.util.*;

public class GroceryStoreApp {

    // Product class
    static class Product {
        private String name;
        private double quantity;
        private double pricePerUnit;

        public Product(String name, double quantity, double pricePerUnit) {
            this.name = name;
            this.quantity = quantity;
            this.pricePerUnit = pricePerUnit;
        }

        public String getName() {
            return name;
        }

        public double getQuantity() {
            return quantity;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public double getTotalPrice() {
            return quantity * pricePerUnit;
        }
    }

    // Customer class
    static class Customer {
        private String name;
        private List<Product> products;

        public Customer(String name, List<Product> products) {
            this.name = name;
            this.products = products;
        }

        public String getName() {
            return name;
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    // BillGenerator class
    static class BillGenerator {
        public double generateBill(Customer customer) {
            double total = 0;
            for (Product product : customer.getProducts()) {
                total += product.getTotalPrice();
            }
            return total;
        }
    }

    // Main method (Object + Sequence Simulation)
    public static void main(String[] args) {
        Product apples = new Product("Apples", 2.0, 3.0); // 2 kg at $3/kg
        Product milk = new Product("Milk", 1.0, 2.0);     // 1 liter at $2/liter

        List<Product> productList = Arrays.asList(apples, milk);
        Customer alice = new Customer("Alice", productList);

        BillGenerator generator = new BillGenerator();
        double totalBill = generator.generateBill(alice);

        System.out.println("Customer: " + alice.getName());
        for (Product product : alice.getProducts()) {
            System.out.println(product.getName() + " (" + product.getQuantity() + 
                               " units at $" + product.getPricePerUnit() + " per unit) → $" + 
                               product.getTotalPrice());
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}