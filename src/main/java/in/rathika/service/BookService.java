package in.rathika.service;

import java.util.ArrayList;
import java.util.List;
import in.rathika.model.*;

public class BookService {
	private BookService() {
		// private constructor to avoid object creation
	}

	private static final List<Book> books = new ArrayList<>();

	/**
	 * method to display the products available
	 * 
	 * @return
	 * 
	 */
	public static List<Book> getBooks() {
		return books;
	}

	/**
	 * Add Book Details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 * @return
	 */

	public static boolean addBook(String bookName, String language, int noOfBooks, int cost) {
		boolean isAdded = false;
		books.add(new Book(bookName, language, noOfBooks, cost));
		isAdded = true;
		return isAdded;
	}
	
	public static boolean deleteBook(String bookName) {
		boolean isDeleted = false;
		Book searchbook = null;
		for(Book book: books) {
			if(book.getBookName().equalsIgnoreCase(bookName)) {
				searchbook = book;
				break;
			}
		}
		if(searchbook != null) {
			books.remove(searchbook);
			isDeleted = true;
			System.out.println("delete");
		}
		return isDeleted;
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

}
