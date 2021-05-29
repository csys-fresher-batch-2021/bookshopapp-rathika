package in.rathika.dao;
import java.util.ArrayList;
import java.util.List;
import in.rathika.model.*;
public class BookDao {
	private static final List<Book> books = new ArrayList<>();
	
	static {
		books.add(new Book("MOON","ENGLISH", 4,500));
		books.add(new Book("PONNIN SELVAN","TAMIL", 3,1000));
		books.add(new Book("A TALE OF TWO CITIES","ENGLISH", 3,700));
		books.add(new Book("The LITTLE PRINCE","ENGLISH", 3,500));
	}
	
	private static final List<Book> language = new ArrayList<>();
	public void addBook(String bookName, String language, int noOfBooks,double cost) {
		
    	 books.add(new Book(bookName, language, noOfBooks, cost));
	}
     public static List<Book> getBook(){
    	 return books;
     }
     
    
	public void addSearch(String bookName, String language2, int noOfBooks, double cost) {
		language.remove(language);
		language.add(new Book(bookName,language2,noOfBooks,cost));
		
	}
	 public static List<Book> getSearch(){
    	 return language;
     }
}