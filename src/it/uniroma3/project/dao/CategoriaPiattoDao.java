package it.uniroma3.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.model.CategoriaPiatto;;

public class CategoriaPiattoDao extends AbstractDao<CategoriaPiatto> {

	public CategoriaPiattoDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CategoriaPiatto findById(long id) {
		return getEntityManager().find(CategoriaPiatto.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaPiatto> findAll() {
		return getEntityManager().createNamedQuery("CategoriaPiattoFindAll").getResultList();
	}

}
