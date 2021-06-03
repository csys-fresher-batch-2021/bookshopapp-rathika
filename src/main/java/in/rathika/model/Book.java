package in.rathika.model;

public class Book {

	/**
	 * Declaring variables required for book shop.
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

	public Book(String bookName, String language, int noOfBooks, double cost) {
		super();
		this.bookName = bookName;
		this.language = language;
		this.noOfBooks = noOfBooks;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", language=" + language + ", noOfBooks=" + noOfBooks + ", cost=" + cost
				+ "]";
	}

}
