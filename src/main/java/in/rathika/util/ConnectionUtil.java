package in.rathika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ConnectionUtil {
	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DATABASE_NAME = "bookshopping_db";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME; 

	
public static Connection getConnection() {
	
	Connection connection = null;
	try {
		
		Class.forName(DRIVER_CLASS_NAME);
		
		connection = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		System.out.println(connection);
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Unable to get the database connection");
	}
	return connection;
}
public static void close(PreparedStatement pst, Connection con) throws Exception {
	
	if (pst != null) {
		pst.close();
	}
	if (con != null) {
		con.close();	
		}
}
}
