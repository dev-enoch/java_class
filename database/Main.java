import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();

        dao.insertBook(new Book("Clean Code", "Robert C. Martin"));
        dao.insertBook(new Book("Effective Java", "Joshua Bloch"));

        List<Book> books = dao.getAllBooks();
        for (Book b : books) {
            System.out.println(b);
        }

        dao.updateBook(1, "Clean Code - Updated");
        dao.deleteBook(2);
    }
}
