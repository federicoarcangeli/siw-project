package it.uniroma3.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.LineaComanda;


public class LineaComandaDao extends AbstractDao<LineaComanda> {



	public LineaComandaDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LineaComanda findById(long id) {
		return getEM().find(LineaComanda.class, id);

	}

	@Override
	public List<LineaComanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LineaComanda> findAllLineaComandaOfComanda(Long idComanda) {
		try{
			TypedQuery<LineaComanda> query = this.getEM().createQuery("select l from LineaComanda l where l.comanda.id= :idComanda",LineaComanda.class);
			query.setParameter("idComanda",idComanda);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LineaComanda findByIdPiattoAndComanda(Long idPiatto , Long idComanda) {
		try{
			TypedQuery<LineaComanda> query = this.getEM().createQuery("select l from LineaComanda l where l.piatto.id = :idPiatto and l.comanda.id= :idComanda ",LineaComanda.class);
			query.setParameter("idPiatto", idPiatto);
			query.setParameter("idComanda", idComanda);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
