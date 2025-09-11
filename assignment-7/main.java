class Circle {
    // Properties
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Methods
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void showInfo() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

class Book {
    // Properties
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method
    public void showInfo() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class main {
    public static void main(String[] args) {
        // Create and show circle
        Circle circle = new Circle(5.0);
        circle.showInfo();

        // Create and show book
        Book book = new Book("Atomic Habits", "James Clear", 499.00);
        book.showInfo();
    }
}
