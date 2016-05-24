package it.uniroma3.project.persistence.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import it.uniroma3.project.persistence.entity.Prenotazione;
import it.uniroma3.project.persistence.entity.Tavolo;

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
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Prenotazione> result = em.createNamedQuery("Prenotazione.findAll",Prenotazione.class).getResultList();
		tx.commit();
		em.close();
		return result;

	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAllPrenotazioneUtente(Long id_utente) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Query query = em.createNativeQuery("select p.* from Prenotazione p where p.utente_id= ?1",Prenotazione.class);
		query.setParameter(1,id_utente);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findPrenotazioneTavolo(Tavolo t, Date today) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Query query = em.createNativeQuery("select p.* from Prenotazione p where p.tavoloprenotato_id= ?1 and p.data= ?2",Prenotazione.class);
		query.setParameter(1,t.getId());
		query.setParameter(2,today,TemporalType.DATE);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}
	
	public List<Prenotazione> findAllPrenotazioniToday(Date today) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Prenotazione> query = em.createQuery( "select p from Prenotazione p where p.data = :today",Prenotazione.class);
		query.setParameter("today", today);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}
	
}
