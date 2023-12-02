package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.RelProductTyre;
import pc05132.hankook.untils.HankookUntils;

public class RelProductTyreDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static RelProductTyreDAO getInstance() {
		
		return new RelProductTyreDAO();
	}
	
	public RelProductTyre findProdById(String id) {
		return em.find(RelProductTyre.class, id);
	}
	
	public List<RelProductTyre> findAll(){
		String jpql = "Select o from RelProductTyre o";
		TypedQuery<RelProductTyre> query = em.createQuery(jpql, RelProductTyre.class);
		List<RelProductTyre> list = query.getResultList();
		return list;
	}
	
	public RelProductTyre create(RelProductTyre o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: RelProductTyreDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: RelProductTyreDAO create function");
		}

		return o;
	}

	public RelProductTyre update(RelProductTyre o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: RelProductTyreDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: RelProductTyreDAO update function");
		}
		return o;
	}
	
	
	public RelProductTyre remove(String id) {
		RelProductTyre entity = this.findRelProductTyreById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: RelProductTyreDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: RelProductTyreDAO update function");
		}
		return entity;

	}

	public RelProductTyre findRelProductTyreById(String id) {
		return em.find(RelProductTyre.class, id);
	}
} 
