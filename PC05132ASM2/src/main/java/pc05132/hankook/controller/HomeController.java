package pc05132.hankook.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/home","/user-controller/*"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
//		System.out.println("URI: " + uri);
			
		
		if(uri.contains("update-account")) {		
			this.doUpdate(req, resp);
			return;
		}else if(uri.contains("sign-up")) {
			this.doSignUp(req, resp);
			return;
		}else if(uri.contains("sign-in")) {
			this.doSignIn(req, resp);
			return;
		}else if(uri.contains("forget-pass")) {
			this.doForgetPassword(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
	
	
	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome Edit profile");
		if(method.equalsIgnoreCase("POST")) {
			System.out.println("Thuc hien chuc nang Edit o day");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/account/update-account.jsp").forward(req, resp);
	}
	
	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Sign Up");
		if(method.equalsIgnoreCase("POST")) {
			System.out.println("Thuc hien chuc nang dang ky o day");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/account/sign-up.jsp").forward(req, resp);
	}
	
	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Sign In");
		if(method.equalsIgnoreCase("POST")) {
			System.out.println("Thuc hien chuc nang dang nhap o day");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/account/sign-in.jsp").forward(req, resp);
	}
	
	private void doForgetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Forget Password");
		if(method.equalsIgnoreCase("POST")) {
			System.out.println("Thuc hien chuc nang ForgetPassword o day");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/account/forget-pass.jsp").forward(req, resp);
	}

}
