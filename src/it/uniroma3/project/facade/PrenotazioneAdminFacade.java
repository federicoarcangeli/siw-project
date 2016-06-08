package it.uniroma3.project.facade;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Tavolo;

@Stateless
public class PrenotazioneAdminFacade {
	
	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Prenotazione create(String nominativo, Date data, Date ora, int ospiti, Tavolo tavolo) {
		Prenotazione prenotazione= new Prenotazione(data,ora,ospiti,nominativo,tavolo);
		em.persist(prenotazione);
		return prenotazione;
	}

}
