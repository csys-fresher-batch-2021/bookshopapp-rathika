package in.rathika.service;

import java.util.List;

import in.rathika.dao.BookDao;
import in.rathika.model.Book;
import in.rathika.validator.BookValidator;

public class BookService {
	
	public BookService() {
		
	}
	
	private static BookDao bookObj = new BookDao();

	private static BookValidator bookValidatorObj = new BookValidator();
    
	/**
	 * Add Book Details.
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 * @return
	 */

	public boolean addBook(String bookName, String language, int noOfBooks, int cost) {
		/*
		 * boolean isAdded = false; books.add(new Book(bookName, language, noOfBooks,
		 * cost)); isAdded = true; return isAdded ;
		 */
		boolean added = false;
		Book bookObject = new Book(bookName,language,noOfBooks,cost);
		boolean bookNameValid = bookValidatorObj.isBookNameValid(bookName);
		boolean noOfBooksValid = bookValidatorObj.isValidNumber(noOfBooks);
		boolean costValid = bookValidatorObj.isValidNumber(cost);
		if(bookNameValid && noOfBooksValid && costValid) {
			bookObj.addBook(bookObject);
			added = true;
		}
		return added;
	}

	
	 /**
	  * Delete book by giving book name.
	  * @param bookName
	  * @return
	  */
	  public static boolean deleteBook(String bookName)
      {
		  System.out.println("I am here to delete");
		  boolean isDeleted =false; 
		  Book searchbook = null;
		  BookDao daoObj = new BookDao();
			List<Book> books = daoObj.getBook();
	     for (Book book : books) {
		  if(book.getBookName().equalsIgnoreCase(bookName)) 
		  { 
			  searchbook = book; 
			  break; 
		  }
	  } 
	  if (searchbook != null) {
		  books.remove(searchbook); 
		  isDeleted = true;
	  
	  } 
	  return isDeleted; 
	  }
	 

	

}
