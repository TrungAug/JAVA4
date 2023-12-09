package pc05132.hankook.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.entity.Image;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.Size;
import pc05132.hankook.entity.User;

@WebServlet({ "/product/product-detail" })
public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idDetail = req.getParameter("id");

		if (idDetail != null) {
			Product product = ProductDAO.getInstance().findProdById(idDetail);

			List<Image> images = product.getImages();
			List<Size> sizes = product.getSizes();
			System.out.println(sizes.isEmpty());
				
			
			if (!images.isEmpty()) {
				req.setAttribute("images", images);
			}
			if (!sizes.isEmpty()) {
				req.setAttribute("sizes", sizes);
			}

			req.setAttribute("product", product);
		}

		req.getRequestDispatcher("/WEB-INF/views/templates/productdetail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/templates/productdetail.jsp").forward(req, resp);
	}
}
