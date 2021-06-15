package in.rathika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.rathika.dao.OrderDao;
import in.rathika.service.OrderService;

/**
 * Servlet implementation class CofirmOrderServlet
 */
@WebServlet("/CofirmOrderServlet")
public class CofirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String total = request.getParameter("noBooks");
			int count = Integer.parseInt(total);
			HttpSession session = request.getSession();
			String bookName = (String) session.getAttribute("bookName");
			boolean valid = OrderService.validNoOfBooks(bookName, count);
			
			int totalCount = OrderService.getUpdatedBooks(bookName);
			
            
			boolean updated = OrderDao.updateBooks(bookName, totalCount - count);
			
			if (valid && updated) {
				HttpSession sess = request.getSession();
				String userName = (String) sess.getAttribute("LOGGED_IN_USER");
				boolean added = OrderService.addConfrimOrder(userName,bookName, count);
				
				if (added) {
					response.sendRedirect("displayOrder.jsp");
				} else {
					response.sendRedirect("viewCart.jsp?errorMessage=Unable to add");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("viewCart.jsp?errorMessage=Invalid No Of Books");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
