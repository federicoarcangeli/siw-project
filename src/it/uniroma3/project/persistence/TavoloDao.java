package it.uniroma3.project.persistence;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.Tavolo;

public class TavoloDao extends AbstractDao<Tavolo> {


	@Override
	public Tavolo findById(long id) {
		EntityManager em = super.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Tavolo o = em.find(Tavolo.class, id);
		tx.commit();
		em.close();
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavolo> findAll() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Tavolo> result = em.createNamedQuery("Tavolo.findAll").getResultList();
		System.out.println(result.toString());
		tx.commit();
		em.close();
		return result;
	}

	public Tavolo findByNumero(String parameter) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = (Query) em.createNativeQuery("select id from tavolo where codicetavolo = ?1");
		q.setParameter(1,parameter);
		BigInteger id = (BigInteger) q.getSingleResult();
		Tavolo t = this.findById(id.longValue());
		tx.commit();
		em.close();
		return t;
	}

}
