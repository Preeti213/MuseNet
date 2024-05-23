package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class authorDAO {
		
	static Connection con;
	static ResultSet res;
	static PreparedStatement prep;
	static List<String> authorList;
	public static List<String> getAuthor() throws ClassNotFoundException, SQLException 
	{
		
		con = getConnection.getCon();
		
		authorList = new ArrayList();
		prep = con.prepareStatement("SELECT DISTINCT author FROM books");
		res = prep.executeQuery();
		while (res.next()) {
		authorList.add(res.getString("author"));
		}
		return authorList;
		
	}
	
//	public static String addAuthor(String authorName) 
//	{
//		
//		col = Connection.createConnection("author");
//		    
//	    Document doc = new Document("author", authorName);
//	    col.insertOne(doc);
//	    
//	    // Return the ID of the inserted author
//	    return doc.getObjectId("_id").toString();
//	}
//	public static String findAuthorID(String author) {
//		
//		 col = Connection.createConnection("author");
//		    
//	    Document query = new Document("author", author);
//	    FindIterable<Document> result = col.find(query);
//
//	    // Retrieve the first document if available
//	    Document firstDocument = result.first();
//
//	    if (firstDocument != null)
//	        return firstDocument.getObjectId("_id").toString(); 
//	    else
//	        return addAuthor(author);
//	    
//	}
//	public static String findAuthorName(String authorID) 
//	{
//	    col = Connection.createConnection("author");
//	    
//	    Document query = new Document("_id", new ObjectId(authorID));
//	    FindIterable<Document> result = col.find(query);
//
//	    // Retrieve the first document if available
//	    Document firstDocument = result.first();
//
//	    if (firstDocument != null)
//	        return firstDocument.getString("author");
//	    else
//	        return "Author not found";
//	 
//	}
//
//	public static long getCount(Author author) {
//		
//		col = Connection.createConnection("author");
//	    
//		 Document query = new Document("author", author.getName());
//         // Count the documents that match the query
//         long count = col.countDocuments(query);
//         return count;
//         
//	}
//
//	public static boolean deleteAuthor(String id) {
//
//		ObjectId objectId = new ObjectId(id);
//        Document query = new Document("_id", objectId);
//        DeleteResult result = col.deleteOne(query);
//
//        // Check if a document was deleted (i.e., affected count is greater than 0)
//        return result.getDeletedCount() > 0;
//	}


}

