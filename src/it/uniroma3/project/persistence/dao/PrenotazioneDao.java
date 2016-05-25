package it.uniroma3.project.persistence.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Tavolo;

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
				"select p.* from Prenotazione p where p.tavoloprenotato_id= ?1 and p.data= ?2", Prenotazione.class);
		query.setParameter(1, t.getId());
		query.setParameter(2, today, TemporalType.DATE);
		return query.getResultList();

	}
}
