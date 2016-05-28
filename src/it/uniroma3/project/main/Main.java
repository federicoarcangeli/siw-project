package it.uniroma3.project.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.dao.ComandaDao;
import it.uniroma3.project.dao.EntityManagerFactorySingleton;
import it.uniroma3.project.dao.PrenotazioneDao;
import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Comanda;

public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.removeComandaById(83L);

	}

}
