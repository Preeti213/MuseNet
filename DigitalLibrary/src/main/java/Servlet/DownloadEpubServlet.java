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
 * Servlet implementation class DownloadEpubServlet
 */
public class DownloadEpubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;

		try {
		    con = getConnection.getCon();
		    prep = con.prepareStatement("SELECT * FROM books WHERE id = ?");
		    prep.setString(1, bookId);
		    rs = prep.executeQuery();
		    
		    if (rs.next()) {
		        InputStream inputStream = rs.getBinaryStream("epub");
		        response.setContentType("application/epub+zip");
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + rs.getString("title") + ".epub\"");
		        
		        byte[] buffer = new byte[1024];
		        int bytesRead;
		        while ((bytesRead = inputStream.read(buffer)) != -1) {
		            response.getOutputStream().write(buffer, 0, bytesRead);
		        }
		    } else {
		        System.out.println("No EPUB file found for the specified book ID.");
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         
	        
	}
}
