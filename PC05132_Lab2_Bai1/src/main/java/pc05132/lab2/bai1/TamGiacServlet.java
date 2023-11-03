package pc05132.lab2.bai1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/","/tamgiac","/chuvi","/dientich"})
public class TamGiacServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/tamgiac.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a = Double.parseDouble(req.getParameter("a"));
		double b = Double.parseDouble(req.getParameter("b"));
		double c = Double.parseDouble(req.getParameter("c"));
		
		if((a+b>c) && (a+c>b) && (b+c>a)) {
			double chuVi=(a+b+c);
			String uri =req.getRequestURI();
			if(uri.contains("dientich")) {
				double dienTich=Math.sqrt(chuVi*(a+b-c)*(a+c-b)*(b+c-a))/4;
				req.setAttribute("message","Diện tích của tam giác là: "+dienTich);
			}else {
				req.setAttribute("message","Chu vi của tam giác là: "+chuVi);
			}
		}else {
			req.setAttribute("message", "Không thỏa mãn các điều kiện của một tam giác!!!!");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/tamgiac.jsp").forward(req, resp);
	}
}
