package pc05132.hankook.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

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
import jakarta.mail.internet.MimeMultipart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import pc05132.hankook.dao.LikeDAO;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.dao.UserDao;
import pc05132.hankook.entity.Like;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.Tyre;
import pc05132.hankook.entity.User;
import pc05132.hankook.untils.CookiesUntils;
import pc05132.hankook.untils.HankookUntils;

@WebServlet({ "/home/index", "/user-controller/*" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();


		String userLike = req.getParameter("userLike");
		String idLike = req.getParameter("idLike");

		List<Product> listActive = ProductDAO.getInstance().findAllActive(true);
		List<Tyre> listTyre = HankookUntils.excuteNamedQueryNoParam("Tyre.FindAll", Tyre.class);
		if (uri.contains("update-account")) {
			this.doUpdate(req, resp);
			return;
		} else if (uri.contains("sign-up")) {

			this.doSignUp(req, resp);
			return;
		} else if (uri.contains("sign-in") || uri.contains("side-bar-sign-in")) {
			String usName = CookiesUntils.get("userNamec", req);
			String passW = CookiesUntils.get("passWordc", req);
			req.setAttribute("usernameC", usName);
			req.setAttribute("passwordC", passW);
			this.doSignIn(req, resp);
			return;
		} else if (uri.contains("forget-pass")) {
			this.doForgetPassword(req, resp);
			return;
		} else if (uri.contains("sign-out")) {
			this.doSignOut(req, resp);
			return;
		} else if (uri.contains("home/index")) {
			if (userLike != null && idLike != null) {
				Product product = ProductDAO.getInstance().findProductById(idLike);
				User user = UserDao.getInstance().findUserById(userLike);
				if (product != null && user != null) {
					java.sql.Date dateLike = new java.sql.Date(System.currentTimeMillis());
					Like like = new Like();
					like.setDateLike(dateLike);
					like.setProduct(product);
					like.setUserss(user);
					LikeDAO.getInstance().create(like);
				}
				
			}

		}
		req.setAttribute("listTyre", listTyre);
		req.setAttribute("listPActive", listActive);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);

	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String method = req.getMethod();
		req.setAttribute("mess", "Welcome! Edit your profile and please enter the correct username first.!");
		if (method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("idUs");
			String admin = req.getParameter("admin");
			User checkUserExists = UserDao.getInstance().findUserById(id);
			if (checkUserExists != null) {
				try {
					String dateStringInput = req.getParameter("birthDay");
					SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
					Date datePare = fmtDate.parse(dateStringInput);
					java.sql.Date userDate = new java.sql.Date(datePare.getTime());
					LocalDate birthDay = userDate.toLocalDate();
					LocalDate currentDate = LocalDate.now();
					Period agePeriod = Period.between(birthDay, currentDate);

					int age = agePeriod.getYears();

					if (age < 18) {
						req.setAttribute("mess", "User must be at least 18 years old.");
					} else {
						try {
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);
							User updateUser = new User();

							if (admin == null) {
								updateUser.setAdmin(false);
							} else {
								updateUser.setAdmin(true);
							}

							BeanUtils.populate(updateUser, req.getParameterMap());
							UserDao.getInstance().update(updateUser);
							req.setAttribute("mess", "Update was successful.");
						} catch (Exception e) {
							req.setAttribute("mess", "Update was fail.");
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					req.setAttribute("mess", "Please double-check the information.");
					e.printStackTrace();
				}
			} else {
				req.setAttribute("mess", "The username does not exist. Please enter it again.");
			}

		}

		req.getRequestDispatcher("/WEB-INF/views/account/update-account.jsp").forward(req, resp);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Sign Up");
		if (method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("idUs");
			User checkUserExists = UserDao.getInstance().findUserById(id);
			if (checkUserExists == null) {
				try {
					String dateStringInput = req.getParameter("birthDay");
					SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
					Date datePare = fmtDate.parse(dateStringInput);
					java.sql.Date userDate = new java.sql.Date(datePare.getTime());
					LocalDate birthDay = userDate.toLocalDate();
					LocalDate currentDate = LocalDate.now();
					Period agePeriod = Period.between(birthDay, currentDate);

					int age = agePeriod.getYears();

					if (age < 18) {
						req.setAttribute("mess", "User must be at least 18 years old.");
					} else {
						try {
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);
							User createUser = new User();

							BeanUtils.populate(createUser, req.getParameterMap());
							UserDao.getInstance().create(createUser);
							req.setAttribute("mess", "Registration was successful.");

						} catch (Exception e) {
							req.setAttribute("mess", "Registration was fail.");
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					req.setAttribute("mess", "Please double-check the information.");
					e.printStackTrace();
				}
			} else {
				req.setAttribute("mess", "Username already exists.");
			}
		}

		req.getRequestDispatcher("/WEB-INF/views/account/sign-up.jsp").forward(req, resp);
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Sign In");
		if (method.equalsIgnoreCase("POST")) {
			String userName = req.getParameter("username");
			String passWord = req.getParameter("password");

			User checkUserExists = UserDao.getInstance().findUserById(userName);
			if (checkUserExists == null) {
				req.setAttribute("mess", "Wrong username");
			} else {
				if (checkUserExists.getPassWord().equals(passWord)) {
					String remember = req.getParameter("remember");
					int hours = remember == null ? 0 : 1; // 1 phút
					CookiesUntils.add("userNamec", userName, hours, resp);
					CookiesUntils.add("passWordc", passWord, hours, resp);

					// lưu đối tương đăng nhập vào session

					req.getSession().setAttribute("userLogin", checkUserExists);

					if (checkUserExists.isAdmin()) {
						req.setAttribute("mess", "Sign In Successfully as Admin");
						resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
						return;

					} else {
						req.setAttribute("mess", "Sign In Successfully as Customer");

						resp.sendRedirect(req.getContextPath() + "/home/favorite");
						return;
					}

				} else {
					req.setAttribute("mess", "Wrong password");
				}
			}

		}

		req.getRequestDispatcher("/WEB-INF/views/account/sign-in.jsp").forward(req, resp);
	}

	private void doForgetPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome To Forget Password");
		if (method.equalsIgnoreCase("POST")) {
			String emailTo = req.getParameter("emailTo");
			String username = req.getParameter("username");

			User user = UserDao.getInstance().findUserById(username);
			if (user == null) {
				req.setAttribute("mess", "Wrong Username. Please input again!");
			} else {
				if (user.getEmail().equals(emailTo)) {
					String emailText = "Your Password is: " + user.getPassWord();

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
						message.setRecipients(RecipientType.TO, emailTo);
						message.setSubject("Password Recovery Instruction");
						message.setText(emailText, "UTF-8", "html");
						message.setReplyTo(null);

						Transport.send(message);
						req.setAttribute("mess", "The password has been sent to your email. Please check it.!");
					} catch (AddressException e) {
						e.printStackTrace();
						req.setAttribute("mess", "Email delivery failed!");
					} catch (MessagingException e) {
						e.printStackTrace();
						req.setAttribute("mess", "Email delivery failed!");
					}

				} else {
					req.setAttribute("mess", "Wrong Email. Please input again!");
				}
			}
		}

		req.getRequestDispatcher("/WEB-INF/views/account/forget-pass.jsp").forward(req, resp);
	}

	private void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/home/index");
	}
}
