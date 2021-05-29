package in.rathika.service;

import java.util.List;

import in.rathika.dao.UserDao;
import in.rathika.model.User;
import in.rathika.validator.UserValidator;

public class UserService {
	/**
	 * Object created for DAO and Validator class.
	 */
     private UserDao userObj = new UserDao();
     
     private UserValidator validatorObj = new UserValidator();
     
     /**
      * Add User details into list.
      * @param name
      * @param email
      * @param mobileNum
      * @param address
      * @param age
      * @param password
      * @param confrimPassword
      * @return
      */
     public boolean addDetails(String name,String email,Long mobileNum,String address,int age,String password,String confrimPassword) {
 		boolean registerd = false;
    	 User regObj = new User(name, email, mobileNum, address, age, password, password);
 		boolean nameValid = validatorObj.isNameValid(name);
 		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
 		boolean emailValid  = validatorObj.isEmailValid(email);
 		boolean addressValid = validatorObj.isAddressValid(address);
 		boolean ageValid = validatorObj.isAgeValid(age);
 		boolean passwordValid =validatorObj.isPasswordValid(password);
 		if(nameValid && mobileValid && emailValid && addressValid && ageValid && passwordValid && password.equals(confrimPassword)) {
 			
 				userObj.addUser(regObj);
 	 			registerd = true;
 		}
 		
 		return registerd;
 	}
     /**
      * Check whether the user is valid.
      * @param userName
      * @param userPassCode
      * @return
      */
     public boolean checkUser(String userName, String userPassCode) {
 		boolean isValidUser = false;
    	 List<User> users = UserDao.getUser();
 		for (User userDetails : users) {
 			if(userDetails.getName().equals(userName) && userDetails.getPassword().equals(userPassCode)) {
 				isValidUser = true;
 			}
 			
 		}
    	 return isValidUser;
 	}
 }
     

