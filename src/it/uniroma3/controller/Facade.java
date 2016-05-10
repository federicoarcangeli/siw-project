package it.uniroma3.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.persistence.AbstractDao;
import it.uniroma3.project.persistence.PrenotazioneDao;

public class Facade {

	public Facade() {	
	}

	public void inserisciPrenotazione(Prenotazione prenotazione){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		
		AbstractDao<Prenotazione> prenotazioneDao = new PrenotazioneDao(emf);
		prenotazioneDao.save(prenotazione);
	
		emf.close();
	}

}
