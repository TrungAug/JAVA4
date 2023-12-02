package pc05132.counter.helper;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DatabaseHelper implements ServletContextListener {
	private static EntityManagerFactory factory;
 	
	public static EntityManagerFactory getFactory() {
		return factory;
		
	}
	
	@Override
	public void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
		factory=Persistence.createEntityManagerFactory("CounterWeb");
	}
	
	@Override
	public void contextDestroyed(jakarta.servlet.ServletContextEvent sce) {
		factory.close();
	}
	
}
