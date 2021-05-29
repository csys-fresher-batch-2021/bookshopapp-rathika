package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.BookService;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		boolean isDeleted = BookService.deleteBook(bookName);
		if(isDeleted) {
			response.sendRedirect("display.jsp");
		}
		else {
			System.out.println("Invaild");
			String errorMessage = "Unable to delete book Name";
			response.sendRedirect("addBookDetails.jsp?errorMessage=" + errorMessage);
		}
	}

}
