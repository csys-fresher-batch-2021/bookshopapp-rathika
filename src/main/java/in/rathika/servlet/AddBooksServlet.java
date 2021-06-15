package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.exception.CannotGetDetailsException;
import in.rathika.service.BookService;

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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookName = request.getParameter("bookName");
            String language = request.getParameter("language");
			String noOfBook = request.getParameter("noBookId");
			int noOfBooks = Integer.parseInt(noOfBook);
            String price = request.getParameter("costId");
			double cost = Double.parseDouble(price);

			boolean isAdded = BookService.addBook(bookName, language, noOfBooks, cost);
			if (isAdded) {
				response.sendRedirect("addBookDetails.jsp");
			} else {

				response.sendRedirect("addBookDetails.jsp?errorMessage=Unable to add Books");
			}

		} catch (Exception e) {
			response.sendRedirect("addBookDetails.jsp?errorMessage=Not able to add");

		}

	}
}