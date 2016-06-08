package it.uniroma3.project.controller;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Tavolo;

@ManagedBean
@RequestScoped
@EJB(name = "tFacade", beanInterface = TavoloFacade.class)
public class TavoloControllerBean {

	private String codiceTavolo;
	private int coperti;

	private Tavolo tavolo;

	@EJB(name="tFacade")
	private TavoloFacade tFacade;

	public String create() {
		this.tavolo = tFacade.create(this.getCodiceTavolo(),this.getCoperti());
		return "registrazioneTavolo";
	}

	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(String codice) {
		this.codiceTavolo = codice;
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
		return tFacade;
	}

	public void setTavoloFacade(TavoloFacade tavoloFacade) {
		this.tFacade = tavoloFacade;
	}


}
