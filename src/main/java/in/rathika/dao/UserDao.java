package in.rathika.dao;
import java.util.ArrayList;
import java.util.List;

import in.rathika.model.User;

public class UserDao {
	private final List<User> userReg = new ArrayList<>();
	
	public void addUser(User regObj) {
		
		userReg.add(regObj);
		
		
	}

}
