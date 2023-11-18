package pc05132.lab3.bai3.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab3.bai3.DAO.ItemDAO;
import pc05132.lab3.bai3.entity.Item;

@WebServlet({ "/detail" })
public class DetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Item> itemList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		itemList=ItemDAO.getInstance().myData();
		req.setAttribute("item", itemList);
		
		req.getRequestDispatcher("/WEB-INF/views/products/detail.jsp").forward(req, resp);
	}
}
