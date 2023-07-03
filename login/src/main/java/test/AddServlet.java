package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login/adduser.jsp")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anton" , "root" , "Redface@123");
			
			String n=request.getParameter("txtName");
			String p=request.getParameter("txtPwd");
			String a=request.getParameter("mobNum");
			String b=request.getParameter("email");
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO login (uname, password, number, email) VALUES (?, ?, ?, ?)");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, a);
			ps.setString(4, b);
			
			ps.executeUpdate();
	
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
