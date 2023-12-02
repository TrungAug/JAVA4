package database;
 
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DatabaseHelper implements ServletContextListener{
	private static EntityManagerFactory factory;
	 	
	public static EntityManagerFactory getFactory() {
		return factory;
		
	}
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Khi ung dung chayj
		factory = Persistence.createEntityManagerFactory("VideoManagerWEBProject");
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//khi dung chuong trinh` do
		factory.close();
	}
	
}
