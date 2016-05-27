package it.uniroma3.project.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {


	public ComandaDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comanda findById(long id) {
		return getEntityManager().find(Comanda.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> findAll() {
		return getEntityManager().createNamedQuery("Comanda.findAll").getResultList();
	}

	public Comanda findComandaByTavolo(Long param) {
		try{
			Query q = (Query) getEntityManager().createNativeQuery("select c.id from comanda c where c.tavolo_id = ?1 and c.completata='false'");
			q.setParameter(1, param);
			BigInteger id = (BigInteger) q.getSingleResult();
			return this.findById(id.longValue());
		} catch (Exception e) {
			return null;
		}
	}


	public List<Comanda> findAllToday(Date today) {
		TypedQuery<Comanda> query = getEntityManager().createQuery( "select c from Comanda c where date(c.dataOraEmissione) = :today",Comanda.class);
		query.setParameter("today", today);
		return query.getResultList();
	}

	public List<Comanda> findAllCompletate() {
		TypedQuery<Comanda> query = getEntityManager().createQuery( "select c from Comanda c where completata = true",Comanda.class);
		return query.getResultList();
	}

}
