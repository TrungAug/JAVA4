package pc05132.lab5.bai1.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab5.bai1.model.RegisterUser;


@WebServlet({"/register"})
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	String message="Chào mừng bạn đến với đăng ký tài khoản";
	
	@Override
	public void init() throws ServletException {
		super.init();
		emf=Persistence.createEntityManagerFactory("PC05132Lab5Register");
//		System.out.println(emf);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager em =emf.createEntityManager();
//		System.out.println(em);
		
		req.setAttribute("mess", message);
		
		req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Hi dopost");
		RegisterUser acc = new RegisterUser();
		String isAdminValue = req.getParameter("isAdmin");
		if(isAdminValue==null) {
			acc.setAdmin(false);
		}else {
			acc.setAdmin(true);
		}
		
		try {
			BeanUtils.populate(acc,req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();
			try {
				manager.persist(acc);
				manager.getTransaction().commit();
				message="Đăng ký thành công";
			} catch (Exception e) {
				message="Đăng ký thất bại";
				manager.getTransaction().rollback();
			}finally {
				if (manager != null && manager.isOpen()) {
		            manager.close();
		        }
			}
		} catch (Exception e) {
			message="Đăng ký thất bại";
			e.printStackTrace();		
		}		
		resp.sendRedirect(req.getContextPath()+"/register");
	}
}
