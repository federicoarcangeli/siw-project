package it.uniroma3.project.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.ComandaDao;
import it.uniroma3.project.model.Comanda;

@Stateless
public class ComandaFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public List<Comanda> findallComandaToday(Date date) {
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comandeToday = dao.findAllToday(date);
		return comandeToday;
	}

	public void inserisciComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		dao.save(comanda);
	}


}
