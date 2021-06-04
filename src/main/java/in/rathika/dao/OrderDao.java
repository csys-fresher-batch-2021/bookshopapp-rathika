package in.rathika.dao;

import java.util.ArrayList;
import java.util.List;

import in.rathika.model.Order;

public class OrderDao {
	/**
	 * Store Ordered Book Details
	 */
	private static final List<Order> orders = new ArrayList<>();

	/**
	 * Add Ordered details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public void addCart(String bookName, String language, int noOfBooks, double cost) {

		orders.add(new Order(bookName, language, noOfBooks, cost));
	}

	/**
	 * Get Ordered List.
	 * 
	 * @return
	 */
	public static List<Order> getOrder() {
		return orders;
	}

	/**
	 * List to store ordered details.
	 */
	private static final List<Order> confrimOrders = new ArrayList<>();

	/**
	 * Method to add ordered details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public static void addOrders(String bookName, String language, int noOfBooks, double cost) {

		confrimOrders.add(new Order(bookName, language, noOfBooks, cost));
	}

	/**
	 * Get the list of order.
	 * 
	 * @return
	 */
	public static List<Order> getConfrimOrder() {
		return confrimOrders;
	}
}
