package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("userName");
			String userPassCode = request.getParameter("password");
			boolean isValid = "Admin".equals(username) && "admin".equals(userPassCode);
			if (isValid) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("ROLE", "ADMIN");
			
				response.sendRedirect("addBookDetails.jsp");
			}
		}catch (Exception e) {
			response.sendRedirect("adminLogin.jsp?errorMessage=Invalid Login Credentials");
		}
	}

}
