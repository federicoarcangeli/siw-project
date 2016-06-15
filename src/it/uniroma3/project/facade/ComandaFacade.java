package it.uniroma3.project.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.ComandaDao;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.services.validator.Time24HoursValidator;

@Stateless
public class ComandaFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public Comanda findComandaById(Long idComanda) {
		ComandaDao dao = new ComandaDao(this.em);
		Comanda comanda = dao.findById(idComanda);
		return comanda;
	}

	public List<Comanda> findallComandeInCorso() {
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comandeInCorso = dao.findAllInCorso();
		return comandeInCorso;
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

	public List<Comanda>findAllComandeCompletateToday(){
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comande = dao.findAllCompletateToday();
		return comande;
	}

	public List<Comanda> findallComandaCompletate() {
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comande = dao.findAllCompletate();
		return comande;
	}

	public List<Comanda> findComandeCompletateInThisDay(Date date) throws ParseException {
		Time24HoursValidator validator = new Time24HoursValidator();
		ComandaDao dao = new ComandaDao(this.em);
		List<Comanda> comande = dao.findAllCompletateInThisDay(validator.simpleFormatDate(date));
		return comande;
	}

	public Map<String, List<String>> findAllOperatoriInServizio() {
		ComandaDao dao = new ComandaDao(this.em);
		return dao.findAllOperatoriInServizio();

	}

}
