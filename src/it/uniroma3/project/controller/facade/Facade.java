package it.uniroma3.project.controller.facade;

import java.util.Date;
import java.util.List;

import it.uniroma3.project.persistence.dao.AbstractDao;
import it.uniroma3.project.persistence.dao.CategoriaPiattoDao;
import it.uniroma3.project.persistence.dao.ComandaDao;
import it.uniroma3.project.persistence.dao.DescrizionePiattoDao;
import it.uniroma3.project.persistence.dao.PiattoDao;
import it.uniroma3.project.persistence.dao.PrenotazioneDao;
import it.uniroma3.project.persistence.dao.TavoloDao;
import it.uniroma3.project.persistence.dao.UtenteDao;
import it.uniroma3.project.persistence.entity.CategoriaPiatto;
import it.uniroma3.project.persistence.entity.Comanda;
import it.uniroma3.project.persistence.entity.DescrizionePiatto;
import it.uniroma3.project.persistence.entity.Piatto;
import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Tavolo;
import it.uniroma3.project.persistence.entity.Utente;

public class Facade {

	public Facade() {
	}

	public void inserisciPrenotazione(Prenotazione prenotazione) {

		AbstractDao<Prenotazione> prenotazioneDao = new PrenotazioneDao();
		prenotazioneDao.save(prenotazione);

	}

	public void inserisciPiatto(Piatto piatto) {
		PiattoDao piattoDao = new PiattoDao();
		piattoDao.save(piatto);
	}

	public void inserisciDescrizione(DescrizionePiatto descrizione) {
		DescrizionePiattoDao descrizionePiattoDao = new DescrizionePiattoDao();
		descrizionePiattoDao.save(descrizione);

	}

	public void inserisciUtente(Utente utente) {
		UtenteDao utenteDao = new UtenteDao();
		utenteDao.save(utente);
	}

	public void inserisciComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao();
		dao.save(comanda);
	}

	public List<CategoriaPiatto> findAllCategorie() {
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao();
		List<CategoriaPiatto> categorie = categoriaPiattoDao.findAll();
		return categorie;
	}

	public CategoriaPiatto findCategoria(String id) {
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao();
		CategoriaPiatto categoria = categoriaPiattoDao.findById(Long.parseLong(id));
		return categoria;
	}

	public void setCategoriaPiatto(Long idPiatto, String idCategoria) {
		PiattoDao PiattoDao = new PiattoDao();
		PiattoDao.setCategoria(idPiatto, idCategoria);
	}

	public List<Piatto> findAllPiatti() {
		PiattoDao piattoDao = new PiattoDao();
		List<Piatto> piatti = piattoDao.findAll();
		return piatti;
	}


	public Utente findUtente(String username) {
		UtenteDao utenteDao = new UtenteDao();
		Utente utente = utenteDao.findUtenteByUserName(username);
		return utente;
	}

	public Tavolo findTavoloByNumero(String parameter) {
		TavoloDao dao = new TavoloDao();
		Tavolo tavolo = dao.findByNumero(parameter);
		return tavolo;
	}

	public List<Prenotazione> findAllPrenotazioniUtente(Long id_utente) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
		List<Prenotazione> prenotazioni = prenotazioneDao.findAllPrenotazioneUtente(id_utente);
		return prenotazioni;
	}


	public List<Tavolo> findAllTavolo() {
		TavoloDao dao = new TavoloDao();
		return dao.findAll();
	}

	public List<Tavolo> findAllTavoliToday(Date today) {
		TavoloDao dao = new TavoloDao();
		return dao.findAllToday(today);
	}

	public void setTavoloPrenotato(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao();
		tavolo.setOccupato(1);
		dao.update(tavolo);	
	}

	public void setTavoloOccupato(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao();
		tavolo.setOccupato(2);
		dao.update(tavolo);	
	}

	public void setTavoloLibero(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao();
		tavolo.setOccupato(0);
		dao.update(tavolo);	

	}

	public List<Prenotazione> findAllPrenotazioni() {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
		List<Prenotazione> prenotazioni = prenotazioneDao.findAll();
		return prenotazioni;
	}

	public List<Prenotazione> findPrenotazione(Tavolo t, Date today) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
		List<Prenotazione> prenotazione = prenotazioneDao.findPrenotazioneTavolo(t, today);
		return prenotazione;
	}

	public void inserisciTavolo(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao();
		dao.save(tavolo);
	}



}
