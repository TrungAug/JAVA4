package pc03980.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminThongKe")
public class AdminThongKeController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 
		req.setAttribute("view","/WEB-INF/views/component/adminThongKe.jsp");
		req.getRequestDispatcher("/WEB-INF/views/adminMain.jsp").forward(req, resp);
		
		
		
	}
	
}
