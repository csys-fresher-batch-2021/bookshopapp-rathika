package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.BookService;

/**
 * Servlet implementation class SearchByCostServlet
 */
@WebServlet("/SearchByCostServlet")
public class SearchByCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String cost = request.getParameter("cost");
			int type = Integer.parseInt(cost);
			boolean added = BookService.searchBookByCost(type);
			if (added) {
				response.sendRedirect("userSearchDisplay.jsp");
			}

		} catch (Exception e) {

			response.sendRedirect("userSearchDisplay.jsp?errorMessage=Unable to add Books ");
		}

	}

}
