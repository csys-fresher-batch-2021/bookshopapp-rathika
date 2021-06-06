package in.rathika.service;

import java.util.List;

import in.rathika.dao.BookDao;
import in.rathika.model.Book;

public class BookService {

	
	private BookService() {

	}

	
	/**
	 * Add Book Details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 * @return
	 * @throws Exception 
	 */
	public static boolean addBook(String bookName, String language, int noOfBooks, double cost) throws Exception {
		boolean isAdded = false;
		boolean present = BookService.isPresent(bookName);
        Book bookObj = new Book(bookName, language, noOfBooks, cost);
		if (!present) {
			isAdded = true;
			BookDao.saveBook(bookObj);
		}

		return isAdded;
	}

	/**
	 * Delete Book from arraylist.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception 
	 */
	public static boolean deleteBook(String bookName) throws Exception {
		
		return BookDao.deleteBooks(bookName.trim());
	}

	
	/**
	 * Find the book present in the list or not.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception 
	 */
	public static boolean isPresent(String bookName) throws Exception {
		boolean present = false;
		List<Book> books = BookDao.getBookDetails();
		for (Book bookDetails : books) {
			if (bookDetails.getBookName().equalsIgnoreCase(bookName)) {
				present = true;
				break;
			}

		}
		return present;

	}

	/**
	 * Get language from arraylist.
	 * 
	 * @param bookName
	 * @return
	 */
	public static String getBookLanguage(String bookName) {
		String language = null;
		List<Book> books = BookDao.getBook();
		for (Book bookDetails : books) {
			if (bookDetails.getBookName().equalsIgnoreCase(bookName)) {
				language = bookDetails.getLanguage();
			}

		}
		return language;

	}

	/**
	 * Get noOfBokks from book name.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception 
	 */
	public static int getNoOfBooks(String bookName) throws Exception {
		int noOfBooks = 0;
		List<Book> books = BookDao.getBookDetails();
		for (Book bookDetails : books) {
			if (bookDetails.getBookName().equalsIgnoreCase(bookName)) {
				noOfBooks = bookDetails.getNoOfBooks();
			}

		}
		return noOfBooks;

	}

	/**
	 * Get cost using book name.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception 
	 */
	public static double getBookCost(String bookName) throws Exception {
		double cost = 0;
		List<Book> books = BookDao.getBookDetails();
		for (Book bookDetails : books) {
			if (bookDetails.getBookName().equalsIgnoreCase(bookName)) {
				cost = bookDetails.getCost();
			}

		}
		return cost;

	}

	/**
	 * Add searching book details.
	 * 
	 * @param language
	 * @return
	 */

	public static boolean searchBookByLanguage(String language) {
		boolean isAdd = false;
		List<Book> languageDetails = BookDao.getSearch();
		languageDetails.removeAll(languageDetails);
		for (Book book : BookDao.getBook()) {
			if (book.getLanguage().equalsIgnoreCase(language)) {
				languageDetails.add(book);
				isAdd = true;
			}
		}
		return isAdd;
	}

	/**
	 * Add search book details.
	 * 
	 * @param type
	 * @return
	 */
	public static boolean searchBookByCost(int type) {
		boolean isAdd = false;
		List<Book> languageDetails = BookDao.getSearch();
		languageDetails.removeAll(languageDetails);
		if (type == 1) {
			for (Book book : BookDao.getBook()) {
				if (book.getCost() <= 500) {
					languageDetails.add(book);
					isAdd = true;
				}
			}
		} else if (type == 2) {
			for (Book book : BookDao.getBook()) {
				if (book.getCost() >= 1000) {
					languageDetails.add(book);
					isAdd = true;
				}
			}
		}

		return isAdd;
	}

	/**
	 * Add confirm Ordered book details.
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean confirmOrder(String bookName) {
		boolean isAdd = false;
		List<Book> languageDetails = BookDao.getSearch();
		languageDetails.removeAll(languageDetails);
		for (Book book : BookDao.getBook()) {
			if (book.getBookName().equalsIgnoreCase(bookName)) {
				languageDetails.add(book);
				isAdd = true;
			}
		}
		return isAdd;
	}
   
	
	/**
	 * Get book details from database.
	 * @return
	 * @throws Exception
	 */
	public static List<Book> getBookDetails() throws Exception{
		List<Book> books = BookDao.getBookDetails();
		books.removeAll(books);
		List<Book> book = BookDao.getBookDetails();
		return book;
		
	}

	

}