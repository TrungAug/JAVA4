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

@WebServlet({ "/detail" })
public class DetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Item> listItem;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		listItem=ItemDAO.getInstance().myData();
		String prodIndex = req.getParameter("index");
		//System.out.println(prodIndex);
		try {
			int index =Integer.parseInt(prodIndex);
		//	System.out.println(listItem.get(index).toString());
			req.setAttribute("i", listItem.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/products/detail.jsp").forward(req, resp);
	}
}
