package PC05132.Lab1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/", "/home" })
public class HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//xu ly form
		double dai = Double.parseDouble(req.getParameter("chieuDai"));
		double rong = Double.parseDouble(req.getParameter("chieuRong"));
		String loai = req.getParameter("loai");
		
		req.setAttribute("dai", dai);
		req.setAttribute("rong", rong);
		
		if(loai.equalsIgnoreCase("chuvi")) {
			req.setAttribute("ketqua", (dai+rong)*2);
		}else {
			req.setAttribute("ketqua", dai*rong);
		}
		
		//tra ve trang home
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}
}
