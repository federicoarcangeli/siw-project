package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.DescrizionePiatto;

public class DescrizionePiattoDao extends AbstractDao<DescrizionePiatto> {

	public DescrizionePiattoDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DescrizionePiatto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DescrizionePiatto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
