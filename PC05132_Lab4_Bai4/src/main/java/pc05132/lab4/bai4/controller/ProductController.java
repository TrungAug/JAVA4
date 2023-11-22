package pc05132.lab4.bai4.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab4.bai4.DAO.ItemDAO;
import pc05132.lab4.bai4.entity.Item;

@WebServlet({ "/products" })
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Item> itemList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		itemList = ItemDAO.getInstance().myData();
		req.setAttribute("itemss", itemList);

		req.getRequestDispatcher("/WEB-INF/views/products/product.jsp").forward(req, resp);
	}

	
}
