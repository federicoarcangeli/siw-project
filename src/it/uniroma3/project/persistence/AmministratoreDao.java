package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Amministratore;

public class AmministratoreDao extends AbstractDao<Amministratore> {

	public AmministratoreDao(EntityManagerFactory emf) {
		super(emf);
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
		EntityManager em = this.emf.createEntityManager();
		Amministratore amministratore = em.find(Amministratore.class,username);
		em.close();
		return amministratore;
	}

}
