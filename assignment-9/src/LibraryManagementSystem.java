
// Interface: Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Abstract class: BaseLibraryItem
abstract class BaseLibraryItem {
    private int itemId;
    private String title;
    private String author;
    private boolean isAvailable;

    public BaseLibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Encapsulation: Getters and Setters
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailability(boolean status) { this.isAvailable = status; }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days
}

// Subclass: Book
class Book extends BaseLibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem() {
        System.out.println("Reserving book: " + getTitle());
        setAvailability(false);
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Subclass: Magazine
class Magazine extends BaseLibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

// Subclass: DVD
class DVD extends BaseLibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem() {
        System.out.println("Reserving DVD: " + getTitle());
        setAvailability(false);
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// ✅ Public class for main method
public class LibraryManagementSystem {
    public static void main(String[] args) {
        BaseLibraryItem[] items = {
                new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Magazine(102, "National Geographic", "Various"),
                new DVD(103, "Inception", "Christopher Nolan")
        };

        System.out.println("📖 Library Items:");
        for (BaseLibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                r.reserveItem();
                System.out.println("Availability after reservation: " + (r.checkAvailability() ? "Yes" : "No"));
            }

            System.out.println("-----------------------------");
        }
    }
}