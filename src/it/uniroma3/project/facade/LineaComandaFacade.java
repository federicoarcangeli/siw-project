package it.uniroma3.project.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.LineaComandaDao;
import it.uniroma3.project.model.LineaComanda;

@Stateless
public class LineaComandaFacade {
	
	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public LineaComanda findLineaByIdPiattoAndComanda(Long idPiatto, Long idComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		LineaComanda linea = dao.findByIdPiattoAndComanda(idPiatto, idComanda);
		return linea;
	}

	public void updateLinea(LineaComanda linea) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		dao.update(linea);
	}

	public void inserisciLinea(LineaComanda linea) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		dao.save(linea);
	}

	public LineaComanda findLineaComanda(Long idLineaComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		LineaComanda linee = dao.findById(idLineaComanda);
		return linee;
	}

	public List<LineaComanda> findallLineeComanda(Long idComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		List<LineaComanda> linee = dao.findAllLineaComandaOfComanda(idComanda);
		return linee;
	}

	public void eliminaRigaComanda(Long idLineaComanda) {
		LineaComandaDao dao = new LineaComandaDao(this.em);
		LineaComanda linea = this.findLineaComanda(idLineaComanda);
		dao.delete(linea);
	}

	public int findNumeroLineaMassimo(Long idLineaComanda){
		LineaComandaDao dao = new LineaComandaDao(this.em);
		return dao.findMaxNumeroLinea(idLineaComanda);
	}

}
