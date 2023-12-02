package pc05132.lab7.bai2.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab7.bai2.dao.AccountDAO;
import pc05132.lab7.bai2.model.AccountMod;

@WebServlet({ "/home", "/account/*" })
public class AccountController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("sign-in")) {
			req.getRequestDispatcher("/WEB-INF/views/account/sign-in.jsp").forward(req, resp);
		}

		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("username");
		String pw = req.getParameter("password");
		try {
			AccountMod accCheck = AccountDAO.getInstance().findById(id);
			if(accCheck!=null) {
				if(accCheck.getPassWord().equals(pw)) {
					//System.out.println(accCheck.toString());
					
					req.getSession().setAttribute("userLogin", accCheck); //check lại
					req.getSession().setAttribute("mess","Đăng nhập thành công");
					resp.sendRedirect(req.getContextPath() + "/account/result");
				}else {
					req.getSession().setAttribute("mess","Sai mật khẩu");
					resp.sendRedirect(req.getContextPath() + "/account/sign-in");
				}
				
			}else {
				req.getSession().setAttribute("mess","Sai tên đăng nhập");
				resp.sendRedirect(req.getContextPath() + "/account/sign-in");
			}
		} catch (NoResultException e) {		
			resp.sendRedirect(req.getContextPath() + "/account/sign-in");
		}		
	}

}
