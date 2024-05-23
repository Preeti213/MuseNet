package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getConnection {
	static Connection con;
	public static Connection getCon() throws SQLException, ClassNotFoundException
	{
		Class.forName(DBIntializer.DRIVER);
		con=DriverManager.getConnection(DBIntializer.CON_STRING,DBIntializer.USERNAME,DBIntializer.PASSWORD);
		
		return con;	
	}

}
