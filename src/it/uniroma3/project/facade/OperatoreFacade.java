package it.uniroma3.project.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.model.Utente;

@Stateless
public class OperatoreFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Utente create(String username, String password, String ruolo) {
		Utente operatore = new Utente(username,password,ruolo);
		em.persist(operatore);
		return operatore;
	}

}
