package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Size;
import pc05132.hankook.untils.HankookUntils;

public class SizeDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static SizeDAO getInstance() {
		
		return new SizeDAO();
	}
	
	public Size findProdById(String id) {
		return em.find(Size.class, id);
	}
	
	public List<Size> findAll(){
		String jpql = "Select o from Size o";
		TypedQuery<Size> query = em.createQuery(jpql, Size.class);
		List<Size> list = query.getResultList();
		return list;
	}
	
	public Size create(Size o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: SizeDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: SizeDAO create function");
		}

		return o;
	}

	public Size update(Size o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: SizeDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: SizeDAO update function");
		}
		return o;
	}
	
	
	public Size remove(String id) {
		Size entity = this.findSizeById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: SizeDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: SizeDAO update function");
		}
		return entity;

	}

	public Size findSizeById(String id) {
		return em.find(Size.class, id);
	}
} 
