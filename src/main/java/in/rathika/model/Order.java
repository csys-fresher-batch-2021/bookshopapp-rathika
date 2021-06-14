package in.rathika.model;

public class Order {

	/**
	 * Declaring Required Variables.
	 */
	private int userId;
	

	private int id;
	private String bookName;
	private String language;
	private int noOfBooks;
	private double cost;
	private String status;
	
	
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

	@Override
	public String toString() {
		return "Order [bookName=" + bookName + ", language=" + language + ", noOfBooks=" + noOfBooks + ", cost=" + cost
				+ "]";
	}


}
