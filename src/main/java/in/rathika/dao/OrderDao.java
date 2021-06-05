package in.rathika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.rathika.exception.CannotGetDetailsException;
import in.rathika.exception.NotAbleToDeleteException;
import in.rathika.model.Book;
import in.rathika.model.Order;
import in.rathika.util.ConnectionUtil;

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

	 * List to store confrim order.

	 * List to store ordered details.

	 */
	private static final List<Order> confrimOrders = new ArrayList<>();

	/**

	 * Save ordered details into database.
	 * 
	 * @param order
	 * @throws Exception
	 */
	public static void saveOrder(Order order) throws Exception {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into orderList(bookName,language,noOfBooks,cost) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, order.getBookName());
			pst.setString(2, order.getLanguage());
			pst.setInt(3, order.getNoOfBooks());
			pst.setDouble(4, order.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws Exception
	 */
	public static void save(List<Order> orders) throws Exception {
		for (Order order : orders) {
			saveOrder(order);
		}
	}

	/**
	 * Get ordered details.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Order> getOrderDetails() throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try {

			String url = "select * from orderList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) {
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				confrimOrders.add(new Order(bookname, bookLanguage, noOfBooks, cost));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return confrimOrders;
	}

	/**
	 * Delete order from database.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteOrders(String bookName) throws Exception {
		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM orderList WHERE bookName=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, bookName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;
	}

	/**
	 * Update no of books from database.
	 * 
	 * @param bookName
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public static boolean updateBooks(String bookName, int count) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isDeleted = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "update bookList set noOfBooks = '" + count + "' where bookName='" + bookName + "'";

			pst = connection.prepareStatement(str);
			pst.executeUpdate();
			isDeleted = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDeleted;

	}

	/**
	 * Get no of books ordered.
	 * 
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public static int getNoOfBooks(String bookName) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;

		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select noOfBooks from orderList where bookName='" + bookName + "'";

			pst = connection.prepareStatement(str);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				count = rs.getInt("noOfBooks");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return count;

	}
	public static void confrimOrder(Order order) throws Exception {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into confrimOrderList(bookName,language,noOfBooks,cost) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, order.getBookName());
			pst.setString(2, order.getLanguage());
			pst.setInt(3, order.getNoOfBooks());
			pst.setDouble(4, order.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws Exception
	 */
	public static void saveConfrimOrder(List<Order> orders) throws Exception {
		for (Order order : orders) {
			confrimOrder(order);
		}
	}
	/**
	 * Get the book details from Data Base.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Order> getConfrimDetails() throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			//confrimOrders.removeAll(confrimOrders);
			String url = "select * from confrimOrderList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) {
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				
				confrimOrders.add(new Order(bookname, bookLanguage, noOfBooks, cost));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return confrimOrders;
	}

	public static boolean deleteConfrimOrders(String bookName) throws Exception {
		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM confrimOrderList WHERE bookName=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, bookName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;
	}


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
