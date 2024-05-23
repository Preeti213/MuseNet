package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DatabaseAccessObject.booksDAO;

@MultipartConfig
public class addNewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String genre = request.getParameter("genre");
			String description = request.getParameter("description");
			System.out.println(description);
			Part pdf = request.getPart("pdf");
	        InputStream pdfInput = pdf.getInputStream();
	        
	        Part epub = request.getPart("epub");
	        InputStream epubInput = pdf.getInputStream();
	        
	        Part img = request.getPart("image");
	        InputStream imgInput = img.getInputStream();
	        
			booksDAO.addBooks(title, author, genre, description, imgInput, pdfInput, epubInput);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
