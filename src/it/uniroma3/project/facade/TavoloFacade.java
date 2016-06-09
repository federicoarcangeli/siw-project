package it.uniroma3.project.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.TavoloDao;
import it.uniroma3.project.model.Tavolo;

@Stateless
public class TavoloFacade {

	private TavoloDao tavoloDao;

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Tavolo create(String codiceTavolo, int coperti) {
		Tavolo tavolo = new Tavolo(codiceTavolo, coperti);
		em.persist(tavolo);
		return tavolo;
	}

	public List<Tavolo> findAllTavolo() {
		this.tavoloDao = new TavoloDao(em);
		return this.tavoloDao.findAll();
	}

	public void setTavoloPrenotato(Tavolo tavolo) {
		tavolo.setOccupato(1);
		TavoloDao dao = new TavoloDao(this.em);
		dao.update(tavolo);
	}

	public void setTavoloOccupato(Tavolo tavolo) {
		tavolo.setOccupato(2);
		TavoloDao dao = new TavoloDao(this.em);
		dao.update(tavolo);
	}

	public void setTavoloLibero(Tavolo tavolo) {
		tavolo.setOccupato(0);
		TavoloDao dao = new TavoloDao(this.em);
		dao.update(tavolo);

	}

}
