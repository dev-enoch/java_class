import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/library";
        String user = "postgres"; // your PostgreSQL username
        String password = "newpassword"; // your PostgreSQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database.");

            // Insert book
            String insertSQL = "INSERT INTO books (title, author) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                ps.setString(1, "Clean Code");
                ps.setString(2, "Robert C. Martin");
                ps.executeUpdate();
                System.out.println("Book inserted.");
            }

            // Retrieve all books
            String selectSQL = "SELECT * FROM books";
            try (PreparedStatement ps = conn.prepareStatement(selectSQL)) {
                ResultSet rs = ps.executeQuery();
                System.out.println("Books in database:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("title") + " by " + rs.getString("author"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
