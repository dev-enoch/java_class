import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class BookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Read JSON input
            StringBuilder jsonInput = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonInput.append(line);
            }

            JSONObject obj = new JSONObject(jsonInput.toString());
            String title = obj.getString("title");
            String author = obj.getString("author");

            // Insert into database
            Database.insertBook(title, author);

            JSONObject res = new JSONObject();
            res.put("message", "Book added successfully");
            res.put("title", title);
            res.put("author", author);

            out.print(res.toString());

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("error", e.getMessage());
            out.print(error.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            StringBuilder jsonInput = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonInput.append(line);
            }

            JSONObject obj = new JSONObject(jsonInput.toString());
            int id = obj.getInt("id");
            String title = obj.getString("title");
            String author = obj.getString("author");

            boolean updated = Database.updateBook(id, title, author);

            JSONObject res = new JSONObject();
            if (updated) {
                res.put("message", "Book updated successfully");
                res.put("id", id);
                res.put("title", title);
                res.put("author", author);
            } else {
                res.put("error", "Book not found");
            }

            out.print(res.toString());

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("error", e.getMessage());
            out.print(error.toString());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            String idParam = request.getParameter("id");
            if (idParam == null) {
                JSONObject error = new JSONObject();
                error.put("error", "Missing id parameter");
                out.print(error.toString());
                return;
            }

            int id = Integer.parseInt(idParam);
            boolean deleted = Database.deleteBook(id);

            JSONObject res = new JSONObject();
            if (deleted) {
                res.put("message", "Book deleted successfully");
                res.put("id", id);
            } else {
                res.put("error", "Book not found");
            }

            out.print(res.toString());

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("error", e.getMessage());
            out.print(error.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        JSONArray books = new JSONArray();
        try (Connection conn = Database.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                JSONObject book = new JSONObject();
                book.put("id", rs.getInt("id"));
                book.put("title", rs.getString("title"));
                book.put("author", rs.getString("author"));
                books.put(book);
            }
        } catch (SQLException e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
            return;
        }

        response.setContentType("application/json");
        response.getWriter().print(books.toString());
    }
}
