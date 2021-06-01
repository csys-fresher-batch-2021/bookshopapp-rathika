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
	
	
	private static final List<Order> confrimOrders = new ArrayList<>();
	
	public static void addOrders(String bookName, String language, int noOfBooks, double cost) {
       
		confrimOrders.add(new Order(bookName, language, noOfBooks, cost));
	}
    
	public static List<Order> getConfrimOrder() {
		return confrimOrders;
	}
	

}
