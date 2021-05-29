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
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookName = request.getParameter("bookName");
			HttpSession sess = request.getSession();
			boolean isDeleted = false;
			boolean isOrderDeleted = false;
			String role = (String) sess.getAttribute("JOB");
			if (role != "REMOVE") {
				isDeleted = BookService.deleteBook(bookName);
				if (isDeleted) {
					response.sendRedirect("display.jsp");
				} else {

					String errorMessage = "Unable to delete book Name";
					response.sendRedirect("addBookDetails.jsp?errorMessage=" + errorMessage);
				}
			} else {
				isOrderDeleted = OrderService.deleteBook(bookName);
				if (isOrderDeleted) {
					response.sendRedirect("viewCart.jsp");

				}
			}
		} catch (Exception e) {

			String errorMessage = "Unable to delete book Name";
			response.sendRedirect("viewCart.jsp?errorMessage=" + errorMessage);
		}
	}

}
