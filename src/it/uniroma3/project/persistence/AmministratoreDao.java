package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.entity.Amministratore;

public class AmministratoreDao extends AbstractDao<Amministratore> {

	public AmministratoreDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Amministratore findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Amministratore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Amministratore findAmministratore(String username) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Amministratore amministratore = em.find(Amministratore.class,username);
		tx.commit();
		em.close();
		return amministratore;
	}

}
