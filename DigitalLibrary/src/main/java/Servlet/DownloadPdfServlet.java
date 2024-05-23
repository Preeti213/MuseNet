package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseAccessObject.getConnection;

/**
 * Servlet implementation class DownloadPdfServlet
 */
public class DownloadPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String bookId = request.getParameter("bookId");

	        // Assuming you have a BookDAO to fetch Book details by bookId
		Connection con;
		try {
			con = getConnection.getCon();
			 PreparedStatement prep = null;
			 ResultSet rs = null;
			 prep = con.prepareStatement("SELECT * FROM books WHERE id = ?");
	         prep.setString(1, bookId); 
	         rs = prep.executeQuery();
	         if (rs.next()) {
	             
	             InputStream inputStream = rs.getBinaryStream("pdf");
	             File tempFile = File.createTempFile("temp", ".pdf");
	             FileOutputStream outputStream = new FileOutputStream(tempFile);
	             // Set response content type
	             response.setContentType("application/pdf");
	             // Set response header to display PDF in browser
	             response.setHeader("Content-Disposition", "inline; filename=\"" + rs.getString("title") + ".pdf\"");

	             byte[] buffer = new byte[1024];
	             int bytesRead;
	             while ((bytesRead = inputStream.read(buffer)) != -1) {
	            	 response.getOutputStream().write(buffer, 0, bytesRead);
	             }
	             outputStream.close();
	             inputStream.close();
//	             Desktop.getDesktop().open(tempFile);
	         } else {
	             System.out.println("No PDF file found for the specified book title.");
	         }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
          
	        
	}



}
