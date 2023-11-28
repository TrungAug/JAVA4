package pc05132.lab6.bai2.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab6.bai2.model.Report;
import pc05132.lab6.bai2.model.UserAcc;
import pc05132.lab6.bai2.model.Video;
import pc05132.lab6.bai2.untils.VideoUntils;


@WebServlet({ "/home", "/find/*"})
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
		} else if (uri.contains("video-id")) {

			String jpaql = "select o from UserAcc o";
			List<UserAcc> listUs = VideoUntils.excuteQuey(jpaql, UserAcc.class);
			req.setAttribute("listUsByVideoId", listUs);

			this.doFindUserByVideoId(req, resp);
			return;
		} else if (uri.contains("favorite-or-not")) {
			String paramFavorite = req.getParameter("favorite");
			String jpaqlVd;
			List<Video> listVd;
			
			if (paramFavorite != null) {				
				boolean favorite = Boolean.parseBoolean(req.getParameter("favorite"));
				
				if (favorite) {
					jpaqlVd = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
				}else {
					jpaqlVd = "select o from Video o WHERE o.favorites IS EMPTY";
				}
				listVd = VideoUntils.excuteQuey(jpaqlVd, Video.class);						
				//Check listVd
//				String kq = favorite ? "THICH" : "KHONG";
//				for (Video video : listVd) {
//					System.out.println(video.getTitle() +" "+ kq);
//				}	
				resp.setContentType("application/json");
				Gson gson = new Gson();
				String jsonData = gson.toJson(listVd);
				resp.getWriter().write(jsonData);
				
			}else {
				jpaqlVd="SELECT o FROM Video o";
				listVd = VideoUntils.excuteQuey(jpaqlVd, Video.class);
				
			}
			
			if(!listVd.isEmpty()) {
				req.setAttribute("myList", listVd);
			}
			req.getRequestDispatcher("/WEB-INF/views/search/favoriteornot.jsp").forward(req, resp);
			//this.doFindByFavorite(req, resp);
			return;
		}else if(uri.contains("report")) {
			String jpql ="Select new Report(o.videox.title,count(o),max(o.likeDate),min(o.likeDate)) From Favorite o Group By o.videox.title"; 
			List<Report> listRP = VideoUntils.excuteQuey(jpql,Report.class);
			
			req.setAttribute("myListRP", listRP);
			req.getRequestDispatcher("/WEB-INF/views/search/report.jsp").forward(req, resp);
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

	private void doFindUserByVideoId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<UserAcc> listUs = VideoUntils.excuteNamedQuery("videoId", req.getParameter("videoIdInput"),
				"UserAcc.findUserFavoriteByVideoId", UserAcc.class);
		req.setAttribute("listUsByVideoId", listUs);

		req.getRequestDispatcher("/WEB-INF/views/search/videoid.jsp").forward(req, resp);
	}

//	private void doFindByFavorite(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		String selectedFavorite = req.getParameter("favorite");
//		String method = req.getMethod();
//		if (method.equalsIgnoreCase("POST")) {
//			boolean favorite = Boolean.parseBoolean(selectedFavorite);
//			List<Video> listVd = VideoUntils.excuteNamedQuery(null, null,
//					favorite ? "Video.findVideoFavorite" : "Video.findVideoNotFavorite", Video.class);
//			if(!listVd.isEmpty()) {
//				req.setAttribute("listVideoByFavorite", listVd);
//			}
//			
//
//		}
//
//		req.getRequestDispatcher("/WEB-INF/views/search/favoriteornot.jsp").forward(req, resp);
//	}
}
