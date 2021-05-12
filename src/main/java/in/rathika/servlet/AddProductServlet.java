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
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Step 1: Get Form Values
		
		String bookName = request.getParameter("bookName");
		
		
		String language = request.getParameter("language");
		String noOfBook = request.getParameter("noOfBooks");
		int noOfBooks = BookService.isParsable(noOfBook);
		boolean validNoOfBooks = BookService.isValidNumber(noOfBooks);
		String price = request.getParameter("cost");
		int cost = BookService.isParsable(price);
		
		boolean validCost = BookService.isValidNumber(cost);
		// Step 2: Call Service => add Product
		boolean isAdded = false;
			if(validNoOfBooks && validCost) {
				try {
					isAdded = BookService.addProduct(bookName, language, noOfBooks, cost);
				}catch(Exception e) {
					String errorMessage = "Invalid data ";
					response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
				}
				
			}
			if (isAdded) {
				try {
					response.sendRedirect("display.jsp");
				}catch(Exception e) {
					String errorMessage = "Unable to add Books ";
					response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
				}
				
			} 

		}
		

	}

