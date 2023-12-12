package pc05132.finaltest.controller;

import java.io.IOException;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.finaltest.entity.Account;
import pc05132.finaltest.untils.CookiesUntils;
import pc05132.finaltest.untils.PC05132Untils;


@WebServlet({ "/user/login" })
public class LoginContronller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		if (uri.contains("login")) {

			this.doSignIn(req, resp);
			return;
		}

		req.getRequestDispatcher("/WEB-INF/views/templates/login.jsp").forward(req, resp);
	}

	protected void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Sign In");
		if (method.equalsIgnoreCase("POST")) {
			String userName = req.getParameter("username");
			String passWord = req.getParameter("password");

			try {
				String jpql = "select o from Account o where o.username=:userName";
				TypedQuery<Account> qry = PC05132Untils.getFactory().createEntityManager().createQuery(jpql,Account.class);
				qry.setParameter("userName", userName);
				Account account = qry.getSingleResult();
				
				if (account == null) {
					req.setAttribute("mess", "Wrong username");
				} else {
					if (account.getPassword().equals(passWord)) {
						String remember = req.getParameter("remember");
						int hours = remember == null ? 0 : 1; // 1 phút
						CookiesUntils.add("userNamec", userName, hours, resp);
						CookiesUntils.add("passWordc", passWord, hours, resp);

						// lưu đối tương đăng nhập vào session

						req.getSession().setAttribute("account", account);

						if (account.isAdmin()) {
							req.setAttribute("mess", "Sign In Successfully as Admin");
							resp.sendRedirect(req.getContextPath() + "/admin/add");
							return;

						} else {
							req.setAttribute("mess", "Sign In Successfully as Customer");

							resp.sendRedirect(req.getContextPath() + "/customer/add");
							return;
						}

					} else {
						req.setAttribute("mess", "Wrong password");
					}
				}
			} catch (Exception e) {
				req.setAttribute("mess", "Wrong password");
			}
			
					
		}
		req.getRequestDispatcher("/WEB-INF/views/templates/login.jsp").forward(req, resp);
	}
	
	
	
}
