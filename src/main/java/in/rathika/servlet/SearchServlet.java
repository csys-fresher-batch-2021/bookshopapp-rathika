package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.rathika.service.BookService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     try {
	    	 String name = request.getParameter("search");
	    	 boolean present = BookService.searchBookByName(name);
	    	 if (present) {
					response.sendRedirect("userSearchDisplay.jsp");
				}
				else {
					response.sendRedirect("userSearchDisplay.jsp?errorMessages=No Books");

				}
	    	 
	     }catch (Exception e) {
               response.sendRedirect("userSearchDisplay.jsp?errorMessage=No books available");
			}
	}

}
