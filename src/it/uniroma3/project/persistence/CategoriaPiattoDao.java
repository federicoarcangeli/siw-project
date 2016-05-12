package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.CategoriaPiatto;

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
	public List<CategoriaPiatto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
