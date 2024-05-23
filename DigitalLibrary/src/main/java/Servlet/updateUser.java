package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DatabaseAccessObject.getConnection;

/**
 * Servlet implementation class updateUser
 */
@MultipartConfig
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userId = request.getParameter("userId");
        String dob = request.getParameter("dob");
        Part img = request.getPart("profile");
        InputStream imgInput = null; // Declare outside the if block

       		try {
       		 if (img != null) {
                 imgInput = img.getInputStream();
                 con = getConnection.getCon();
    			 PreparedStatement prep = con.prepareStatement("UPDATE user SET name=?, email=?, password=?, dob=?, profile =? WHERE id=?");
    			 prep.setString(1, userName);
    			 prep.setString(2, email);
    			 prep.setString(3, password);
    			 prep.setString(4, dob);
    			 prep.setBinaryStream(5, imgInput);
    			 prep.setString(6, userId);
    			 int rowsAffected = prep.executeUpdate();
    			 response.sendRedirect("test.jsp");
             }
       		 else
       		 {
       			 con = getConnection.getCon();
    			 PreparedStatement prep = con.prepareStatement("UPDATE user SET name=?, email=?, password=?, dob=? WHERE id=?");
    			 prep.setString(1, userName);
    			 prep.setString(2, email);
    			 prep.setString(3, password);
    			 prep.setString(4, dob);
    			 
    			 prep.setString(5, userId);
    			 int rowsAffected = prep.executeUpdate();
    			 response.sendRedirect("test.jsp");
       		 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
