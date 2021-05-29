package in.rathika.dao;

import java.util.ArrayList;
import java.util.List;

import in.rathika.model.User;

public class UserDao {
	/**
	 * ArrayList to store User Details.
	 */
	private static final List<User> userReg = new ArrayList<>();

	/**
	 * Add user Details.
	 * 
	 * @param regObj
	 */
	public void addUser(User regObj) {

		userReg.add(regObj);

	}

	/**
	 * Get user details.
	 * 
	 * @return
	 */
	public static List<User> getUser() {
		return userReg;

	}
}
