package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.model.Prenotazione;

public class PrenotazioneDao extends AbstractDao<Prenotazione> {

	public PrenotazioneDao(EntityManagerFactory emf ) {
		super(emf);
	}

	@Override
	public Prenotazione findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prenotazione p = em.find(Prenotazione.class, id);
		tx.commit();
		em.close();
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Prenotazione> result = em.createNamedQuery("Prenotazione.findAll").getResultList();
		em.close();
		return result;
	}

}
