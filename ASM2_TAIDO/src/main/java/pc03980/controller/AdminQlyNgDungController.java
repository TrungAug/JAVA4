package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.DAO.AccountDAO;
import pc03980.entity.Account; 

@WebServlet({ "/adminQlyNgDung/index", "/adminQlyNgDung/edit/*", "/adminQlyNgDung/create",
	"/adminQlyNgDung/update", "/adminQlyNgDung/delete" })
public class AdminQlyNgDungController  extends HttpServlet{

	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			AccountDAO dao = new AccountDAO();
			Account account = new Account();
			String uri = req.getRequestURI();
			 
			req.setAttribute("message", "Thông tin người dùng");
			
			
			if (uri.contains("edit")) {
				// user/edit/id
				String id = uri.substring(uri.lastIndexOf("/") + 1);
				account = dao.findById(id);

			} else if (uri.contains("create")) {
				// user/create

				try {

					BeanUtils.populate(account, req.getParameterMap());
					dao.create(account);
					 
					req.setAttribute("message", "Thêm mới thành công");

				} catch (Exception e) {
					req.setAttribute("message", "Thêm mới thất bại");
				}

			} else if (uri.contains("update")) {
				// user/update
				try {
					BeanUtils.populate(account, req.getParameterMap());
					 
					dao.update(account);
					req.setAttribute("message", "Cập nhật thành công");

				} catch (Exception e) {
					req.setAttribute("message", "Cập nhật thất bại");
				}

			} else if (uri.contains("delete")) {
				// user/delete
				
				try {

					String id = req.getParameter("id");
					dao.remove(id);
					req.setAttribute("message", "Xóa thành công");

				} catch (Exception e) {
					req.setAttribute("message", "Xóa thất bại");
				}
			}
		 
		 
 
			req.setAttribute("form",account); // form user
			req.setAttribute("items", dao.findAll()); // items: List<User>

		req.setAttribute("view","/WEB-INF/views/component/adminQlyNgDung.jsp");
		req.getRequestDispatcher("/WEB-INF/views/adminMain.jsp").forward(req, resp);
		
	 }
		 
		
		
		
	 
	
}
