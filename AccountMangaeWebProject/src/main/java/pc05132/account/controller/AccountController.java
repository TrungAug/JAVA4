package pc05132.account.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.account.database.DatabaseHelper;
import pc05132.account.entity.Account;

@WebServlet({ "/account", "/account/*" })
public class AccountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		if (uri.contains("/delete")) {
			String userName = req.getParameter("username");
			if (userName != null) {
				DatabaseHelper.getSessionFactory().inTransaction(session -> {
					Account account = session.find(Account.class, userName);
					session.remove(account);

				});
				resp.sendRedirect(req.getContextPath() + "/account");
				return;
			}			
		} else if (uri.contains("/update")) {
			String userId = req.getParameter("username");
			if (userId != null && !userId.isBlank()) {
				Account account = DatabaseHelper.getSessionFactory().fromSession(session -> {
					return session.find(Account.class, userId);
				});
				req.setAttribute("user", account);
				req.setAttribute("isUpdate", true);
			}

		}

		DatabaseHelper.getSessionFactory().inSession(session -> {
			Query<Account> query = session.createNamedQuery("Account.FindAll", Account.class);
			List<Account> listUs = query.getResultList();
			req.setAttribute("userList", listUs);
		});

		req.getRequestDispatcher("/WEB-INF/account.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("/create")) {
			Account account = new Account();
			try {
				BeanUtils.populate(account, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			DatabaseHelper.getSessionFactory().inTransaction(sesson -> sesson.persist(account));
		} else if (uri.contains("/update")) {
			Account account = new Account();
			try {
				BeanUtils.populate(account, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			DatabaseHelper.getSessionFactory().inTransaction(sesson -> sesson.merge(account));
		}

		// req.getRequestDispatcher("/account").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/account");
	}
}
