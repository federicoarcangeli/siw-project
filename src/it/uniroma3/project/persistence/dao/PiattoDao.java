package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.project.persistence.entity.Piatto;



public class PiattoDao extends AbstractDao<Piatto> {

	public PiattoDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Piatto findById(long id) {
		return getEntityManager().find(Piatto.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Piatto> findAll() {
		return getEntityManager().createNamedQuery("PiattoFindAll").getResultList();

	}

	public void setCategoria(Long idPiatto, String idCategoria) {
		// TODO Auto-generated method stub

	}

}
