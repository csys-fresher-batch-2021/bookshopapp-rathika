package in.rathika.service;

import java.sql.SQLException;

import in.rathika.dao.UserDao;
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
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean addDetails(String name, String email, Long mobileNum, String address, int age, String password,
			String confrimPassword) throws Exception {
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

	
	
	
	
}
