package it.uniroma3.project.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.model.Utente;

@Stateless
public class UtenteFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Utente create(String nome , String cognome ,String username, String telefono , String email, String password) {
		Utente operatore = new Utente(nome , cognome , username, telefono , email, password);
		em.persist(operatore);
		return operatore;
	}
}
