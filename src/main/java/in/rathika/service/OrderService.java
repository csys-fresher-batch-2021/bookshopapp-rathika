package in.rathika.service;

import java.util.ArrayList;
import java.util.List;

import in.rathika.dao.BookDao;
import in.rathika.dao.OrderDao;
import in.rathika.model.Book;
import in.rathika.model.Order;

public class OrderService {
    
	private static OrderDao orderDao = new OrderDao();
	
	/**
	 * Add Book Details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 * @return
	 */
   public static boolean addOrder(String bookName, String language, int noOfBooks, double cost) {
		boolean isAdded = false;
		boolean present = OrderService.isPresent(bookName);
		
		if(!present) {
			isAdded=true;
		    orderDao.addCart(bookName, language, noOfBooks, cost);
		}
		
		
		return isAdded;
	}
	
   public static boolean isPresent(String bookName) {
	   boolean present = false;
	   List<Order> orders = orderDao.getOrder();
		for (Order orderDetails : orders) {
		   if(orderDetails.getBookName().equalsIgnoreCase(bookName)) {
			   present = true;
		   }
		   
		}
	   return present;
	   
   }
   
   public static boolean deleteBook(String bookName) {
		boolean isDeleted = false;
		Book searchbook = null;
		List<Book> books = BookDao.getSearch();
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
	
}
