package it.uniroma3.project.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

	public Tavolo findTavoloByNumero(String numeroTavolo) {
		TavoloDao dao = new TavoloDao(this.em);
		Tavolo tavolo = dao.findByNumero(numeroTavolo);
		return tavolo;
	}

	public Tavolo findTavoloByID(Long idTavolo) {
		TavoloDao dao = new TavoloDao(this.em);
		Tavolo tavolo = dao.findById(idTavolo);
		return tavolo;
	}

	public void setTavoloPrenotato(Tavolo tavolo) {
		tavolo.setStato(1);
		TavoloDao dao = new TavoloDao(this.em);
		dao.update(tavolo);
	}

	public void setTavoloOccupato(Tavolo tavolo) {
		tavolo.setStato(2);
		TavoloDao dao = new TavoloDao(this.em);
		dao.update(tavolo);
	}


	public void setTavoloLibero(Tavolo tavolo) {
		TavoloDao dao = new TavoloDao(this.em);
		tavolo.setStato(0);
		dao.update(tavolo);
	}

}
