package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.entity.Account; 

@WebServlet({"/log_in"})
public class LoginController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 req.setAttribute("infor", "Đăng nhập");
		req.setAttribute("view","/WEB-INF/views/component/log_in.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Account account = new Account();
		try {
			BeanUtils.populate(account, req.getParameterMap());
		} catch (Exception e) {
			throw new ServletException();
		}
		
		try(EntityManager entityManager = Database.DatabaseHelper.getFactory().createEntityManager()){
			
			TypedQuery<Account> query = entityManager.createQuery(
					"select o from Account o Where o.id = :username and o.password = :password",
					Account.class
					);
			query.setParameter("username", account.getId().toString());
			query.setParameter("password", account.getPassword().toString());
			
			
			try {
				Account fondAccount = query.getSingleResult(); 
				req.getSession().setAttribute("account", fondAccount);
				
				if(fondAccount.isAdmin()) {
					resp.sendRedirect(req.getContextPath() + "/admin");
					
				}else {
					resp.sendRedirect(req.getContextPath() + "/home");
					
				}
				
			} catch (Exception e) {
				 
				resp.sendRedirect(req.getContextPath() + "/log_in");
				
				req.setAttribute("infor", "Đăng nhập thất bại");
			}
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
