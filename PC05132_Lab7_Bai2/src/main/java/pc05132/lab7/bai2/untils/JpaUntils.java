package pc05132.lab7.bai2.untils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JpaUntils implements ServletContextListener {
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getFactory() {
		return emf;
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("PC05132Lab7Bai2");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		emf.close();
	}

//	static public EntityManager getEntityManager() {
//		if (emf == null || !emf.isOpen()) {
//			emf = Persistence.createEntityManagerFactory("PC05132Lab7Bai2");
//		}
//		return emf.createEntityManager();
//	}
//	
//	static public void shutDown() {
//		if (emf != null && emf.isOpen()) {
//			emf.close();		
//		}
//		emf=null;
//	}
//	public static void main(String[] args) {
//		System.out.println(JpaUntils.getEntityManager());
//	}
}
