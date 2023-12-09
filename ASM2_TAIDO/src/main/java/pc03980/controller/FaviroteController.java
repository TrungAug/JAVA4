package pc03980.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc03980.entity.Account;

@WebServlet("/favorite")
public class FaviroteController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 HttpSession session = req.getSession();
		  
		Account account =  (Account) session.getAttribute("account");
		
		
		req.setAttribute("view","/WEB-INF/views/component/favorite.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
}
