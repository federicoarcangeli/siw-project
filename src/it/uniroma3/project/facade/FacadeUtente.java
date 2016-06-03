package it.uniroma3.project.facade;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.model.Utente;

@Stateless
public class FacadeUtente {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	private String username;
	private String password;

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public Utente getUtenteByUsername(String username) {
		TypedQuery<Utente> query = em.createQuery("select u from Utente u where u.username = :username", Utente.class);
		try {
			return query.setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
