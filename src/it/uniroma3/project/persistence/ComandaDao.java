package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {

	public ComandaDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comanda findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
