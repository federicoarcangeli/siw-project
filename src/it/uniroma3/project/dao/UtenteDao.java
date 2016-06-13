package it.uniroma3.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Utente;

public class UtenteDao extends AbstractDao<Utente> {

	public UtenteDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utente findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* da controllare */
	public Utente findUtente(String email) {
		try {
			return getEM().find(Utente.class, email);
		} catch (Exception e) {
			return null;
		}
	}

	public Utente findUtenteByUserName(String username) {
		TypedQuery<Utente> query = getEM().createQuery("select u from Utente u where u.username = :username",
				Utente.class);
		try {
			return query.setParameter("username", username).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}

	}

	public Utente findAdmin(String username, String password) {
		TypedQuery<Utente> query = getEM().createQuery(
				"select u from Utente u where u.username = :username and u.password = :password and u.role = 'admin'",
				Utente.class);
		try {
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Utente find(Utente utente) {
		return getEM().find(Utente.class, utente);
	}

	public List<Utente> findOperatori() {
		TypedQuery<Utente> query = getEM().createQuery(
				"select u from Utente u where u.role = 'operatore' or u.role = 'admin'",
				Utente.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}



}
