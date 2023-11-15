package pc05132.demo6.cookie.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.demo6.cookie.model.SimpleUser;

@WebServlet({"/user"})
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name_getFromCookie = null;
		
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("userC")) {
					name_getFromCookie = cookie.getValue();
				}
			}
		}
		req.setAttribute("cookie_nameShow", name_getFromCookie);
		req.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleUser us = new SimpleUser();
		
		try {
			DateConverter fmtDate = new DateConverter(new Date());
			fmtDate.setPattern("dd/MM/yyyy");
			ConvertUtils.register(fmtDate,Date.class);		
			
			BeanUtils.populate(us, req.getParameterMap());
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
//		System.out.println(us.getName());
//		System.out.println(us.getDate());
		req.setAttribute("nameIp", us.getName());
		req.setAttribute("dateIp", us.getDate());
		
		
		Cookie cookie = new Cookie("userC",us.getName());
		cookie.setMaxAge(60*5);
		cookie.setPath("/");
		resp.addCookie(cookie);
		
		
		req.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(req, resp);
	}
}
