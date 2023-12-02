package pc05132.counter.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class CountListener implements ServletContextListener, HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		int visitCount = (int) se.getSession().getServletContext().getAttribute("visitCount");
		int onlineCount = (int) se.getSession().getServletContext().getAttribute("onlineCount");
		
		visitCount++;
		onlineCount++;
		
		se.getSession().getServletContext().setAttribute("visitCount", visitCount);
		se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
	
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		int onlineCount= (int) se.getSession().getServletContext().getAttribute("onlineCount");
		onlineCount--;
		
		se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("visitCount", 0);
		sce.getServletContext().setAttribute("onlineCount",0);
	}
	
}
