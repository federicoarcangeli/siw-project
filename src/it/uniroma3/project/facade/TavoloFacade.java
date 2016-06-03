package it.uniroma3.project.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.model.Tavolo;

@Stateless
public class TavoloFacade {
	
	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;
	
	public Tavolo create(String codiceTavolo, int coperti) {
		Tavolo tavolo = new Tavolo();
		tavolo.setCodiceTavolo(codiceTavolo);
		tavolo.setCoperti(coperti);
		em.persist(tavolo);
		return tavolo;
	}

}
