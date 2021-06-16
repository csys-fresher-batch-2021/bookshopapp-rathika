package in.rathika.model;
import java.time.LocalDate;


public class Order {

	/**
	 * Declaring Required Variables.
	 */
	
    private int id;
   

	private int userId;
	private String userName;
	private String bookName;
	private String language;
	private int noOfBooks;
	private double cost;
	
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private String status;
	
	


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookName() {
		return bookName;
	}

	public String getLanguage() {
		return language;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public double getCost() {
		return cost;
	}

	public Order(String bookName, String language, int noOfBooks, double cost) {
		super();
		this.bookName = bookName;
		this.language = language;
		this.noOfBooks = noOfBooks;
		this.cost = cost;
	}



	public Order(int id,int userId,String bookname2, String bookLanguage, int noOfBooks2, double cost2, String status) {
		
		this.userId = userId;
		this.id = id;
		this.bookName = bookname2;
		this.language = bookLanguage;
		this.noOfBooks = noOfBooks2;
		this.cost = cost2;
		this.status = status;
	
		
	}

	public Order(int id2, String bookname2, String bookLanguage, int noOfBooks2, double cost2, String status2) {
		super();
		
		this.id = id2;
		this.bookName = bookname2;
		this.language = bookLanguage;
		this.noOfBooks = noOfBooks2;
		this.cost = cost2;
		this.status = status2;
	}
	
	 public Order(int id, int userId, String userName, String bookName, String language, int noOfBooks, double cost,
				LocalDate orderDate, LocalDate deliveryDate, String status) {
			super();
			this.id = id;
			this.userId = userId;
			this.userName = userName;
			this.bookName = bookName;
			this.language = language;
			this.noOfBooks = noOfBooks;
			this.cost = cost;
			this.orderDate = orderDate;
			this.deliveryDate = deliveryDate;
			this.status = status;
		}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", userName=" + userName + ", bookName=" + bookName
				+ ", language=" + language + ", noOfBooks=" + noOfBooks + ", cost=" + cost + ", orderDate=" + orderDate
				+ ", deliveryDate=" + deliveryDate + ", status=" + status + "]";
	}

	
	

}
