package pc05132.hankook.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet({"/home","/templates/signup","/templates/signin","/templates/signin","/templates/updateaccout"})
@WebServlet("/home")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String uri =req.getRequestURI();
//		if(uri.contains("signup")) {
//			System.out.println( "doSingUp()");
//		}else if(uri.contains("signin")) {
//			System.out.println( "doSingIn()");
//		}else if(uri.contains("forgetpass")) {
//			System.out.println( "doForGetpass()");
//		}else if(uri.contains("updateaccout")) {
//			System.out.println( "doUpdateAccout()");
//		}
//			
//		
//		
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
//	}
}
