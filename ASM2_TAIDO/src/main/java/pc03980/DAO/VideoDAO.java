package pc03980.DAO;

import java.util.List;

import Database.DatabaseHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc03980.entity.Video; 

public class VideoDAO {
	private EntityManager em =  DatabaseHelper.getFactory().createEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	

	public Video create(Video entity) {
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

	
	
	public Video update(Video entity) {
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

	
	
	public Video remove(String id) {
		Video entity = this.findById(id);
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
	

	
	
	public Video findById(String id) {
		Video entity = em.find(Video.class, id);
		return entity;
	}

	
	public List<Video> findAll() {
		
		try {
			   String jpql = "SELECT o FROM Video o";
			    TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			    List<Video> list = query.getResultList();
			    return list;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	 
	}

	
	
}

