package in.rathika.service;

import java.util.ArrayList;



public class BookManager {
	
	private BookManager() {
		
	}
	/**
	 * Declaring Array list for book details.
	 */
	public static ArrayList<Book> books = new ArrayList<Book>();
	/**
	 * Add Book details into array list.
	 * @param book
	 */
	
	
	public static void addBook(Book book) {
		books.add(book);
	}

	/**
	 * This method is to add book details.
	 * @param name
	 * @param noBooks
	 * @param rate
	 */
	//BookDetails book = new BookDetails();
	public static ArrayList<Book> addBookDetails() {
		
		int i=0;
		
		Book book1 = new Book();
		book1.language = "TAMIL";
		book1.bookName = "MAHABHARATHAM";
		book1.noOfBooks = 10;
		book1.cost = 2000;
		i++;
		BookManager.addBook(book1);

		Book book2 = new Book();
		book2.language = "TAMIL";
		book2.bookName = "PONNIN SELVAN";
		book2.noOfBooks = 12;
		book2.cost = 1200;
		i++;
		BookManager.addBook(book2);
		
		Book book3 = new Book();
		book3.language = "ENGLISH";
		book3.bookName = "THE ALCHAMIST";
		book3.noOfBooks = 50;
		book3.cost = 700;
		i++;
		BookManager.addBook(book3);
		
		Book book4 = new Book();
		book4.language = "ENGLISH";
		book4.bookName = "HARRY PARTOR";
		book4.noOfBooks = 10;
		book4.cost = 1500;
		i++;
		BookManager.addBook(book4);
		
		Book book5 = new Book();
		book5.language = "ENGLISH";
		book5.bookName = "BLACK BEAUTY";
		book5.noOfBooks = 20;
		book5.cost = 750;
		i++;
		BookManager.addBook(book5);
		
		Book book6 = new Book();
		book6.language = "ENGLISH";
		book6.bookName = "NEW MOON";
		book6.noOfBooks = 5;
		book6.cost = 800;
		i++;
		BookManager.addBook(book6);
		
		//BookDetailsValidation.validation(books);
		return books;
	}
	/**
	 * Display the Added Books.
	 */
	public static void displayBooks() {
		
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
	}
		
	
}
