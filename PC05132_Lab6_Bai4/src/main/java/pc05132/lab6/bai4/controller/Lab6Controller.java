package pc05132.lab6.bai4.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab6.bai4.model.Report;
import pc05132.lab6.bai4.model.UserAcc;
import pc05132.lab6.bai4.model.Video;
import pc05132.lab6.bai4.untils.VideoUntils;

@WebServlet({ "/home", "/find/*" })
public class Lab6Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("random")) {

			this.doRandomVideo(req, resp);
			return;

		} else if (uri.contains("favorite-by-year")) {

			//String jpql = "Select new Report(o.videox.title,count(o),max(o.likeDate),min(o.likeDate)) From Favorite o Group By o.videox.title";
			
			String method = req.getMethod();

			if (method.equalsIgnoreCase("GET")) {
				String getYearParam = req.getParameter("year");

				if (getYearParam != null && !getYearParam.isEmpty() && getYearParam.matches("\\d+")) {
					Integer getYear = Integer.valueOf(getYearParam);

					try (EntityManager em = VideoUntils.getEntityManager()) {
						StoredProcedureQuery query = em.createStoredProcedureQuery("spFavoriteByYear");

						if (getYear != null) {
							query.registerStoredProcedureParameter("year", Integer.class, ParameterMode.IN);
							query.setParameter("year", getYear);
						}
						List<Report> listRp = new ArrayList<>();
						;
						List<Object[]> listO = query.getResultList();
						// System.out.println(listO.isEmpty());

						if (!listO.isEmpty()) {
							for (Object[] objects : listO) {
								String titleString = (String) objects[0];
								Integer likes = ((Number) objects[1]).intValue();
								Date newest = (Date) objects[2];
								Date oldest = (Date) objects[3];
								Report reporta = new Report(titleString, likes, newest, oldest);
								listRp.add(reporta);
							}
							req.setAttribute("myListRP", listRp);
						} else {
							req.setAttribute("mess", "Không có video được thích trong năm " + getYear);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			

			this.doFindFavoriteByYear(req, resp);
			return;
		}

		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	private void doRandomVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (EntityManager em = VideoUntils.getEntityManager()) {
			Query query = em.createNamedQuery("Report.random5");
			List<Video> listVd = query.getResultList();
			req.setAttribute("myListRandom", listVd);
		}

		req.getRequestDispatcher("/WEB-INF/views/search/random.jsp").forward(req, resp);
	}

	private void doFindFavoriteByYear(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getMethod();

		if (method.equalsIgnoreCase("POST")) {
			String getYearParam = req.getParameter("year");

			if (getYearParam != null && !getYearParam.isEmpty() && getYearParam.matches("\\d+")) {
				Integer getYear = Integer.valueOf(getYearParam);

				try (EntityManager em = VideoUntils.getEntityManager()) {
					StoredProcedureQuery query = em.createStoredProcedureQuery("spFavoriteByYear");

					if (getYear != null) {
						query.registerStoredProcedureParameter("year", Integer.class, ParameterMode.IN);
						query.setParameter("year", getYear);
					}
					List<Report> listRp = new ArrayList<>();
					;
					List<Object[]> listO = query.getResultList();
					// System.out.println(listO.isEmpty());

					if (!listO.isEmpty()) {
						for (Object[] objects : listO) {
							String titleString = (String) objects[0];
							Integer likes = ((Number) objects[1]).intValue();
							Date newest = (Date) objects[2];
							Date oldest = (Date) objects[3];
							Report reporta = new Report(titleString, likes, newest, oldest);
							listRp.add(reporta);
						}
						req.setAttribute("myListRP", listRp);
					} else {
						req.setAttribute("mess", "Không có video được thích trong năm " + getYear);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		req.getRequestDispatcher("/WEB-INF/views/search/favoritebyyear.jsp").forward(req, resp);
	}
}
