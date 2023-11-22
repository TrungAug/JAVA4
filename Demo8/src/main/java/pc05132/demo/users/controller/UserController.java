package pc05132.demo.users.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.demo.users.model.Userss;

@WebServlet({ "/user" })
public class UserController extends HttpServlet {

	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		super.init();
//		emf=Persistence.createEntityManagerFactory("UserDatabaseWebProjectDemo");
		try {
			emf = Persistence.createEntityManagerFactory("UserDatabaseWebProjectDemo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EntityManager em = emf.createEntityManager();
			List<Userss> list= em.createQuery("Select o From Userss o",Userss.class).getResultList();
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Userss user = new Userss();

		try {
			BeanUtils.populate(user, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		try {
		    EntityManager manager = emf.createEntityManager();
		    manager.getTransaction().begin();
		    try {
		        manager.persist(user);
		        manager.getTransaction().commit();
		    } catch (Exception e) {
		        manager.getTransaction().rollback();
		    } finally {
		        if (manager != null && manager.isOpen()) {
		            manager.close();
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/user");
	}
}
