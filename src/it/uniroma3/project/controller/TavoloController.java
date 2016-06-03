package it.uniroma3.project.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Tavolo;

@ManagedBean
public class TavoloController {
	
	private String codice;
	private int coperti;
	
	private Tavolo tavolo;
	
	@EJB
	private TavoloFacade tavoloFacade;
	
	public String createTavolo() {
		this.tavolo = tavoloFacade.create(codice, coperti);
		return "registrazioneTavolo";
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public TavoloFacade getTavoloFacade() {
		return tavoloFacade;
	}

	public void setTavoloFacade(TavoloFacade tavoloFacade) {
		this.tavoloFacade = tavoloFacade;
	}

}
