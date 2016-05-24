package it.uniroma3.project.persistence.dao;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.persistence.entity.LineaComanda;


public class LineaComandaDao extends AbstractDao<LineaComanda> {



	@Override
	public LineaComanda findById(long id) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		LineaComanda l = em.find(LineaComanda.class, id);
		tx.commit();
		em.close();
		return l;
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

	public LineaComanda findByIdPiattoAndComanda(Long idPiatto , Long idComanda) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			Query q = (Query) em.createNativeQuery("select l.id from lineacomanda l where l.piatto_id = ?1 and l.comanda_id= ?2 ");
			q.setParameter(1, idPiatto);
			q.setParameter(2, idComanda);
			BigInteger id = (BigInteger) q.getSingleResult();
			LineaComanda l = this.findById(id.longValue());
			em.close();
			return l;
		} catch (Exception e) {
			return null;
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

}
