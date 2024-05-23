package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Library.Book;

public class wishlistDAO {
	static Connection con;
	static PreparedStatement prep;
	static ResultSet res;
	
	public static void addBook(String bookId, String userId) throws SQLException, ClassNotFoundException {
		con = getConnection.getCon();
		prep = con.prepareStatement("SELECT COUNT(*) FROM wishlist WHERE bookId = ? AND studentId = ?");
				
		prep.setString(1, bookId);
	    prep.setString(2, userId);
	    
	    
	     res = prep.executeQuery();
	     res.next();
	     int count = res.getInt(1); 
	     
	    if (count == 0) {
	    	prep = con.prepareStatement("INSERT INTO wishlist (bookId, studentId) VALUES (?, ?)");
	    	prep.setString(1, bookId);
		    prep.setString(2, userId);
		    prep.executeUpdate();
	    }
	}
	public static boolean removeBook(String bookId, String userId) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		prep = con.prepareStatement("DELETE FROM wishlist WHERE bookId = ? AND studentId = ?");
				
		prep.setString(1, bookId);
	    prep.setString(2, userId);
	    int rowsAffected = prep.executeUpdate();
     return rowsAffected > 0;
	    
	    
		
	}

	public static List<Book> getBooks(String userId) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		List<Book> ls = new ArrayList<>();
		
		prep = con.prepareStatement("select bookId from wishlist where studentId = ?");
		prep.setString(1, userId );
		res = prep.executeQuery();
		while(res.next())
		{
			
			ls.add(booksDAO.getBookById(res.getString("bookId")));
		}
		
		return ls;
		
	}
	public static Set<String> getBooksIDs(String userId) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		Set<String> ls = new HashSet<>();
		//get book id- get bookDetails
		prep = con.prepareStatement("select bookId from wishlist where studentId = ?");
		prep.setString(1, userId );
		res = prep.executeQuery();
		while(res.next())
		{
			ls.add(res.getString("bookId"));
		}
		
		
		
		return ls;
		
	}

	
}
