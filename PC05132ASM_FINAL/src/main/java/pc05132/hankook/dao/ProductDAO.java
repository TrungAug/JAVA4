package pc05132.hankook.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pc05132.hankook.entity.Product;
import pc05132.hankook.untils.HankookUntils;

public class ProductDAO {
	private EntityManager em = HankookUntils.getFactory().createEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public static ProductDAO getInstance() {
		
		return new ProductDAO();
	}
	
	public Product findProdById(String id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> findAll(){
		String jpql = "Select o from Product o";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public List<Product> findAllActive(boolean active){
		String jpql = "Select o from Product o where o.active=:param";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("param", active);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public Product create(Product o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			System.out.println("Insert Successful: ProductDAO create function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Insert Failed: ProductDAO create function");
		}

		return o;
	}

	public Product update(Product o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			System.out.println("Update Successful: ProductDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Update Failed: ProductDAO update function");
		}
		return o;
	}
	
	
	public Product remove(String id) {
		Product entity = this.findProductById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete Successful: ProductDAO update function");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Delete Failed: ProductDAO update function");
		}
		return entity;

	}

	public Product findProductById(String id) {
		return em.find(Product.class, id);
	}
} 
