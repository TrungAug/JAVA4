package pc05132.hankook.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc05132.hankook.entity.User;

@WebServlet({ "/home/help" })
public class HelpAndSupportController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session = req.getSession();
//		User userLogin = (User) session.getAttribute("userLogin");
//		if (userLogin != null) {
//			if (userLogin.isAdmin()) {
//				req.getRequestDispatcher("/WEB-INF/views/templates/home-admin.jsp").forward(req, resp);
//			} else {
//				req.getRequestDispatcher("/WEB-INF/views/templates/home-customer.jsp").forward(req, resp);
//			}
//		} else {
//			req.getRequestDispatcher("/WEB-INF/views/templates/help.jsp").forward(req, resp);
//		}
		
		req.getRequestDispatcher("/WEB-INF/views/templates/help.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/templates/help.jsp").forward(req, resp);
	}
}
