package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.wishlistDAO;

/**
 * Servlet implementation class removeBookFromWishlist
 */
public class removeBookFromWishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		String userId = request.getParameter("userId");
		try {
					
					Boolean delete = wishlistDAO.removeBook(bookId, userId);
					System.out.println("bookDeleted :" + delete);
					response.sendRedirect(request.getContextPath() + "/getWishlistBooks");
				
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
			
	}

}
