package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.getConnection;

/**
 * Servlet implementation class deleteUser
 */
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		String userId = request.getParameter("userId");
        System.out.println(userId);
        try {
			con = getConnection.getCon();
			//delete from wishlist first then user
			PreparedStatement prep = con.prepareStatement("Delete from wishlist WHERE studentId=?");
			 prep.setString(1, userId);
			 int rowsAffected = prep.executeUpdate();
			 prep = con.prepareStatement("Delete from user WHERE id=?");
			 prep.setString(1, userId);
			 rowsAffected = prep.executeUpdate();
			 response.sendRedirect("test.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
