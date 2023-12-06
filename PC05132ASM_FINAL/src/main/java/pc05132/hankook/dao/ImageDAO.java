package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Image;
import pc05132.hankook.untils.HankookUntils;

public class ImageDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static ImageDAO getInstance() {
		
		return new ImageDAO();
	}
	
	public Image findProdById(String id) {
		return em.find(Image.class, id);
	}
	
	public List<Image> findAll(){
		String jpql = "Select o from Image o";
		TypedQuery<Image> query = em.createQuery(jpql, Image.class);
		List<Image> list = query.getResultList();
		return list;
	}
	
	public Image create(Image o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: ImageDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: ImageDAO create function");
		}

		return o;
	}

	public Image update(Image o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: ImageDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: ImageDAO update function");
		}
		return o;
	}
	
	
	public Image remove(String id) {
		Image entity = this.findImageById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: ImageDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: ImageDAO update function");
		}
		return entity;

	}

	public Image findImageById(String id) {
		return em.find(Image.class, id);
	}
} 
