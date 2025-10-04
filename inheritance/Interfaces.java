import java.util.ArrayList;


// Abstract and Interface Practice

public interface Downloadable {
    void download();
}

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

public class EBook extends Book implements Downloadable {
    private int fileSizeMB;

    public EBook(String title, String author, int fileSizeMB) {
        super(title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public String getFormatInfo() {
        return "[File Size: " + fileSizeMB + "MB]";
    }

    public void download() {
        System.out.println("Downloading ebook " + printInfo() + " ...");
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
public class Interfaces {
    public static void main(String[] args) {
        EBook ebook = new EBook("Clean Code", "Robert C. Martin", 5);
        ebook.download();

        AudioBook ab = new AudioBook("The Pragmatic Programmer", "Andrew Hunt", 300);
        System.out.println(ab.printInfo());
    }
}
