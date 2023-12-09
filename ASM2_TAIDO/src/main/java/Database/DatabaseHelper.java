package Database;

 
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener; 


@WebListener
public class DatabaseHelper implements ServletContextListener {
	private static EntityManagerFactory factory;
	 
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		  try {
	            factory = Persistence.createEntityManagerFactory("ASM2_TAIDO");
	        } catch (Exception e) {
	        	 System.out.println("Error initializing EntityManagerFactory: " + e.getMessage());
	          
	            e.printStackTrace();
	        
	    }
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (factory != null) {
	        factory.close();
	    }
	}
	
}