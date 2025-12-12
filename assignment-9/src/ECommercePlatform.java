// Interface: Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class: BaseProduct (renamed to avoid duplicate "Product")
abstract class BaseProduct {
    private int productId;
    private String name;
    private double price;

    public BaseProduct(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract method
    public abstract double calculateDiscount();

    // Polymorphic method
    public void printFinalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable)this).calculateTax() : 0;
        double finalPrice = price + tax - discount;

        System.out.println("Product: " + name);
        System.out.println("Base Price: ₹" + price);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Tax: ₹" + tax);
        System.out.println("Final Price: ₹" + finalPrice);
        if (this instanceof Taxable) {
            System.out.println("Tax Details: " + ((Taxable)this).getTaxDetails());
        }
        System.out.println("-----------------------------");
    }
}

// Electronics class
class Electronics extends BaseProduct implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied on electronics.";
    }
}

// Clothing class
class Clothing extends BaseProduct implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "5% GST applied on clothing.";
    }
}

// Groceries class (no tax)
class Groceries extends BaseProduct {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        BaseProduct[] products = {
                new Electronics(101, "Smartphone", 30000),
                new Clothing(102, "T-Shirt", 800),
                new Groceries(103, "Rice Bag", 1200)
        };

        System.out.println("🛍️ Final Price Summary:");
        for (BaseProduct product : products) {
            product.printFinalPrice(); // Polymorphism in action
        }
    }
}