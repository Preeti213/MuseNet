package DatabaseAccessObject;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import Library.User;

public class userDAO {

	static Connection con;
	static PreparedStatement prep;
	static ResultSet res;
	public static User checkCredentials(String email, String password) throws ClassNotFoundException, SQLException {
		 
        con = getConnection.getCon();
        prep = con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
        prep.setString(1, email);
        prep.setString(2, password);

        res = prep.executeQuery();
        if (res.next()) {
            
            User u1 = new User(res.getString("id"), res.getString("name"), res.getBinaryStream("profile"),
                               res.getString("email"), res.getString("password"), res.getString("dob"));
            return u1;
        }
        System.out.println("User credentials not found.");
        return null;
		     
		
		
	}
	public static User addUser(String email, String name , String password, String dob, InputStream img) throws ClassNotFoundException, SQLException
	{
		
		  con = getConnection.getCon();
	       
		  prep = con.prepareStatement("INSERT INTO user (email, name, password, dob, profile) " +
                  "SELECT ?, ?, ?, ?, ? " + 
                  "FROM DUAL " +
                  "WHERE NOT EXISTS (SELECT * FROM user WHERE email = ?)");


	        prep.setString(1, email);
	        prep.setString(2, name);
	        prep.setString(3, password);
	        prep.setString(4, dob);
	        prep.setBinaryStream(5, img);
	        prep.setString(6, email);
	       
	        int rowsAffected = prep.executeUpdate();
	        if (rowsAffected > 0) {
	            // Insertion successful
	            System.out.println("Data inserted successfully!");
	        } else {
	            // Email already exists
	            System.out.println("Email already exists in the database.");
	        }
	        return checkCredentials(email, password);
	}
	public static boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		prep = con.prepareStatement("SELECT COUNT(*) FROM user WHERE email = ?");
		prep.setString(1, email);

        // Execute query
        res = prep.executeQuery();
        res.next();
        int count = res.getInt(1);

        // Send response based on email availability
        return (count > 0); 
           
		
	}
	
	
	

}
