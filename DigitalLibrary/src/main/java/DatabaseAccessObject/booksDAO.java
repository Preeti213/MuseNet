package DatabaseAccessObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import Library.Book;

public class booksDAO {

	static Connection con;
	static ResultSet res;
	static PreparedStatement prep;
	static List<Book> booksList;
	
//	public static List<Book> getBooks() throws SQLException, ClassNotFoundException
//	{
//		 
//		con = getConnection.getCon();
//		booksList = new ArrayList();
//		
//		prep = con.prepareStatement("select * from books");
//		res = prep.executeQuery();
//		
//		while (res.next()) {
//
//			
//			Book b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
//					res.getString("genre"), res.getString("description"),
//					res.getBinaryStream("cover"));
//			booksList.add(b);
//		}
//		return booksList;
//	}

	public static List<Book> getBooks(Set<String> wishlistedBooksId) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		booksList = new ArrayList();
		
		prep = con.prepareStatement("select * from books");
		res = prep.executeQuery();
		
		while (res.next()) {
			//user id pta tha book id
			//if book id present h user ke sath then add wishlisted else add to wishlist
			Book b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
					res.getString("genre"), res.getString("description"),
					res.getBinaryStream("cover"), res.getBinaryStream("pdf"), wishlistedBooksId.contains(res.getString("id")));
			
			booksList.add(b);
		}
		return booksList;
	}
	
	public static void addBooks(String title, String author, String genre,String description, InputStream img, InputStream pdf, InputStream epub)
			throws SQLException, ClassNotFoundException {
		//ADD DESCRIPTION
		con = getConnection.getCon();
		 prep = con.prepareStatement("INSERT INTO books (title, author, genre, description, cover, pdf,epub) " +
                 "SELECT ?, ?, ?, ?, ?, ? ,?" +
                 "FROM DUAL " +
                 "WHERE NOT EXISTS (SELECT * FROM books WHERE title = ?)");
         prep.setString(1, title);
         prep.setString(2, author);
         prep.setString(3, genre);
         prep.setString(4, description);
         prep.setBinaryStream(5, img);
         prep.setBinaryStream(6, pdf);
         prep.setBinaryStream(7, epub);
         prep.setString(8, title);
         prep.executeUpdate();
 
		
	}

	public static Book getBookById(String bookId) throws ClassNotFoundException, SQLException {

		con = getConnection.getCon();
		Book b = new Book();
		
		prep = con.prepareStatement("SELECT * FROM books WHERE id = ?");
		prep.setString(1, bookId);
		res = prep.executeQuery();
		while (res.next()) {
	
			 b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
					res.getString("genre"), res.getString("description"),
					res.getBinaryStream("cover"));
			
		}
		return b;
	}
	public static Book getDetails(String title) throws SQLException, ClassNotFoundException {

		con = getConnection.getCon();
		Book b = new Book();
		prep = con.prepareStatement("SELECT * FROM books WHERE title = ?");
		prep.setString(1, title);
		res = prep.executeQuery();
		while (res.next()) {

			b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
					res.getString("genre"), res.getString("description"),
					res.getBinaryStream("cover"), res.getBinaryStream("pdf"), res.getBinaryStream("epub"));
			
		}
		return b;
	
}

	public static List<Book> filterBooks(String filterType, String filterName, Set<String> wishlistedBooksId) throws ClassNotFoundException, SQLException {

		con = getConnection.getCon();
		booksList = new ArrayList();
		
		prep = con.prepareStatement("select * from books  WHERE " + filterType + " like ?");
		prep.setString(1, "%" + filterName + "%");
		res = prep.executeQuery();
		
		while (res.next()) {
	
			Book b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
					res.getString("genre"), res.getString("description"),
					res.getBinaryStream("cover"),wishlistedBooksId.contains(res.getString("id")));
			booksList.add(b);
		}
		return booksList;
		
	}

	public static List<Book> searchBooks(String searchText) throws SQLException, ClassNotFoundException {
		con = getConnection.getCon();
		booksList = new ArrayList();
		
		String sql = "SELECT DISTINCT  * FROM books WHERE author LIKE ? OR genre LIKE ? OR title LIKE ?";
		 prep = con.prepareStatement(sql);
		prep.setString(1, "%" + searchText + "%"); // Add wildcard '%' before and after filter text
		prep.setString(2, "%" + searchText + "%");
		prep.setString(3, "%" + searchText + "%");
		res = prep.executeQuery();
		
		while (res.next()) {
	
			Book b = new Book(res.getString("id"),res.getString("title"),res.getString("author"),
					res.getString("genre"), res.getString("description"),
					res.getBinaryStream("cover"), res.getBinaryStream("pdf"));
			booksList.add(b);
		}
		return booksList;
		
	}


