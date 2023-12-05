package pc05132.lab8.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/home/index","/home/contact","/home/about" })
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri=req.getRequestURI();
		
		if(uri.contains("index")) {
			req.setAttribute("title", "Home page");
			req.setAttribute("view", "/WEB-INF/views/templates/home.jsp");
		}else if(uri.contains("contact")) {
			req.setAttribute("title", "Contact page");
			req.setAttribute("view", "/WEB-INF/views/templates/contact.jsp");
		}else if(uri.contains("about")) {
			req.setAttribute("title", "About page");
			req.setAttribute("view", "/WEB-INF/views/templates/about.jsp");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
	}
}
