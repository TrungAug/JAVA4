package PC05132.Demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/","/form","/love"})
public class RadioLoveFormController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LoveBean lovebean = new LoveBean();
		
		try {
			BeanUtils.populate(lovebean, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String fullname =req.getParameter("fullname");
//		String gender =req.getParameter("gender");
//		String married =req.getParameter("married");
//		String [] hobby =req.getParameterValues("hobby");
//		
//		System.out.println(fullname);
//		System.out.println(gender);
//		System.out.println(married);
//		System.out.println(hobby==null?"None":Arrays.toString(hobby));
		

		System.out.println(lovebean.getFullname());
		System.out.println(lovebean.getGender());
		System.out.println(lovebean.isMarried());
		System.out.println(Arrays.toString(lovebean.getHobby()));
		
		
		req.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(req, resp);
	}
}
