public class BookController {
    // List to hold books
    public List<Book__c> books { get; set; }
    // Variable to hold new book information
    public Book__c newBook { get; set; }

    // Constructor to fetch existing books from Salesforce
    public BookController() {
        books = [SELECT Id, Title__c, Author__c, Publication_Year__c FROM Book__c LIMIT 10];
        newBook = new Book__c(); // Initialize the new book object
    }

    // Method to save a new book
    public PageReference saveBook() {
        insert newBook; // Insert the new book into Salesforce
        books.add(newBook); // Add the new book to the list of books
        newBook = new Book__c(); // Reset the form for the next input
        return null; // Stay on the same page
    }

    // Method to update book details
    public PageReference updateBook() {
        update books; // Update all books in Salesforce
        return null; // Stay on the same page
    }
}
