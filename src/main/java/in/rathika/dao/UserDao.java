package in.rathika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.rathika.exception.CannotGetDetailsException;
import in.rathika.model.User;
import in.rathika.util.ConnectionUtil;

public class UserDao {

	/**
	 * List to store User details.
	 */
	private static List<User> userDetails = new ArrayList<>();
	/**
	 * HashMap to get email and password.
	 */
	private static List<User> loginMap = new ArrayList<>();
	private static Map<String, String> adminMap = new HashMap<>();
	

	/**
	 * private constructor.
	 */
	private UserDao() {

	}

	/**
	 * Add User Details into database.
	 * 
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 * @throws SQLException
	 */
	public static void save(User user) throws CannotGetDetailsException, ClassNotFoundException {
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
		    pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable to add user");
			
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * Add user details.
	 * 
	 * @param users
	 * @throws Exception
	 */
	public static void save(List<User> users) throws CannotGetDetailsException, ClassNotFoundException {
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
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 * @throws SQLException
	 */
	public static List<User> checkUser() throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "select email,password from userList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String uemail = rs.getString("email");
				String pass = rs.getString("password");
				User regObj = new User(uemail, pass);
				loginMap.add(regObj);

			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");
		
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return loginMap;
	}


	/**
	 * Get user name using emailId
	 * 
	 * @param emailId
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 * @throws SQLException
	 */
	public static String getValidUser(String emailId) throws CannotGetDetailsException, ClassNotFoundException {
		// Step 1: Get connection
		String name = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select username, email from userList";
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String uname = rs.getString("username");
				String email = rs.getString("email");
				if (email.equals(emailId)) {
					name = uname;
				}
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return name;
	}

	/**
	 * Get the user Details.
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public List<User> getUserDetails() throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from userList";
			con = ConnectionUtil.getConnection();

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String uname = rs.getString("username");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobileNumber");
				String userAddress = rs.getString("address ");
				int userAge = rs.getInt("age");
				String userPass = rs.getString("password");
				User regObj = new User(uname, email, mobile, userAddress, userAge, userPass);
				userDetails.add(regObj);

			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return userDetails;
	}

	/**
	 * Check Whether the admin is valid.
	 * 
	 * @param adminName
	 * @param adminPassCode
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static Map<String, String> checkAdmin() throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from adminLogin";
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String adminname = rs.getString("adminName");
				String pass = rs.getString("password");
				adminMap.put(adminname, pass);
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return adminMap;
	}

	/**
	 * Get user details from userList.
	 * 
	 * @param userName
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static List<User> getUserDetails(String userName) throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String sql = "select id,email,mobileNumber,address from userList where username='" + userName
					+ "' ORDER BY userName";
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
                int userId = rs.getInt("id");
				String emailId = rs.getString("email");

				long mobile = rs.getLong("mobileNumber");
				String address = rs.getString("address");

				userDetails.add(new User(userId,emailId, mobile, address));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return userDetails;
	}
	
	/**
	 * Get Id name of the user.
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static int getId(String userName) throws CannotGetDetailsException, ClassNotFoundException {
		int id = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select id,username from userList ";
			con = ConnectionUtil.getConnection();
			
            pst = con.prepareStatement(sql);
			
            rs = pst.executeQuery();

            while (rs.next()) {
				int userId = rs.getInt("id");
				String user = rs.getString("username");
				if (user.equals(userName)) {
					id = userId;
					break;
				}
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException("Invalid User");
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return id;
	}

}