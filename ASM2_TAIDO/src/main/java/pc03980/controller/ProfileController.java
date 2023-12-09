package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.DAO.AccountDAO;
import pc03980.entity.Account;
import Database.DatabaseHelper;

@WebServlet("/profile")
public class ProfileController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
		Account account = (Account) req.getSession().getAttribute("account");
		 
		BeanUtils.populate(account, req.getParameterMap());
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		 req.setAttribute("infor", "Thông tin cá nhân");
		req.setAttribute("view","/WEB-INF/views/component/profile.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		 
			try {
				Account account = (Account) req.getSession().getAttribute("account");
				AccountDAO dao = new AccountDAO();
				BeanUtils.populate(account, req.getParameterMap());
					 
				
				
				dao.update(account);
				req.setAttribute("infor", "Cập nhật tài khoản thành công!");
				} catch (Exception e) {
				req.setAttribute("infor", "Lỗi cập nhật tài khoản!");
				}

		 
			req.setAttribute("view","/WEB-INF/views/component/profile.jsp");
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
		
	
	}
	
 
