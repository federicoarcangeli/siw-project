package it.uniroma3.project.facade;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.project.dao.*;
import it.uniroma3.project.model.*;

public class Facade {
	private EntityManager em;

	public Facade() {
		this.em = getEntityManager();
	}

	public void inserisciPrenotazione(Prenotazione prenotazione) {
		this.em.getTransaction().begin();
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		prenotazioneDao.save(prenotazione);
		this.em.getTransaction().commit();

	}

	public void removeComandaById(Long idComanda) {
		this.em.getTransaction().begin();
		ComandaDao dao = new ComandaDao(this.em);
		dao.deleteById(idComanda);
		this.em.getTransaction().commit();
	}

	public LineaComanda findLineaComanda(Long idLineaComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		LineaComanda linee = dao.findById(idLineaComanda);
		this.em.getTransaction().commit();
		return linee;
	}

	public void eliminaRigaComanda(LineaComanda idLineaComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.delete(idLineaComanda);
		this.em.getTransaction().commit();
	}

	public void inserisciPiatto(Piatto piatto) {
		this.em.getTransaction().begin();
		PiattoDao piattoDao = new PiattoDao(this.em);
		piattoDao.save(piatto);
		this.em.getTransaction().commit();
	}

	public void inserisciDescrizione(DescrizionePiatto descrizione) {
		DescrizionePiattoDao descrizionePiattoDao = new DescrizionePiattoDao(this.em);
		this.em.getTransaction().begin();
		descrizionePiattoDao.save(descrizione);
		this.em.getTransaction().commit();

	}

	public void inserisciUtente(Utente utente) {
		UtenteDao utenteDao = new UtenteDao(this.em);
		this.em.getTransaction().begin();
		utenteDao.save(utente);
		this.em.getTransaction().commit();
	}

