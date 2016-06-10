package it.uniroma3.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.project.model.DescrizionePiatto;

public class DescrizionePiattoDao extends AbstractDao<DescrizionePiatto> {


	public DescrizionePiattoDao(EntityManager em) {
		super(em);
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
