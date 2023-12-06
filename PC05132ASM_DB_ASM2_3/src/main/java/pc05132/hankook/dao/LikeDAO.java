package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Like;
import pc05132.hankook.untils.HankookUntils;

public class LikeDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static LikeDAO getInstance() {
		
		return new LikeDAO();
	}
	
	public Like findProdById(String id) {
		return em.find(Like.class, id);
	}
	
	public List<Like> findAll(){
		String jpql = "Select o from Like o";
		TypedQuery<Like> query = em.createQuery(jpql, Like.class);
		List<Like> list = query.getResultList();
		return list;
	}
	
	public Like create(Like o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: LikeDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: LikeDAO create function");
		}

		return o;
	}

	public Like update(Like o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: LikeDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: LikeDAO update function");
		}
		return o;
	}
	
	
	public Like remove(String id) {
		Like entity = this.findLikeById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: LikeDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: LikeDAO update function");
		}
		return entity;

	}

	public Like findLikeById(String id) {
		return em.find(Like.class, id);
	}
	
	public Long countLikesByProductId(String productId) {
	    String jpql = "SELECT COUNT(l) FROM Like l WHERE l.product.id = :productId";
	    TypedQuery<Long> query = em.createQuery(jpql, Long.class);
	    query.setParameter("productId", productId);

	    return query.getSingleResult();
	}
} 
