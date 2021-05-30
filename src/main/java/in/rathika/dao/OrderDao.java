package in.rathika.dao;

import java.util.ArrayList;
import java.util.List;

import in.rathika.model.Book;
import in.rathika.model.Order;

public class OrderDao {
	/**
	 * Store Ordered Book Details
	 */
	private static final List<Order> orders = new ArrayList<>();

	/**
	 * Add Orderd details.
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

}
