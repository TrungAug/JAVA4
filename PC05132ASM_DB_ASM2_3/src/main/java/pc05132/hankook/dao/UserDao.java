package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.User;
import pc05132.hankook.untils.HankookUntils;

public class UserDao {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public static UserDao getInstance() {
		return new UserDao();
	}

	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			System.out.println("Insert Successful: UserDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: UserDAO create function");
		}

		return user;
	}

	public User update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			System.out.println("Update Successful: UserDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: UserDAO update function");
		}
		return user;
	}
	
	
	public User remove(String id) {
		User entity = this.findUserById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: UserDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: UserDAO update function");
		}
		return entity;

	}

	public User findUserById(String id) {
		return em.find(User.class, id);
	}

	public List<User> findAll() {
		String jpql = "Select o from User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
}
