package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.persistence.entity.Piatto;



public class PiattoDao extends AbstractDao<Piatto> {

	@Override
	public Piatto findById(long id) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Piatto p = em.find(Piatto.class, id);
		tx.commit();
		em.close();
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Piatto> findAll() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Piatto> result = em.createNamedQuery("PiattoFindAll").getResultList();
		tx.commit();
		em.close();
		return result;
	}

	public void setCategoria(Long idPiatto, String idCategoria) {
		// TODO Auto-generated method stub

	}

}
