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
	 * Parse string into integer.
	 * 
	 * @param price
	 * @return
	 */
	public static int isParsable(String price) {
		int res = 0;
		try {
			res = Integer.parseInt(price);

		} catch (final NumberFormatException e) {
			res = 0;
		}
		return res;
	}

}
