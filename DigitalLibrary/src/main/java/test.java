import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseAccessObject.getConnection;
import Library.User;

public class test {
	public static void main(String [] args) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection.getCon();
		 PreparedStatement prep = con.prepareStatement("SELECT * FROM user  WHERE  id=3");
		 ResultSet res = prep.executeQuery();
		 if(res.next())
		 {
			 User u1 = new User(res.getString("id"),res.getString("name"),res.getBinaryStream("profile"),res.getString("email"), 
						res.getString("password"), res.getString("dob"));
			
		 }
		 
	}
}
