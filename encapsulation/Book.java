public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid title.");
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Invalid author.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void printInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}