package in.rathika.service;

import java.util.List;

import in.rathika.dao.OrderDao;
import in.rathika.model.Order;

public class OrderService {

	private OrderService() {

	}

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

		if (!present) {
			isAdded = true;
			orderDao.addCart(bookName, language, noOfBooks, cost);
		}

		return isAdded;
	}

	/**
	 * Search Book name is present or not.
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean isPresent(String bookName) {
		boolean present = false;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) {
			if (orderDetails.getBookName().equalsIgnoreCase(bookName)) {
				present = true;
			}

		}
		return present;

	}

	/**
	 * Delete Book from the list.
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean deleteBook(String bookName) {
		boolean isDeleted = false;
		Order searchbook = null;
		List<Order> books = OrderDao.getOrder();
		for (Order order : books) {
			if (order.getBookName().equalsIgnoreCase(bookName)) {
				searchbook = order;
				break;
			}
		}

		if (searchbook != null) {
			books.remove(searchbook);
			isDeleted = true;

		}
		return isDeleted;
	}

	public static boolean checkValidNoOfBooks(String bookName, int count) {
		boolean present = OrderService.isPresent(bookName);
		boolean validBooks = false;
		if(present) {
			List<Order> books = OrderDao.getOrder();
			for (Order order : books) {
				if (order.getNoOfBooks()>=count) {
					validBooks = true;
					
				}
			}
		}
		return validBooks;
	}

}
