package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.rathika.dao.UserDao;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uemail = request.getParameter("emailId");
			String userPassCode = request.getParameter("passCode");

			boolean isValidUser = UserDao.checkUser(uemail, userPassCode);

			String uname = UserDao.getValidUser(uemail);
			
			if (isValidUser) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", uname);
				session.setAttribute("ROLE", "USER");
				response.sendRedirect("addCart.jsp");
			}
		}catch (Exception e) {
			response.sendRedirect("userLogin.jsp?errorMessage=Invalid Login Credentials");
		}
	}
}
