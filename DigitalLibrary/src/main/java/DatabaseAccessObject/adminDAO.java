package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDAO {
	static Connection con;
	static PreparedStatement prep;
	static ResultSet res;
	public static boolean checkCredentials(String userName, String password) throws ClassNotFoundException, SQLException {
		con = getConnection.getCon();
		prep =con.prepareStatement("SELECT * FROM librarian  WHERE  name = ? AND password = ?");
		
		
		prep.setString(1, userName);
		prep.setString(2, password);
		
		res = prep.executeQuery();
		if(res.next())
			return true;
		
		return false;
		
		
	}

}
