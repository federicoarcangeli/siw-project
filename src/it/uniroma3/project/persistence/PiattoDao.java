package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Piatto;

public class PiattoDao extends AbstractDao<Piatto> {

	public PiattoDao(EntityManagerFactory emf) {
		super(emf);

	}

	@Override
	public Piatto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Piatto> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Piatto> result = em.createNamedQuery("PiattoFindAll").getResultList();
		em.close();
		return result;
	}

	public void setCategoria(Long idPiatto, String idCategoria) {
		// TODO Auto-generated method stub
		
	}

}
