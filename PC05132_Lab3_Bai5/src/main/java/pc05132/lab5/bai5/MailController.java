package pc05132.lab5.bai5;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/mail"})
public class MailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/sendmail/mailform.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				String username="trungntpc05132@fpt.edu.vn";
				String pass="123";
				return new PasswordAuthentication(username, pass);
			}
		
		});
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/sendmail/mailform.jsp").forward(req, resp);
	}
}
