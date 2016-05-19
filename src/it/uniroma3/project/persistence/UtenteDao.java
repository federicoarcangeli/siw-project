package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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

	/*da controllare*/
	public Utente findUtente(String email) {
		EntityManager em = null;
		try {
		em = super.getEntityManager();
		Utente utente = em.find(Utente.class,email);
		em.close();
		return utente;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(em.isOpen())
				em.close();
		}
	}
	
	public Utente findUtenteByUserName(String username) {
		
		EntityManager em = super.getEntityManager();
		TypedQuery<Utente> query = em.createQuery("select u from Utente u where u.username = :username", Utente.class);
		return query.setParameter("username", username).getSingleResult();
	}

}
