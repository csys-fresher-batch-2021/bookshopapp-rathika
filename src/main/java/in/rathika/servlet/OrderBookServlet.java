package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.BookService;
import in.rathika.service.OrderService;

/**
 * Servlet implementation class OrderBookServlet
 */
@WebServlet("/OrderBookServlet")
public class OrderBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String bookName = request.getParameter("bookName");

			String language = BookService.getBookLanguage(bookName);
			int noOfBooks = BookService.getNoOfBooks(bookName);
			double cost = BookService.getBookCost(bookName);
			boolean isAdded = false;
			
			
				isAdded = OrderService.addOrder(bookName, language, noOfBooks, cost);
				if (isAdded) {
					response.sendRedirect("viewCart.jsp");
				}

			
		} catch (Throwable e) {
			response.sendRedirect("addCart.jsp?errorMessage=Unable to add");
		}

	}
}