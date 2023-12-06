package pc05132.hankook.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home/index*")
public class LikeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userLike=req.getParameter("userLike");
		String idLike=req.getParameter("idLike");
		System.out.println(userLike);
		System.out.println(idLike);
//		if(userLike!=null && idLike!=null) {
//			try {
//				HttpSession httpSession = req.getSession();
//				String getIdUser = (String) httpSession.getAttribute("idUserLiking");
//				String getIdProduct = (String) httpSession.getAttribute("idProLiking");
//				
//				System.out.println("getIdUser " + getIdUser);
//				System.out.println("getIdProduct "+getIdProduct);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		
		
		req.getSession().setAttribute("idUserLiking", userLike);
		req.getSession().setAttribute("idProLiking",idLike);
		resp.sendRedirect(req.getContextPath()+"/home/index?action=doLike&idLike="+idLike+"&userLike="+userLike);
	}
}
