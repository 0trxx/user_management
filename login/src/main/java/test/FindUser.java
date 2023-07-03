package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login/find.jsp")
public class FindUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anton", "root", "Redface@123");

            // Set up the response content type
            response.setContentType("text/html");

            // Get the search terms from the form input
            String n = request.getParameter("name");
            String p = request.getParameter("mobNum");
            String e = request.getParameter("email");

            // Build the SQL query based on the search terms
            String sql = "SELECT * FROM login WHERE 1=1";
            if (n != null && !n.isEmpty()) {
                sql += " AND uname LIKE ?";
            }
            if (p != null && !p.isEmpty()) {
                sql += " AND number LIKE ?";
            }
            if (e != null && !e.isEmpty()) {
                sql += " AND email LIKE ?";
            }

            // Retrieve data from the database based on the search term
            PreparedStatement ps = con.prepareStatement(sql);
            int parameterIndex = 1;
            if (n != null && !n.isEmpty()) {
                ps.setString(parameterIndex++, "%" + n + "%");
            }
            if (p != null && !p.isEmpty()) {
                ps.setString(parameterIndex++, "%" + p + "%");
            }
            if (e != null && !e.isEmpty()) {
                ps.setString(parameterIndex++, "%" + e + "%");
            }

            ResultSet rs = ps.executeQuery();

            // Format the data as an HTML table with CSS styles
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>User Results</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; }");
            out.println("h1 { text-align: center; }");
            out.println("table { margin: 20px auto; border-collapse: collapse; width: 80%; }");
            out.println("th, td { padding: 10px; text-align: left; }");
            out.println("th { background-color: #ccc; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("a { display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: #fff; text-decoration: none; border-radius: 5px; }");
            out.println("a:hover { background-color: #45a049; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<h1>User Results</h1>");
            out.println("<table>");
            out.println("<tr><th>Name</th><th>Phone Number</th><th>E-mail</th></tr>");

            boolean foundResults = false; // Flag to track if any results are found

            while (rs.next()) {
                String uname = rs.getString("uname");
                String number = rs.getString("number");
                String email = rs.getString("email");
                // Check if the retrieved values match the search criteria
                if ((n == null || uname.contains(n)) &&
                        (p == null || number.contains(p)) &&
                        (e == null || email.contains(e))) {

                    foundResults = true; // Set the flag to indicate results are found

                    out.println("<tr>");
                    out.println("<td>" + uname + "</td>");
                    out.println("<td>" + number + "</td>");
                    out.println("<td>" + email + "</td>");
                    out.println("</tr>");
                }
            }

            // If no results are found, display a message and redirect to home
            if (!foundResults) {
                out.println("<tr>");
                out.println("<td colspan='3'>No results found.</td>");
                out.println("</tr>");
               
            }

            out.println("</table>");
            out.println("<a href=\"login.jsp\">Home</a>");
            out.println("</body></html>");

            // Close the database connection
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

