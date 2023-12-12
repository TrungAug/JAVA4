package pc05132.thithu.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.thithu.model.Account;
import pc05132.thithu.untils.HankookUntils;

@WebServlet("/home/login")
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/sign-in.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//		System.out.println(username);
//		System.out.println(password);
 		
		
		try {
			String jpql = "select o from Account o where o.username=:userName";
			TypedQuery<Account> qry = HankookUntils.getFactory().createEntityManager().createQuery(jpql,Account.class);
			qry.setParameter("userName", username);
			Account account = qry.getSingleResult();
			if(account==null) {
				req.setAttribute("mess", "Sai tên đăng nhập");
		
			}else if(!account.getPassword().equals(password)) {
				req.setAttribute("mess", "Sai mật khẩu");
				
			}else {
				req.getSession().setAttribute("usLogin", account);
				if(account.isRole()) {
					resp.sendRedirect(req.getContextPath()+"/admin/editor-user");
					return;
				}else {
					resp.sendRedirect(req.getContextPath()+"/user/todo");
					return;
				}
			}
		} catch (Exception e) {
			req.setAttribute("mess", "Sai tên đăng nhập");
		}
		
		
		
		req.getRequestDispatcher("/WEB-INF/sign-in.jsp").forward(req, resp);
	}
}
