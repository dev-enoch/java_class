import java.util.ArrayList;

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

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book);
    }

    public void listBooks() {
        System.out.println("Library books:");
        for (Book b : books) {
            System.out.println("- " + b);
        }
    }

    public void findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + b);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class Arrays {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));
        library.addBook(new Book("Refactoring", "Martin Fowler"));

        library.listBooks();
        library.findBook("Effective Java");
    }
}
