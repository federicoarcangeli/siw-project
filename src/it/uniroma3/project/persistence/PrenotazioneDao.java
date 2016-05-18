package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Utente;

public class PrenotazioneDao extends AbstractDao<Prenotazione> {


	@Override
	public Prenotazione findById(long id) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prenotazione p = em.find(Prenotazione.class, id);
		tx.commit();
		em.close();
		return p;
	}

	@Override
	public List<Prenotazione> findAll() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAllPrenotazioneUtente(String email) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Query query = em.createNativeQuery("select p.id,p.data,p.ora,p.numeroospiti,p.utente_email,p.tavoloprenotato_id from prenotazione p where p.utente_email= ?1",Prenotazione.class);
		query.setParameter(1,email);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}
}
