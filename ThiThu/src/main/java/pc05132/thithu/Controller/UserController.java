package pc05132.thithu.Controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

import pc05132.thithu.model.Account;
import pc05132.thithu.model.ToDoList;
import pc05132.thithu.untils.HankookUntils;

@WebServlet({ "/user/todo", "/user/udpate" })
public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account acccount = (Account) req.getSession().getAttribute("usLogin");
		// String jpql = "select o from ToDoList o";
		String jpql = "select o from ToDoList o where o.account=:acc";
		TypedQuery<ToDoList> qry = HankookUntils.getFactory().createEntityManager().createQuery(jpql, ToDoList.class);
		qry.setParameter("acc", acccount);
		List<ToDoList> listTodo = qry.getResultList();

		req.setAttribute("listTodo", listTodo);
		req.getSession().setAttribute("usLogin", acccount);
		req.getRequestDispatcher("/WEB-INF/views/account/user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		Account account = (Account) req.getSession().getAttribute("usLogin");
		// System.out.println(account==null);
		
			ToDoList todoList = new ToDoList();
			todoList.setAccount(account);

			try {
				BeanUtils.populate(todoList, req.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}

			try (EntityManager em = HankookUntils.getFactory().createEntityManager()) {
				em.getTransaction().begin();
				em.persist(todoList);
				em.getTransaction().commit();
			}
		

		req.getRequestDispatcher("/WEB-INF/views/account/user.jsp").forward(req, resp);
	}
}
