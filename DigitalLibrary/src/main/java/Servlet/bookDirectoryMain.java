package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseAccessObject.authorDAO;
import DatabaseAccessObject.booksDAO;
import DatabaseAccessObject.genreDAO;
import DatabaseAccessObject.wishlistDAO;
import Library.Book;
import Library.User;

/**
 * Servlet implementation class bookDirectoryMain
 */
public class bookDirectoryMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 User user = (User)session.getAttribute("userDetails");
		 
		try {
			
			 List<String> authors = authorDAO.getAuthor();
			 List<String> genres = genreDAO.getGenre();
			 List<Book> userWishlist = wishlistDAO.getBooks(user.getId());
			 
			 Set<String> wishlistedBooksId = wishlistDAO.getBooksIDs(user.getId());
			 List<Book> booksList = booksDAO.getBooks(wishlistedBooksId);
			 
			session.setAttribute("booksList", booksList);
			session.setAttribute("authors", authors);
			 session.setAttribute("genres", genres);
			 session.setAttribute("userWishlist", userWishlist);
			 session.setAttribute("wishlistedBooksId", wishlistedBooksId);
			request.getRequestDispatcher("books.jsp").forward(request, response);
	        
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
