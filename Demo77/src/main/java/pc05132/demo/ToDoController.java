package pc05132.demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/todo","/todo/add"})
public class ToDoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/todolist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
//		System.out.println(uri);
		
		if(uri.contains("add")) {
			ToDo todoitem = new ToDo();
			
			try {
				BeanUtils.populate(todoitem, req.getParameterMap());
			} catch (IllegalAccessException e) {				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
//			List<ToDo> list = (List<ToDo>) req.getSession().getAttribute("todo_list");
			List<ToDo> list = (List<ToDo>) req.getServletContext().getAttribute("todo_list");
			
//			getSession(), tắt trang sẽ set về gia trị ban đầu,
//			getServletContext() lưu lại giá trị hiện tại khi tắt và mở lại trang ,bị mất khi tắt server
			
//			todo_list một cái tên tự tạo ra nếu chưa có thì taoj thêm ở line 51
			
			if(list==null) {
				list = new ArrayList<>();
//				req.getSession().setAttribute("todo_list", list);
				req.getServletContext().setAttribute("todo_list", list);
			}
			
			list.add(todoitem);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/todolist.jsp").forward(req, resp);
	}
}
