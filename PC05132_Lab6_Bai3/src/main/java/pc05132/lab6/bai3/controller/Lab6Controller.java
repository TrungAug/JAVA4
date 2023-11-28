package pc05132.lab6.bai3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab6.bai3.model.Report;
import pc05132.lab6.bai3.model.UserAcc;
import pc05132.lab6.bai3.model.Video;
import pc05132.lab6.bai3.untils.VideoUntils;

@WebServlet({ "/home", "/find/*" })
public class Lab6Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("user-id")) {
			String jpaql = "select o from UserAcc o";
			List<UserAcc> listUs = VideoUntils.excuteQuey(jpaql, UserAcc.class);
			req.setAttribute("listUsByUserId", listUs);

			String jpaqlVd = "select o from Video o";
			List<Video> listVd = VideoUntils.excuteQuey(jpaqlVd, Video.class);
			req.setAttribute("listVideoByUserId", listVd);

			this.doFindVideoByUserId(req, resp);
			return;
		} else if (uri.contains("keyword")) {

			String jpaqlVd = "select o from Video o";
			List<Video> listVd = VideoUntils.excuteQuey(jpaqlVd, Video.class);
			req.setAttribute("listVideoByKeyword", listVd);

			this.doFindByKeyWord(req, resp);
			return;
		} else if (uri.contains("by-date")) {

			this.doFindUserByDate(req, resp);
			return;
		} else if (uri.contains("by-month")) {
			String jpaqlVd = "select o from Video o";
			List<Video> listVd = VideoUntils.excuteQuey(jpaqlVd, Video.class);
			req.setAttribute("myListByMonth", listVd);
			
			this.doFindByMonth(req, resp);
			return;
		}

		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	private void doFindVideoByUserId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<UserAcc> listUs = VideoUntils.excuteNamedQuery("paramUserId", req.getParameter("usernameInput"),
				"UserAcc.getUserByUserId", UserAcc.class);
		req.setAttribute("listUsByUserId", listUs);

		List<Video> listVd = VideoUntils.excuteNamedQuery("paramUserId", req.getParameter("usernameInput"),
				"Video.findFavoriteVideoByUserId", Video.class);
		req.setAttribute("listVideoByUserId", listVd);

		req.getRequestDispatcher("/WEB-INF/views/search/userid.jsp").forward(req, resp);
	}

	private void doFindByKeyWord(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Video> listVd = VideoUntils.excuteNamedQuery("paramKeyword", "%" + req.getParameter("keywordInput") + "%",
				"Video.findVideoByKeyWord", Video.class);

		// System.out.println(listVd.isEmpty());
		req.setAttribute("listVideoByKeyword", listVd);
		req.getRequestDispatcher("/WEB-INF/views/search/keyword.jsp").forward(req, resp);
	}

	private void doFindUserByDate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//
//		List<UserAcc> listUs = VideoUntils.excuteNamedQuery("videoId", req.getParameter("videoIdInput"),
//				"UserAcc.findUserFavoriteByVideoId", UserAcc.class);
//		req.setAttribute("listUsByVideoId", listUs);

		req.getRequestDispatcher("/WEB-INF/views/search/bydate.jsp").forward(req, resp);
	}

	private void doFindByMonth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
//		System.out.println(method);
		if(method.equalsIgnoreCase("POST")) {
			String[] values = req.getParameterValues("month");
			if(values==null) {
				req.setAttribute("mess","Vui lòng chọn tháng");
			}else {
				List<Integer> months = new ArrayList<Integer>();
				for (String month : values) {
					//System.out.println(month);
					months.add(Integer.valueOf(month));
				}
				
				List<Video> listVd =VideoUntils.excuteNamedQuery("months", months, "Video.findInMonths",Video.class);
				
				if(listVd.isEmpty()) {
					req.setAttribute("mess","Không có video trong tháng " +months.toString());
				}
				
				req.setAttribute("myListByMonth", listVd);
			}	
		}

		req.getRequestDispatcher("/WEB-INF/views/search/bymonth.jsp").forward(req, resp);
	}
}
