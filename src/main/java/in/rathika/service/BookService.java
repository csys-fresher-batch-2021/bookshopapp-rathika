package in.rathika.service;
import java.util.*;
import java.awt.List;
import java.util.ArrayList;
import in.rathika.model.*;
public class BookService {
	private BookService() {
		//private constructor to avoid object creation
	}
	private static final ArrayList<Book>  books = new ArrayList<>();

	/**
	 * method to display the products available
	 * 
	 * @return
	 * 
	 */
	public static ArrayList<Book> getBooks() {
		return books;
	}
	public static boolean addProduct(String bookName,String language,int noOfBooks,int cost) {
		boolean isAdded = false;
		System.out.println("Successfully added " + bookName +" "+language +" "+noOfBooks +" "+cost);
		books.add(new Book(bookName,language,noOfBooks,cost));
		isAdded=true;
		return isAdded;
	}
	public static boolean isValidNumber(int number) {
		boolean valid = false;
		if(number>0) {
			valid = true;
		}
		else {
			valid = false;
		}
		return valid;
	}
}
