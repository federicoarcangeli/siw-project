package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.persistence.entity.CategoriaPiatto;;

public class CategoriaPiattoDao extends AbstractDao<CategoriaPiatto> {


	@Override
	public CategoriaPiatto findById(long id) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CategoriaPiatto result = em.find(CategoriaPiatto.class,id);
		tx.commit();
		em.close();
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaPiatto> findAll() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<CategoriaPiatto> result = em.createNamedQuery("CategoriaPiattoFindAll").getResultList();
		tx.commit();
		em.close();
		return result;
	}

}
