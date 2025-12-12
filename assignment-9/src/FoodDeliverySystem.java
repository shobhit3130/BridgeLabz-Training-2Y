// Interface: Discountable
interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

// Abstract class: BaseFoodItem (renamed to avoid duplicate "FoodItem")
abstract class BaseFoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public BaseFoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters and Setters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract method
    public abstract double calculateTotalPrice();
}

// Subclass: VegItem
class VegItem extends BaseFoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - discount;
    }

    @Override
    public void applyDiscount(double percent) {
        discount = (getPrice() * getQuantity()) * (percent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg item discount applied: ₹" + discount;
    }
}

// Subclass: NonVegItem
class NonVegItem extends BaseFoodItem implements Discountable {
    private double extraCharge;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.extraCharge = 50; // fixed non-veg charge
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + extraCharge) * getQuantity();
        return total - discount;
    }

    @Override
    public void applyDiscount(double percent) {
        discount = ((getPrice() + extraCharge) * getQuantity()) * (percent / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-veg item discount applied: ₹" + discount;
    }
}

// ✅ Public class for main method
public class FoodDeliverySystem {
    public static void main(String[] args) {
        BaseFoodItem item1 = new VegItem("Paneer Tikka", 200, 2);
        BaseFoodItem item2 = new NonVegItem("Chicken Biryani", 250, 3);

        Discountable d1 = (Discountable) item1;
        Discountable d2 = (Discountable) item2;

        d1.applyDiscount(10); // 10% discount
        d2.applyDiscount(5);  // 5% discount

        System.out.println("🟢 Veg Item:");
        item1.getItemDetails();
        System.out.println(d1.getDiscountDetails());
        System.out.println("Total Price: ₹" + item1.calculateTotalPrice());

        System.out.println("\n🔴 Non-Veg Item:");
        item2.getItemDetails();
        System.out.println(d2.getDiscountDetails());
        System.out.println("Total Price: ₹" + item2.calculateTotalPrice());
    }
}