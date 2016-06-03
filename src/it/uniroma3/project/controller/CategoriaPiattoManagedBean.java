package it.uniroma3.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;

@ManagedBean
public class CategoriaPiattoManagedBean {

	@EJB
	private CategoriaPiattoFacade cpFacade;

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private CategoriaPiatto categoria;
	private String nome;
	private List<CategoriaPiatto> categorie;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public CategoriaPiattoFacade getCpFacade() {
		return cpFacade;
	}

	public void setCpFacade(CategoriaPiattoFacade cpFacade) {
		this.cpFacade = cpFacade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaPiatto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPiatto categoria) {
		this.categoria = categoria;
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public String getList() {
		this.categorie = this.cpFacade.getCategorie();
		return "inserimentoPiatti";
	}
	
	public String getListTest() {
		this.categorie = this.cpFacade.getCategorie();
		return "categorieTest";
	}

	public List<CategoriaPiatto> getCategorie() {
		return this.categorie;
	}

	public String findCategoriaPiatto() {
		this.categoria = this.cpFacade.get(this.id);
		return "categoria";
	}

	public String findCategoriaPiatto(long id) {
		this.categoria = this.cpFacade.get(id);
		return "categoria";
	}
	
	@PostConstruct
	public void init() {
		this.categorie = this.cpFacade.getCategorie();
	}

}
