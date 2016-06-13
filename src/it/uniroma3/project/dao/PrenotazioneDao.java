package it.uniroma3.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		return getEM().find(Prenotazione.class, id);
	}

	@Override
	public List<Prenotazione> findAll() {
		return getEM().createNamedQuery("Prenotazione.findAll", Prenotazione.class).getResultList();

	}

	public List<Prenotazione> findAllPrenotazioneUtente(Long id_utente) {
		try{
			TypedQuery<Prenotazione> query = getEM().createQuery("select p from Prenotazione p where p.utente.id= ?1",
					Prenotazione.class);
			query.setParameter(1, id_utente);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findPrenotazioniTavolo(Tavolo t) {
		try{
			Query query = getEM().createNativeQuery(
					"select p.* from Prenotazione p where p.tavoloprenotato_id= ?1 and p.data = CURRENT_DATE and p.stato != 2", Prenotazione.class);
			query.setParameter(1, t.getId());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Prenotazione> findAllPrenotazioniToday() {
		try{
			TypedQuery<Prenotazione> query = getEM().createQuery( "select p from Prenotazione p where p.data = CURRENT_DATE",Prenotazione.class);
			List<Prenotazione> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public Prenotazione findPrenotazioneByTavolo(Long idTavolo) {
		try{
			Query query = getEM().createNativeQuery(
					"select p.* from Prenotazione p where p.tavoloprenotato_id= ?1 and p.data = CURRENT_DATE and p.stato != 2", Prenotazione.class);
			query.setParameter(1, idTavolo);
			return (Prenotazione) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
