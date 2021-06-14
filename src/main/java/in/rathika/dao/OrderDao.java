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
	public static void saveOrder(Order order) throws CannotGetDetailsException, ClassNotFoundException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into orderList(userid,bookName,language,noOfBooks,cost,status) values (?,?,?,?,?,'pending')";
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getUserId());
			pst.setString(2, order.getBookName());
			pst.setString(3, order.getLanguage());
			pst.setInt(4, order.getNoOfBooks());
			pst.setDouble(5, order.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			throw new CannotGetDetailsException("unable to get details");
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
	public static void save(List<Order> orders) throws Throwable {
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

			String url = "select id,userid,bookName,language,noOfBooks,cost,status from orderList ORDER BY bookName";
			con = ConnectionUtil.getConnection();
			
			
			pst = con.prepareStatement(url);
			rs = pst.executeQuery();
			confrimOrders.clear();
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userid");
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				String status = rs.getString("status");
				confrimOrders.add(new Order(id,userId,bookname, bookLanguage, noOfBooks, cost,status));
			}
			

		} catch (SQLException e) {
			throw new CannotGetDetailsException("unable to get details");

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
	public static boolean deleteOrders(String bookName) throws CannotGetDetailsException, NotAbleToDeleteException, ClassNotFoundException {
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
			throw new CannotGetDetailsException("unable to get details");
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
	public static boolean updateBooks(String bookName, int count) throws Throwable {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "update bookList set noOfBooks = ? where bookName=?";

			pst = connection.prepareStatement(str);
			pst.setInt(1,count);
			pst.setString(2, bookName);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("unable to get details");
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

			throw new CannotGetDetailsException("unable to get details");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return count;

	}
	/**
	 * Get order
	 * @param order
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static void confrimOrder(Order order) throws CannotGetDetailsException, ClassNotFoundException {
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
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new CannotGetDetailsException("unable to insert details");
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
	public static void saveConfrimOrder(List<Order> orders) throws Throwable {
		for (Order order : orders) {
			confrimOrder(order);
		}
	}
	/**
	 * Get the book details from Data Base.
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static List<Order> getConfrimDetails() throws CannotGetDetailsException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			
			String url = "select bookName,language,noOfBooks,cost from confrimOrderList ORDER BY bookName";
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
			throw new CannotGetDetailsException("unable to get details");

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return confrimOrders;
	}
    /**
     * Delete Book from confrim order list.
     * @param bookName
     * @return
     * @throws CannotGetDetailsException 
     * @throws ClassNotFoundException 
     * @throws Exception
     */
	public static boolean deleteConfrimOrders(String bookName) throws NotAbleToDeleteException, CannotGetDetailsException, ClassNotFoundException {
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
			throw new CannotGetDetailsException("unable to delete");
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;
	}
    /**
     * Add orderd Details.
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
	 * @return
	 */
	public static List<Order> getCartDetails() {
		return cartDetails;
	}
	/**
	 * Update Order status.
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

			
			String str = "update orderList set status = 'accepted' where id=?";
			pst = connection.prepareStatement(str);
			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;
			

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to update");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;

	}
	
	
    /**
     * Update order Status.
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

			
			String str = "update orderList set status ='rejected' where id=?" ;
			pst = connection.prepareStatement(str);
			
			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable update");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;
	}
    /**
     * Get User Order
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
            System.out.println(id);
			String url = "select * from orderList where userid=?";
			con = ConnectionUtil.getConnection();
			
			
			pst = con.prepareStatement(url);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			userOrders.clear();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int userId = rs.getInt("userid");
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				String status = rs.getString("status");
				userOrders.add(new Order(id1,userId,bookname, bookLanguage, noOfBooks, cost,status));
			}
			

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable get user");

		} finally {
			ConnectionUtil.close(pst, con);
		}
		
		return userOrders;
	}
	public static List<Order> saveUserOrder() throws Throwable {
		return userOrders;
	}
}
