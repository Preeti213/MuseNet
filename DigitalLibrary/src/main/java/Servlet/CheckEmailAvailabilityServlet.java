package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.userDAO;

/**
 * Servlet implementation class CheckEmailAvailabilityServlet
 */
public class CheckEmailAvailabilityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		try {
			if (!userDAO.checkEmail(email)) {
				System.out.println("email not available");
				response.getWriter().write("not available");
			} else {
				System.out.println("email available");
				response.getWriter().write("available");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
