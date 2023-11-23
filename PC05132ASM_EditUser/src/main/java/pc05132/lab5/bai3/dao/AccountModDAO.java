package pc05132.lab5.bai3.dao;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.lab5.bai3.model.AccountMod;
import pc05132.lab5.bai3.untils.JpaUntils;

public class AccountModDAO {

	private EntityManager em = JpaUntils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public static AccountModDAO getInstance() {
		return new AccountModDAO();
	}

	public AccountMod create(AccountMod account) {
		//AccountMod entity = new AccountMod();
		try {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			System.out.println("Success");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Fail");
			System.out.println(account.toString());
		}
		return account;
	}

	public AccountMod update(AccountMod account) {
		//AccountMod entity = new AccountMod();
		try {
			em.getTransaction().begin();
			em.merge(account);
			em.getTransaction().commit();
			System.out.println("Success");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Fail");
		}
		return account;
	}

	public AccountMod remove(String id) {
		AccountMod entity = this.findById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Success");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Fail");
		}
		return entity;

	}

	public AccountMod findById(String id) {
		AccountMod entity = em.find(AccountMod.class, id);

		return entity;
	}

	public List<AccountMod> findAll() {
		String jpql = "Select o from AccountMod o";
		TypedQuery<AccountMod> query = em.createQuery(jpql, AccountMod.class);
		List<AccountMod> list = query.getResultList();
		return list;
	}
}
