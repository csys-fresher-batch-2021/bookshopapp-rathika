package in.rathika.dao;
import java.util.ArrayList;
import java.util.List;
import in.rathika.model.*;
public class BookDao {
	/**
	 * ArrayList to store Book Details.
	 */
	private static final List<Book> books = new ArrayList<>();
	/**
	 * Store Some Book Details.
	 */
	static {
		books.add(new Book("MOON","ENGLISH", 4,500));
		books.add(new Book("PONNIN SELVAN","TAMIL", 3,1000));
		books.add(new Book("A TALE OF TWO CITIES","ENGLISH", 3,700));
		books.add(new Book("The LITTLE PRINCE","ENGLISH", 3,500));
	}
	/**
	 * ArrayList to store search books.
	 */
	private static final List<Book> language = new ArrayList<>();
	/**
	 * Add Book details.
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public void addBook(String bookName, String language, int noOfBooks,double cost) {
		
    	 books.add(new Book(bookName, language, noOfBooks, cost));
	}
	/**
	 * Get Book Details.
	 * @return
	 */
     public static List<Book> getBook(){
    	 return books;
     }
     /**
      * Add Book Details that user search.
      * @param bookName
      * @param language2
      * @param noOfBooks
      * @param cost
      */
    
	public void addSearch(String bookName, String language2, int noOfBooks, double cost) {
		language.remove(language);
		language.add(new Book(bookName,language2,noOfBooks,cost));
		
	}
	/**
	 * Get Search Book Details.
	 * @return
	 */
	 public static List<Book> getSearch(){
    	 return language;
     }
}