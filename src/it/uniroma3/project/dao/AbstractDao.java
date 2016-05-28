package it.uniroma3.project.dao;

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
	private EntityManager em;
	
	public AbstractDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * persiste l'entità
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		em.persist(entity);
	}

	/**
	 * elimina l'entità
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		em.remove(entity);
	}

	/**
	 * aggiorna il riferimento all'entità
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		em.merge(entity);
	}

	public static EntityManager getEntityManager() {
		EntityManager em =  EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
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
