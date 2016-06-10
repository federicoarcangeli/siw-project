package it.uniroma3.project.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Tavolo;

public class TavoloDao extends AbstractDao<Tavolo> {

	public TavoloDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tavolo findById(long id) {
		return getEM().find(Tavolo.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavolo> findAll() {
		return getEM().createNamedQuery("Tavolo.findAll").getResultList();
	}

	public Tavolo findByNumero(String parameter) {
		TypedQuery<Tavolo> q =  getEM().createQuery("select t from Tavolo t where t.codiceTavolo = ?1",Tavolo.class);
		try {
			q.setParameter(1, parameter);
			return q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Restituisce tutti i tavoli prenotati oggi
	 * 
	 * @param today
	 * @return
	 */
	public List<Tavolo> findAllToday(Date today) {
		TypedQuery<Tavolo> query = getEM()
				.createQuery("select t " + "from Tavolo t left join Prenotazione on tavoloprenotato_id = t.id "
						+ "and data = :today " + "order by t.id", Tavolo.class);
		query.setParameter("today", today, TemporalType.DATE);
		return query.getResultList();
	}
}
