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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String username = request.getParameter("userName");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			long mobileNum = Long.parseLong(mobile);
			String address = request.getParameter("address");
			String userAge = request.getParameter("age");
			int age = Integer.parseInt(userAge);
			String passCode = request.getParameter("pass");
			String confrimCode = request.getParameter("reenterPass");

			UserService service = new UserService();

			boolean isAdded = service.addDetails(username, email, mobileNum, address, age, passCode, confrimCode);
			if (isAdded) {
				response.sendRedirect("userLogin.jsp");

			}
		}

		catch (Exception e) {
			String errorMessage = "Invalid user details ";
			response.sendRedirect("userRegistration.jsp?errorMessage=" + errorMessage);
		}

	}

}
