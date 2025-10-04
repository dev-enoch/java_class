public class UserApp {
    public static void main(String[] args) {
       Book book = new Book("Effective Java", "Joshua Bloch");
       book.printInfo();

       book.setTitle("");
       book.setAuthor(null);

       book.setTitle("Clean Code");
       book.setAuthor("Robert C. Martin");

       System.out.println("Updated title:" + book.getTitle());
       System.out.println("Updated author:" + book.getAuthor());
    }
}
