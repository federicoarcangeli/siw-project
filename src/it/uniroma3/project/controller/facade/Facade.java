package it.uniroma3.project.controller.facade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.persistence.AbstractDao;
import it.uniroma3.project.persistence.DescrizionePiattoDao;
import it.uniroma3.project.persistence.PiattoDao;
import it.uniroma3.project.persistence.PrenotazioneDao;

public class Facade {

	public Facade() {	
	}

	public void inserisciPrenotazione(Prenotazione prenotazione){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		
		AbstractDao<Prenotazione> prenotazioneDao = new PrenotazioneDao(emf);
		prenotazioneDao.save(prenotazione);
	
		emf.close();
	}
	
	public void inserisciPiatto(Piatto piatto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PiattoDao piattoDao = new PiattoDao(emf);
		piattoDao.save(piatto);
		emf.close();
	}
	
	public void inserisciDescrizione(DescrizionePiatto descrizione) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		DescrizionePiattoDao descrizionePiattoDao = new DescrizionePiattoDao(emf);
		descrizionePiattoDao.save(descrizione);
		emf.close();
		
	}

}
