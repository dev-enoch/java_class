import java.sql.*;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "newpassword";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertBook(String title, String author) throws SQLException {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
        }
    }

    public static boolean updateBook(int id, String title, String author) throws SQLException {
        String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }

    public static boolean deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
}
