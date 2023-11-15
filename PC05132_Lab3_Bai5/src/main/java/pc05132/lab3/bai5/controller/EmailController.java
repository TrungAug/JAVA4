package pc05132.lab3.bai5.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.mail.internet.MimeMultipart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import pc05132.lab3.bai5.model.MailModel;

@MultipartConfig
@WebServlet({ "/mail" })
public class EmailController extends HttpServlet {

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
		MailModel mailmodel = new MailModel();

		try {
			BeanUtils.populate(mailmodel, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");

//		String emailFrom = "trung2894@gmail.com";
		String emailFrom = mailmodel.getEmailf();
		String password = "ludqafyeukrhuiuu";

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailFrom, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailmodel.getEmailf()));
			message.setRecipients(RecipientType.TO, mailmodel.getEmailt());
			message.setSubject(mailmodel.getSubject());
			message.setText(mailmodel.getBody(), "UTF-8", "html");
			message.setReplyTo(null);

			
			Multipart multipart = new MimeMultipart();
			MimeBodyPart bodypart = new MimeBodyPart();
			bodypart.setText(mailmodel.getBody(),"UTF-8","html");
			multipart.addBodyPart(bodypart);
			
			
			Part attachFile = req.getPart("attach_file");
			if(attachFile.getSize()>0) {
				File dir = new File(req.getServletContext().getRealPath("/attchFilesTemp"));
				if(!dir.exists()) {
					dir.mkdirs();
				}
				File fileAttached = new File(dir,attachFile.getSubmittedFileName());
				attachFile.write(fileAttached.getAbsolutePath());
							
				MimeBodyPart attachBodyPart = new MimeBodyPart();
				attachBodyPart.setDataHandler(new DataHandler(new FileDataSource(fileAttached)));
				attachBodyPart.setFileName(attachFile.getSubmittedFileName());
				multipart.addBodyPart(attachBodyPart);
				
			}
			
			message.setContent(multipart);
			
			Transport.send(message);
			req.setAttribute("message", "Gửi email thành công!!!");
		} catch (AddressException e) {
			e.printStackTrace();
			req.setAttribute("message", "Gửi email thất bại!!!");
		} catch (MessagingException e) {
			e.printStackTrace();
			req.setAttribute("message", "Gửi email thất bại!!!");
		}

		req.getRequestDispatcher("/WEB-INF/views/sendmail/mailform.jsp").forward(req, resp);
	}
}
