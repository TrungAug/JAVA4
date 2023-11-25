package pc05132.hankook.untils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HankookUntils {
	private static EntityManagerFactory emf;
	static public EntityManager getEntityManager() {
		if(emf==null || !emf.isOpen()) {
			emf=Persistence.createEntityManagerFactory("PC05132ASM2HANKOOK");
		}
		return emf.createEntityManager();
	}
	static public void shutDown() {
		if (emf != null && emf.isOpen()) {
			emf.close();		
		}
		emf=null;
	}
	
	public static void main(String[] args) {
		System.out.println(HankookUntils.getEntityManager());
	}
}
