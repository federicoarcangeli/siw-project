package it.uniroma3.project.persistence;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {


	@Override
	public Comanda findById(long id) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Comanda c = em.find(Comanda.class, id);
		tx.commit();
		em.close();
		return c;
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

	public Comanda findComandaByTavoloAndDay(Long param , Date data) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			Query q = (Query) em.createNativeQuery("select c.id from comanda c where c.tavolo_id = ?1 and date(dataoraemissione) = ?2");
			q.setParameter(1, param);
			q.setParameter(2, data);
			BigInteger id = (BigInteger) q.getSingleResult();
			Comanda c = this.findById(id.longValue());
			em.close();
			return c;
		} catch (Exception e) {
			return null;
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

}
