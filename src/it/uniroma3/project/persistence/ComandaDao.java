package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {


	@Override
	public Comanda findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> findAll() {
		EntityManager em = super.getEntityManager();
		Query query = em.createNamedQuery("Comanda.findAll");
		List<Comanda> result = query.getResultList();
		em.close();
		return result;
	}

}
