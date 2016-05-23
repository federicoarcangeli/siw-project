package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

/**
 * classe astratta per DAO
 * 
 * @author Federico
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {
	private static final String PERSISTENCE_UNIT_NAME = "restaurant-unit";
	private static EntityManagerFactory emf;
	
	public AbstractDao() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	}

	/**
	 * persiste l'entità
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		em.close();
	}

	/**
	 * elimina l'entità
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		T toRemove = em.merge(entity);
		em.remove(toRemove);
		tx.commit();
		em.close();
	}

	/**
	 * aggiorna il riferimento all'entità
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(entity);
		tx.commit();
		em.close();
	}

	public static EntityManager getEntityManager() {
		EntityManager em =  emf.createEntityManager();
		return em;
	}
	
	public void closeEnityManagerFactory() {
		if(emf.isOpen()) {
			emf.close();
		}
	}

	/**
	 * resituisce l'oggetto di tipo T con identificativo id
	 * 
	 * @param id
	 * @return un oggetto T
	 */
	public abstract T findById(long id);

	/**
	 * restituisce la lista degli oggetti di tipo T attraverso la query findAll
	 * 
	 * @return una lista di oggetti di tipo T
	 */
	public abstract List<T> findAll();

}
