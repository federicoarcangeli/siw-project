package it.uniroma3.project.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.persistence.PrenotazioneDao;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PrenotazioneDao dao = new PrenotazioneDao(emf);
		emf.close();
	}

}
