package pc05132.hankook.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import org.hibernate.internal.build.AllowSysOut;

import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
import pc05132.hankook.untils.HankookUntils;

@WebServlet({ "/share" })
public class ShareController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		req.getSession().setAttribute("idUserSharing", req.getParameter("user"));
		req.getSession().setAttribute("idProSharing",req.getParameter("idShare"));
		req.getRequestDispatcher("/WEB-INF/views/templates/share.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String idShared = (String) httpSession.getAttribute("idProSharing");
		String idUs= (String) httpSession.getAttribute("idUserSharing");

		try {
			Product product = ProductDAO.getInstance().findProdById(idShared);
			User user = UserDao.getInstance().findUserById(idUs);
			

			if(product!=null && user!=null) {
				String urlSending = "http://localhost:8080/PC05132ASM2/product/product-detail?id="+idShared;
				String emailContent = req.getParameter("sendSharingInputMessage") + "<br>" +urlSending ;
				
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
					message.setSubject("Sharing Proudct");
					message.setText(emailContent, "UTF-8", "html");
					message.setReplyTo(null);
	
					Transport.send(message);
					req.getSession().setAttribute("mess", "The product has been sent to the email. Please check it.!");
				}catch (AddressException e) {
					e.printStackTrace();
					req.getSession().setAttribute("mess", "Email delivery failed!");
				}catch (MessagingException e) {
					e.printStackTrace();
					req.getSession().setAttribute("mess", "Email delivery failed!");
				}
				
				
				Share share = new Share();
				Date dateShare = new Date(System.currentTimeMillis());
				share.setDateShare(dateShare);
				share.setProduct(product);
				share.setUserss(user);
				ShareDAO.getInstance().create(share);
				
				
			}
			
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath()+"/share?action=doShare&idShare="+idShared+"&user="+idUs);
		}
		
		
		
		resp.sendRedirect(req.getContextPath()+"/share?action=doShare&idShare="+idShared+"&user="+idUs);
	}
}
