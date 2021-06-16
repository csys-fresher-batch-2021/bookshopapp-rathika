package in.rathika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.rathika.exception.DBException;
public class ConnectionUtil {
	private ConnectionUtil() {
		//Default constructor
	}
	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");
	/**
	 * This method creates a database connection.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		return DriverManager.getConnection(url, username, password);
	
	}
	/**
	 * This method is used to close the connection of Resultset connection and prepared statement
	 * Method overloading
	 * @param con
	 * @throws DBException 
	 */
	public static void close( ResultSet rs, Statement statement, Connection con) throws DBException {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(statement!= null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new DBException("unable to connect");
		}
	}
	/**
	 * This method closes the connections for statement and connection.
	 * @param statement
	 * @param con
	 * @throws DBException 
	 */
	public static void close(Statement statement, Connection con) throws DBException {
		try {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new DBException("unable to close connection");
		}
	}
}