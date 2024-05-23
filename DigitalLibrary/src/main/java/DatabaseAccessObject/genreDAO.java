package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class genreDAO {
	static Connection con;
	static ResultSet res;
	static PreparedStatement prep;
	static List<String> genreList;
	public static List<String> getGenre() throws ClassNotFoundException, SQLException 
	{
		con = getConnection.getCon();
		
		genreList = new ArrayList();
		HashSet<String> hs = new HashSet<>();
		
		prep = con.prepareStatement("SELECT DISTINCT genre FROM books");
		res = prep.executeQuery();
		while (res.next()) {
			hs.addAll(Arrays.asList(res.getString("genre").split(",")));
		}
//		FindIterable<Document> cursor = col.find();
//		for (Document genreData : cursor) {
//			genreList.add(Genre.toGenre(genreData));
//		}
		return new ArrayList<>(hs);
	}
//	public static String findGenreID(String genre) 
//	{
//		
//		col = Connection.createConnection("genre");
//		
//		Document query = new Document("genre", genre);
//        Object result = col.find(query).first();
//
//        if (result != null)
//            return ((Document) result).getObjectId("_id").toString();
//        else
//            return addGenre(genre);
//       
//	}
//	
//	private static String addGenre(String genreName) 
//	{
//		
//		col = Connection.createConnection("genre");
//	
//		Document doc = new Document("genre" , genreName);
//		col.insertOne(doc);
//		
//		return findGenreID(genreName);
//	}
//	
//	public static String findGenreName(String genreID) 
//	{
//	    col = Connection.createConnection("genre");
//
//	    Document query = new Document("_id", new ObjectId(genreID));
//	    FindIterable<Document> result = col.find(query);
//
//	    Document firstDocument = result.first();
//
//	    if (firstDocument != null)
//	        return firstDocument.getString("genre");
//	    else
//	        return "genre not found";
//	   
//	}
//	public static long getCount(Genre genre) {
//		col = Connection.createConnection("genre");
//	    
//		 Document query = new Document("genre", genre.getName());
//        // Count the documents that match the query
//        long count = col.countDocuments(query);
//        return count;
//	}
//	public static boolean deleteGenre(String id) {
//
//		ObjectId objectId = new ObjectId(id);
//        Document query = new Document("_id", objectId);
//        DeleteResult result = col.deleteOne(query);
//
//        // Check if a document was deleted (i.e., affected count is greater than 0)
//        return result.getDeletedCount() > 0;
//		
//	}
//
}
