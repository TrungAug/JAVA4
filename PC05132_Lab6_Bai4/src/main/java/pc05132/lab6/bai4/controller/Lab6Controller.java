package pc05132.lab6.bai4.controller;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab6.bai4.model.Report;
import pc05132.lab6.bai4.model.UserAcc;
import pc05132.lab6.bai4.model.Video;
import pc05132.lab6.bai4.untils.VideoUntils;


@WebServlet({ "/home", "/find/*"})
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
		 
		}else if(uri.contains("report")) {
			
			
			this.doFindReportByYear(req, resp);
			return;
		}
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

	private void doRandomVideo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try(EntityManager em = VideoUntils.getEntityManager()){
			Query query=em.createNamedQuery("Report.random5");
			List<Video> listVd = query.getResultList();
			req.setAttribute("myListRandom", listVd);
		}

		req.getRequestDispatcher("/WEB-INF/views/search/random.jsp").forward(req, resp);
	}

	

	private void doFindReportByYear(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String getYearParam = req.getParameter("year");

        if (getYearParam != null && !getYearParam.isEmpty()) {
            Integer getYear = Integer.valueOf(getYearParam);

            try (EntityManager em = VideoUntils.getEntityManager()) {
                StoredProcedureQuery query = em.createStoredProcedureQuery("Report.favoriteByYear");
                query.setParameter("year", getYear);
                List<Video> listVd = query.getResultList();
                req.setAttribute("myListRP", listVd);
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }

		req.getRequestDispatcher("/WEB-INF/views/search/report.jsp").forward(req, resp);
	}
}
