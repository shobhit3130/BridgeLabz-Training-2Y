package lambda;

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " ₹" + price + " ★" + rating + " -" + discount + "%";
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 45000, 4.5, 10),
                new Product("Phone", 30000, 4.7, 15),
                new Product("Tablet", 20000, 4.2, 5)
        );

        // Sort by price
        products.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Sorted by price:");
        products.forEach(System.out::println);

        // Sort by rating
        products.sort((a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("\nSorted by rating:");
        products.forEach(System.out::println);

        // Sort by discount
        products.sort((a, b) -> Double.compare(b.discount, a.discount));
        System.out.println("\nSorted by discount:");
        products.forEach(System.out::println);
    }
}