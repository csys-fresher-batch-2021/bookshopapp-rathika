package in.rathika.service;

import java.util.ArrayList;
import java.util.List;
import in.rathika.model.*;
import in.rathika.dao.BookDao;

public class BookService {
	
    
	private static BookDao bookDao = new BookDao();
	/**
	 * Add Book Details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 * @return
	 */
   public static boolean addBook(String bookName, String language, int noOfBooks, double cost) {
		boolean isAdded = false;
		boolean present = BookService.isPresent(bookName);
		
		if(!present) {
			isAdded=true;
			bookDao.addBook(bookName, language, noOfBooks, cost);
		}
		
		
		return isAdded;
	}
	
	public static boolean deleteBook(String bookName) {
		boolean isDeleted = false;
		Book searchbook = null;
		List<Book> books = bookDao.getBook();
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
   public static boolean isPresent(String bookName) {
	   boolean present = false;
	   List<Book> books = bookDao.getBook();
		for (Book bookDetails : books) {
		   if(bookDetails.getBookName().equalsIgnoreCase(bookName)) {
			   present = true;
		   }
		   
		}
	   return present;
	   
   }
   
   public static String getBookLanguage(String bookName) {
	   String language=null;
	   List<Book> books = bookDao.getBook();
		for (Book bookDetails : books) {
		   if(bookDetails.getBookName().equalsIgnoreCase(bookName)) {
			   language = bookDetails.getLanguage();
		   }
		   
		}
	   return language;
	   
   }
   
   public static int getNoOfBooks(String bookName) {
	   int noOfBooks = 0;
	   List<Book> books = bookDao.getBook();
		for (Book bookDetails : books) {
		   if(bookDetails.getBookName().equalsIgnoreCase(bookName)) {
			   noOfBooks = bookDetails.getNoOfBooks();
		   }
		   
		}
	   return noOfBooks;
	   
   }
   
   public static double getBookCost(String bookName) {
	   double cost = 0;
	   List<Book> books = bookDao.getBook();
		for (Book bookDetails : books) {
		   if(bookDetails.getBookName().equalsIgnoreCase(bookName)) {
			   cost = bookDetails.getCost();
		   }
		   
		}
	   return cost;
	   
   }
  

   
   public static boolean addSearchDetails(String bookName, String language, int noOfBooks, double cost) {
		boolean isAdded = false;
		boolean present = BookService.isPresent(bookName);
		
		if(!present) {
			isAdded=true;
			bookDao.addSearch(bookName, language, noOfBooks, cost);
			System.out.println(language);
			System.out.println("Book servise");
		}
		return isAdded;
 }
   
 
 
   
  
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
   
   public static boolean searchBookByCost(int type) {
		boolean isAdd = false;
		List<Book> languageDetails = BookDao.getSearch();
		languageDetails.removeAll(languageDetails);
		if(type == 1) {
			for (Book book : BookDao.getBook()) {
				if (book.getCost()<=500) {
					languageDetails.add(book);
					isAdd = true;
				} 
			}
		}
		else if(type==2){
			for (Book book : BookDao.getBook()) {
				if (book.getCost()>=1000) {
					languageDetails.add(book);
					isAdd = true;
				} 
			}
		}
		
      return isAdd;
	}


}
