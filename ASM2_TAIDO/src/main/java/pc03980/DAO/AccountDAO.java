package pc03980.DAO;

import java.util.List;

import Database.DatabaseHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc03980.entity.Account; 

public class AccountDAO {

	private EntityManager em = DatabaseHelper.getFactory().createEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	

	public Account create(Account entity) {
		try {
			
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
			
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);		
		}
	}

	
	
	public Account update(Account entity) {
		try {
			
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
			
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);		
		}
	}

	
	
	public Account remove(String id) {
		Account entity = this.findById(id);
		try {
			
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
			
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);		
		}
	}
	

	
	
	public Account findById(String id) {
		Account entity = em.find(Account.class, id);
		return entity;
	}

	
	public List<Account> findAll() {
		
		try {
			   String jpql = "SELECT o FROM Account o";
			    TypedQuery<Account> query = em.createQuery(jpql, Account.class);
			    List<Account> list = query.getResultList();
			    return list;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	 
	}

	
	
}
