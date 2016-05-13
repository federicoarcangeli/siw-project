package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import it.uniroma3.project.entity.CategoriaPiatto;;

public class CategoriaPiattoDao extends AbstractDao<CategoriaPiatto> {

	public CategoriaPiattoDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CategoriaPiatto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaPiatto> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<CategoriaPiatto> result = em.createNamedQuery("CategoriaPiattoFindAll").getResultList();
		em.close();
		return result;
	}

}