//	public static List<Book> getBooks(String filterType, String filterName) throws SQLException, ClassNotFoundException {
//		
//		con = getConnection.getCon();
//		
//		booksList = new ArrayList();
//		prep = con.prepareStatement("SELECT * FROM books WHERE " + filterType + " = ?");
//		prep.setString(1, filterName);
//		res= prep.executeQuery();
//
//		while (res.next()) {
//			Book b = new Book(res.getString("title"),res.getString("author"),
//					res.getString("genre"),res.getString("id"));
//			booksList.add(b);
//		}
//		
////		FindIterable<Document> result = col.find(Filters.eq(filterType, filterName));
////		
////		for (Document bookData : result) {
////		    booksList.add(Book.toBook(bookData));
////		}
//		
//		return booksList;
//	}
//	public static List<Book> searchBooks(String filterName) throws SQLException, ClassNotFoundException 
//	{
//	
//		con = getConnection.getCon();
//		
//		booksList = new ArrayList();
//		prep = con.prepareStatement("SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR genre LIKE ?");
//		prep.setString(1, "%" + filterName + "%");
//		prep.setString(2, "%" + filterName + "%");
//		prep.setString(3, "%" + filterName + "%");
//		res= prep.executeQuery();
//
//		while (res.next()) {
//			Book b = new Book(res.getString("title"),res.getString("author"),
//					res.getString("genre"),res.getString("id"));
//			booksList.add(b);
//		}
//		
//		
//		return booksList;
//	}
////
////	
////
//	public static boolean deleteBook(String bookId) throws SQLException, ClassNotFoundException {
//		con = getConnection.getCon();
//		
//		prep = con.prepareStatement("DELETE FROM books WHERE id = ?");
//	    prep.setString(1, bookId);
//
//	    int rowsAffected = prep.executeUpdate();
//        return rowsAffected > 0;
//	
//	}
////	public static Book getBookByID(String id) {
////	    
////	try {
////	        ObjectId objectId = new ObjectId(id); 
////
////	        Document query = new Document("_id", objectId);
////	        FindIterable<Document> result = col.find(query);
////
////	        Document firstDocument = result.first();
////	        if (firstDocument != null)
////	        {
////	        	 return Book.toBook(firstDocument);
////	        }
////
////	    } catch (IllegalArgumentException e) {
////	        System.out.println("error in bookDAO getBookById");
////	    }
////
////	    return null;
////	}
////
////	public static long getCount(String type, String name) {
////		
////		col = Connection.createConnection("books");
////	    
////		 Document query = new Document(type, name);
////        
////        long count = col.countDocuments(query);
////        return count;
////	}
////
//	public static boolean updateBook(String bookId, String title, String author, String genre) throws SQLException, ClassNotFoundException {
//		con = getConnection.getCon();
//		
//		prep = con.prepareStatement("UPDATE books SET title = ?, author = ?, genre = ? WHERE id = ?");
//	    prep.setString(1, title);
//	    prep.setString(2, author);
//	    prep.setString(3, genre);
//	    prep.setString(4, bookId);
//
//	    int rowsAffected = prep.executeUpdate();
//	    return rowsAffected>0;
//	}
//
//
}
