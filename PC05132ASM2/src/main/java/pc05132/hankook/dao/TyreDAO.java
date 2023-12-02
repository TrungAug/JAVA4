package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Tyre;
import pc05132.hankook.untils.HankookUntils;

public class TyreDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static TyreDAO getInstance() {
		
		return new TyreDAO();
	}
	
	public Tyre findProdById(String id) {
		return em.find(Tyre.class, id);
	}
	
	public List<Tyre> findAll(){
		String jpql = "Select o from Tyre o";
		TypedQuery<Tyre> query = em.createQuery(jpql, Tyre.class);
		List<Tyre> list = query.getResultList();
		return list;
	}
	
	public Tyre create(Tyre o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: TyreDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: TyreDAO create function");
		}

		return o;
	}

	public Tyre update(Tyre o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: TyreDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: TyreDAO update function");
		}
		return o;
	}
	
	
	public Tyre remove(String id) {
		Tyre entity = this.findTyreById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: TyreDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: TyreDAO update function");
		}
		return entity;

	}

	public Tyre findTyreById(String id) {
		return em.find(Tyre.class, id);
	}
} 
