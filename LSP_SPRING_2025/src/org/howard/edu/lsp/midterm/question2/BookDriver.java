package org.howard.edu.lsp.midterm.question2;

/**
 * Driver class to test the Book class functionality.
 */
public class BookDriver {

    /**
     * Main method to demonstrate Book class functionality.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating Book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Testing equals method
        System.out.println(book1.equals(book2)); // Expected: true
        System.out.println(book1.equals(book3)); // Expected: false

        // Testing toString method
        System.out.println(book1); // Output formatted book details
    }
}
