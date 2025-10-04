public class UserProfile {
    private String username;
    private String email;
    private int age;

    // constructor
    public UserProfile(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    // getter for username
    public String getUsername() {
        return username;
    }

    // setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // getter for email
    public String getEmail() {
        return email;
    }

    // setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // setter for age with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    public void displayProfile() {
        System.out.println("User: " + username + ", Email: " + email + ", Age: " + age);
    }
}
