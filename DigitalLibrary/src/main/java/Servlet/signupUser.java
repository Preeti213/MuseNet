package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DatabaseAccessObject.userDAO;
import Library.User;

/**
 * Servlet implementation class signupUser
 */
@MultipartConfig
public class signupUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String email = request.getParameter("email");
	        String name = request.getParameter("username");
	        String password = request.getParameter("password");
	        String dob = request.getParameter("dob");
	        // Get the image part
	        Part imagePart = request.getPart("image");
	        InputStream imageStream = null;
	        if (imagePart != null && imagePart.getSize() > 0) {
	            imageStream = imagePart.getInputStream();
	        } else {
	          
	            String defaultImagePath = getServletContext().getRealPath("/assets/avatar.png");
	            imageStream = getServletContext().getResourceAsStream("/assets/avatar.png");
	        }
	        try {
	           
	          
	            ;
	            User user =userDAO.addUser(email, name, password,dob, imageStream);
				if(user.getId()!=null)
				{
//					request.getRequestDispatcher("login.jsp");
					HttpSession session = request.getSession();
					session.setAttribute("userDetails",user );
					 response.sendRedirect(request.getContextPath() + "/bookDirectoryMain");
				}
				else
				{
					request.getRequestDispatcher("login.jsp");
				}
				
				
	        } catch (SQLException | ClassNotFoundException e) {
	            // Handle exceptions
	            e.printStackTrace();
	            response.sendRedirect("login.jsp");
	        } finally {
	            // Close input stream if it's not null
	            if (imageStream != null) {
	                imageStream.close();
	            }
	        }
	    }
}