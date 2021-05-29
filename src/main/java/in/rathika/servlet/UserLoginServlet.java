package in.rathika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.rathika.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String userPassCode = request.getParameter("passCode");
			UserService user = new UserService();
			boolean isValidUser = user.checkUser(userName,userPassCode);
			if(isValidUser) {
				//String username = UserService.getUserName(userId);
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", userName);
				session.setAttribute("ROLE", "USER");
				response.sendRedirect("addCart.jsp");
				
			}
		}catch(Exception e) {
			response.sendRedirect("login.jsp?errorMessage=Invalid Login Credentials");
		}
	}
	}


