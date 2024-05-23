package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.wishlistDAO;

/**
 * Servlet implementation class addBookToWishlist
 */
public class addBookToWishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookId = request.getParameter("bookId");
		String userId = request.getParameter("userId");
		try {
			if (userId != null) {

				wishlistDAO.addBook(bookId, userId);
				response.sendRedirect("bookDirectoryMain");
				//redierct main page 
//				response.sendRedirect(request.getContextPath() + "/getWishlistBooks");
			}

			else {

				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);

			}
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
}
