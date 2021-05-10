package in.rathika;

import static org.junit.Assert.*;

import org.junit.Test;

import in.rathika.testcase.*;
import in.rathika.service.*;

public class DisplayBookTest {

	@Test
	/**
	 * Adding book details.
	 * Display the book details after adding books.
	 */
	public void addDisplayBook() {
		System.out.println("---------ADD BOOKS--------");
	
		int noOfBooks = BookManager.addBookDetails();
		System.out.println("------TOTAL NO OF BOOKS--------"+noOfBooks);
		//System.out.println("Books are added");
		//Book.updateDetails("NEW MOON", "NEW SUN");
		System.out.println("-----------Display Books---------");
		BookManager.displayBooks();
		
	}

}
