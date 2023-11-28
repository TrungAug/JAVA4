package pc05132.lab6.bai3.untils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pc05132.lab6.bai3.model.UserAcc;

public class VideoUntils {
	private static EntityManagerFactory emf;

	static public EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("PC05132Lab6Bai3");
		}
		return emf.createEntityManager();
	}

	static public void shutDown() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
		emf = null;
	}

//	public static void main(String[] args) {
//		System.out.println(VideoUntils.getEntityManager());
//	}

	public static <T> List<T> excuteQuey(String jpaql, Class<T> myClass) {
		List<T> listT = new ArrayList<>();
		try (EntityManager em = VideoUntils.getEntityManager()) {
			TypedQuery<T> jpQuery = em.createQuery(jpaql, myClass);
			listT = jpQuery.getResultList();
		}
		return listT;
	}

	public static <T> List<T> excuteNamedQuery(String paramName, Object paramValue, String namedQueryName,
			Class<T> myClass) {
		List<T> listT = new ArrayList<>();
		try (EntityManager em = VideoUntils.getEntityManager()) {
			TypedQuery<T> namedQuery = em.createNamedQuery(namedQueryName, myClass);
			namedQuery.setParameter(paramName, paramValue);
			listT = namedQuery.getResultList();

		}
		return listT;
	}

//	public static <T> List<T> excuteNamedQuery(String paramName, Object paramValue, String namedQueryName,Class<T> myClass ){
//		List<T> listT = new ArrayList<>();
//		try(EntityManager em = VideoUntils.getEntityManager()){
//			TypedQuery<T> namedQuery =em.createNamedQuery(namedQueryName, myClass);
//			if (!Objects.isNull(paramName) && paramValue != null) {
//                namedQuery.setParameter(paramName, paramValue);
//                listT = namedQuery.getResultList();
//            }else {
//            	listT = namedQuery.getResultList();
//            }		
//		}	
//		return listT;
//	}

}
