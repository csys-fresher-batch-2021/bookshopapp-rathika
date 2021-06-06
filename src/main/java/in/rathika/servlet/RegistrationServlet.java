package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rathika.service.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String username = request.getParameter("userName");
			String email = request.getParameter("email");
			String mobileNumber = request.getParameter("mobile");
			long userMobileNum = Long.parseLong(mobileNumber);
			String address = request.getParameter("address");
			String userAge = request.getParameter("age");
			int validAge = Integer.parseInt(userAge);
			String password = request.getParameter("pass");
			String confrimPassCode = request.getParameter("reenterPass");

			UserService service = new UserService();

			boolean isAdded = service.addDetails(username, email, userMobileNum, address, validAge, password,
					confrimPassCode);
			if (isAdded) {
				response.sendRedirect("userLogin.jsp");

			}
		} catch (Exception e) {
			response.sendRedirect("userRegistration.jsp?errorMessage=Invalid user details");
		}

	}
}