	public void inserisciComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.save(comanda);
		this.em.getTransaction().commit();
	}

	public void inserisciLinea(LineaComanda linea) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.save(linea);
		this.em.getTransaction().commit();
	}

	public List<CategoriaPiatto> findAllCategorie() {
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao(this.em);
		this.em.getTransaction().begin();
		List<CategoriaPiatto> categorie = categoriaPiattoDao.findAll();
		this.em.getTransaction().commit();
		return categorie;
	}

	public CategoriaPiatto findCategoria(String idCategoria) {
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao(this.em);
		this.em.getTransaction().begin();
		CategoriaPiatto categoria = categoriaPiattoDao.findById(Long.parseLong(idCategoria));
		this.em.getTransaction().commit();
		return categoria;
	}

	public void setCategoriaPiatto(Long idPiatto, String idCategoria) {
		PiattoDao PiattoDao = new PiattoDao(this.em);
		this.em.getTransaction().begin();
		PiattoDao.setCategoria(idPiatto, idCategoria);
		this.em.getTransaction().commit();
	}

	public Utente findUtente(String username) {
		UtenteDao utenteDao = new UtenteDao(this.em);
		this.em.getTransaction().begin();
		Utente utente = utenteDao.findUtenteByUserName(username);
		this.em.getTransaction().commit();
		return utente;
	}

	public Piatto findPiatto(Long idPiatto) {
		PiattoDao piattoDao = new PiattoDao(this.em);
		this.em.getTransaction().begin();
		Piatto piatto = piattoDao.findById(idPiatto);
		this.em.getTransaction().commit();
		return piatto;
	}

	public List<Comanda> findallComandaCompletate() {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		List<Comanda> comande = dao.findAllCompletate();
		this.em.getTransaction().commit();
		return comande;
	}

	public void concludiComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		comanda.setCompletata(true);
		dao.update(comanda);
		this.em.getTransaction().commit();
	}

	public Comanda findComandaByTavolo(Long idTavolo) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		Comanda comanda = dao.findComandaByTavolo(idTavolo);
		this.em.getTransaction().commit();
		return comanda;
	}

	public Tavolo findTavoloByNumero(String numeroTavolo) {
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		Tavolo tavolo = dao.findByNumero(numeroTavolo);
		this.em.getTransaction().commit();
		return tavolo;
	}

	public LineaComanda findLineaByIdPiattoAndComanda(Long idPiatto, Long idComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		LineaComanda linea = dao.findByIdPiattoAndComanda(idPiatto, idComanda);
		this.em.getTransaction().commit();
		return linea;
	}

	public List<Prenotazione> findAllPrenotazioniUtente(Long idUser) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		List<Prenotazione> prenotazioni = prenotazioneDao.findAllPrenotazioneUtente(idUser);
		this.em.getTransaction().commit();
		return prenotazioni;
	}

	public List<Piatto> findAllPiatti() {
		PiattoDao piattoDao = new PiattoDao(this.em);
		this.em.getTransaction().begin();
		List<Piatto> piatti = piattoDao.findAll();
		this.em.getTransaction().commit();
		return piatti;
	}

	public List<Tavolo> findAllTavolo() {
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		List<Tavolo> result = dao.findAll();
		this.em.getTransaction().commit();
		return result;
	}

	public List<Tavolo> findAllTavoliToday(Date today) {
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		List<Tavolo> result = dao.findAllToday(today);
		this.em.getTransaction().commit();
		return result;
	}

	public List<Prenotazione> findAllPrenotazioniToday(Date today) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		List<Prenotazione> prenotazione = dao.findAllPrenotazioniToday();
		this.em.getTransaction().commit();
		return prenotazione;
	}

	public List<LineaComanda> findallLineeComanda(Long idComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		List<LineaComanda> linee = dao.findAllLineaComandaOfComanda(idComanda);
		this.em.getTransaction().commit();
		return linee;
	}

	public void setTavoloPrenotato(Tavolo tavolo) {
		tavolo.setOccupato(1);
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		dao.update(tavolo);
		this.em.getTransaction().commit();
	}

	public void setTavoloOccupato(Tavolo tavolo) {
		tavolo.setOccupato(2);
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		dao.update(tavolo);
		this.em.getTransaction().commit();
	}

	public void setTavoloLibero(Tavolo tavolo) {
		tavolo.setOccupato(0);
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		dao.update(tavolo);
		this.em.getTransaction().commit();

	}

	public List<Prenotazione> findAllPrenotazioni() {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		List<Prenotazione> prenotazioni = prenotazioneDao.findAll();
		this.em.getTransaction().commit();
		return prenotazioni;
	}

	public List<Prenotazione> findPrenotazione(Tavolo t, Date today) {
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		List<Prenotazione> prenotazione = prenotazioneDao.findPrenotazioneTavolo(t);
		this.em.getTransaction().commit();
		return prenotazione;
	}

	public void inserisciTavolo(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao(this.em);
		this.em.getTransaction().begin();
		dao.save(tavolo);
		this.em.getTransaction().commit();
	}

	public void updateLinea(LineaComanda linea) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.update(linea);
		this.em.getTransaction().commit();
	}

	public void updateComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.update(comanda);
		this.em.getTransaction().commit();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}

	public void closeEntityManager() {
		if (this.em != null)
			this.em.close();
	}

	public List<Comanda> findallComandaToday(Date date) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		List<Comanda> comandeToday = dao.findAllToday();
		this.em.getTransaction().commit();
		return comandeToday;
	}

	public List<Comanda> findallComanda() {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		List<Comanda> comande = dao.findAll();
		this.em.getTransaction().commit();
		return comande;
	}

	public Comanda findComandaById(Long idComanda) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		Comanda comanda = dao.findById(idComanda);
		this.em.getTransaction().commit();
		return comanda;
	}

	public Piatto findPiattoById(Long idTavolo) {
		PiattoDao dao = new PiattoDao(this.em);
		this.em.getTransaction().begin();
		Piatto piatto = dao.findById(idTavolo);
		this.em.getTransaction().commit();
		return piatto;
	}

	public void eliminaComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		this.em.getTransaction().begin();
		dao.delete(comanda);
		this.em.getTransaction().commit();
	}

	public Prenotazione findPrenotazioneByTavolo(long idComanda) {
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		Prenotazione prenotazione = dao.findByTavolo(idComanda);
		this.em.getTransaction().commit();
		return prenotazione;
	}

	public void setPrenotazioneCompletata(Prenotazione prenotazione) {
		prenotazione.setCompletato(true);
		PrenotazioneDao dao = new PrenotazioneDao(this.em);
		this.em.getTransaction().begin();
		dao.update(prenotazione);
		this.em.getTransaction().commit();
	}

}
