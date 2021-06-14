package in.rathika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.rathika.exception.CannotGetDetailsException;
import in.rathika.exception.NotAbleToDeleteException;
import in.rathika.model.Book;
import in.rathika.util.ConnectionUtil;

public class BookDao {
	/**
	 * ArrayList to store Book Details.
	 */
	private static final List<Book> books = new ArrayList<>();

	/**
	 * ArrayList to store search books.
	 */
	private static final List<Book> language = new ArrayList<>();

	/**
	 * Add Book details.
	 * 
	 * @param bookName
	 * @param language
	 * @param noOfBooks
	 * @param cost
	 */
	public void addBook(String bookName, String language, int noOfBooks, double cost) {

		books.add(new Book(bookName, language, noOfBooks, cost));
	}

	/**
	 * Get Book Details.
	 * 
	 * @return
	 */
	public static List<Book> getBook() {
		return books;
	}

	/**
	 * 
	 * 
	 * @param bookName
	 * @param language2
	 * @param noOfBooks
	 * @param cost
	 */

	public void addSearch(String bookName, String language2, int noOfBooks, double cost) {

		language.add(new Book(bookName, language2, noOfBooks, cost));

	}

	/**
	 * Get Search Book Details.
	 * 
	 * @return
	 */
	public static List<Book> getSearch() {
		return language;
	}

	/**
	 * Insert book details into DataBase.
	 * 
	 * @param book
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static void saveBook(Book book) throws  CannotGetDetailsException, ClassNotFoundException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
		
			String sql = "insert into bookList(bookName,language,noOfBooks,cost) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, book.getBookName());
			pst.setString(2, book.getLanguage());
			pst.setInt(3, book.getNoOfBooks());
			pst.setDouble(4, book.getCost());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * Add book details into
	 * 
	 * @param bookss
	 * @throws Exception
	 */
	public static void save(List<Book> books) throws Throwable {
		for (Book book : books) {
			saveBook(book);
		}
	}

	/**
	 * Get the book details from Data Base.
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	public static List<Book> getBookDetails() throws CannotGetDetailsException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
            books.clear();
			String url = "select bookName,language,noOfBooks,cost from bookList where noOfBooks>0 ORDER BY bookName";
			con = ConnectionUtil.getConnection();
			
			pst = con.prepareStatement(url);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String bookname = rs.getString("bookName");
				String bookLanguage = rs.getString("language");
				int noOfBooks = rs.getInt("noOfBooks");
				double cost = rs.getDouble("cost");
				
				books.add(new Book(bookname, bookLanguage, noOfBooks, cost));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return books;
	}

	/**
	 * Delete Book from Database.
	 * 
	 * @param bookName
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws NotAbleToDeleteException 
	 * @throws Exception
	 */
	public static boolean deleteBooks(String bookName) throws CannotGetDetailsException, ClassNotFoundException, NotAbleToDeleteException {

		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM bookList WHERE bookName=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, bookName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;

	}
}

