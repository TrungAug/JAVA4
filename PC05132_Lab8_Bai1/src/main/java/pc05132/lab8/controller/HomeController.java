package pc05132.lab8.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/home/index","/home/help","/home/promotion" })
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri=req.getRequestURI();
		
		if(uri.contains("index")) {
			req.setAttribute("title", "Home page");
			req.setAttribute("view", "/WEB-INF/views/templates/home.jsp");
		}else if(uri.contains("help")) {
			req.setAttribute("title", "Help page");
			req.setAttribute("view", "/WEB-INF/views/templates/help.jsp");
		}else if(uri.contains("promotion")) {
			req.setAttribute("title", "Promotion page");
			req.setAttribute("view", "/WEB-INF/views/templates/promotion.jsp");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
	}
}
