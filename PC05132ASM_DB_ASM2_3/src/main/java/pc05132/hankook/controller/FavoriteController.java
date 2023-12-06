package pc05132.hankook.controller;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.User;
import pc05132.hankook.untils.HankookUntils;

@WebServlet({ "/home/favorite" })
public class FavoriteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(userLogin!=null) {
			try(EntityManager em = HankookUntils.getFactory().createEntityManager()){
				TypedQuery<Product> qry = em.createNamedQuery("Favorite.SelectProductByUser", Product.class);
				qry.setParameter("user",userLogin);
				List<Product> listprod = qry.getResultList();
				req.setAttribute("listFavorite", listprod);
			}
		}
	
		
		
		req.getRequestDispatcher("/WEB-INF/views/templates/favorite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/templates/favorite.jsp").forward(req, resp);
	}
}
