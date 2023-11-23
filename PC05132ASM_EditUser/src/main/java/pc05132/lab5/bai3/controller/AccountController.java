package pc05132.lab5.bai3.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab5.bai3.dao.AccountModDAO;
import pc05132.lab5.bai3.model.AccountMod;

@WebServlet({ "/account/index", "/account/edit/*", "/account/create", "/account/update", "/account/delete" })
public class AccountController extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//		req.getRequestDispatcher("/WEB-INF/account.jsp").forward(req, resp);
//	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountMod acc = new AccountMod();
		String uri = req.getRequestURI();
		String id = req.getParameter("id");
		if (uri.contains("edit")) {
			id = uri.substring(uri.lastIndexOf("/") + 1);
			acc = AccountModDAO.getInstance().findById(id);
		} else if (uri.contains("create")) {		
			if (AccountModDAO.getInstance().findById(id) == null) {
				try {
					BeanUtils.populate(acc, req.getParameterMap());
					AccountModDAO.getInstance().create(acc);
					req.setAttribute("message", "Insert Success");
				} catch (Exception e) {
					req.setAttribute("message", "Insert Failed");
				}
			} else {
				req.setAttribute("message", "Username already exists " + id);
			}

		} else if (uri.contains("update")) {
			try {
				BeanUtils.populate(acc, req.getParameterMap());
				AccountModDAO.getInstance().update(acc);
				req.setAttribute("message", "Update Success");
			} catch (Exception e) {
				req.setAttribute("message", "Update Failed");
			}
		} else if (uri.contains("delete")) {
			if (AccountModDAO.getInstance().findById(id) != null) {
				try {
					AccountModDAO.getInstance().remove(id);
					req.setAttribute("message", "Delete Success");
				} catch (Exception e) {
					req.setAttribute("message", "Delete Failed");
				}
			} else {				
				req.setAttribute("message", "Username does not exist " + id);
			}
		}

		req.setAttribute("form", acc);
		req.setAttribute("listAcc", AccountModDAO.getInstance().findAll());
		req.getRequestDispatcher("/WEB-INF/account.jsp").forward(req, resp);
	}
}
