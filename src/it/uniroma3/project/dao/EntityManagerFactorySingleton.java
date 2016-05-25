package it.uniroma3.project.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static final String PERSISTENCE_UNIT_NAME = "restaurant-unit";
	private static EntityManagerFactory emf;
	
	public static synchronized EntityManagerFactory getInstance() {
		if(emf == null)
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return emf;
	}
	
	public void closeEnityManagerFactory() {
		if(emf.isOpen()) {
			emf.close();
		}
	}


}
