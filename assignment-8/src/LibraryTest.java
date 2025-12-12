// Superclass: Book
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Published: " + publicationYear);
    }
}

// Subclass: Author
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // Show book info
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main class
public class LibraryTest {
    public static void main(String[] args) {
        Author book = new Author("The Java Journey", 2022, "Shobhit Gupta", "Passionate coder and educator.");
        book.displayInfo();
    }
}