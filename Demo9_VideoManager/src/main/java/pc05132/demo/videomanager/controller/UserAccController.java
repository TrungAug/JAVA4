package pc05132.demo.videomanager.controller;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.demo.videomanager.model.UserAcc;

@WebServlet({"/user","/user/favorites"})
public class UserAccController extends HttpServlet {
	private EntityManagerFactory factory;
	
	@Override
	public void init() throws ServletException {
		factory=Persistence.createEntityManagerFactory("Demo9VideoManager");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try(EntityManager em =factory.createEntityManager()){
			TypedQuery<UserAcc> userQuery=em.createQuery("Select o from UserAcc o", UserAcc.class);
			List<UserAcc> userList =userQuery.getResultList();
			req.setAttribute("userList", userList);
		}
		req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try(EntityManager em =factory.createEntityManager()){
			TypedQuery<UserAcc> userQuery=em.createNamedQuery("UserAcc.findByFavoriteVideo", UserAcc.class);
			userQuery.setParameter("videoId", req.getParameter("videoId"));
			List<UserAcc> userList =userQuery.getResultList();
			req.setAttribute("userList", userList);
		}
		req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
	}
	
}
