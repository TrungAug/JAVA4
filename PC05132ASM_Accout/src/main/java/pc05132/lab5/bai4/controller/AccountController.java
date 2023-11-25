package pc05132.lab5.bai4.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab5.bai4.dao.AccountDAO;
import pc05132.lab5.bai4.model.AccountMod;

@WebServlet({ "/home","/account/sign-in", "/account/sign-up", "/account/edit-profile" })
public class AccountController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		if (uri.contains("sign-in")) {
			this.doSignIn(req, resp);
		} else if (uri.contains("sign-up")) {
			this.doSignUp(req, resp);
		} else if (uri.contains("edit-profile")) {
			this.doEditProfile(req, resp);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome to Sign in");
		if (method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("username");
			String pw = req.getParameter("password");
			AccountMod accCheck = AccountDAO.getInstance().findById(id);
			if (accCheck != null) {
				if (accCheck.getPassWord().equals(pw)) {
					req.setAttribute("mess", "Sign in Success");
				} else {
					req.setAttribute("mess", "Wrong password");
				}
			} else {
				req.setAttribute("mess", "Wrong username");
			}
		}

		req.getRequestDispatcher("/WEB-INF/views/account/sign-in.jsp").forward(req, resp);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome to Sign up");
		if (method.equalsIgnoreCase("POST")) {
			AccountMod newAcc = new AccountMod();
			String id = req.getParameter("id");
			AccountMod accCheck = AccountDAO.getInstance().findById(id);
			if(accCheck==null) {
				try {
					BeanUtils.populate(newAcc, req.getParameterMap());
					AccountDAO.getInstance().create(newAcc);
					req.setAttribute("mess", "Sign up Success");
				} catch (Exception e) {
					req.setAttribute("mess", "Sign up Failed");
				}
			}else {
				req.setAttribute("mess", "Username already exists " + id);
			}
		}
		req.getRequestDispatcher("/WEB-INF/views/account/sign-up.jsp").forward(req, resp);
	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("mess", "Welcome Edit profile");
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("id");	
			AccountMod editAcc = new AccountMod();
//			AccountMod acc = (AccountMod) req.getSession().getAttribute("editAcc");			
//			System.out.println("doEditProfile" +id);
//			System.out.println("doEditProfile acc==null" + acc==null);
//			System.out.println("doEditProfile acc!=null" + acc!=null);
//			System.out.println(acc);
			 if (id != null && !id.isEmpty()) {
				 AccountMod accCheck = AccountDAO.getInstance().findById(id);
					if(accCheck!=null) {
						try {							
							BeanUtils.populate(editAcc, req.getParameterMap());
							AccountDAO.getInstance().update(editAcc);
							req.setAttribute("mess", "Update Success");
						} catch (Exception e) {
							req.setAttribute("mess", "Update Failed");
						}
					}else {
						req.setAttribute("mess", "Username does not exists " + id);
					}
			 }else {
				 req.setAttribute("mess", "Invalid ID");
			 }		
		}

		req.getRequestDispatcher("/WEB-INF/views/account/edit-profile.jsp").forward(req, resp);
	}
}
