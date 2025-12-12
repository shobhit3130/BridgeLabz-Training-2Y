import java.util.*;

public class LibraryApp {

    // Book class (can exist independently)
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "\"" + title + "\" by " + author;
        }
    }

    // Library class (aggregates books)
    static class Library {
        private String name;
        private List<Book> books;

        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void showBooks() {
            System.out.println("Library: " + name);
            for (Book book : books) {
                System.out.println("  - " + book);
            }
        }
    }

    // Main method to demonstrate aggregation
    public static void main(String[] args) {
        // Independent books
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");
        Book book3 = new Book("Clean Code", "Robert C. Martin");

        // Libraries
        Library cityLibrary = new Library("City Library");
        Library schoolLibrary = new Library("School Library");

        // Aggregating books into libraries
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);

        schoolLibrary.addBook(book2); // same book in another library
        schoolLibrary.addBook(book3);

        // Display contents
        cityLibrary.showBooks();
        System.out.println();
        schoolLibrary.showBooks();
    }
}