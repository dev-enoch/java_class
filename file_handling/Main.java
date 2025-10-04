import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class BookLogger {
    private static final String FILE_NAME = "books.txt";

    public void saveBook(String title) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(title + "\n");
            System.out.println("Book logged: " + title);
        } catch (IOException e) {
            System.out.println("Error logging book: " + e.getMessage());
        }
    }

    public void showAllBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Logged Books:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading books: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookLogger logger = new BookLogger();
        logger.saveBook("The Great Gatsby");
        logger.saveBook("1984");
        logger.saveBook("Voyage to the Sea");
        logger.showAllBooks();
    }
}
