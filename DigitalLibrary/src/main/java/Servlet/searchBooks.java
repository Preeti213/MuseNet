package Servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseAccessObject.booksDAO;
import Library.Book;

/**
 * Servlet implementation class searchBooks
 */
public class searchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchText = request.getParameter("searchText");
        
        List<Book> filteredbookList;
        HttpSession session =request.getSession();
        	try {
        		filteredbookList = booksDAO.searchBooks(searchText);
				  
			        session.setAttribute("filteredbookList", filteredbookList);
			        if(filteredbookList.size()>0)
			        {
			        	request.setAttribute("searchMessage", "Discovering books containing " +searchText);
				        request.getRequestDispatcher("filteredBooks.jsp").forward(request, response);
			        }
			        else
			        {
			        	response.setHeader("Content-Disposition", null);
			     		session.setAttribute("searchText", searchText);
			     		response.sendRedirect("searchGoogle.jsp");
			        	 
			        }
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
        	
	}

	
}
