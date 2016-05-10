package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.LineaOrdine;

public class LineaOrdineDao extends AbstractDao<LineaOrdine> {

	public LineaOrdineDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LineaOrdine findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaOrdine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
