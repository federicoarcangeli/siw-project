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

	public Comanda findComandaById(Long idComanda) {
		ComandaDao dao = new ComandaDao(this.em);
		Comanda comanda = dao.findById(idComanda);
		return comanda;
	}

	public List<Comanda> findallComandaToday() {
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comandeToday = dao.findAllToday();
		return comandeToday;
	}

	public void inserisciComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		dao.save(comanda);
	}

	public void concludiComanda(Long idComanda) {
		ComandaDao dao = new ComandaDao(this.em);
		Comanda comanda = dao.findById(idComanda);
		this.setCompletata(comanda);
	}

	public void setCompletata(Comanda comanda){
		ComandaDao dao = new ComandaDao(this.em);
		comanda.setCompletata(true);
		dao.update(comanda);
	}

	public void eliminaComandaByID(Long idComanda) {
		ComandaDao dao = new ComandaDao(this.em);
		Comanda comanda = dao.findById(idComanda);
		dao.delete(comanda);
	}

	public void updateComanda(Comanda comanda) {
		ComandaDao dao = new ComandaDao(this.em);
		dao.update(comanda);
	}

	public Comanda findComandaByTavolo(Long idTavolo) {
		ComandaDao dao = new ComandaDao(this.em);
		Comanda comanda = dao.findComandaByTavolo(idTavolo);
		comanda = this.findComandaById(comanda.getId());
		return comanda;
	}

}
