package in.rathika;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
		ArrayList<Book> books = BookManager.addBookDetails();
        int i=0;
		for(Book detail:books) {
			
			
			i++;
			System.out.println("--------DISPLAY BOOK NUMBER  "+   i +" DETAILS----------");
			System.out.println("BOOK NUMBER "+ i);
			System.out.println("LANGUAGE "+ detail.language);
			System.out.println(" BOOK NAME " + detail.bookName);
			System.out.println( "NO OF BOOKS " + detail.noOfBooks );
			System.out.println("BOOK COST " + detail.cost);
		}
		//System.out.println("------TOTAL NO OF BOOKS--------"+noOfBooks);
		//System.out.println("Books are added");
		//Book.updateDetails("NEW MOON", "NEW SUN");
		//System.out.println("-----------Display Books---------");
		//BookManager.displayBooks();
		
	}

}
