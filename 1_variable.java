public class User {
    String name;
    int age;

    public void sayHello() {
        System.out.println("Hello " + name + ", you are " + age + " years old.");
    }
}

// Book Class: Test
public class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void printInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// User profile class
public class UserProfile {
    String username;
    String email;
    int age;

    public UserProfile(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public void displayProfile() {
        System.out.println("User: " + username + ", Email: " + email + ", Age: " + age);
    }
}

public class UserApp {
    public static void main(String[] args) {
        User unl = new User();
    
        unl.name = "Enoch";
        unl.age = 24;
        unl.sayHello();

        Book book = new Book("Effective Java", "Joshua Bloch");
        book.printInfo();

        Book book2 = new Book("Clean Code", "Robert C. Martin");
        book2.printInfo();

        UserProfile profile = new UserProfile("enoch123", "test@gmail.com", 24);
        profile.displayProfile();
    }
}


