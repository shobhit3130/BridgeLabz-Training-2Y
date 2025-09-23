import java.util.*;

public class ECommerceApp {

    // Product class
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    // Order class (aggregates products)
    static class Order {
        private String orderId;
        private List<Product> products;

        public Order(String orderId) {
            this.orderId = orderId;
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public double getTotalAmount() {
            double total = 0;
            for (Product p : products) {
                total += p.getPrice();
            }
            return total;
        }

        public void showOrderDetails() {
            System.out.println("Order ID: " + orderId);
            for (Product p : products) {
                System.out.println("  - " + p);
            }
            System.out.println("Total: $" + getTotalAmount());
        }
    }

    // Customer class (places orders)
    static class Customer {
        private String name;
        private List<Order> orders;

        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }

        public void placeOrder(Order order) {
            orders.add(order);
            System.out.println(name + " placed an order: " + order.orderId);
        }

        public void viewOrders() {
            System.out.println("Customer: " + name);
            for (Order order : orders) {
                order.showOrderDetails();
                System.out.println();
            }
        }
    }

    // Main method to demonstrate relationships and communication
    public static void main(String[] args) {
        // Products
        Product laptop = new Product("Laptop", 750.00);
        Product phone = new Product("Smartphone", 500.00);
        Product headphones = new Product("Headphones", 80.00);

        // Customer
        Customer alice = new Customer("Alice");

        // Order 1
        Order order1 = new Order("ORD001");
        order1.addProduct(laptop);
        order1.addProduct(headphones);
        alice.placeOrder(order1);

        // Order 2
        Order order2 = new Order("ORD002");
        order2.addProduct(phone);
        alice.placeOrder(order2);

        // View all orders
        System.out.println();
        alice.viewOrders();
    }
}