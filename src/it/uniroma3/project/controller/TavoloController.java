package it.uniroma3.project.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Tavolo;

@ManagedBean(name ="tavoloController")
@RequestScoped
@EJB(name = "tFacade", beanInterface = TavoloFacade.class)
public class TavoloController {

	private String codice;
	private int coperti;
	private Tavolo tavolo;
	private int occupato;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private PrenotazioneFacade pFacade;

	public String create() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(this.tFacade.findTavoloByNumero(this.codice)!=null){
			context.getExternalContext().getRequestMap().put("tavoloError", "il tavolo numero " + this.codice + " è gia presente nella sala");
			return "registraTavolo";
		}
		this.tavolo = tFacade.create(this.codice,this.coperti);
		context.getExternalContext().getRequestMap().put("tavoloCorrente", "il tavolo numero " + this.codice + " con " + this.coperti + " coperti è stato inserito correttamente");
		return "registraTavolo";
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
		return tFacade;
	}


	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public int getOccupato() {
		return occupato;
	}

	public void setOccupato(int occupato) {
		this.occupato = occupato;
	}


}
