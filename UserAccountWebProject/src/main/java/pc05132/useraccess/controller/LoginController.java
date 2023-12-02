package pc05132.useraccess.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.useraccess.database.DatabaseHelper;
import pc05132.useraccess.entity.Account;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account account = new Account();
		
		try {
			BeanUtils.populate(account, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(EntityManager em =DatabaseHelper.getFactory().createEntityManager()){
			TypedQuery<Account> query = em.createQuery(
					
					"Select o from Account o where o.username=:usernameIp and o.pasword=:passwordIp",
					Account.class
					);
			query.setParameter("usernameIp", account.getUsername());
			query.setParameter("passwordIp", account.getPasword());
			
			
			try {
				Account foundAcount =query.getSingleResult();
				req.getSession().setAttribute("accountSS", foundAcount);
				if(foundAcount.isAdmin()) {
					resp.sendRedirect(req.getContextPath()+"/admin");
				}else {
					resp.sendRedirect(req.getContextPath()+"/user");
				}
			} catch (NoResultException e) {
				resp.sendRedirect(req.getContextPath()+"/login");
			}
			
		}
		
	}
}
	