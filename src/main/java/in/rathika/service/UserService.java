package in.rathika.service;

import in.rathika.dao.UserDao;
import in.rathika.model.User;
import in.rathika.validator.UserValidator;

public class UserService {
     private UserDao userObj = new UserDao();
     
     private UserValidator validatorObj = new UserValidator();
     
  
  
     
     public boolean addDetails(String name,String email,Long mobileNum,String address,int age,String password,String confrimPassword) {
 		boolean registerd = false;
    	 User regObj = new User(name, email, mobileNum, address, age, password, password);
 		boolean nameValid = validatorObj.isNameValid(name);
 		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
 		boolean emailValid  = validatorObj.isEmailValid(email);
 		boolean addressValid = validatorObj.isAddressValid(address);
 		boolean ageValid = validatorObj.isAgeValid(age);
 		boolean passwordValid =validatorObj.isPasswordValid(password);
 		if(nameValid && mobileValid && emailValid && addressValid && ageValid && passwordValid) {
 			if(password.equals(confrimPassword)) {
 				userObj.addUser(regObj);
 	 			registerd = true;
 			}
 		}
 		
 		return registerd;
 	}
     
}
