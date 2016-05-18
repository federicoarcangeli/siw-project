package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import it.uniroma3.project.entity.Utente;

public class UtenteDao extends AbstractDao<Utente> {

	@Override
	public Utente findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Utente findUtente(String email) {
		EntityManager em = this.emf.createEntityManager();
		Utente utente = em.find(Utente.class,email);
		em.close();
		return utente;
	}

}
