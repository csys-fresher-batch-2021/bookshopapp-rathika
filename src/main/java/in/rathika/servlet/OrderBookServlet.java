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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String bookName = request.getParameter("bookName");
		//boolean present = BookService.isPresent(bookName);
		String language = BookService.getBookLanguage(bookName);
		int noOfBooks = BookService.getNoOfBooks(bookName);
		double cost = BookService.getBookCost(bookName);
		boolean isAdded = false;
		boolean present = OrderService.isPresent(bookName);
		if(!present) {
			isAdded = OrderService.addOrder(bookName, language, noOfBooks, cost);
			if(isAdded) {
				response.sendRedirect("viewCart.jsp");
			}
			else {
				System.out.println("Alraedy added");
			}
		}
		}catch(Exception e) {
			response.sendRedirect("addCart.jsp?errorMessage=Unable to add");	
		}
		
		
		
	}
}
