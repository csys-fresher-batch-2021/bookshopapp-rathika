package in.rathika.model;

public class Book {
	/**
	 * Declaring variables required  for book shop.
	 */
	    private String language;
		private String bookName;
		
		private int noOfBooks;
		private int cost;
	
		public Book(String title, String language2, int noOfBooks2, int price) {
			this.bookName = title;
			this.language = language2;
			this.noOfBooks = noOfBooks2;
			this.cost = price;
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
		
	
		public int getCost() {
			return cost;
		}
		@Override
		public String toString() {
			return "Book [ bookName=" + bookName + ",language=" + language + ", noOfBooks=" + noOfBooks + ", cost="
					+ cost + "]";
		}
		
}
