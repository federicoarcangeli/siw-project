package it.uniroma3.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Piatto;

@ManagedBean
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PiattoFacade.class),
		@EJB(name = "cpFacade", beanInterface = CategoriaPiattoFacade.class) })
public class MenuControllerBean {

	@EJB(name = "pFacade")
	private PiattoFacade pFacade;

	@EJB(name = "cpFacade")
	private CategoriaPiattoFacade cpFacade;
	
	private List<CategoriaPiatto> categorie;
	
	private List<String> nomiCategorie;
	
	private List<Piatto> piatti;
	
	@PostConstruct
	public void init() {
		this.categorie = this.cpFacade.getCategorie();
		this.nomiCategorie = new ArrayList<>();
		this.categorie = this.cpFacade.getCategorie();
		for (CategoriaPiatto c : this.categorie) {
			this.nomiCategorie.add(c.getNome());
		}
		this.piatti = this.pFacade.findAll();
	}
	
	public String goToMenu() {
		return "menu";
	}

	public PiattoFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PiattoFacade pFacade) {
		this.pFacade = pFacade;
	}

	public CategoriaPiattoFacade getCpFacade() {
		return cpFacade;
	}

	public void setCpFacade(CategoriaPiattoFacade cpFacade) {
		this.cpFacade = cpFacade;
	}

	public List<CategoriaPiatto> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public List<String> getNomiCategorie() {
		return nomiCategorie;
	}

	public void setNomiCategorie(List<String> nomiCategorie) {
		this.nomiCategorie = nomiCategorie;
	}

	public List<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}
	
	
	

}
