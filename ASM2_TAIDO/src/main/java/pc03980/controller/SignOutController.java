package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.mail.Session;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.DAO.AccountDAO;
import pc03980.DAO.VideoDAO;
import pc03980.entity.Account;
import Database.DatabaseHelper;

@WebServlet("/signOut")
public class SignOutController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getSession().setAttribute("account", null);
		VideoDAO dao = new VideoDAO();
		 req.setAttribute("items", dao.findAll());
		
		 
		 req.setAttribute("view","/WEB-INF/views/component/main.jsp");
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
 
	}
	
 
