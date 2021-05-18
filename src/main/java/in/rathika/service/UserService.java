package in.rathika.service;

import in.rathika.DAO.UserDao;
import in.rathika.model.User;
import in.rathika.validator.UserValidator;

public class UserService {
     private UserDao userObj = new UserDao();
     
     private UserValidator validatorObj = new UserValidator();
     
  
    //String userName = registrationObj.getName();
     
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
 			else {
 				System.out.println("Invalid confrim password");
 			}
 			
 		}
 		else {
 			System.out.println("Invalid details");
 			registerd = false;
 		}
 		return registerd;
 	}
     
}
