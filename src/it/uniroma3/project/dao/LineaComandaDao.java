package it.uniroma3.project.dao;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public List<LineaComanda> findAllLineaComandaOfComanda(Long idComanda) {
		Query query = getEM().createNativeQuery("select l.* from lineacomanda l where l.comanda_id= ?1",LineaComanda.class);
		query.setParameter(1,idComanda);
		return query.getResultList();
	}

	public LineaComanda findByIdPiattoAndComanda(Long idPiatto , Long idComanda) {
		try{
			Query q = (Query) getEM().createNativeQuery("select l.id from lineacomanda l where l.piatto_id = ?1 and l.comanda_id= ?2 ");
			q.setParameter(1, idPiatto);
			q.setParameter(2, idComanda);
			BigInteger id = (BigInteger) q.getSingleResult();
			LineaComanda l = this.findById(id.longValue());
			return l;
		} catch (Exception e) {
			return null;
		}

	}

}
