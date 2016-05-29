package it.uniroma3.project.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Tavolo;

public class PrenotazioneDao extends AbstractDao<Prenotazione> {

	public PrenotazioneDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prenotazione findById(long id) {
		return getEntityManager().find(Prenotazione.class, id);
	}

	@Override
	public List<Prenotazione> findAll() {
		return getEntityManager().createNamedQuery("Prenotazione.findAll", Prenotazione.class).getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAllPrenotazioneUtente(Long id_utente) {
		Query query = getEntityManager().createNativeQuery("select p.* from Prenotazione p where p.utente_id= ?1",
				Prenotazione.class);
		query.setParameter(1, id_utente);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findPrenotazioneTavolo(Tavolo t, Date today) {
		Query query = getEntityManager().createNativeQuery(
				"select p.* from Prenotazione p where p.tavoloprenotato_id= ?1 and p.data= ?2 and p.completato='false'", Prenotazione.class);
		query.setParameter(1, t.getId());
		query.setParameter(2, today, TemporalType.DATE);
		return query.getResultList();

	}

	public List<Prenotazione> findAllPrenotazioniToday(Date today) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Prenotazione> query = em.createQuery( "select p from Prenotazione p where p.data = :today",Prenotazione.class);
		query.setParameter("today", today);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}

	public Prenotazione findByTavolo(long idComanda) {
		try {
			Query q = (Query) getEntityManager().createNativeQuery("select id from prenotazione where tavoloprenotato_id = ?1 and completato='false'");
			q.setParameter(1, idComanda);
			BigInteger id = (BigInteger) q.getSingleResult();
			return this.findById(id.longValue());
		} catch (Exception e) {
			return null;
		}
	}

}
