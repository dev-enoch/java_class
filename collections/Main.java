import java.util.ArrayList;
import java.util.HashMap;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public String toString() {
        return title + " by " + author;
    }
}

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();
    HashMap<String, Book> bookMap = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
         bookMap.put(book.getTitle().toLowerCase(), book);
        System.out.println("Added: " + book);
    }

    public void listAllBooks() {
        System.out.println("Library books:");
        for (Book b : books) {
            System.out.println("- " + b);
        }
    }

    public void findBook(String title) {
        Book found = bookMap.get(title.toLowerCase());
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Book not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("Clean Code", "Robert C. Martin"));
        manager.addBook(new Book("Effective Java", "Joshua Bloch"));
        manager.addBook(new Book("Refactoring", "Martin Fowler"));

        manager.listAllBooks();
        manager.findBook("Effective Java");
    }
}