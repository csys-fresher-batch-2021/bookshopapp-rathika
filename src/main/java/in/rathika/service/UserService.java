package in.rathika.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import in.rathika.dao.UserDao;
import in.rathika.exception.CannotGetDetailsException;
import in.rathika.exception.DBException;
import in.rathika.model.User;
import in.rathika.validator.UserValidator;

public class UserService {

	public UserService() {

	}

	/**
	 * Object created for DAO and Validator class.
	 */
	

	private UserValidator validatorObj = new UserValidator();

	/**
	 * Add User details into list.
	 * 
	 * @param name
	 * @param email
	 * @param mobileNum
	 * @param address
	 * @param age
	 * @param password
	 * @param confrimPassword
	 * @return
	 * @throws DBException 
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean addDetails(String name, String email, Long mobileNum, String address, int age, String password,
			String confrimPassword) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		boolean registerd = false;
		User regObj = new User(name, email, mobileNum, address, age, password);
		boolean nameValid = validatorObj.isNameValid(name);
		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
		boolean emailValid = validatorObj.isEmailValid(email);
		boolean addressValid = validatorObj.isAddressValid(address);
		boolean ageValid = validatorObj.isAgeValid(age);
		boolean passwordValid = validatorObj.isPasswordValid(password);
		
		if (nameValid && mobileValid && emailValid && addressValid && ageValid && passwordValid
				&& password.equals(confrimPassword)) {
            	UserDao.save(regObj);
    			registerd = true;
         }

		return registerd;
	}

    /**
     * Find whether the user is valid.
     * @param uemail
     * @param userPassCode
     * @return
     * @throws DBException 
     * @throws Exception
     */
	public static boolean isValidUser(String uemail, String userPassCode) throws CannotGetDetailsException, ClassNotFoundException, DBException {
        boolean valid = false;	
		   List<User> loginDetails = UserDao.checkUser();
		   for (User user : loginDetails) {
			   if (user.getEmail().equals(uemail) && user.getPassword().equals(userPassCode) ) {
				
				   
					   valid = true;
					   break;
				   
				   
			   }
			   
		}
		   return valid;
	}
	/**
	 * Check Whether the admin is valid.
	 * @param name
	 * @param password
	 * @return
	 * @throws DBException 
	 * @throws Exception
	 */
    public static boolean isValidAdmin(String name,String password) throws CannotGetDetailsException, ClassNotFoundException, DBException{
		boolean valid = false;
		Map<String,String> adminLoginDetails = UserDao.checkAdmin();
		for (String name1 : adminLoginDetails.keySet()) {
			String password1 = adminLoginDetails.get(name1);
			if(password1.equals(password) && name1.equals(name)) {
				valid = true;
				break;
			}
			   

		}
    	return valid;
    	
    }
    
    
	
}