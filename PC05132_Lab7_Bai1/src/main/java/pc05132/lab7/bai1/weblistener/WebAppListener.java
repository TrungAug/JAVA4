package pc05132.lab7.bai1.weblistener;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class WebAppListener implements HttpSessionListener,ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//ghi
		ServletContext application = sce.getServletContext();
		Integer vistors = (Integer) application.getAttribute("visitor");
		try {
			String path = application.getRealPath("/visitor.txt");
			byte[] data = String.valueOf(vistors).getBytes();
			Files.write(Paths.get(path), data, StandardOpenOption.CREATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//đọc
		ServletContext application = sce.getServletContext();
		Integer visitors =0;
		
		try {
			String path = application.getRealPath("/visitor.txt");
			List<String> lines = Files.readAllLines(Paths.get(path));
			visitors=Integer.valueOf(lines.get(0));
		} catch (Exception e) {
			visitors=99;
		}
		application.setAttribute("visitor", visitors);
	}
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//tăng
		HttpSession session = se.getSession();
		ServletContext application =session.getServletContext();
		Integer visitors = (Integer) application.getAttribute("visitor");
		application.setAttribute("visitor", visitors+1);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
}
