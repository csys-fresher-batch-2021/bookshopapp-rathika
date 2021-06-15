package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.OrderService;

/**
 * Servlet implementation class AcceptOrderServlet
 */
@WebServlet("/AcceptOrderServlet")
public class AcceptOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String  id = request.getParameter("orderId");
			int orderId = Integer.parseInt(id);
			boolean updated = OrderService.updateStatus(orderId);
			if(updated) {
				response.sendRedirect("viewOrder.jsp");
			}
		}catch(Exception e) {
			response.sendRedirect("viewOrder.jsp?errorMessage=No books available");
		}
	}

}
