package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
	
	public List<LineaComanda> findAllLineaComandaOfComanda(Long comanda) {
		EntityManager em = super.getEntityManager();
		TypedQuery<LineaComanda> query = em.createQuery("select * from LineaComanda"
				+ "join Comanda where LineaComanda.comanda_id = :comanda", LineaComanda.class);
		query.setParameter("comanda", comanda);
		return query.getResultList();
	}

}
