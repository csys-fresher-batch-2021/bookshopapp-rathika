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
		List<Order> book = OrderDao.getOrder();
		book.removeAll(book);
		if (!present || present) {
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

	/**
	 * Check No of books valid.
	 * 
	 * @param bookName
	 * @param count
	 * @return
	 */
	public static boolean checkValidNoOfBooks(String bookName, int count) {
		boolean present = OrderService.isPresent(bookName);
		boolean validBooks = false;
		if (present) {
			List<Order> books = OrderDao.getOrder();
			for (Order order : books) {
				if (order.getNoOfBooks() >= count) {
					validBooks = true;

				}
			}
		}
		return validBooks;
	}

	/**
	 * Add books
	 * 
	 * @param bookName
	 * @param noOfBooks
	 * @return
	 * @throws Exception
	 */
	public static boolean addConfrimOrder(String bookName, int noOfBooks) throws Exception {
		boolean isAdd = false;
		boolean present = OrderService.isPresent(bookName);
		// boolean ordered = OrderService.isPresentOrder(bookName);
		for (Order order : OrderDao.getOrder()) {
			if (present) {
				double cost = order.getCost();
				String language = order.getLanguage();
				Order orderObj = new Order(bookName, language, noOfBooks, cost);
				// OrderDao.addOrders(bookName,language,noOfBooks,cost);
				OrderDao.saveOrder(orderObj);
				isAdd = true;
				break;

			}

		}
		return isAdd;
	}

	/**
	 * validate number of books
	 * 
	 * @param bookName
	 * @param noOfBooks
	 * @return
	 */
	public static boolean validNoOfBooks(String bookName, int noOfBooks) {
		boolean valid = false;
		boolean present = OrderService.isPresent(bookName);
		if (present) {
			List<Order> books = OrderDao.getOrder();
			for (Order order : books) {
				if (order.getNoOfBooks() >= noOfBooks) {

					valid = true;
					break;

				}
			}

		}
		return valid;
	}

	/**
	 * Delete book from cart.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteCart(String bookName) throws Exception {

		return OrderDao.deleteOrders(bookName.trim());
	}

	/**
	 * Calculate bill for cart books.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static double billCalculation() throws Exception {
		double total = 0;
		List<Order> books = OrderService.getOrderDetails();
		for (Order book : books) {
			// OrderDao.saveConfrimOrder(books);
			total = total + book.getNoOfBooks() * book.getCost();
			// OrderDao.deleteOrders(book.getBookName());

		}

		return total;
	}

	/**
	 * Check whether the ordered book is present in particular arraylist.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public static boolean isPresentOrder(String bookName) throws Exception {
		boolean present = false;
		List<Order> orders = OrderService.getOrderDetails();
		for (Order orderDetails : orders) {
			if (orderDetails.getBookName().equalsIgnoreCase(bookName)) {
				present = true;
			}

		}
		return present;

	}

	/**
	 * Get order details.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Order> getOrderDetails() throws Exception {
		List<Order> orders = OrderDao.getOrderDetails();
		orders.removeAll(orders);
		List<Order> order = OrderDao.getOrderDetails();
		return order;

	}

	/**
	 * Delete Book from Order List.
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean deleteBookOrder(String bookName) {
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

	/**
	 * Get No of books for update.
	 * 
	 * @param bookName
	 * @return
	 */
	public static int getUpdatedBooks(String bookName) {
		int count1 = 0;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) {
			if (orderDetails.getBookName().equalsIgnoreCase(bookName)) {
				count1 = orderDetails.getNoOfBooks();

			}

		}
		return count1;
	}
}
