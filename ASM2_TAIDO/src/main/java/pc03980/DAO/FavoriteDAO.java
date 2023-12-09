package pc03980.DAO;

import java.util.List;

import Database.DatabaseHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc03980.entity.Favorite;
import pc03980.entity.Video; 

public class FavoriteDAO {
	private EntityManager em =  DatabaseHelper.getFactory().createEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	

 
	 
	

	
	
	public Favorite findById(String id) {
		Favorite entity = em.find(Favorite.class, id);
		return entity;
	}

	
	public List<Favorite> findAll() {
		
		try {
			   String jpql = "SELECT o FROM Video o";
			    TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			    List<Favorite> list = query.getResultList();
			    return list;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	 
	}

	
	
}

