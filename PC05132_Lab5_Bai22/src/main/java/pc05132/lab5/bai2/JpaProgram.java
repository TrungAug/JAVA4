package pc05132.lab5.bai2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaProgram {

	private static void create() {
		UserEntity entity = new UserEntity();
		entity.setId("pc05132");
		entity.setFullname("Nguyen Thanh Trung");
		entity.setEmail("trungntpc05132@fpt.edu.vn");
		entity.setPassword("12345678");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PC05132Lab5Bai2Console");
		// System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		// System.out.println(em);
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Thêm mới thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
			e.printStackTrace();
		}
		em.close();
		emf.close();

	}

	private static void update() {
	}

	private static void delete() {
	}

	private static void findAll() {
	}

	private static void findByRole(boolean role) {
	}

	private static void findByKeyword(String keyword) {
	}

	private static void findOne(String username, String password) {
	}

	private static void findPage(int page, int size) {
	}

	public static void main(String[] args) {
		create();
//		update();
//		delete();
//		findAll();
//		findByRole(false);
//		findByKeyword(null);
//		findOne(null, null);
//		findPage(0, 0);	
	}

}
