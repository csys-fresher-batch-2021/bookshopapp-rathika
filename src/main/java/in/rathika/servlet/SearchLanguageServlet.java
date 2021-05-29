package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.rathika.service.BookService;

/**
 * Servlet implementation class SearchLanguageServlet
 */
@WebServlet("/SearchLanguageServlet")
public class SearchLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String language= request.getParameter("language");
			boolean added = BookService.searchBookByLanguage(language);
			if(added) {
				
					response.sendRedirect("userSearchDisplay.jsp");
				}
				
			
			
		}catch(Exception e) {
			String errorMessage = "Unable to add Books ";
			response.sendRedirect("userSearchDisplay.jsp?errorMessage=" + errorMessage);
		}
		
	}

}
