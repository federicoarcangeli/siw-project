package it.uniroma3.project.persistence;

import java.util.List;

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
	public List<Piatto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
