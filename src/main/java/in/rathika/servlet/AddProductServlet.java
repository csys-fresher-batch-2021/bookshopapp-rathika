package in.rathika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("AddProductServlet");
		// Step 1: Get Form Values
		
		String bookName = request.getParameter("bookName");
		out.println(bookName);
		//System.out.println("done");
		String language = request.getParameter("language");
		out.println(language);
		int noOfBooks = Integer.parseInt(request.getParameter("noOfBooks"));
		out.println(noOfBooks);
		boolean validNoOfBooks = BookService.isValidNumber(noOfBooks);
		int cost = Integer.parseInt(request.getParameter("cost"));
		out.println(cost);
		boolean validCost = BookService.isValidNumber(cost);
		// Step 2: Call Service => add Product
		boolean isAdded = false;
		if(validNoOfBooks && validCost) {
			isAdded = BookService.addProduct(bookName, language, noOfBooks, cost);
		}
		
		// Step 3: Decide to which page we should redirect ?
		if (isAdded) {
			response.sendRedirect("display.jsp");
		} else {
			String errorMessage = "Unable to add Books ";
			response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
		}


	}
}
