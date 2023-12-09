package pc03980.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.DAO.VideoDAO;
import pc03980.entity.Video;

@WebServlet("/chiTietPage/index/*")
public class chiTietPageController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();	 
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		
		VideoDAO dao = new VideoDAO();
		Video video = new Video();
		
		video = dao.findById(id); 
		
		req.setAttribute("form",video); // form user
		req.setAttribute("items", dao.findAll()); // items: List<User>
		
		req.setAttribute("view","/WEB-INF/views/component/chitietpage.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
}
