package pc03980.controller;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.mail.Session;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc03980.DAO.VideoDAO;
import pc03980.entity.Account; 
//import pc03980.utils.DatabaseHelper; 

@WebServlet("/home")
public class HomeController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//try(EntityManager entityManager = DatabaseHelper.getFactory().createEntityManager()){
//	TypedQuery<User> query = entityManager.createQuery("select o from o",User.class);
//}
		 HttpSession session = req.getSession();
		 
		  Account account = (Account) session.getAttribute("account");
		  if (account != null) {
	            // Bạn có thể sử dụng thông tin từ đối tượng Account ở đây
	            String id = account.getId();
	             
	           System.out.println("ID : "+id);
	           req.setAttribute("adminn", account.isAdmin());
	        }
		
		  
	
		VideoDAO dao = new VideoDAO();
		if(dao!=null) {
			req.setAttribute("items", dao.findAll());
		}
		 
		
		
		req.setAttribute("view","/WEB-INF/views/component/main.jsp");
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		
		
	}
	
}
