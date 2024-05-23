package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseAccessObject.userDAO;
import Library.User;

/**
 * Servlet implementation class loginUser
 */
public class loginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			User u1= userDAO.checkCredentials(email, password);
			if(u1!=null)
			{
//				request.getRequestDispatcher("login.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("userDetails",u1 );
				
				 response.sendRedirect(request.getContextPath() + "/bookDirectoryMain");
				
			}
			else
			{
				String errorMessage = "Error occurred while logging in!";
	            String script = "<script type='text/javascript'>alert('" + errorMessage + "');</script>";
	           
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
