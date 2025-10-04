import java.util.ArrayList;

public class BookStore {
    ArrayList<Book> inventory = new ArrayList<>();
    
    public String findBook(String title) throws BookNotFoundException {
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.printInfo();
            }
        }
        throw new BookNotFoundException("Book with title '" + title + "' not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.inventory.add(new Book("Clean Code", "Robert C. Martin"));
        store.inventory.add(new Book("Effective Java", "Joshua Bloch"));

        try {
            System.out.println(store.findBook("Clean Code"));
            System.out.println(store.findBook("Unknown Book"));
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}