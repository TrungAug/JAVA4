package pc05132.lab3.bai4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/login" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String usernameCookie = CookieUtils.get("usernameC", req);
		String passCookie = CookieUtils.get("passC", req);
		
		req.setAttribute("usernameCookie", usernameCookie);
		req.setAttribute("passwordCookie", passCookie);
		
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		if(!username.equalsIgnoreCase("pc05132")) {
			req.setAttribute("message", "Sai tên đăng nhập");
		}else if(pass.length()<6) {
			req.setAttribute("message", "Mật khẩu không đúng");
		}else {
			req.setAttribute("message", "Đăng nhập thành công");
			
			int hours = (remember==null)?0:30*24;
			CookieUtils.add("usernameC", username, hours, resp);
			CookieUtils.add("passC", pass, hours, resp);
		}
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
	}
}
