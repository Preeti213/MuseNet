package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseAccessObject.wishlistDAO;
import Library.Book;
import Library.User;

/**
 * Servlet implementation class getWishlistBooks
 */
public class getWishlistBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			User u1 = (User)session.getAttribute("userDetails");
			List<Book> userWishlist = wishlistDAO.getBooks(u1.getId());
			session.setAttribute("userWishlist", userWishlist);
			response.sendRedirect("userWishlist.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
