package it.uniroma3.project.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.PrenotazioneDao;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Tavolo;
import it.uniroma3.project.model.Utente;

@Stateless
public class PrenotazioneFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Prenotazione create(String nominativo, Date data, Date ora, int ospiti, Tavolo tavolo) {
		Prenotazione prenotazione= new Prenotazione(data,ora,ospiti,nominativo,tavolo);
		em.persist(prenotazione);
		return prenotazione;
	}

	public Prenotazione create(Date data, Date ora, int ospiti,Utente utente ,Tavolo tavolo) {
		Prenotazione prenotazione= new Prenotazione(data,ora,ospiti,utente,tavolo);
		em.persist(prenotazione);
		return prenotazione;
	}

	public List<Prenotazione> findAllPrenotazioniToday(Date today) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazione = dao.findAllPrenotazioniToday(today);
		return prenotazione;
	}

	public List<Prenotazione> findAllPrenotazioni() {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazioni = prenotazioneDao.findAll();
		return prenotazioni;
	}

	public List<Prenotazione> findPrenotazione(Tavolo t, Date today) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazione = prenotazioneDao.findPrenotazioneTavolo(t, today);
		return prenotazione;
	}

	public Prenotazione findPrenotazioneByTavolo(long idTavolo) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		Prenotazione prenotazione = dao.findByTavolo(idTavolo);
		return prenotazione;
	}

	public void setPrenotazioneCompletata(Prenotazione prenotazione) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		prenotazione.setCompletato(true);
		dao.update(prenotazione);
	}

}
