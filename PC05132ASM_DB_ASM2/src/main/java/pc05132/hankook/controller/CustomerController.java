package pc05132.hankook.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.entity.Product;

@WebServlet("/user/customer")
public class CustomerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> listActive = ProductDAO.getInstance().findAllActive(true);
		req.setAttribute("listPActive", listActive);
		req.getRequestDispatcher("/WEB-INF/views/templates/home-customer.jsp").forward(req, resp);
	}
}
