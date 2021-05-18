package in.rathika.DAO;
import java.util.ArrayList;
import java.util.List;

import in.rathika.model.*;

public class UserDao {
	private final List<User> userReg = new ArrayList<User>();
	
	public void addUser(User regObj) {
		
		userReg.add(regObj);
		System.out.println("I am here");
		
	}

}
