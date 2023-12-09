package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
import pc03980.DAO.VideoDAO;
import pc03980.entity.Video; 

@WebServlet({"/admin", "/admin/edit/*", "/admin/create",
	"/admin/update", "/admin/delete"})
public class AdminMainController  extends HttpServlet{

	 @Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				VideoDAO dao = new VideoDAO();
				Video video = new Video();
				String uri = req.getRequestURI();
				 
				req.setAttribute("message", "Thông tin người dùng");
				
				
				if (uri.contains("edit")) {
					// user/edit/id
					String id = uri.substring(uri.lastIndexOf("/") + 1);
					video = dao.findById(id);

				} else if (uri.contains("create")) {
					// user/create

					try {

						BeanUtils.populate(video, req.getParameterMap());
						dao.create(video);
						 
						req.setAttribute("message", "Thêm mới thành công");

					} catch (Exception e) {
						req.setAttribute("message", "Thêm mới thất bại");
					}

				} else if (uri.contains("update")) {
					// user/update
					try {
						BeanUtils.populate(video, req.getParameterMap());
						 
						dao.update(video);
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
			 
			 
	 
				req.setAttribute("form",video); // form user
				req.setAttribute("items", dao.findAll()); // items: List<User>

				req.setAttribute("view","/WEB-INF/views/component/adminQlyVideo.jsp");
				req.getRequestDispatcher("/WEB-INF/views/adminMain.jsp").forward(req, resp);
			
		 }
			 
				 
	
		
		
	}
	
 
 
