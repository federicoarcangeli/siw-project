package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.Portata;

public class PortataDao extends AbstractDao<Portata> {

	public PortataDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Portata findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Portata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
