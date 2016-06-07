package it.uniroma3.project.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.project.dao.CategoriaPiattoDao;
import it.uniroma3.project.dao.PiattoDao;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.Piatto;

@Stateless
public class PiattoFacade {
	
	@PersistenceContext(unitName = "restaurant")
	private EntityManager em;
	
	public Piatto create(String nome, DescrizionePiatto descrizionePiatto, CategoriaPiatto categoria) {
		Piatto piatto = new Piatto();
		piatto.setNome(nome);
		piatto.setPortata(categoria);
		em.persist(descrizionePiatto);
		piatto.setDescrizionePiatto(descrizionePiatto);
		em.persist(piatto);
		return piatto;
	}
	
	public Piatto findById(Long id) {
		return em.find(Piatto.class, id);
	}
	
	public List<Piatto> findAll() {
		PiattoDao dao = new PiattoDao(em);
		return dao.findAll();
	}
	
	public CategoriaPiatto findCategoriaById(Long id) {
		return em.find(CategoriaPiatto.class, id);
	}
	
	public CategoriaPiatto findCategoriaByName(String nome) {
		CategoriaPiattoDao cDao = new CategoriaPiattoDao(em);
		return cDao.findByName(nome);
	}

}
