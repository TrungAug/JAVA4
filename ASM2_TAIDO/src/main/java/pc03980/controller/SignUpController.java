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
import pc03980.DAO.AccountDAO;
import pc03980.entity.Account; 

@WebServlet({"/signUp"})
public class SignUpController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 req.setAttribute("infor", "Đăng ký");
		req.setAttribute("view","/WEB-INF/views/component/dangKy.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Account account = new Account();
		AccountDAO dao = new AccountDAO();
		 
		
		try {

			BeanUtils.populate(account, req.getParameterMap());
			dao.create(account);
			 
			req.setAttribute("infor", "Đăng ký thành công");

		} catch (Exception e) {
			req.setAttribute("infor", "Đăng ký thất bại");
		}
			
		 req.setAttribute("infor", "Đăng ký thành công");
			req.setAttribute("view","/WEB-INF/views/component/dangKy.jsp");
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
 
