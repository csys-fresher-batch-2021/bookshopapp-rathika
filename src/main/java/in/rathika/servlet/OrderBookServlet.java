package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			boolean present = OrderService.isPresent(bookName);
			if (!present) {
				isAdded = OrderService.addOrder(bookName, language, noOfBooks, cost);
				HttpSession sess = request.getSession();
				String role = (String) sess.getAttribute("JOB");
				if (isAdded && role != "SEARCHING") {
					response.sendRedirect("addCart.jsp");
				} else if (isAdded && role == "SEARCHING") {
					response.sendRedirect("userSearchDisplay.jsp");
				}

			}
		} catch (Exception e) {
			String errorMessage = "Unable to add";
			response.sendRedirect("addCart.jsp?errorMessage=" + errorMessage);
		}

	}
}
