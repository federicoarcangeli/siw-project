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

	public Prenotazione createByPersonale(String nominativo, Date data, Date ora, int ospiti, Tavolo tavolo) {
		Prenotazione prenotazione= new Prenotazione(data,ora,ospiti,nominativo,tavolo);
		em.persist(prenotazione);
		return prenotazione;
	}

	public Prenotazione createByUtente(Date data, Date ora, int ospiti,Utente utente ,Tavolo tavolo) {
		Prenotazione prenotazione= new Prenotazione(data,ora,ospiti,utente,tavolo);
		em.persist(prenotazione);
		return prenotazione;
	}

	public List<Prenotazione> findAllPrenotazioniToday() {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazione = dao.findAllPrenotazioniToday();
		return prenotazione;
	}

	public List<Prenotazione> findAllPrenotazioni() {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazioni = prenotazioneDao.findAll();
		return prenotazioni;
	}

	public List<Prenotazione> findPrenotazione(Tavolo t) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazione = prenotazioneDao.findPrenotazioniTavolo(t);
		return prenotazione;
	}

	public Prenotazione findPrenotazioneByTavolo(Long idTavolo) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		Prenotazione prenotazione = dao.findPrenotazioneByTavolo(idTavolo);
		return prenotazione;
	}

	public void setPrenotazioneCompletata(Prenotazione prenotazione) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		prenotazione.setStato(2);
		dao.update(prenotazione);
	}

	public void setPrenotazioneError(Prenotazione prenotazione) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		prenotazione.setStato(3);
		dao.update(prenotazione);

	}

	public void setPrenotazioneInCorso(Long idTavolo) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		Prenotazione prenotazione = dao.findPrenotazioneByTavolo(idTavolo);
		prenotazione.setStato(1);
		dao.update(prenotazione);
	}

	public Prenotazione findPrenotazioneByID(Long idPrenotazione){
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		Prenotazione prenotazione = dao.findById(idPrenotazione);
		return prenotazione;
	}

	public void eliminaPrenotazioneByID(Long idPrenotazione) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		Prenotazione prenotazione = dao.findById(idPrenotazione);
		dao.delete(prenotazione);
	}

	public List<Prenotazione> findAllPrenotazioniUtente(Long idPrenotazione) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		List<Prenotazione> prenotazioni = dao.findAllPrenotazioneUtente(idPrenotazione);
		return prenotazioni;
	}

	public void update(Prenotazione prenotazione){
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		dao.update(prenotazione);
	}

}
