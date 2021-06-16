package in.rathika.service;

import java.time.LocalDate;
import java.util.List;

import in.rathika.dao.OrderDao;
import in.rathika.dao.UserDao;
import in.rathika.exception.CannotGetDetailsException;
import in.rathika.exception.NotAbleToDeleteException;
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
		List<Order> book = OrderDao.getOrder();
		book.clear();
		orderDao.addCart(bookName, language, noOfBooks, cost);
		isAdded = true;

		

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
	public static boolean addConfrimOrder(String userName,String bookName, int noOfBooks) throws CannotGetDetailsException, ClassNotFoundException  {
		boolean isAdd = false;
		boolean present = OrderService.isPresent(bookName);
		
		int user = UserDao.getId(userName);
		
		
		
		for (Order order : OrderDao.getOrder()) {
			if (present) {
				
				int id = order.getId();
				
				double cost = order.getCost();
				String language = order.getLanguage();
				String status = order.getStatus();
				
				LocalDate orderDate = LocalDate.now();
				
				LocalDate deliveryDate = orderDate.plusDays(6);
				Order orderObj = new Order(id,user,userName,bookName, language, noOfBooks, cost,orderDate,deliveryDate,status);
				
				OrderDao.saveOrder(orderObj);
				

				OrderDao.addConfrimCart(bookName, language, noOfBooks, cost);
				 
				isAdd = true;

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
	 * @throws NotAbleToDeleteException 
	 * @throws Exception
	 */
	public static boolean deleteCart(String bookName) throws CannotGetDetailsException, ClassNotFoundException, NotAbleToDeleteException {

		return OrderDao.deleteOrders(bookName.trim());
	}

	/**
	 * Calculate bill for cart books.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static double billCalculation()  {
		double total = 0;
		
		List<Order> books = OrderDao.getConfrimOrder();
		
		for (Order book : books) {
			total = total + book.getNoOfBooks() * book.getCost();
		}
	
		
        books.clear();
        
		return total;
	}

	/**
	 * Check whether the ordered book is present in particular arraylist.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public static boolean isPresentOrder(String bookName) throws CannotGetDetailsException, ClassNotFoundException {
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
	 * @throws CannotGetDetailsException 
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static List<Order> getOrderDetails() throws ClassNotFoundException, CannotGetDetailsException  {
		List<Order> orders = OrderDao.getOrderDetails();
		orders.clear();
		List<Order> order = OrderDao.getOrderDetails();
		return order;

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
	
     
     public static boolean updateRejectStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException  {
		
		return OrderDao.updateRejectStatus(orderId);
	}
	
	public static boolean updateStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException  {
		
		return OrderDao.updateStatus(orderId);
	}

}
