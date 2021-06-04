package in.rathika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

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
			System.out.print(DB_URL);
		} catch (ClassNotFoundException | SQLException e) {
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

	public static JdbcTemplate getJdbcTemplate() {
		DataSource dataSource = getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	private static DataSource getDataSource() {
		// DataSource
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER_CLASS_NAME);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USERNAME);
		ds.setPassword(DB_PASSWORD);
		return ds;
	}

}