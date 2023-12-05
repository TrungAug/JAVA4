package pc05132.hankook.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.dao.ShareDAO;
import pc05132.hankook.dao.UserDao;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.Share;
import pc05132.hankook.entity.User;

@WebServlet({"/share"})
public class ShareController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idShare = req.getParameter("idShare");
		String urlSending ="http://localhost:8080/PC05132ASM2/product/product-detail?id="+idShare;
		String emailContent = req.getParameter("sendSharingInputMessage") + "<br>" + urlSending;
		HttpSession httpsession = req.getSession();
		User userLogin = (User) httpsession.getAttribute("userLogin");
		Product product = ProductDAO.getInstance().findProdById(idShare);
		//Long sharesCount = ShareDAO.getInstance().totalShare(idShare) ;
		if(userLogin!=null) {
			//Gửi mail
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");

			String emailFrom = "trung2894@gmail.com";
			String password = "ludqafyeukrhuiuu";

			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailFrom, password);
				}
			});
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(emailFrom));
				message.setRecipients(RecipientType.TO, req.getParameter("sendSharingInputEmail"));
				message.setSubject("Password Recovery Instruction");
				message.setText(emailContent, "UTF-8", "html");
				message.setReplyTo(null);

				Transport.send(message);
				req.setAttribute("mess", "The product has been sent to the email. Please check it.!");
				
				Share share = new Share();
				Date dateShare = new Date(System.currentTimeMillis());
				share.setDateShare(dateShare);
				share.setProduct(product);
				share.setUserss(userLogin);
				ShareDAO.getInstance().create(share);
				//sharesCount++;
				//req.setAttribute("sharesCount",sharesCount);
				resp.sendRedirect(req.getContextPath()+"/home/index");
			} catch (AddressException e) {
				e.printStackTrace();
				req.setAttribute("mess", "Email delivery failed!");
			} catch (MessagingException e) {
				e.printStackTrace();
				req.setAttribute("mess", "Email delivery failed!");
			}
		}
		
		
		req.setAttribute("mess", "Welcome to your sharing!");
		req.getRequestDispatcher("/WEB-INF/views/templates/share.jsp").forward(req, resp);
	}
	
}
