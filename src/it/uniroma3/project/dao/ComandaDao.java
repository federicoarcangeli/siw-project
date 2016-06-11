package it.uniroma3.project.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {


	public ComandaDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comanda findById(long id) {
		return getEM().find(Comanda.class, id);
	}

	public void deleteById(long id) {
		Comanda comanda = this.findById(id);
		if(comanda!=null) {
			Comanda toRemove = getEM().merge(comanda);
			getEM().remove(toRemove);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> findAll() {
		return getEM().createNamedQuery("Comanda.findAll").getResultList();
	}

	public Comanda findComandaByTavolo(Long param) {
		try{
			TypedQuery<Comanda> q =  getEM().createQuery("select c from Comanda c where c.tavolo_id = ?1 and c.completata='false'",Comanda.class);
			q.setParameter(1, param);
			return q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Comanda> findAllToday(Date today) {
		TypedQuery<Comanda> query = this.getEM().createQuery("select c from Comanda c where c.dataOraEmissione > CURRENT_DATE",Comanda.class);
		return query.getResultList();
	}

	public List<Comanda> findAllCompletate() {
		TypedQuery<Comanda> query = getEM().createQuery( "select c from Comanda c where completata = true",Comanda.class);
		return query.getResultList();
	}

}
