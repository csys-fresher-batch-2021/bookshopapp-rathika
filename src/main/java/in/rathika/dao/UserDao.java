package in.rathika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import in.rathika.model.User;
import in.rathika.util.ConnectionUtil;

public class UserDao {
	
	
	private UserDao() {
		
	}
	/**
	 * Add User Details into database.
	 * 
	 * @param user
	 * @throws Exception
	 * @throws SQLException
	 */
	public static void save(User user) throws Exception {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into userList(username,email,mobileNumber,address,age,password) values ( ?,?,?,?,?,? )";
			pst = con.prepareStatement(sql);

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getAddress());
			pst.setInt(5, user.getAge());
			pst.setString(6, user.getPassword());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	public static void save(List<User> users) throws Exception {
		for (User user : users) {
			save(user);
		}
	}

	/**
	 * Check Whether the user already registerd or not.
	 * 
	 * @param userEmail
	 * @param userPassCode
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static boolean checkUser(String userEmail, String userPassCode) throws Exception {
		// Step 1: Get connection
		boolean isValid = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String url = "select email,password from userList";
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) {
				String uemail = rs.getString("email");
				String pass = rs.getString("password");
				if (uemail.equals(userEmail) && pass.equals(userPassCode)) {
					isValid = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid User");
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return isValid;
	}

	/**
	 * Get user name using emailId
	 * 
	 * @param emailId
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static String getValidUser(String emailId) throws Exception {
		// Step 1: Get connection
		String name = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String url = "select username, email from userList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) {
				String uname = rs.getString("username");
				String email = rs.getString("email");
				if (email.equals(emailId)) {
					name = uname;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return name;
	}
}
