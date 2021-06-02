package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.rathika.service.OrderService;

/**
 * Servlet implementation class CofirmOrderServlet
 */
@WebServlet("/CofirmOrderServlet")
public class CofirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		String total = request.getParameter("noBooks");
		int count = Integer.parseInt(total);
		HttpSession session = request.getSession();
		String bookName = (String) session.getAttribute("bookName");
		boolean valid = OrderService.validNoOfBooks(bookName, count);
		if(valid) {
			boolean added = OrderService.addConfrimOrder(bookName, count);
			if(added) {
				response.sendRedirect("displayOrder.jsp");
			}
			else {
				response.sendRedirect("viewCart.jsp?errorMessage=Unable to add");
			}
		}
	}catch(Exception e) {
			response.sendRedirect("viewCart.jsp?errorMessage=Invalid No Of Books");
		}
		
	}

}