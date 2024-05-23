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

import DatabaseAccessObject.booksDAO;
import Library.Book;

/**
 * Servlet implementation class filterBooks
 */
public class filterBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("filteredBooks.jsp").forward(request, response);
		doPost(request, response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String filterType = request.getParameter("value1");
     String filterName = request.getParameter("value2");
     HttpSession session = request.getSession();
     Set<String> wishlistedBooksId =(Set)session.getAttribute("wishlistedBooksId");
     
     	try {
     		 List<Book> filteredbookList = booksDAO.filterBooks(filterType , filterName, wishlistedBooksId);
				 
			        session.setAttribute("filteredbookList", filteredbookList);
			        request.setAttribute("searchMessage", "Discovering books under " +filterType +" : "+filterName);
			        response.sendRedirect("filteredBooks.jsp");
			        
			} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
			}
     	
		
	}
}
