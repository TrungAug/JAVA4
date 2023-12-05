package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Share;
import pc05132.hankook.untils.HankookUntils;

public class ShareDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static ShareDAO getInstance() {
		
		return new ShareDAO();
	}
	
	public Share findProdById(String id) {
		return em.find(Share.class, id);
	}
	
	public List<Share> findAll(){
		String jpql = "Select o from Share o";
		TypedQuery<Share> query = em.createQuery(jpql, Share.class);
		List<Share> list = query.getResultList();
		return list;
	}
	
	public Long totalShare(String idProduct) {
		String jpql = "SELECT COUNT(s) FROM Share s WHERE s.product.idPro = :param";
		Long shareCount = em.createQuery(jpql, Long.class)
				.setParameter("param", idProduct)
			    .getSingleResult();
		return shareCount;
	}
	
	public Share create(Share o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: ShareDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: ShareDAO create function");
		}

		return o;
	}

	public Share update(Share o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: ShareDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: ShareDAO update function");
		}
		return o;
	}
	
	
	public Share remove(String id) {
		Share entity = this.findShareById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: ShareDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: ShareDAO update function");
		}
		return entity;

	}

	public Share findShareById(String id) {
		return em.find(Share.class, id);
	}
} 
