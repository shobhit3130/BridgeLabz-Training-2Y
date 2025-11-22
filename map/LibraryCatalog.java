package map;

import java.util.*;

public class LibraryCatalog {
    public static void main(String[] args) {
        // TreeMap keeps ISBNs sorted
        Map<String, String> catalog = new TreeMap<>();

        // 1. Add several books (ISBN → Title)
        catalog.put("978-1234567890", "The Java Handbook");
        catalog.put("978-0987654321", "Data Structures in Depth");
        catalog.put("978-1111111111", "Algorithms Unlocked");
        catalog.put("978-2222222222", "Clean Code");
        catalog.put("978-3333333333", "Design Patterns Explained");

        // 2. Search by ISBN
        String searchISBN = "978-0987654321";
        if (catalog.containsKey(searchISBN)) {
            System.out.println("Found: " + catalog.get(searchISBN));
        } else {
            System.out.println("Book not found.");
        }

        // 3. Remove a book (e.g., sold/discarded)
        catalog.remove("978-1111111111");

        // 4. Print all ISBNs + titles sorted by ISBN
        System.out.println("\nLibrary Catalog:");
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Extension: Search by title
        String titleSearch = "Clean Code";
        boolean found = false;
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(titleSearch)) {
                System.out.println("\nFound by title: ISBN = " + entry.getKey());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nBook title not found.");
        }
    }
}
