package in.rathika.validator;

import java.util.List;

import in.rathika.dao.BookDao;
import in.rathika.exception.CannotGetDetailsException;
import in.rathika.model.Book;

public class BookValidator {

	private BookValidator() {
		
	}
	
	/**
	 * Validate number.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isValidNumber(int number) {
		boolean valid = false;
		if (number > 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * Cost Validation
	 * @param number
	 * @return
	 */
    
	public static boolean isCostValid(double number) {
		boolean valid = false;
		if (number > 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	
   
	
	
	/**
	 * Validate book name Book name does not contain number.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isBookNameValid(String name) {
		boolean valid = true;
		String regex = "[a-zA-Z_ ]+\\.?";
		if (name.matches(regex)) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	public static boolean isBookPresent(String bookName) throws CannotGetDetailsException, ClassNotFoundException {
		List<Book> bookDetails = BookDao.getBook();
		boolean exists = false;
		
		for (Book books : bookDetails) {
			if(books.getBookName().equalsIgnoreCase(bookName)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
}
