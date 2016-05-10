package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Tavolo;

public class TavoloDao extends AbstractDao<Tavolo> {

	public TavoloDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tavolo findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tavolo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
