package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.adminDAO;

/**
 * Servlet implementation class loginAdmin
 */
public class loginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_login");
		String password = request.getParameter("user_pass");
		//check database
		try {
			
			if(adminDAO.checkCredentials(userName, password))
			{
				 response.sendRedirect(request.getContextPath() + "/bookDirectoryMain");
			}
			else
			{
				request.getRequestDispatcher("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
