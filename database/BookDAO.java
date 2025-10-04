import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void insertBook(Book book) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.executeUpdate();
            System.out.println("Book inserted: " + book.getTitle());
        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
            }
        } catch (SQLException e) {
            System.out.println("Read error: " + e.getMessage());
        }

        return books;
    }

    public void updateBook(int id, String newTitle) {
        String sql = "UPDATE books SET title = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newTitle);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Book updated: " + newTitle);
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Book deleted with ID: " + id);
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}
