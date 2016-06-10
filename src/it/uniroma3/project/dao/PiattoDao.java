package it.uniroma3.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.project.model.Piatto;



public class PiattoDao extends AbstractDao<Piatto> {

	public PiattoDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Piatto findById(long id) {
		return getEM().find(Piatto.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Piatto> findAll() {
		return getEM().createNamedQuery("Piatto.findAll").getResultList();

	}

	public void setCategoria(Long idPiatto, String idCategoria) {
		// TODO Auto-generated method stub

	}

}
