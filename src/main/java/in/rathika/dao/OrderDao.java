package in.rathika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.rathika.exception.CannotGetDetailsException;
import in.rathika.exception.DBException;
import in.rathika.exception.NotAbleToDeleteException;
import in.rathika.model.Order;
import in.rathika.util.ConnectionUtil;

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

	/**
	 * List to store confrim order.
	 */
	private static final List<Order> confrimOrders = new ArrayList<>();
	private static final List<Order> userOrders = new ArrayList<>();

	private static final List<Order> orderDetails = new ArrayList<>();
	private static final List<Order> cartDetails = new ArrayList<>();

	public static void addConfrimCart(String bookName, String language, int noOfBooks, double cost) {

		orderDetails.add(new Order(bookName, language, noOfBooks, cost));
	}

	public static List<Order> getConfrimOrder() {
		return orderDetails;
	}

	/**
	 * Save ordered details into database.
	 * 
	 * @param order
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static void saveOrder(Order order) throws CannotGetDetailsException, DBException, ClassNotFoundException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into orderList(userid,username,bookname,language,noofbooks,cost,order_date,delivery_date,status) values (?,?,?,?,?,?,?,?,'PENDING')";
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getUserId());
			pst.setString(2, order.getUserName());
			pst.setString(3, order.getBookName());
			pst.setString(4, order.getLanguage());
			pst.setInt(5, order.getNoOfBooks());
			pst.setDouble(6, order.getCost());
			pst.setObject(7, order.getOrderDate());
			pst.setObject(8, order.getDeliveryDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CannotGetDetailsException("unable to get details");
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws DBException 
	 * @throws Exception
	 */
	public static void save(List<Order> orders) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		for (Order order : orders) {
			saveOrder(order);
		}
	}

	/**
	 * Get ordered details.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static List<Order> getOrderDetails() throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String url = "select id,userid,username,bookName,language,noOfBooks,cost,order_date,delivery_date,status from orderList ORDER BY bookName";
			con = ConnectionUtil.getConnection();

			pst = con.prepareStatement(url);
			rs = pst.executeQuery();
			confrimOrders.clear();
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userid");
				String userName = rs.getString("username");
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				LocalDate orderDate = LocalDate.parse(rs.getString("order_date"));
				LocalDate deliveryDate = LocalDate.parse(rs.getString("delivery_date"));
				String status = rs.getString("status");

				confrimOrders.add(new Order(id, userId, userName, bookname, bookLanguage, noOfBooks, cost, orderDate,
						deliveryDate, status));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("unable select details");

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
	 * @throws NotAbleToDeleteException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static boolean deleteOrders(String bookName)
			throws CannotGetDetailsException, NotAbleToDeleteException, ClassNotFoundException,DBException {
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
			throw new CannotGetDetailsException("unable to get details to delete");
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
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static boolean updateBooks(String bookName, int count) throws DBException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "update bookList set noOfBooks = ? where bookName=?";

			pst = connection.prepareStatement(str);
			pst.setInt(1, count);
			pst.setString(2, bookName);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new DBException("unable to get details to update books");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;

	}

	/**
	 * Get no of books ordered.
	 * 
	 * @param bookName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static int getNoOfBooks(String bookName) throws CannotGetDetailsException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;

		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select noOfBooks from orderList where bookName=?";

			pst = connection.prepareStatement(str);
			pst.setString(1, bookName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				count = rs.getInt("noOfBooks");

			}

		} catch (SQLException e) {

			throw new CannotGetDetailsException("unable to get noOfBooks");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return count;

	}


	/**
	 * Add orderd Details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public static void addOrders(String bookName, String language, int noOfBooks, double cost) {
		orderDetails.add(new Order(bookName, language, noOfBooks, cost));

	}

	/**
	 * Add cart details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public static void addCartDetails(String bookName, String language, int noOfBooks, double cost) {
		cartDetails.add(new Order(bookName, language, noOfBooks, cost));

	}

	/**
	 * Get Cart Details.
	 * 
	 * @return
	 */
	public static List<Order> getCartDetails() {
		return cartDetails;
	}

	/**
	 * Update Order status.
	 * 
	 * @param orderId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static boolean updateStatus(int orderId) throws CannotGetDetailsException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {

			connection = ConnectionUtil.getConnection();

			String str = "update orderList set status = 'DELIVERED' where id=?";
			pst = connection.prepareStatement(str);
			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to update status");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;

	}

	/**
	 * Update order Status.
	 * 
	 * @param orderId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws CannotGetDetailsException
	 */
	public static boolean updateRejectStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {

			connection = ConnectionUtil.getConnection();

			String str = "update orderList set status ='CANCELLED' where id=?";
			pst = connection.prepareStatement(str);

			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to update status details");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;
	}

	/**
	 * Get User Order
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public static List<Order> getUserOrder(int id) throws CannotGetDetailsException, ClassNotFoundException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String url = "select * from orderList where userid=?";
			con = ConnectionUtil.getConnection();

			pst = con.prepareStatement(url);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			userOrders.clear();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("userid");
				String userName = rs.getString("username");
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				LocalDate orderDate = LocalDate.parse(rs.getString("order_date"));
				LocalDate deliveryDate = LocalDate.parse(rs.getString("delivery_date"));
				String status = rs.getString("status");
				userOrders.add(new Order(id1, userId, userName, bookname, bookLanguage, noOfBooks, cost, orderDate,
						deliveryDate, status));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable get user order");

		} finally {
			ConnectionUtil.close(pst, con);
		}

		return userOrders;
	}

	public static List<Order> saveUserOrder() {
		return userOrders;
	}
}
