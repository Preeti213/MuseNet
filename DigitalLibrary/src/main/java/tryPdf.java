import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DatabaseAccessObject.getConnection;

@WebServlet("/tryPdf")
public class tryPdf {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		 {
		String title = request.getParameter("title");
		Part pdf = request.getPart("epub");
        InputStream pdfInput = pdf.getInputStream();
	}
	
	}	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
//	{
//		Connection con = getConnection.getCon();
//		//adding book to database
////		 PreparedStatement stat = null;
////		 FileInputStream input = null;
////		 
////		 stat = con.prepareStatement("update bookPdf set bookPdf = ? where bookTitle = 'test'");
////		 File file = new File("C:\\Users\\admin\\Downloads\\2002873_MidTermReport_PreetiYadav.pdf");
////		 input = new FileInputStream(file);
////		 stat.setBinaryStream(1, input);
////		 System.out.println("Reading input file :: "+file.getAbsolutePath());
////		 
////		 //execute statement
////		 System.out.println("\nStoring resume in Database :: "+file);
////		 System.out.println();
////		 stat.executeUpdate();
////		 System.out.println("\nCompleted");
//		 
//		//showing book
//		 PreparedStatement prep = null;
//		 ResultSet rs = null;
//		 prep = con.prepareStatement("SELECT pdf FROM books WHERE title = ?");
//         prep.setString(1, "rep"); // Assuming the book title is 'test'
//         rs = prep.executeQuery();
//         
//         if (rs.next()) {
//             // Write the binary stream to a temporary file
//             InputStream inputStream = rs.getBinaryStream("pdf");
//             File tempFile = File.createTempFile("temp", ".pdf");
//             FileOutputStream outputStream = new FileOutputStream(tempFile);
//             
//             byte[] buffer = new byte[1024];
//             int bytesRead;
//             while ((bytesRead = inputStream.read(buffer)) != -1) {
//                 outputStream.write(buffer, 0, bytesRead);
//             }
//             outputStream.close();
//             inputStream.close();
//             
//             // Open the temporary file using the default PDF viewer
//             Desktop.getDesktop().open(tempFile);
//         } else {
//             System.out.println("No PDF file found for the specified book title.");
//         }
//         System.out.println("done");
//	}


