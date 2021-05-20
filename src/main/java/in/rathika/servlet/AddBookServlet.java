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
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			String bookName = request.getParameter("bookName");
			
			
			String language = request.getParameter("language");
			String noOfBook = request.getParameter("noOfBooks");
			int noOfBooks = Integer.parseInt(noOfBook);
			
			
			
			String price = request.getParameter("cost");
			
			int cost = Integer.parseInt(price);

			
		
            BookService service = new BookService();
			boolean isAdded = service.addBook(bookName, language, noOfBooks, cost);
			if(isAdded) {
				response.sendRedirect("addBookDetails.jsp");
			}
		}catch(Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("addBookDetails.jsp?errorMessage=" + errorMessage);
		}
			

	}

}
