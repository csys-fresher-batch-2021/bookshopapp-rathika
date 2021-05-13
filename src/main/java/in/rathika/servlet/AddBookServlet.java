package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.BookService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String language = request.getParameter("language");
		String noOfBook = request.getParameter("noOfBooks");
		int noOfBooks = BookService.isParsable(noOfBook);
		boolean validNoOfBooks = BookService.isValidNumber(noOfBooks);
		String price = request.getParameter("cost");
		int cost = BookService.isParsable(price);

		boolean validCost = BookService.isValidNumber(cost);
		boolean isAdded = false;
		if (validNoOfBooks && validCost) {
			try {
				isAdded = BookService.addProduct(bookName, language, noOfBooks, cost);
			} catch (Exception e) {
				String errorMessage = "Invalid cost or no of books ";
				response.sendRedirect("addBookDeatails.jsp?errorMessage=" + errorMessage);
			}

		}
		if (isAdded) {
			try {
				response.sendRedirect("display.jsp");
			} catch (Exception e) {
				String errorMessage = "Unable to add Books ";
				response.sendRedirect("addBookDetails.jsp?errorMessage=" + errorMessage);
			}

		}

	}

}
