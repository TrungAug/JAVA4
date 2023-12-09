package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.DAO.AccountDAO;
import pc03980.entity.Account;

@WebServlet("/changePass")
public class ChangePassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("infor", "Đổi Mật Khẩu");
		try {

			Account account = (Account) req.getSession().getAttribute("account");
			BeanUtils.populate(account, req.getParameterMap());

		} catch (Exception e) {
			System.out.println("changpassDoget");
			throw new ServletException();
		}

		req.setAttribute("view", "/WEB-INF/views/component/ChangePass.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account account = (Account) req.getSession().getAttribute("account");
		AccountDAO dao = new AccountDAO();
		try {
			String pass = req.getParameter("password");
			String pass1 = req.getParameter("password1");
			String pass2 = req.getParameter("password2");

			Account passs = dao.findById(account.getId());

			if (passs.getPassword().equals(pass)) {
				if (pass1.equals(pass2)) {

					BeanUtils.populate(account, req.getParameterMap());

					account.setPassword(pass2);

					dao.update(account);

					// req.setAttribute("infor",account.getId() +":"+ account.getPassword());
					
				}
				req.setAttribute("infor", "Cập nhật tài khoản thành công!");
			}
		} catch (Exception e) {
			req.setAttribute("infor", "Lỗi cập nhật tài khoản!");
		}

		req.setAttribute("view", "/WEB-INF/views/component/ChangePass.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}

}
