package it.uniroma3.project.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.CategoriaPiattoDao;
import it.uniroma3.project.model.CategoriaPiatto;

@Named
@Stateless
public class CategoriaPiattoFacade {

	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;

	public CategoriaPiatto create(String nome) {
		CategoriaPiatto categoria = new CategoriaPiatto();
		categoria.setNome(nome);
		em.persist(categoria);
		return categoria;
	}

	public CategoriaPiatto get(Long id) {
		CategoriaPiatto categoria = em.find(CategoriaPiatto.class, id);
		return categoria;
	}

	public CategoriaPiatto findByName(String name) {
		CategoriaPiattoDao dao = new CategoriaPiattoDao(em);
		return dao.findByName(name);
	}

	public List<CategoriaPiatto> findAll() {
		try {
			return em.createNamedQuery("CategoriaPiatto.findAll", CategoriaPiatto.class).getResultList();
		} catch(NoResultException e) {
			return new ArrayList<>();
		}

	}

}
