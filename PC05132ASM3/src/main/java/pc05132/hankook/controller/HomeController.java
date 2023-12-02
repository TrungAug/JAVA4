package pc05132.hankook.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.hankook.dao.UserDao;
import pc05132.hankook.entity.User;
import pc05132.hankook.untils.CookiesUntils;

@WebServlet({ "/home", "/user-controller/*" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if (uri.contains("update-account")) {
			this.doUpdate(req, resp);
			return;
		} else if (uri.contains("sign-up")) {
			this.doSignUp(req, resp);
			return;
		} else if (uri.contains("sign-in")) {
			String usName = CookiesUntils.get("userNamec", req);
			String passW =CookiesUntils.get("passWordc", req);
			req.setAttribute("usernameC", usName);
			req.setAttribute("passwordC", passW);
			this.doSignIn(req, resp);
			return;
		} else if (uri.contains("forget-pass")) {
			this.doForgetPassword(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		req.setAttribute("mess", "Welcome Edit profile");
		if (method.equalsIgnoreCase("POST")) {
			System.out.println("Thuc hien chuc nang Edit o day");
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
						req.setAttribute("mess", "Users must be at least 18 years old.");
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
			String userName=req.getParameter("username");
			String passWord=req.getParameter("password");
			
			User checkUserExists=UserDao.getInstance().findUserById(userName);
			if(checkUserExists==null) {
				req.setAttribute("mess", "Wrong username");
			}else {
				if(checkUserExists.getPassWord().equals(passWord)) {
					String remember = req.getParameter("remember");
					int hours = remember==null?0:1; //1 phút
					CookiesUntils.add("userNamec",userName, hours, resp);
					CookiesUntils.add("passWordc",passWord, hours, resp);
										
					if(checkUserExists.isAdmin()) {
						req.setAttribute("mess", "Sign In Successfully as Admin");
						
						//update code của user 
					}else {
						req.setAttribute("mess", "Sign In Successfully as Customer");
						//update code của customer
					}
					
				}else {
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
			System.out.println("Thuc hien chuc nang ForgetPassword o day");
		}

		req.getRequestDispatcher("/WEB-INF/views/account/forget-pass.jsp").forward(req, resp);
	}

}
