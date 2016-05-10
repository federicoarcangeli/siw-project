package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Ordine;

public class OrdineDao extends AbstractDao<Ordine> {

	public OrdineDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ordine findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
