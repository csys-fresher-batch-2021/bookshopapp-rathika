package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.BookService;
import in.rathika.validator.BookValidator;

/**
 * Servlet implementation class AddBooksServlet
 */
@WebServlet("/AddBooksServlet")
public class AddBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookName = request.getParameter("bookName");
			boolean isValidName = BookValidator.isBookNameValid(bookName);
			String language = request.getParameter("language");
			String noOfBook = request.getParameter("noOfBooks");
			int noOfBooks = Integer.parseInt(noOfBook);
			boolean validNoOfBooks = BookValidator.isValidNumber(noOfBooks);
			String price = request.getParameter("cost");
			double cost = Double.parseDouble(price);

			boolean validCost = BookValidator.isCostValid(cost);

			boolean isAdded = false;
			if (isValidName && validNoOfBooks && validCost) {

				isAdded = BookService.addBook(bookName, language, noOfBooks, cost);
				if (isAdded) {
					response.sendRedirect("addBookDetails.jsp");
				} else {
					String errorMessage = "Unable to add Books ";
					System.out.println("I am here");
					response.sendRedirect("addBookDetails.jsp?errorMessage=" + errorMessage);
				}
			}
              
		} catch (Exception e) {
			
			response.sendRedirect("addBookDetails.jsp?errorMessage=Not able to add");
		
		}

	}
}
