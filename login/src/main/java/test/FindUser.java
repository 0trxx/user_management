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
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anton" , "root" , "Redface@123");
			
			// Set up the response content type
			response.setContentType("text/html");

			// Get the search terms from the form input
			String n = request.getParameter("name");
			String p = request.getParameter("mobNum");
			String e = request.getParameter("email");
			
			// Build the SQL query based on the search terms
			String sql = "SELECT * FROM login WHERE 1=1";
			if (n != null && !n.isEmpty()) {
				sql += " AND uname LIKE '%" + n + "%'";
			}
			if (p != null && !p.isEmpty()) {
				sql += " AND number LIKE '%" + p + "%'";
			}
			if (e != null && !e.isEmpty()) {
				sql += " AND email LIKE '%" + e + "%'";
			}
			
			
			// Retrieve data from the database based on the search term
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			// Format the data as an HTML table
						PrintWriter out = response.getWriter();
						out.println("<html><head><title>User Results</title></head><body>");
						out.println("<h1>User Results</h1>");
						out.println("<table border='1' cellpadding='5'>");
						out.println("<tr  ><th>Name</th> <th>Phone Number</th> <th>E-mail</th> </tr>");
						while (rs.next()) {
							out.println("<tr>");
							out.println("<td>" + rs.getString("uname") + "</td>");
							out.println("<td>" + rs.getString("number") + "</td>");
							out.println("<td>" + rs.getString("email") + "</td>");
							out.println("</tr>");
						}
						out.println("</table>");
						out.println("<a href=login.jsp> Home </a>");
						out.println("</body></html>");

						// Close the database connection
						rs.close();
						ps.close();
	
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
