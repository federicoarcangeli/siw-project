package it.uniroma3.project.persistence;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.Operatore;
import it.uniroma3.project.entity.Tavolo;

public class TavoloDao extends AbstractDao<Tavolo> {

	public TavoloDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public List<Tavolo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tavolo findByNumero(String parameter) {
		EntityManager em = super.emf.createEntityManager();
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
