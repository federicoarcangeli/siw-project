package it.uniroma3.project.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.persistence.entity.LineaComanda;


public class LineaComandaDao extends AbstractDao<LineaComanda> {



	@Override
	public LineaComanda findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaComanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<LineaComanda> findAllLineaComandaOfComanda(Long idComanda) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Query query = em.createNativeQuery("select l.* from lineacomanda l where l.comanda_id= ?1",LineaComanda.class);
		query.setParameter(1,idComanda);
		List<LineaComanda> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}

}
