package pc05132.lab5.bai3.untils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUntils {
	private static EntityManagerFactory emf;

	static public EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("PC05132Lab5Bai3");
		}
		return emf.createEntityManager();
	}

	static public void shutdown() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
		emf = null;
	}
//	public static void main(String[] args) {
//		System.out.println(JpaUntils.getEntityManager());
//	}
}
