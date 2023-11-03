package pc05132.lab2.bai2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet({"/","/dangky","/result"})
public class DangKyController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/param/dangky.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
//		String username = req.getParameter("username");
//		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
//		boolean married = (req.getParameter("married") != null);
//		String country = req.getParameter("country");
//		System.out.println(">>username: " + username);
//		System.out.println(">>gender: " + gender);
//		System.out.println(">>married: " + married);
//		System.out.println(">>country: " + country);
		
		req.getRequestDispatcher("/WEB-INF/views/param/result.jsp").forward(req, resp);
	}
}
