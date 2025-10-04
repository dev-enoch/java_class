import java.util.ArrayList;

public abstract class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract String getFormatInfo();

    public String printInfo() {
        return "Book: " + title + " by " + author + " " + getFormatInfo();
    }
}

public class EBook extends Book {
    private int fileSizeMB;

    public EBook(String title, String author, int fileSizeMB) {
        super(title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public String getFormatInfo() {
        return "[File Size: " + fileSizeMB + "MB]";
    }

    @Override
    public String printInfo() {
        return super.printInfo();
    }
}

public class AudioBook extends Book {
    private int durationMinutes;

    public AudioBook(String title, String author, int durationMinutes) {
        super(title, author);
        this.durationMinutes = durationMinutes;
    }

    public String getFormatInfo() {
        return "[Duration: " + durationMinutes + " minutes]";
    }

}

// Application
public class Main {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        // library.add(new Book("Effective Java", "Joshua Bloch"));
        library.add(new EBook("Clean Code", "Robert C. Martin", 5));
        library.add(new AudioBook("The Pragmatic Programmer", "Andrew Hunt", 300));

        for (Book a : library) {
            System.out.println(a.printInfo());
        }
    }
}
