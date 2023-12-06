package pc05132.hankook.untils;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HankookUntils implements ServletContextListener {
	
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getFactory() {
		return emf;
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("PC05132ASM2HANKOOK");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		emf.close();
	}
	
	
	public static <T> List<T> excuteQuey(String jpaql, Class<T> myClass) {
		List<T> listT = new ArrayList<>();
		try (EntityManager em = HankookUntils.getFactory().createEntityManager()) {
			TypedQuery<T> jpQuery = em.createQuery(jpaql, myClass);
			listT = jpQuery.getResultList();
		}
		return listT;
	}

	public static <T> List<T> excuteNamedQuery(String paramName, Object paramValue, String namedQueryName,
			Class<T> myClass) {
		List<T> listT = new ArrayList<>();
		try (EntityManager em = HankookUntils.getFactory().createEntityManager()) {
			TypedQuery<T> namedQuery = em.createNamedQuery(namedQueryName, myClass);
			namedQuery.setParameter(paramName, paramValue);
			listT = namedQuery.getResultList();

		}
		return listT;
	}
	
	public static <T> List<T> excuteNamedQueryNoParam(String namedQueryName,
			Class<T> myClass) {
		List<T> listT = new ArrayList<>();
		try (EntityManager em = HankookUntils.getFactory().createEntityManager()) {
			TypedQuery<T> namedQuery = em.createNamedQuery(namedQueryName, myClass);
			listT = namedQuery.getResultList();

		}
		return listT;
	}
	
	
	
	
//	static public EntityManager getEntityManager() {
//		if(emf==null || !emf.isOpen()) {
//			emf=Persistence.createEntityManagerFactory("PC05132ASM2HANKOOK");
//		}
//		return emf.createEntityManager();
//	}
//	static public void shutDown() {
//		if (emf != null && emf.isOpen()) {
//			emf.close();		
//		}
//		emf=null;
//	}
	
//	public static void main(String[] args) {
//		System.out.println(HankookUntils.getEntityManager());
//	}
}
