package pc05132.lab4.bai2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc05132.lab4.bai2.dao.UsersDao;
import pc05132.lab4.bai2.model.Users;

@WebServlet({ "/users" })
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Users> userList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		userList = Arrays.asList(new Users[] { new Users("Username1", "Password1", false),
//				new Users("Username2", "Password2", true), new Users("Username3", "Password3", true),
//				new Users("Username4", "Password4", false), new Users("Username5", "Password5", true) }
//
//		);
		userList = UsersDao.getInstance().myData();
		req.setAttribute("items", userList);

		req.getRequestDispatcher("WEB-INF/views/users/homeindex.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rmb = req.getParameter("remeber");

		try {
			Users us = new Users();
			if (rmb == null) {
				us.setRemember(false);
			} else {
				us.setRemember(true);
			}
			BeanUtils.populate(us, req.getParameterMap());
//			UsersDao.getInstance().save(us);
			userList.add(us);
			req.setAttribute("items", userList);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("WEB-INF/views/users/homeindex.jsp").forward(req, resp);
	}
}
