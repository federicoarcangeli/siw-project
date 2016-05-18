package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.entity.Operatore;

public class OperatoreDao extends AbstractDao<Operatore> {

	public OperatoreDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Operatore findById(long codice) {
		return null;
	}
	
	public Operatore findByCodice(String codice) {
		EntityManager em = super.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Operatore o = em.find(Operatore.class, codice);
		tx.commit();
		em.close();
		return o;
	}
	
// cambiata primary key operatore in codice e non in id  (PIU COMODO)
//	public Operatore findByCodice(String codice) {
//		EntityManager em = super.emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		Query q = (Query) em.createNativeQuery("select codice from operatore where codice = ?1");
//		q.setParameter(1,codice);
//		Long id = (Long) q.getSingleResult();
//		return this.findById(id);
//	}


	@Override
	public List<Operatore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
