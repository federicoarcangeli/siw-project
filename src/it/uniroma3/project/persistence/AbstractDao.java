package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

/**
 * classe astratta DAO
 * 
 * @author Federico
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {
	public EntityManagerFactory emf;

	public AbstractDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * resituisce l'oggetto T con identificativo id
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
