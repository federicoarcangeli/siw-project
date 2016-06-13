package it.uniroma3.project.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.UtenteDao;
import it.uniroma3.project.model.Utente;

@Stateless
public class UtenteFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	private UtenteDao utenteDao;

	public Utente create(String nome , String cognome ,String username, String telefono , String email, String password) {
		utenteDao = new UtenteDao(em);
		Utente utente = new Utente(nome , cognome , username, telefono , email, password);
		utenteDao.save(utente);
		return utente;
	}

	public Utente signUp(Utente utente) {
		this.utenteDao = new UtenteDao(em);
		this.utenteDao.save(utente);
		return utente;
	}

	public Utente find(Utente utente) {
		this.utenteDao = new UtenteDao(em);
		return this.utenteDao.find(utente);
	}

	public Utente findByUsername(String username) {
		this.utenteDao = new UtenteDao(em);
		return this.utenteDao.findUtenteByUserName(username);
	}

	public Utente findAdmin(String username, String password) {
		this.utenteDao = new UtenteDao(em);
		return this.utenteDao.findAdmin(username, password);
	}

	public List<Utente> findOperatori() {
		this.utenteDao = new UtenteDao(em);
		return this.utenteDao.findOperatori();
	}


}
