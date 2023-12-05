package pc05132.hankook.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.hankook.dao.UserDao;
import pc05132.hankook.entity.User;

@WebServlet({"/admin/editor-user","/admin/edit/*","/admin/create","/admin/update","/admin/delete"})
public class EditUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		User editUser= new User();
		String id = req.getParameter("idUs");
		
		if(uri.contains("edit")) {
			id=uri.substring(uri.lastIndexOf("/") + 1);			
			editUser = UserDao.getInstance().findUserById(id);			
		}else if(uri.contains("create")) {			
			if(UserDao.getInstance().findUserById(id)==null) {
				try {
					DateTimeConverter dtc = new DateConverter(new Date());
					dtc.setPattern("MM/dd/yyyy");
					ConvertUtils.register(dtc, Date.class);
					
					BeanUtils.populate(editUser, req.getParameterMap());
					//System.out.println(editUser.toString());
					UserDao.getInstance().create(editUser);
					req.setAttribute("message", "Insert Success");
				} catch (Exception e) {
					req.setAttribute("message", "Insert Failed");
				}
			}else {
				req.setAttribute("message", "Username already exists " + id);
			}
		}else if(uri.contains("update")) {
			if(UserDao.getInstance().findUserById(id)!=null) {
				try {
					DateTimeConverter dtc = new DateConverter(new Date());
					dtc.setPattern("MM/dd/yyyy");
					ConvertUtils.register(dtc, Date.class);
					
					BeanUtils.populate(editUser, req.getParameterMap());
					System.out.println(editUser.toString());
					UserDao.getInstance().update(editUser);
					req.setAttribute("message", "Update Success");
				} catch (Exception e) {
					req.setAttribute("message", "Update Failed");
				}
			}else {
				req.setAttribute("message", "Username "+id+ " does not exists");
			}
		}else if(uri.contains("delete")) {
			if(UserDao.getInstance().findUserById(id)!=null) {
				try {
					UserDao.getInstance().remove(id);
					req.setAttribute("message", "Delete Success");
				} catch (Exception e) {
					req.setAttribute("message", "Delete Failed");
				}
			}else {
				req.setAttribute("message", "Username "+id+ " does not exists");
			}
		}
		
		req.setAttribute("form", editUser);
		req.setAttribute("listUs",UserDao.getInstance().findAll());
		req.getRequestDispatcher("/WEB-INF/views/templates/edit-user.jsp").forward(req, resp);
	}
}
