package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Operatore;

public class OperatoreDao extends AbstractDao<Operatore> {

	public OperatoreDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Operatore findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operatore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
