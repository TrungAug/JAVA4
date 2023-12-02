package pc05132.lab7.bai2.dao;

import jakarta.persistence.EntityManager;
import pc05132.lab7.bai2.model.AccountMod;
import pc05132.lab7.bai2.untils.JpaUntils;

public class AccountDAO {
	private EntityManager em = JpaUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public static AccountDAO getInstance() {
		return new AccountDAO();
	}

	public AccountMod create(AccountMod acc) {
		try {
			em.getTransaction().begin();
			em.persist(acc);
			em.getTransaction().commit();
			System.out.println("Success from create() AccountDAO");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Fail from create() AccountDAO");
		}
		return acc;
	}
	
	public AccountMod update(AccountMod acc) {
		try {
			em.getTransaction().begin();
			em.merge(acc);
			em.getTransaction().commit();
			System.out.println("Success from update() AccountDAO");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Fail from update() AccountDAO");
			System.out.println(acc==null);
		}
		return acc;
	}

	public AccountMod findById(String id) {
		AccountMod acc = em.find(AccountMod.class, id);

		return acc;
	}
}
