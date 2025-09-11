import java.util.Scanner;

public class MobilePhoneDetails {

    // MobilePhone class definition
    static class MobilePhone {
        String brand;
        String model;
        double price;

        // Constructor
        public MobilePhone(String b, String m, double p) {
            brand = b;
            model = m;
            price = p;
        }

        // Method to display phone details
        public void displayDetails() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Price: ₹" + price);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input phone details
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter model: ");
        String model = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        // Create MobilePhone object
        MobilePhone phone = new MobilePhone(brand, model, price);

        // Display phone details
        System.out.println("\n--- Mobile Phone Details ---");
        phone.displayDetails();
    }
}