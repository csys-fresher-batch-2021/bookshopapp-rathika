package in.rathika.model;

public class Order {

	/**
	 * Declaring Required Variables.
	 */
	private String bookName;
	private String language;
	private int noOfBooks;
	private double cost;

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

	@Override
	public String toString() {
		return "Order [bookName=" + bookName + ", language=" + language + ", noOfBooks=" + noOfBooks + ", cost=" + cost
				+ "]";
	}

}
