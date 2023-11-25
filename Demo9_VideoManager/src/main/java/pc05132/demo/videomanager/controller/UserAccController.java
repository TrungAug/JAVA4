package pc05132.demo.videomanager.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet({"/user"})
public class UserAccController extends HttpServlet {
	private EntityManagerFactory factory;
	
	@Override
	public void init() throws ServletException {
		factory=Persistence.createEntityManagerFactory("Demo9VideoManager");
	}
	
}
